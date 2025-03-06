package com.bs.zodo.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
@Service
public class LatestDateFormater {
    public List<String> formatDates(List<String> givenDates, String outputFormat) {
        List<String> validDats = new ArrayList<>();
        List<DateTimeFormatter> formats = Arrays.asList(
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("MM-dd-yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ofPattern("MMM d, yyyy")
        );


        for (String toFormaterDate : givenDates) {
            Optional<LocalDate> date = Optional.ofNullable(parseDate(formats, toFormaterDate));
            date.ifPresent(value -> validDats.add(value.toString()));
        }
        return validDats;
    }

    private LocalDate parseDate(List<DateTimeFormatter> formats, String givenDate) {
        for (DateTimeFormatter format : formats) {
            try {
                return LocalDate.parse(givenDate, format);
            } catch (DateTimeParseException ignored) {
                // Try next format
            }
        }
        return null;
    }
}
