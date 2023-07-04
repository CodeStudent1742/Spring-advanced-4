package com.csvconverter.csvconverter;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PersonProcessor implements ItemProcessor<Person, Person> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Person process(Person person) throws Exception {
        LocalDate birthDate = person.getBirthDate();
        int age = calculateAge(birthDate);
        person.setAge(age);
        return person;
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}