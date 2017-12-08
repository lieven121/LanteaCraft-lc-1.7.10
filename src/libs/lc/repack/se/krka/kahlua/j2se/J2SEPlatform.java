package lc.repack.se.krka.kahlua.j2se;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import lc.repack.se.krka.kahlua.Version;
import lc.repack.se.krka.kahlua.luaj.compiler.LuaCompiler;
import lc.repack.se.krka.kahlua.stdlib.*;
import lc.repack.se.krka.kahlua.test.UserdataArray;
import lc.repack.se.krka.kahlua.threading.BlockingKahluaThread;
import lc.repack.se.krka.kahlua.vm.*;

public class J2SEPlatform implements Platform {
	private static J2SEPlatform INSTANCE = new J2SEPlatform();
	public static J2SEPlatform getInstance() {
		return INSTANCE;
	}
	
    @Override
    public double pow(double x, double y) {
        return Math.pow(x, y);
    }

    @Override
    public KahluaTable newTable() {
        return new KahluaTableImpl(new ConcurrentHashMap<Object, Object>());
    }

    @Override
    public KahluaTable newEnvironment() {
        KahluaTable env = newTable();
		setupEnvironment(env);
        return env;
    }

	@Override
	public void setupEnvironment(KahluaTable env) {
		env.wipe();
		env.rawset("_G", env);
		env.rawset("_VERSION", Version.VERSION + " (J2SE)");

		MathLib.register(this, env);
		BaseLib.register(env);
		RandomLib.register(this, env);
		UserdataArray.register(this, env);
		StringLib.register(this, env);
		CoroutineLib.register(this, env);
		OsLib.register(this, env);
		TableLib.register(this, env);
		LuaCompiler.register(env);

		KahluaThread workerThread = setupWorkerThread(env);
		KahluaUtil.setupLibrary(env, workerThread, "/stdlib");

		try {
			LuaClosure closure = LuaCompiler.loadis(getClass().getResourceAsStream("/serialize.lua"), "serialize.lua", env);
			workerThread.call(closure, null, null, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private KahluaThread setupWorkerThread(KahluaTable env) {
        BlockingKahluaThread thread = new BlockingKahluaThread(this, env);
		KahluaUtil.setWorkerThread(env, thread);
		return thread;
    }

}
