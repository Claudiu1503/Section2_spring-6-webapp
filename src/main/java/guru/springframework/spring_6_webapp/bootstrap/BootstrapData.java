package guru.springframework.spring_6_webapp.bootstrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Jhons");

        Book ddd = new Book();
        ddd.setTitle("Atomic Habits");
        ddd.setIsbn("123123");


        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Doe");

        Book abc = new Book();
        abc.setTitle("Deep Work");
        abc.setIsbn("456456");

        Author johnSaved = authorRepository.save(john);
        Book abcSaved = bookRepository.save(abc);

        ericSaved.getBooks().add(dddSaved);
        johnSaved.getBooks().add(abcSaved);

        authorRepository.save(johnSaved);
        authorRepository.save(ericSaved);

        System.out.println("In boostrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: "+bookRepository.count());




    }
}
