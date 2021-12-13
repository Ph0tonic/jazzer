package com.example;
import java.io.*; 

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.lang.Runtime;
import java.lang.Process;

import com.code_intelligence.jazzer.api.HookType;
import com.code_intelligence.jazzer.api.MethodHook;
import java.lang.invoke.MethodHandle;
import com.code_intelligence.jazzer.api.Jazzer;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueHigh;

public class RuntimeHook {
  @MethodHook(type = HookType.REPLACE, targetClassName = "java.lang.Runtime",
  targetMethod = "exec", targetMethodDescriptor = "")
  public static Process
  hookRuntime(MethodHandle handle, Object thisObject, Object[] args, int hookId) {
    // try {
      //   Runtime.getRuntime().exec("touch /tmp/jazzer/examples/hook.md");
      // } catch(Exception e) {}
      Jazzer.reportFindingFromHook(new FuzzerSecurityIssueHigh("Runtime.exec triggered !"));
      throw new FuzzerSecurityIssueHigh("Runtime.exec has been called");
    }    
}
