package testspace;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class LoadClassInJar {
  public static void main(String[] args) throws Exception {
    File file = new File("/root/workspace/RPT2.9SP1/WebContent/WEB-INF/lib/ojdbc14.jar");
    @SuppressWarnings("resource")
    URLClassLoader loader = new URLClassLoader(new URL[] { file.toURI().toURL() });
    Class<?> clazz = loader.loadClass("oracle.jdbc.driver.OracleDriver");

    Driver driver = (Driver) clazz.newInstance();
    Properties p = new Properties();
    p.put("user", "newrpt_plt");
    p.put("password", "newrpt_plt");
    Connection con = driver.connect("jdbc:oracle:thin:@10.0.1.204:1521:lgdnew", p);
    System.out.println(con);
  }
}