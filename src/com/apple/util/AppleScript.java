package com.apple.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AppleScript {
	public static void main( String[] args ) throws ScriptException {        
        ScriptEngineManager mgr = new ScriptEngineManager();        
        
        ScriptEngine engine = mgr.getEngineByName("AppleScript");
        engine.eval( "tell application \"iTunes\" to play" );        
    }
}
