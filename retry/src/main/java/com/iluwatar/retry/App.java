package com.iluwatar.retry;

/**
 *  The purpose of Retry Pattern is to handle transient faults that could occurs due to
 *  - temporary unavailable service
 *  - network problem
 *  The idea of the pattern is:
 *  1)To abort the request - If fault is not likely to be successfully resolved after small range of time
 *  2)Try to retry the request - If fault is unusual or rare; Busy service.
 *  The logic of the pattern is under Retry class
 */
public class App {
  private static RetryPattern retry = new RetryPattern();

  /**
   * Main method
   * @param args
   */
  public static void main(String[] args) {
    SpellBook sb = new SpellBook();
    RetryInterface connection = null;

    //We are trying to access different resources from remote service
    try {
      connection = () -> sb.getSpellWithTransientFault();
      connection.connect();

    } catch (Exception e) {
      RetryPattern retry = new RetryPattern();
      retry.testFunction(connection);
    }

    try {
      connection = () -> sb.getSpellWithSeriousFault();
      connection.connect();

    } catch (Exception e) {
      RetryPattern retry = new RetryPattern();
      retry.testFunction(connection);
    }




  }

}
