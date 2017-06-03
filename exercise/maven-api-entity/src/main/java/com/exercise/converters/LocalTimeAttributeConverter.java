package com.exercise.converters;

import java.sql.Time;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.LocalTime;

//Metatrepei to LocalTime se Time 
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time>{
    

    @Override
    public Time convertToDatabaseColumn(LocalTime jodaLocalTime) { 
        return new Time(jodaLocalTime.toDateTimeToday().getMillis());
    }
 
    @Override
    public LocalTime convertToEntityAttribute(Time sqlTime) {      
        return (sqlTime == null ? null : new LocalTime(sqlTime));
    }
 

}
