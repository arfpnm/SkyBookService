package com.sky.library;

import com.sky.library.domain.Book;
import com.sky.library.exception.BookNotFoundException;
import com.sky.library.service.BookService;
import com.sky.library.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class BookserviceApplicationTests {

  @Autowired
  private BookService bookService;

  @Test
  void testRetrieveBookByReference() throws BookNotFoundException {
    String expected = "The Gruffalo book";
    String s = bookService.retrieveBook("BOOK-GRUFF472");
    assertEquals(expected, s);
  }

  @Test
  void testRetrieveBookyWithInvalidReferenceStartsWith() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.retrieveBook("ABOOK-999");
    }, "book reference must begin with BOOK-");
  }

  @Test()
  void testRetrieveBookWithInvalidReference() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.retrieveBook("BOOK-999");
    }, "Book not found");
  }

  @Test()
  void testRetrievingBookWithNullReference() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.retrieveBook(null);
    }, "Book not found");
  }

  @Test
  void testBookingSummaryByReferenceWithReviewSizeLessThan9() throws BookNotFoundException {
    String expected = "[BOOK-GRUFF472] The Gruffalo - A mouse taking a walk in the woods.";
    String s = bookService.getBookSummary("BOOK-GRUFF472");
    assertEquals(expected, s);
  }

  @Test
  void testBookingSummaryByReferenceWithReviewSizeGreaterThan9() throws BookNotFoundException {
    String expected = "[BOOK-POOH222] Winnie The Pooh - In this first volume, we meet all the friends...";
    String s = bookService.getBookSummary("BOOK-POOH222");
    assertEquals(expected, s);
  }

  @Test
  void testBookingSummaryWithInvalidReference() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.getBookSummary("ABOOK-999");
    }, "book reference must begin with BOOK-");
  }

  @Test()
  void testBookingSummaryWithInvalidReferenceStartsWith() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.getBookSummary("BOOK-999");
    }, "Book not found");
  }

  @Test()
  void testBookingSummaryWithNullReference() throws BookNotFoundException {
    assertThrows(BookNotFoundException.class, () -> {
      bookService.getBookSummary(null);
    }, "Book not found");
  }

  @Test
  public void testUtilDisplaySummary(){
    String expected = "[BOOK-POOH222] Winnie The Pooh - In this first volume, we meet all the friends...";
    Book book = new Book();
    book.setRef("BOOK-POOH222");
    book.setTitle("Winnie The Pooh");
    book.setReview("In this first volume, we meet all the friends and Family");
    String actual = Util.displaySummary(book);
    assertEquals(expected, actual);
  }

}
