package ru.aklementev.springzaebalapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ru.aklementev.springzaebalapp.model.Zaebator;
import ru.aklementev.springzaebalapp.repository.MyRepository;
import ru.aklementev.springzaebalapp.service.MyService;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1")
public class ZaebalController {

    private final MyService service;
    private final MyRepository repository;


    @Autowired
    public ZaebalController(MyService service, MyRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping(value = "/user/{name}/zaebal", produces = MediaType.APPLICATION_JSON_VALUE)
    public Zaebator zaebalCounter(@PathVariable("name") final String name) throws IOException {
        service.checkName(name);

        return service.getZaebatorByName(name);
    }

    @GetMapping("/kto/i/skolko/zaebal")
    public String zaebalCounter() {
        repository.getAllZaebators();
        return repository.getAllZaebators().toString();
    }
}
