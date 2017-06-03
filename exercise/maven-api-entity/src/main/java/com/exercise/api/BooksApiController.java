package com.exercise.api;

import com.exercise.model.Book;
import com.exercise.model.BookItem;
import com.exercise.model.Rental;
import com.exercise.repository.BookRepository;
import io.swagger.annotations.*;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-02T21:22:43.118+03:00")

@Controller
public class BooksApiController implements BooksApi {
    
    @Autowired
    private BookRepository bookRepo;
    
    @Override
    public ResponseEntity<List<BookItem>> booksGet() {
        ArrayList<BookItem> bookItems = new ArrayList<>();
        for (com.exercise.entity.Book book : bookRepo.findAll()){
            BookItem bookItem = new BookItem();
            bookItem.setId(book.getId());
            bookItem.setName(book.getName());
            bookItems.add(bookItem);
        }
        return new ResponseEntity<>(bookItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Book> booksIdGet(@ApiParam(value = "The id of the requested book",required=true ) @PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        com.exercise.entity.Book bookEntity = bookRepo.findOne(id);
        if (bookEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookEntity.toDtoBook(), HttpStatus.OK);
        }
    }
}
