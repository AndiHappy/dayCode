package jvm;
public class SyncTest {

    public SyncTest syncVar;

    public static SyncTest syncStaticVar;

    public static synchronized void testStaticSync() {
      try {
        System. out.println("test syncStaticVar start" );
        Thread. sleep(5000);
        System. out.println("test syncStaticVar end" );
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }


    public void testSyncThis() {
        synchronized (this ) {
            try {
                System. out.println("test sync this start" );
                Thread. sleep(5000);
                System. out.println("test sync this end" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testSyncVar() {
        synchronized (syncVar ) {
            try {
                System. out.println("test sync var start" );
                Thread. sleep(3000);
                System. out.println("test sync var end" );
            } catch (InterruptedException e) {

            }
        }
    }

    public void testStaticSyncVar() {
        synchronized (syncStaticVar ) {
          try {
            System. out.println("test testStaticSyncVar start" );
            Thread. sleep(5000);
            System. out.println("test testStaticSyncVar end" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public static void main(String[] args) {
        final SyncTest testSync = new SyncTest();
        testSync. syncVar = new SyncTest();
        testSync. syncVar = testSync;
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.testSyncThis();
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.testSyncVar();
            }
        });
        
        Thread thread3 = new Thread(new Runnable() {
          @Override
          public void run() {
              testSync.testStaticSyncVar();
          }
      });
        
        threadOne.start();
        threadTwo.start();
        thread3.start();
    }
}