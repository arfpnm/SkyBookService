package com.sky.library.repository;

import com.sky.library.domain.Book;
import com.sky.library.stub.BookRepositoryStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

  @Autowired
  private BookRepositoryStub bookRepositoryStub;

  public Optional<List<Book>> find(){
    return bookRepositoryStub.retrieveBooks();
  }

}
