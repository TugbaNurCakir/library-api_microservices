package com.example.registrationapi.client.library;

import com.example.registrationapi.client.library.model.dto.BookDto;
import com.example.registrationapi.client.library.model.request.UpdateAvailableRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LibraryApiService {
    private final RestTemplate libraryApiTemplate;
    private final ObjectMapper objectMapper;

    public BookDto getBookDto(int id){
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
       ResponseEntity<BookDto> responseEntity= libraryApiTemplate.getForEntity("/books/{id}", BookDto.class, params);
       return responseEntity.getBody();
    }
    @SneakyThrows
    public void updateAvailability(int id, boolean availability) throws JsonProcessingException {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));


        UpdateAvailableRequest request = UpdateAvailableRequest.builder()
                .availability(availability)
                .build();

        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UpdateAvailableRequest> httpEntity = new HttpEntity<>(request, reqHeaders);
        libraryApiTemplate.put("/books/{id}/availability", httpEntity, params);
    }
}
