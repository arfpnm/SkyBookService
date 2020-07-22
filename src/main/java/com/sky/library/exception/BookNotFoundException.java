package com.sky.library.exception;

/**
 * Exception class
 */
public class BookNotFoundException extends RuntimeException{

  public BookNotFoundException(String msg) {
    super(msg);
  }

}
