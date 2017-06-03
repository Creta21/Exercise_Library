package io.swagger;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import java.text.FieldPosition;
import java.util.Date;


public class RFC3339DateFormat extends ISO8601DateFormat {

  // Same as ISO8601DateFormat but serializing milliseconds.
  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    String value = ISO8601Utils.format(date, true);
    toAppendTo.append(value);
    return toAppendTo;
  }

}

/*
    To package io.swagger && to io.swagger.configuration dimiourgeite apo ta stubs.
    mpainoume mesa sto fakelo swagger kai diagrafoume ti main, einai ena arxeio me onoma SpringBoot2
    h kati tetoio. Meta pame pisw na vlepoume to fakelo io ton kanoume copy kai pame sto fakelo me to 
    project mas kai pame ekei pou einai o fakelos com kai naoume paste! :)
*/