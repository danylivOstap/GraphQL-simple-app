package com.od.graphql.services.impl;

import com.od.graphql.model.Book;
import com.od.graphql.repositories.BookRepository;
import com.od.graphql.services.BookService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;

  @Override
  public Page<Book> getBooks(final Pageable pageable) {
    log.info("Getting books... ");
    return bookRepository.findAll(pageable);
  }

  @Override
  public Optional<Book> getBook(final String isbn) {
    return bookRepository.findById(isbn);
  }
}
