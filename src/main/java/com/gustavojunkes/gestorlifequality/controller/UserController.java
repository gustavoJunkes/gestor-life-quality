package com.gustavojunkes.gestorlifequality.controller;

import com.gustavojunkes.gestorlifequality.model.dto.DefaultUserDto;
import com.gustavojunkes.gestorlifequality.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<DefaultUserDto> save(@RequestBody DefaultUserDto userDto){
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DefaultUserDto> edit(@RequestBody DefaultUserDto userDto, @RequestParam ("id") Long id){
            return new ResponseEntity<>(userService.edit(userDto, id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam ("id") Long id){
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DefaultUserDto>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultUserDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
}
