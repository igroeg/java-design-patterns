package com.iluwatar.retry;


public class RetryPattern {
  private Exception recievedException;
  private int retryCount;

  public RetryPattern() {

  }


  /***
   *
   * @param connection
   */
  public void testFunction(RetryInterface connection) {
    try {
      System.out.println(connection.connect());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
