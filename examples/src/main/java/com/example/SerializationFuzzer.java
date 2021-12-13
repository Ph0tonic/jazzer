package com.example;

import java.io.*; 

import org.apache.commons.beanutils.BeanComparator;
import com.sun.syndication.feed.impl.ObjectBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.lang.Runtime;
import java.lang.Process;

public class SerializationFuzzer {
  private static final String PAYLOAD = "/tmp/test/groovy/payload.bin";

  public static void fuzzerTestOneInput(byte[] input) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(SerializationFuzzer.PAYLOAD);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Object unserObj = ois.readObject();
    ois.close();
  }
}
