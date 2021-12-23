package com.example.libraryapi.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableBookDto {
    private List<BookDTO> bookDtoList;
    private int totalPages;
    private long totalElements;
}