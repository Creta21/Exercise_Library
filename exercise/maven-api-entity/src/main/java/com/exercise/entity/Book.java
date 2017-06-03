package com.exercise.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto edw na doume
    @Column(name = "id")
    private int id;
    
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "isbn")
    private String isbn;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;
    
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER) // PROSOXI sti sxesi && To onoma book tha dwsoume stin class Rental!!!!
    private List<Rental> rentals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "\nBook{" + "id=" + id + ", isbn=" + isbn + ", name=" + name + ", author=" + author + ", rentals=" + rentals + '}';
    }
    
    public com.exercise.model.Book toDtoBook() {
        com.exercise.model.Book bookModel = new com.exercise.model.Book();
        
        bookModel.setIsbn(this.getIsbn());
        bookModel.setName(this.getName());
        bookModel.setAuthor(this.getAuthor());
            
        int bookState = -1;
        
        for( com.exercise.entity.Rental r: rentals){
    
            int rentalState = r.isActiveOrOverdue();
            // if the book state was not changed yet, we update it with this rental state. 
            // This way, we prevent an unordered list of rentals from overriding the real state of the book.
            // once a rental is active or overdue, any following rental cannot override this value.
            if (bookState == -1)
                bookState = rentalState;
            
            com.exercise.model.Rental dtoRental = new com.exercise.model.Rental();
            dtoRental.setPersonName(r.getPersonName());
            dtoRental.setDate(r.getDate());
            dtoRental.setReturnDate(r.getReturnDate());
            bookModel.addRentalsItem( dtoRental );
        }
        // finally we set the Rented and Overdue properties of the DTO book
        if (bookState != -1) {
            bookModel.setIsRented(true);
            bookModel.overdueDays(bookState);
        }else {
            bookModel.setIsRented(false);
        }
        return bookModel; 
    }
}
