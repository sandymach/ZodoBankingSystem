package com.bs.zodo.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DateFormaterService {
    public List<String> formatDates(List<String> givenDates, String outputFormat) {
        SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat.trim());
        List<String> formats = Arrays.asList(
                "yyyy-MM-dd", "dd/MM/yyyy", "MM-dd-yyyy", "yyyy/MM/dd", "dd.MM.yyyy", "MMM d, yyyy"
        );
        List<String> validDats = new ArrayList<>();

        for (String toFormaterDate : givenDates) {
            Optional<Date> date = Optional.ofNullable(parseDate(formats, toFormaterDate));
            date.ifPresent(value -> validDats.add(outputFormatter.format(value)));
        }
        return validDats;
    }

    private Date parseDate(List<String> formats, String givenDate) {
        for (String format : formats) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                dateFormat.setLenient(false);
                dateFormat.parse(givenDate.trim());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
