package com.example.libraryapi.model.entity.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPageableRequest {
    private Integer pageSize;
    private Integer currentPage;
}