package dev.phoenixtype.pagination.data;

import com.github.javafaker.Faker;
import dev.phoenixtype.pagination.model.Address;
import dev.phoenixtype.pagination.model.Person;
import dev.phoenixtype.pagination.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading sample data");

        // create 100 rows of people in the database
        List<Person> people = IntStream.rangeClosed(0,0)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                )).toList();
        personRepository.saveAll(people);
        logger.info("Sample data loaded");
    }
}