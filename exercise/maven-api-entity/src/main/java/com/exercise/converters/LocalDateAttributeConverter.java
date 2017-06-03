package com.exercise.converters;

import java.sql.Date; // tis vasis
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.LocalDate; // apo ta entity tis java

// Metatrepei to Date tis vasis se LocalDate kai anapoda
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDate jodDate) {
    	return (jodDate == null ? null : Date.valueOf(jodDate.toString()));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : new LocalDate(sqlDate));
    }
}