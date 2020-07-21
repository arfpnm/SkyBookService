package com.sky.library.service;

import com.sky.library.exception.BookNotFoundException;

public interface BookService {

  String retrieveBook(String bookReference) throws BookNotFoundException;

  String getBookSummary(String bookReference) throws BookNotFoundException;

}
