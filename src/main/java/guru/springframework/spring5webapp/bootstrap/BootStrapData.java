package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author omar = new Author("Omar", "Morales");
        Book myBook = new Book("La melancolica muerte de Chico Ostra", "9788433901477");
        Publisher myPublisher = new Publisher();
        myPublisher.setName("Omar Publisher");

        omar.getBooks().add(myBook);
        myBook.getAuthors().add(omar);
        myBook.setPublisher(myPublisher);

        publisherRepository.save(myPublisher);
        authorRepository.save(omar);
        bookRepository.save(myBook);

        System.out.println("Books: "+bookRepository.count());
        System.out.println("Author: "+authorRepository.count());
        System.out.println("Publisher: "+publisherRepository.count());


    }
}
