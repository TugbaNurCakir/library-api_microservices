package com.example.userapi.Controller;

import com.example.userapi.Model.Entity.dto.UserDto;
import com.example.userapi.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id){
        return userService.getUserDto(id);
    }

    @PutMapping("{id}/increment ")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void incrementCount(@PathVariable int id){
        userService.incrementRegistrationsCount(id);
    }


}
