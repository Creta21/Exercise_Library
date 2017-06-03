package com.exercise.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;
import javax.validation.constraints.*;
/**
 * Rental
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-02T21:22:43.118+03:00")

public class Rental   {
  @JsonProperty("personName")
  private String personName = null;

  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("returnDate")
  private LocalDate returnDate = null;

  public Rental personName(String personName) {
    this.personName = personName;
    return this;
  }

   /**
   * Get personName
   * @return personName
  **/
  @ApiModelProperty(value = "")
  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public Rental date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Rental returnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
    return this;
  }

   /**
   * Get returnDate
   * @return returnDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(this.personName, rental.personName) &&
        Objects.equals(this.date, rental.date) &&
        Objects.equals(this.returnDate, rental.returnDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personName, date, returnDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rental {\n");
    
    sb.append("    personName: ").append(toIndentedString(personName)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
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

