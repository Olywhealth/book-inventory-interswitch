package com.johnson.interswitch.repository;

import com.johnson.interswitch.enums.Genre;
import com.johnson.interswitch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Johnson on 16/12/2023
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingOrAuthorContainingOrYearOfPublicationOrGenre(String title, String author, String year, Genre genre);
}
