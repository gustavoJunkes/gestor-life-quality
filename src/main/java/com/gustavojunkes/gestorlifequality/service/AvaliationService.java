 package com.gustavojunkes.gestorlifequality.service;

import com.gustavojunkes.gestorlifequality.exception.AvaliationNotFoundException;
import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.Question;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultAvaliationDto;
import com.gustavojunkes.gestorlifequality.model.dto.DtoConvert;
import com.gustavojunkes.gestorlifequality.repository.AvaliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliationService {

    @Autowired
    AvaliationRepository repository;

    @Autowired
    DtoConvert dtoConvert;

    /**
     * MÉTODOS SAVE RETORNANDO OBJECT
     * */

    //idependente de existir ou não, a avaliação é salva commo uma nova de qualquer forma
    public DefaultAvaliationDto save(DefaultAvaliationDto avaliationDto){

        Avaliation avaliation = dtoConvert.defaultDtoToAvaliationEntity(avaliationDto);
        avaliation.setDate(LocalDate.now());

        // pergunta se o numero dessa avaliação bate com o de alguma já cadastrada

//        if (avaliationId == null){
            avaliation = (Avaliation) repository.save(avaliation);
//        }else{
//            //recria essa avaliação como uma nova identica
//            avaliation = copyAvaliationContent(avaliationId);
//        }
        return dtoConvert.toDefaultAvaliationDto(avaliation);
    }

    public void delete(Long id){
        Optional<Avaliation> avaliation = repository.findById(id);

        if (avaliation.isPresent()){
            repository.deleteById(id);
        }else throw new AvaliationNotFoundException("No avaliation found with the given id ("+id+")");
    }

    /**
     * ATENÇÃO A ESSE MÉTODO
     * */
    public DefaultAvaliationDto edit(DefaultAvaliationDto avaliationDto, Long id){
//        Optional<User> user = repository.findById(id);

        Avaliation newAvaliation = dtoConvert.defaultDtoToAvaliationEntity(avaliationDto);
        newAvaliation.setId(id);
        newAvaliation = (Avaliation) repository.save(newAvaliation);
        return dtoConvert.toDefaultAvaliationDto(newAvaliation);
    }

    public DefaultAvaliationDto getById(Long id){
        Optional<Avaliation> avaliation = repository.findById(id);

        if(avaliation.isPresent()){
            return dtoConvert.toDefaultAvaliationDto(avaliation.get());
        }else throw new AvaliationNotFoundException("No avaliation found with the given id ("+id+")");
    }

    public List<DefaultAvaliationDto> getAll(){
        List<Avaliation>avaliations = repository.findAll();
        return dtoConvert.toDefaultAvaliationDtoList(avaliations);
    }

//    retorna true se a avaliação já existe, seguindo a lógica de negócio implementada, retorna false caso ela não exista ou nunca tenha sido feita.
    private Long isAnExistingAvaliation(Long controlNumber){

        List<Avaliation> avaliations = repository.findAll();

        for (Avaliation avaliation:
            avaliations) {
            if(avaliation.getControlNumber().equals(controlNumber)){
                return avaliation.getId();
            }
        }
        return null;
    }

//    private Avaliation copyAvaliationContent(Long id){
//
//        Avaliation avaliation = repository.getById(id);
//
//        Avaliation copiedAvaliation = new Avaliation(avaliation.getScore(), avaliation.getTittle(), avaliation.getDescription(), avaliation.getUser(), avaliation.getDate(), avaliation.getAvaliationThemes(), avaliation.getControlNumber());
//        return copiedAvaliation;
//    }


    //Este método transforma todas as respostas das questões de dada avaliação em null
//    private List<AvaliationTheme> setQuestionsToNull(Avaliation avaliation){
//
//        List<AvaliationTheme> avaliationThemes = avaliation.getAvaliationThemes();
//
//        for (AvaliationTheme theme:
//             avaliationThemes) {
//            for (Question question: theme.getQuestions() ) {
//                question.setAnswer(null);
//            }
//
//        }'
//
//    }
}
