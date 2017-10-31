package spring;

import org.springframework.util.ClassUtils;
import static java.lang.String.format;

import java.io.File;
import java.io.IOException;

/**
 * @author zhailz
 * @Date 2017年9月25日 - 上午9:45:38
 * @Doc:
 */
public class SpringFile {
  private static final String CONTEXT = format("%s-context.xml", ClassUtils
      .convertClassNameToResourcePath(SpringFile.class.getName()));

  public static void main(String[] args) throws IOException {
    File tmp = new File("",CONTEXT);
    System.out.println(tmp.getAbsolutePath());
    if (!tmp.exists()) {
      tmp.getParentFile().createNewFile();
      tmp.createNewFile();
    }
  }
}
