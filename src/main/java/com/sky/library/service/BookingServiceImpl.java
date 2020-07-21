package com.sky.library.service;

import com.sky.library.domain.Book;
import com.sky.library.exception.BookNotFoundException;
import com.sky.library.repository.BookRepository;
import com.sky.library.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class provides service such as retrieving and get book summary based on the book reference
 */
@Service
public class BookingServiceImpl implements BookService{

  @Autowired
  private BookRepository bookRepository;
  @Value("${INVALID_BOOK_REFERENCE}")
  private String invalidBookingReference;
  @Value("${BOOK}")
  private String bookString;
  @Value("${BOOKNOTFOUND}")
  private String bookNotFoundString;
  @Value("${REFSTARTSWITH}")
  private String refStartsWith;


  @Override
  public String retrieveBook(String bookReference) throws BookNotFoundException {
    String title = bookRepository.find().flatMap(books -> books.stream().
        filter(t -> t.getRef().equals(bookReference)).map(Book::getTitle).findFirst()).orElseThrow(() ->
        new BookNotFoundException(bookNotFoundString));
    if(Optional.ofNullable(title).isPresent()){
      title += " "+bookString;
    }
    return title;
  }

  @Override
  public String getBookSummary(String bookReference) throws BookNotFoundException {
    if(bookReference != null && !bookReference.startsWith(refStartsWith)){
      throw new BookNotFoundException(invalidBookingReference);
    }
    return  bookRepository.find().flatMap(books -> books.stream().
        filter(bk -> bk.getRef().equals(bookReference)).map(Util::displaySummary).findFirst()).orElseThrow(() ->
        new BookNotFoundException(bookNotFoundString));
  }
}
