package com.spglobal.rt.service.NanoHTTPD;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class hwserver
{
  public static void main(String[] args) throws Exception
  {
    try (ZContext context = new ZContext()) {
      //  Socket to talk to clients
      ZMQ.Socket socket = context.createSocket(SocketType.XPUB);
      socket.setRcvHWM(0);
      socket.setImmediate(true);
      socket.connect("tcp://localhost:5562");

      while (true) {
    	  
    	  byte[] srr= socket.recv();
    	  int type=(int)srr[0];
    	  byte[] topic=Arrays.copyOfRange(srr, 1, srr.length);
    	  String topicName=new String(topic);
    	 
    	  
    	  if(0==type) {
    		  System.out.println(" UNSUB=====>"+topicName);  
    	  }else {
    		  System.out.println("  SUB=====>"+topicName);  
    	  }
    	  
    	  
    	  
      }
    }
  }
}