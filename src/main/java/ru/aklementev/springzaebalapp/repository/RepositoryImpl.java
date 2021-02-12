package ru.aklementev.springzaebalapp.repository;


import org.springframework.stereotype.Component;
import ru.aklementev.springzaebalapp.model.Zaebator;

import java.util.List;

@Component
public class RepositoryImpl implements MyRepository {

    @Override
    public List<Zaebator> getAllZaebators() {
        return null;
    }


}
