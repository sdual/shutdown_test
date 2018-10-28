package io.github.sdual.shutdown_test;

public class Main {

  public static void main(String[] args) {

    try {

      Runtime.getRuntime().addShutdownHook(new Thread(
          () ->
              System.out.println("Shutdown event is triggered.")
      ));
      start();
    } catch (InterruptedException e) {
      System.out.println("interrupted.");
    }

  }

  public static void start() throws InterruptedException {
    Thread.sleep(100000);
  }

}
