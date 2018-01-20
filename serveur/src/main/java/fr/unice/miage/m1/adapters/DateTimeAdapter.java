package fr.unice.miage.m1.adapters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override public LocalDateTime unmarshal(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(value, formatter);
    }

    @Override
    public String marshal(LocalDateTime v) {
        // TODO : Implement
        return null;
    }
}