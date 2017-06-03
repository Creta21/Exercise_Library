package com.exercise.api;

import com.exercise.model.Book;
import com.exercise.model.BookItem;
import io.swagger.annotations.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-02T21:22:43.118+03:00")

@Api(value = "books", description = "the books API")
@RequestMapping(value = "/") // SOS na valoume auti ti grammi
public interface BooksApi {

    @ApiOperation(value = "Returns a list of all the books", notes = "Returns a list of all the books", response = BookItem.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The list of all the books", response = BookItem.class) })
    @RequestMapping(value = "/books",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
        @CrossOrigin // SOS kai auto!!!!! gia na exei prosvasei to ajax sta api
    ResponseEntity<List<BookItem>> booksGet();


    @ApiOperation(value = "Returns the requested book", notes = "Returns the requested book", response = Book.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The requested book", response = Book.class),
        @ApiResponse(code = 404, message = "book not found.", response = Book.class) })
    @RequestMapping(value = "/books/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
        @CrossOrigin // SOS kai auto!!!!
    ResponseEntity<Book> booksIdGet(@ApiParam(value = "The id of the requested book",required=true ) @PathVariable("id") Integer id);

}
