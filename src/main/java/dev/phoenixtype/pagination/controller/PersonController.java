package dev.phoenixtype.pagination.controller;

import dev.phoenixtype.pagination.model.Person;
import dev.phoenixtype.pagination.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size) {
        return personRepository.findAll(PageRequest.of(page, size));
    }
}
