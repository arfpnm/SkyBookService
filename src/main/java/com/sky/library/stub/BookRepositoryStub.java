package com.sky.library.stub;

import com.sky.library.domain.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This class provides the mocked data of books
 */
@Component
public class BookRepositoryStub {

  public Optional<List<Book>> retrieveBooks() {
    Book book1 = new Book();
    book1.setRef("BOOK-GRUFF472");
    book1.setTitle("The Gruffalo");
    book1.setReview("A mouse taking a walk in the woods");

    Book book2 = new Book();
    book2.setRef("BOOK-POOH222");
    book2.setTitle("Winnie The Pooh");
    book2.setReview("In this first volume, we meet all the friends and family");

    Book book3 = new Book();
    book3.setRef("BOOK-WILL987");
    book3.setTitle("The Wind In The Willows");
    book3.setReview("With the arrival of spring and fine weather outside");
    return Optional.of(Arrays.asList(book1, book2, book3));
  }
}
