package com.gustavojunkes.gestorlifequality.controller;

import com.gustavojunkes.gestorlifequality.model.dto.DefaultAvaliationDto;
import com.gustavojunkes.gestorlifequality.service.AvaliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliation")
public class AvaliationController {
    @Autowired
    AvaliationService avaliationService;

    @PostMapping
    public ResponseEntity<DefaultAvaliationDto> save(@RequestBody DefaultAvaliationDto avaliationDto){
        return new ResponseEntity<>(avaliationService.save(avaliationDto), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<DefaultAvaliationDto> edit(@RequestBody DefaultAvaliationDto avaliationDto, @RequestParam ("id") Long id){
            return new ResponseEntity<>(avaliationService.edit(avaliationDto, id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam ("id") Long id){
        avaliationService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DefaultAvaliationDto>> getAll(){
        return new ResponseEntity<>(avaliationService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultAvaliationDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<>(avaliationService.getById(id), HttpStatus.OK);
    }
}
