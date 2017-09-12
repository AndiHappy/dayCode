package products.htmlParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebpageCapture {
  public void captureHtml(String ip) throws Exception {
    String strURL = "http://www.soduso.com/";
    URL url = new URL(strURL);
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "gb2312");
    BufferedReader bufReader = new BufferedReader(input);
    String line = "";
    StringBuilder contentBuf = new StringBuilder();
    while ((line = bufReader.readLine()) != null) {
      contentBuf.append(line).append("\n");
    }
    String buf = contentBuf.toString();
    System.out.println(buf);
  }

  public void captureJavascript(String postid) throws Exception {
    String strURL = "http://www.kiees.cn/sf.php?wen=" + postid + "&channel=";
    URL url = new URL(strURL);
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
    BufferedReader bufReader = new BufferedReader(input);
    String line = "";
    StringBuilder contentBuf = new StringBuilder();
    while ((line = bufReader.readLine()) != null) {
      contentBuf.append(line);
    }
    System.out.println("captureJavascript()" + contentBuf.toString());
  }
}
