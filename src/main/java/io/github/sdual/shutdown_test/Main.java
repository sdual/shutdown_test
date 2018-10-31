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

    System.out.println("end.");
  }

  public static void start() throws InterruptedException {
    while (true) {
      Thread.sleep(5000);
      Thread.currentThread().interrupt();
    }
  }

}
