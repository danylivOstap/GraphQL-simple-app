package com.od.graphql.services;

import com.od.graphql.model.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
  Page<Book> getBooks(Pageable pageable);

  Optional<Book> getBook(String isbn);
}
