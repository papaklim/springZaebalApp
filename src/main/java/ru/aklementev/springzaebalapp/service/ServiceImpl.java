package ru.aklementev.springzaebalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aklementev.springzaebalapp.model.Zaebator;
import ru.aklementev.springzaebalapp.repository.MyRepository;

import java.util.List;

@Service
public class ServiceImpl implements MyService {

    private MyRepository repository;

    @Autowired
    public ServiceImpl(MyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void checkName(String nameToBeChecked) {
        boolean wasFound = false;
        List<Zaebator> allZaebators = repository.getAllZaebators();

        if (nameToBeChecked.equals("papaklim")) {
            throw new IllegalArgumentException("papaklim заебать не может");
        }

        for (int i = 0; i < allZaebators.size(); i++) {
            if (allZaebators.get(i).getName().equals(nameToBeChecked)) {
                Integer counter = allZaebators.get(i).getCounter();
                allZaebators.get(i).setCounter(++counter);
                wasFound = true;
                System.out.println(allZaebators);
            }
        }
        if (!wasFound) {
            System.out.println("Добавляем");
            allZaebators.add(new Zaebator(nameToBeChecked, 1));
            System.out.println(allZaebators);
        }

    }

    @Override
    public Zaebator getZaebatorByName(String name) {
        List<Zaebator> allZaebators = repository.getAllZaebators();
        Zaebator result = null;
        for (int i = 0; i < allZaebators.size(); i++) {
            if (allZaebators.get(i).getName().equals(name)) {
                return allZaebators.get(i);
            }
        }
        return result;
    }
}
