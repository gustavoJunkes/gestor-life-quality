package com.gustavojunkes.gestorlifequality.service;

import com.gustavojunkes.gestorlifequality.exception.AvaliationThemeNotFoundException;
import com.gustavojunkes.gestorlifequality.exception.UserNotFoundException;
import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.User;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultAvaliationThemeDto;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultUserDto;
import com.gustavojunkes.gestorlifequality.model.dto.DtoConvert;
import com.gustavojunkes.gestorlifequality.repository.AvaliationThemeRepository;
import com.gustavojunkes.gestorlifequality.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliationThemeService {

    @Autowired
    AvaliationThemeRepository repository;

    @Autowired
    DtoConvert dtoConvert;

    /**
     * MÉTODOS SAVE RETORNANDO OBJECT
     * */
    public DefaultAvaliationThemeDto save(DefaultAvaliationThemeDto avaliationThemeDto){
        AvaliationTheme avaliationTheme = dtoConvert.defaultDtoToAvaliationThemeEntity(avaliationThemeDto);
        avaliationTheme = (AvaliationTheme) repository.save(avaliationTheme);

        return dtoConvert.toDefaultAvaliationThemeDto(avaliationTheme);
    }

    public void delete(Long id){
        Optional<AvaliationTheme> avaliationTheme = repository.findById(id);

        if (avaliationTheme.isPresent()){
            repository.deleteById(id);
        }else throw new AvaliationThemeNotFoundException("No avaliationTheme found with the given id ("+id+")");
    }

    /**
     * ATENÇÃO A ESSE MÉTODO
     * */
    public DefaultAvaliationThemeDto edit(DefaultAvaliationThemeDto avaliationThemeDto, Long id){
//        Optional<User> user = repository.findById(id);

        AvaliationTheme newAvaliationTheme = dtoConvert.defaultDtoToAvaliationThemeEntity(avaliationThemeDto);
        newAvaliationTheme.setId(id);
        newAvaliationTheme = (AvaliationTheme) repository.save(newAvaliationTheme);
        return dtoConvert.toDefaultAvaliationThemeDto(newAvaliationTheme);
    }

    public DefaultAvaliationThemeDto getById(Long id){
        Optional<AvaliationTheme> avaliationTheme = repository.findById(id);

        if(avaliationTheme.isPresent()){
            return dtoConvert.toDefaultAvaliationThemeDto(avaliationTheme.get());
        }else throw new AvaliationThemeNotFoundException("No avaliationTheme found with the given id ("+id+")");
    }

    public List<DefaultAvaliationThemeDto> getAll(){
        List<AvaliationTheme> avaliationThemes = repository.findAll();
        return dtoConvert.toDefaultAvaliationThemeDtoList(avaliationThemes);
    }

    public List<DefaultAvaliationThemeDto> getByAvaliation(Long id){
        Optional<List<AvaliationTheme>> avaliationThemes = repository.findByAvaliation(id);

        if(avaliationThemes.isPresent()){
            List<DefaultAvaliationThemeDto> dtos = dtoConvert.toDefaultAvaliationThemeDtoList(avaliationThemes.get());
            return dtos;
        }else throw new AvaliationThemeNotFoundException("No theme was found");
    }

}
