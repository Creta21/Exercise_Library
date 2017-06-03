package com.exercise.model;

import java.util.Objects;
import com.exercise.model.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
/**
 * Book
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-02T21:22:43.118+03:00")

public class Book   {
  @JsonProperty("isbn")
  private String isbn = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("isRented")
  private Boolean isRented = null;

  @JsonProperty("overdueDays")
  private Integer overdueDays = null;

  @JsonProperty("rentals")
  private List<Rental> rentals = new ArrayList<Rental>();

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

   /**
   * Get isbn
   * @return isbn
  **/
  @ApiModelProperty(value = "")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Book author(String author) {
    this.author = author;
    return this;
  }

   /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(value = "")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book isRented(Boolean isRented) {
    this.isRented = isRented;
    return this;
  }

   /**
   * Get isRented
   * @return isRented
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsRented() {
    return isRented;
  }

  public void setIsRented(Boolean isRented) {
    this.isRented = isRented;
  }

  public Book overdueDays(Integer overdueDays) {
    this.overdueDays = overdueDays;
    return this;
  }

   /**
   * Get overdueDays
   * @return overdueDays
  **/
  @ApiModelProperty(value = "")
  public Integer getOverdueDays() {
    return overdueDays;
  }

  public void setOverdueDays(Integer overdueDays) {
    this.overdueDays = overdueDays;
  }

  public Book rentals(List<Rental> rentals) {
    this.rentals = rentals;
    return this;
  }

  public Book addRentalsItem(Rental rentalsItem) {
    this.rentals.add(rentalsItem);
    return this;
  }

   /**
   * Get rentals
   * @return rentals
  **/
  @ApiModelProperty(value = "")
  public List<Rental> getRentals() {
    return rentals;
  }

  public void setRentals(List<Rental> rentals) {
    this.rentals = rentals;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.isbn, book.isbn) &&
        Objects.equals(this.name, book.name) &&
        Objects.equals(this.author, book.author) &&
        Objects.equals(this.isRented, book.isRented) &&
        Objects.equals(this.overdueDays, book.overdueDays) &&
        Objects.equals(this.rentals, book.rentals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, name, author, isRented, overdueDays, rentals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    isRented: ").append(toIndentedString(isRented)).append("\n");
    sb.append("    overdueDays: ").append(toIndentedString(overdueDays)).append("\n");
    sb.append("    rentals: ").append(toIndentedString(rentals)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

