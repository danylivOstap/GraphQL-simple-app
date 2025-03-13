package com.od.graphql.controllers;

import com.od.graphql.model.Book;
import com.od.graphql.services.BookService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GraphQLController {
  private final BookService bookService;

  @QueryMapping
  public Iterable<Book> listBooks(
      @Argument("page") final Integer page,
      @Argument("size") final Integer size) {

    return bookService.getBooks(PageRequest.of(
        Optional.ofNullable(page).orElse(0),
        Optional.ofNullable(size).orElse(20)
    ));
  }

  @QueryMapping
  public Optional<Book> bookByIsbn(@Argument("isbn") final String isbn) {
    return bookService.getBook(isbn);
  }
}
