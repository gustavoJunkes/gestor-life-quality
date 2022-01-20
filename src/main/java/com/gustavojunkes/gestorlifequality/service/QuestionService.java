package com.gustavojunkes.gestorlifequality.service;

import com.gustavojunkes.gestorlifequality.exception.QuestionNotFoundException;
import com.gustavojunkes.gestorlifequality.model.Question;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultQuestionDto;
import com.gustavojunkes.gestorlifequality.model.dto.DtoConvert;
import com.gustavojunkes.gestorlifequality.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository repository;

    @Autowired
    DtoConvert dtoConvert;

    /**
     * MÉTODOS SAVE RETORNANDO OBJECT
     * */
    public DefaultQuestionDto save(DefaultQuestionDto questionDto){
        Question question = dtoConvert.defaultDtoToQuestionEntity(questionDto);
        question = (Question) repository.save(question);

        return dtoConvert.toDefaultQuestionDto(question);
    }

    public void delete(Long id){
        Optional<Question> question = repository.findById(id);

        if (question.isPresent()){
            repository.deleteById(id);
        }else throw new QuestionNotFoundException("No question found with the given id ("+id+")");
    }

    /**
     * ATENÇÃO A ESSE MÉTODO
     * */
    public DefaultQuestionDto edit(DefaultQuestionDto questionDto, Long id){
//        Optional<User> user = repository.findById(id);

        Question newQuestion = dtoConvert.defaultDtoToQuestionEntity(questionDto);
        newQuestion.setId(id);
        newQuestion = (Question) repository.save(newQuestion);
        return dtoConvert.toDefaultQuestionDto(newQuestion);
    }

    public DefaultQuestionDto getById(Long id){
        Optional<Question> question = repository.findById(id);

        if(question.isPresent()){
            return dtoConvert.toDefaultQuestionDto(question.get());
        }else throw new QuestionNotFoundException("No question found with the given id ("+id+")");
    }

    public List<DefaultQuestionDto> getAll(){
        List<Question> questions = repository.findAll();
        return dtoConvert.toDefaultQuestionDtoList(questions);
    }
}
