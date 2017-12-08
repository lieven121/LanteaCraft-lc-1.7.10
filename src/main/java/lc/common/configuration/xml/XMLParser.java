package lc.common.configuration.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XML configuration parser
 *
 * @author AfterLifeLochie
 *
 */
public class XMLParser {

	private final DocumentBuilderFactory factory;

	/** Default constructor */
	public XMLParser() {
		factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(false);
	}

	/**
	 * Attempts to read a configuration file structure from the file
	 *
	 * @param chunk
	 *            The chunk to read.
	 * @return The ConfigList root object.
	 * @throws XMLParserException
	 *             Any XML or read exception.
	 */
	public ComponentConfigList read(InputStream chunk) throws XMLParserException {
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(chunk);
			NodeList root = doc.getChildNodes();
			Node modRoot = DOMHelper.findNode(root, "ModConfig", false);
			if (modRoot == null)
				throw new XMLParserException("Missing ModConfig root tag.");
			return readRoot(modRoot);
		} catch (IOException e) {
			throw new XMLParserException("Can't parse; IOException occured.", e);
		} catch (ParserConfigurationException e) {
			throw new XMLParserException("Can't parse; configuration exception.", e);
		} catch (SAXException e) {
			throw new XMLParserException("Can't parse; document syntax exception.", e);
		}
	}

	/**
	 * Attempts to read a root config container object.
	 *
	 * @param modRoot
	 *            The ModConfig root container.
	 * @return The ModConfig root container, usually containing a list of
	 *         ModuleConfig nodes.
	 * @throws XMLParserException
	 */
	private ComponentConfigList readRoot(Node modRoot) throws XMLParserException {
		ComponentConfigList root = new ComponentConfigList("ModConfig");
		ArrayList<ComponentConfig> rootChildren = new ArrayList<ComponentConfig>();
		NodeList childrenRoot = modRoot.getChildNodes();
		for (int i = 0; i < childrenRoot.getLength(); i++) {
			Node child = childrenRoot.item(i);
			if (DOMHelper.isNodeOfType(child, "Component", false))
				rootChildren.add(readModuleConfig(root, (Element) child));
		}
		root.setChildren(rootChildren);
		return root;
	}

	private ComponentConfig readModuleConfig(ConfigNode parent, Element moduleNode) throws XMLParserException {
		DOMHelper.checkedAllAttributes(moduleNode, new String[] { "name", "enabled" });
		ComponentConfig moduleRoot = new ComponentConfig("Component", parent);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		ArrayList<ConfigNode> rootChildren = new ArrayList<ConfigNode>();
		parameters.put("name", moduleNode.getAttribute("name"));
		parameters.put("enabled", DOMHelper.popBoolean(moduleNode.getAttribute("enabled"), false));
		NodeList childrenRoot = moduleNode.getChildNodes();
		for (int i = 0; i < childrenRoot.getLength(); i++) {
			Node child = childrenRoot.item(i);
			if (child instanceof Element)
				rootChildren.add(readRecusriveObject(moduleRoot, (Element) child));
		}
		moduleRoot.setParameters(parameters);
		moduleRoot.setChildren(rootChildren);
		Comment nodeComment = DOMHelper.findLeadingComment(moduleNode);
		if (nodeComment != null)
			moduleRoot.setComment(nodeComment.getData());
		return moduleRoot;
	}

	private ConfigNode readRecusriveObject(ConfigNode parent, Element element) throws XMLParserException {
		if (element.hasChildNodes()) {
			ConfigList group = new ConfigList(element.getTagName(), parent);
			ArrayList<ConfigNode> childrenGroup = new ArrayList<ConfigNode>();
			if (element.hasAttributes()) {
				HashMap<String, Object> parameters = new HashMap<String, Object>();
				NamedNodeMap nodes = element.getAttributes();
				for (int i = 0; i < nodes.getLength(); i++)
					parameters.put(nodes.item(i).getNodeName(), nodes.item(i).getNodeValue());
				group.setParameters(parameters);
			}
			NodeList children = element.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child instanceof Element)
					childrenGroup.add(readRecusriveObject(group, (Element) child));
			}
			group.setChildren(childrenGroup);
			Comment nodeComment = DOMHelper.findLeadingComment(element);
			if (nodeComment != null)
				group.setComment(nodeComment.getData());
			return group;
		} else {
			ConfigNode single = new ConfigNode(element.getTagName(), parent);
			if (element.hasAttributes()) {
				HashMap<String, Object> parameters = new HashMap<String, Object>();
				NamedNodeMap nodes = element.getAttributes();
				for (int i = 0; i < nodes.getLength(); i++)
					parameters.put(nodes.item(i).getNodeName(), nodes.item(i).getNodeValue());
				single.setParameters(parameters);
			}
			Comment nodeComment = DOMHelper.findLeadingComment(element);
			if (nodeComment != null)
				single.setComment(nodeComment.getData());
			return single;
		}
	}
}
