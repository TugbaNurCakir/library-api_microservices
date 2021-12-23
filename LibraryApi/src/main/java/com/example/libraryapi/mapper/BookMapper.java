package com.example.libraryapi.mapper;

import com.example.libraryapi.model.entity.Book;
import com.example.libraryapi.model.entity.dto.BookDTO;
import com.example.libraryapi.model.entity.dto.PageableBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    BookDTO toBookDto(Book book);
    List<BookDTO> toBookDtoList(List<Book> book);

    PageableBookDto toPageableBookDto(Page<Book> bookPage);
}
