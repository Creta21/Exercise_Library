package com.exercise.converters;

import java.sql.Timestamp;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

// Metatrepei to Timestamp se DateTime
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<DateTime, Timestamp>{
    

    @Override
    public Timestamp convertToDatabaseColumn(DateTime jodDateTime) {
        return (jodDateTime == null ? null : new Timestamp(jodDateTime.toDateTime().getMillis()));
    }
 
    @Override
    public DateTime convertToEntityAttribute(Timestamp sqlTimestamp) {      
        return (sqlTimestamp == null ? null : new DateTime(sqlTimestamp, DateTimeZone.UTC));
    }    

}
