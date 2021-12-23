package com.example.libraryapi.Controller;

import com.example.libraryapi.Service.BookService;
import com.example.libraryapi.model.entity.Request.GetPageableRequest;
import com.example.libraryapi.model.entity.dto.BookDTO;
import com.example.libraryapi.model.entity.dto.PageableBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @DeleteMapping("{id}")
    public void removeBook(@PathVariable int id) {
        bookService.removeBook(id);
    }

    @GetMapping("{id}")
    public BookDTO getBook(@PathVariable int id) {
        return bookService.getBookDto(id);
    }

    @GetMapping
    public PageableBookDto getBook(GetPageableRequest request) {
        return bookService.getBookDtoList(request);
    }
}
