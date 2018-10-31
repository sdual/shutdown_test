package io.github.sdual.shutdown_test;

public class ShutdownTest {

  private static Thread main;

  public static void main(String[] args) throws Exception {

    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

      public void run() {
        System.out.println("TERM");
        main.interrupt();

        while (true) {
          if (!main.isAlive()) {
            System.out.println("[hook] main thread was terminated.");
            break;
          }
          System.out.println("[hook] main thread is alive.");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
//
//        for (int i = 0; i < 4; i++) {
//          //System.out.print("busy: ");
//          //System.out.println(i);
//          try {
//            Thread.sleep(1000);
//            System.out.println(main.isAlive());
//          } catch (Exception e) {
//          }
//        }
        System.out.println("[hook] shutdown hook end.");
      }

    }));

  main = Thread.currentThread();

//    try {
//      while (true) {
//        Thread.sleep(1000);
//        System.out.println("run");
//      }
//    } catch (InterruptedException e) {
//      System.out.println("main thread is interrupted.");
//      e.printStackTrace();
//    }

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      System.out.println("[main] main thread interrupted.");
    }

    Thread.sleep(2000);
    System.out.println("[main] main thread end.");
  }

}
