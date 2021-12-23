package com.example.registrationapi.client.user;

import com.example.registrationapi.client.user.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserApiService {
    private final RestTemplate userApiTemplate;

    public UserDto getUserDto(int id){
        return userApiTemplate.getForObject("/users/"+id, UserDto.class);
    }
    public void implementCount(int id){
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        ResponseEntity<Void> exchange = userApiTemplate.exchange("/users/{id}/increment", HttpMethod.PUT, null, Void.class, params);
    }
}
