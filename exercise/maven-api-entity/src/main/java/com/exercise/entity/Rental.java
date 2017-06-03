package com.exercise.entity;

import com.exercise.converters.LocalDateAttributeConverter;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.joda.time.Days;
import org.joda.time.LocalDate;

@Entity
@Table(name = "rental")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Size(min = 1, max = 45)
    @Column(name = "person_name")
    private String personName;
    
    @Column(name = "date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate date;
    
    @Column(name = "return_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate returnDate;
    
    @ManyToOne // PROSOXI sti sxesi
    @JoinColumn(name = "book_id")
    private Book book; // auto einai to onoma pou exei sto mappedBy = "book" stin class Book !!!!!!

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "\n\t\t\tRental{" + "id=" + id + ", personName=" + personName + ", date=" + date + ", returnDate=" + returnDate + '}';
    } 
    
    public int isActiveOrOverdue() {
        // -1 value will be used to tell that the Rental is not active (it is returned)
        int result = -1;
        
        if( getReturnDate() == null){
            // in this case, 0 will represent a rental that is still active but not overdue yet.
            result = 0;
            // now we calculate the time passed between rental date and today
            LocalDate today = LocalDate.now();
            int days = Days.daysBetween(getDate(), today).getDays();
            if (days > 21) {
                return days - 21;
            }
        }
        return result;  
    }
}
