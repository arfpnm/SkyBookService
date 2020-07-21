package com.sky.library.util;

import com.sky.library.domain.Book;

import java.util.Optional;

public class Util {

  private static final int maxLen = 9;

  public static String displaySummary(Book book) {
    StringBuilder stringBuilder = null;
    if (Optional.ofNullable(book).isPresent()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(book.getRef());
      stringBuilder.append("]");
      stringBuilder.append(" ");
      stringBuilder.append(book.getTitle());
      stringBuilder.append(" - ");
      String review = book.getReview();
      stringBuilder.append(displayReview(review));
    }
    return stringBuilder.toString();
  }

  private static String displayReview(String review){
      String displayString = null;
      String[] words = review.split(" ");
      StringBuilder stringBuilder = new StringBuilder();
      int len = Math.min(words.length, maxLen);
      for (int i = 0; i < len; i++) {
        stringBuilder.append(words[i]);
        stringBuilder.append(" ");
      }
        displayString = stringBuilder.toString().trim();
      return len == maxLen ? displayString.concat("...") : displayString.concat(".");
  }

}
