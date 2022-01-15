package com.gustavojunkes.gestorlifequality.service;

import com.gustavojunkes.gestorlifequality.exception.AvaliationNotFoundException;
import com.gustavojunkes.gestorlifequality.exception.UserNotFoundException;
import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.User;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultAvaliationDto;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultUserDto;
import com.gustavojunkes.gestorlifequality.model.dto.DtoConvert;
import com.gustavojunkes.gestorlifequality.repository.AvaliationRepository;
import com.gustavojunkes.gestorlifequality.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DefaultAvaliationDto save(DefaultAvaliationDto avaliationDto){
        Avaliation avaliation = dtoConvert.defaultDtoToAvaliationEntity(avaliationDto);
        avaliation = (Avaliation) repository.save(avaliation);

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
}
