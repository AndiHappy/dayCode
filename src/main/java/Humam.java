import java.util.Base64;

class Huma extends Exception {}  
class Sneeze extends Huma {} 

public class Humam {  
	 

    public static void main(String[] args)   
        throws Exception {
        try {  
            try {  
              throw new Sneeze();  
          }   
          catch ( Huma a ) {  
              System.out.println("Caught Humam");  
              throw a;  
          }  
      }   
      catch ( Sneeze s ) {  
          System.out.println("Caught Sneeze");  
          return ;  
      }  
      finally {  
          System.out.println("Hello World!");  
      }  
  }  
} 

 