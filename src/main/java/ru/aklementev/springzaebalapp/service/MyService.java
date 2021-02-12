package ru.aklementev.springzaebalapp.service;

import ru.aklementev.springzaebalapp.model.Zaebator;

import java.io.IOException;

public interface MyService {

    void checkName(String nameToBeChecked) throws IOException;

    Zaebator getZaebatorByName(String name);
}
