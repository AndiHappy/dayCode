package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhailz
 * @Date 2017年10月15日 - 下午5:46:13
 * @Doc: 
 */
public class Snippet {
  /**
   * 使用IO读取指定文件的前1024个字节的内容。
   * @param file 指定文件名称。
   * @throws java.io.IOException IO异常。
   */
  public static void ioRead(String file) throws IOException {
      FileInputStream in = new FileInputStream(file);
      byte[] b = new byte[1024];
      in.read(b);
      System.out.println(new String(b));
      in.close();
  }
  
  /**
   * 使用NIO读取指定文件的前1024个字节的内容。
   * @param file 指定文件名称。
   * @throws java.io.IOException IO异常。
   */
  public static void nioRead(String file) throws IOException {
      FileInputStream in = new FileInputStream(file);
      FileChannel channel = in.getChannel();
  
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      channel.read(buffer);
      buffer.flip();
      byte[] b = buffer.array();
      System.out.println(new String(b));
      in.close();
  }
  
  public static void main(String[] args) throws Exception {
    ioRead("README.md");
    nioRead("README.md");
  }
}

