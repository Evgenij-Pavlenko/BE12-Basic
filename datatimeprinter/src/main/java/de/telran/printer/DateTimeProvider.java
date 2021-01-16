package de.telran.printer;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
public class DateTimeProvider {
    public String getCurrentDateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
