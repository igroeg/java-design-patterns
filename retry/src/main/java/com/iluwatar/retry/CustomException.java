package com.iluwatar.retry;

/**
 * Created by pro on 21.02.17.
 */
public class CustomException extends RuntimeException {
  private String message;

  public CustomException(String message) {
    super(message);
  }
}
