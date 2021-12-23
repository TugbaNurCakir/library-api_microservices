package com.example.libraryapi;

import com.example.libraryapi.Repository.AuthorRepository;
import com.example.libraryapi.Repository.BookRepository;
import com.example.libraryapi.model.entity.Author;
import com.example.libraryapi.model.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //bir kere çalıştırdıktan sonra bu anatasyonu kapat.
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author = authorRepository.save(
                Author.builder()
                        .name("test")
                        .surname("author")
                        .build());

        for(int i=0; i<100; i++){
            bookRepository.save(
                    Book.builder()
                            .title("test book"+i)
                            .authorId(author.getId())
                            .build());

        }
    }
}
