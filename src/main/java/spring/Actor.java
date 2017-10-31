package spring;

/**
 * @author zhailz
 * @Date 2017年9月21日 - 下午2:40:05
 * @Doc: 
 */
public class Actor {
  
  private String name;

  /**
   * @param string
   */
  public Actor(String string) {

    this.name = string;
  }
  
  public Actor() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
