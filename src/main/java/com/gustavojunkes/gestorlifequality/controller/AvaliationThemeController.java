package com.gustavojunkes.gestorlifequality.controller;

import com.gustavojunkes.gestorlifequality.model.dto.DefaultAvaliationThemeDto;
import com.gustavojunkes.gestorlifequality.service.AvaliationThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliationTheme")
public class AvaliationThemeController {

    @Autowired
    AvaliationThemeService avaliationThemeService;

    @PostMapping
    public ResponseEntity<DefaultAvaliationThemeDto> save(@RequestBody DefaultAvaliationThemeDto avaliationThemeDto){
        return new ResponseEntity<>(avaliationThemeService.save(avaliationThemeDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DefaultAvaliationThemeDto> edit(@RequestBody DefaultAvaliationThemeDto avaliationThemeDto, @RequestParam ("id") Long id){
            return new ResponseEntity<>(avaliationThemeService.edit(avaliationThemeDto, id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam ("id") Long id){
        avaliationThemeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DefaultAvaliationThemeDto>> getAll(){
        return new ResponseEntity<>(avaliationThemeService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultAvaliationThemeDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<>(avaliationThemeService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DefaultAvaliationThemeDto>> getByAvaliationId(@RequestParam Long id){
        return new ResponseEntity<>(avaliationThemeService.getByAvaliation(id), HttpStatus.OK);
    }
}
