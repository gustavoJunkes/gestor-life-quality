package com.gustavojunkes.gestorlifequality.service;

import com.gustavojunkes.gestorlifequality.exception.UserNotFoundException;
import com.gustavojunkes.gestorlifequality.model.User;
import com.gustavojunkes.gestorlifequality.model.dto.DefaultUserDto;
import com.gustavojunkes.gestorlifequality.model.dto.DtoConvert;
import com.gustavojunkes.gestorlifequality.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    DtoConvert dtoConvert;

    /**
     * MÉTODOS SAVE RETORNANDO OBJECT
     * */
    public DefaultUserDto save(DefaultUserDto userDto){
        User user = dtoConvert.defaultDtoToUserEntity(userDto);
        user = (User) repository.save(user);

        return dtoConvert.toDefaultUserDto(user);
    }

    public void delete(Long id){
        Optional<User> user = repository.findById(id);

        if (user.isPresent()){
            repository.deleteById(id);
        }else throw new UserNotFoundException("No user found with the given id ("+id+")");
    }

    /**
     * ATENÇÃO A ESSE MÉTODO
     * */
    public DefaultUserDto edit(DefaultUserDto userDto, Long id){
//        Optional<User> user = repository.findById(id);

        User newUser = dtoConvert.defaultDtoToUserEntity(userDto);
        newUser.setId(id);
        newUser = (User) repository.save(newUser);
        return dtoConvert.toDefaultUserDto(newUser);
    }

    public DefaultUserDto getById(Long id){
        Optional<User> user = repository.findById(id);

        if(user.isPresent()){
            return dtoConvert.toDefaultUserDto(user.get());
        }else throw new UserNotFoundException("No user found with the given id ("+id+")");
    }

    public List<DefaultUserDto> getAll(){
        List<User>users = repository.findAll();
        return dtoConvert.toDefaultUserDtoList(users);
    }
}
