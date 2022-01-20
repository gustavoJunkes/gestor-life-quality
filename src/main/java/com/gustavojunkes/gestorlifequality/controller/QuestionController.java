package com.gustavojunkes.gestorlifequality.controller;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultQuestionDto;
import com.gustavojunkes.gestorlifequality.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<DefaultQuestionDto> save(@RequestBody DefaultQuestionDto questionDto){
        return new ResponseEntity<>(questionService.save(questionDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DefaultQuestionDto> edit(@RequestBody DefaultQuestionDto questionDto, @RequestParam ("id") Long id){
            return new ResponseEntity<>(questionService.edit(questionDto, id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam ("id") Long id){
        questionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DefaultQuestionDto>> getAll(){
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultQuestionDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<>(questionService.getById(id), HttpStatus.OK);
    }
}
