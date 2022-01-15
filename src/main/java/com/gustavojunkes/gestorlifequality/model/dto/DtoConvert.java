package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoConvert {

    public DefaultUserDto toDefaultUserDto(User user){
        DefaultUserDto dto = new DefaultUserDto(user.getName(), user.getEmail());
        return dto;
    }

    public DefaultAvaliationDto toDefaultAvaliationDto(Avaliation avaliation){
        DefaultAvaliationDto dto = new DefaultAvaliationDto(avaliation.getScore(), avaliation.getUser());
        return dto;
    }

    public User defaultDtoToUserEntity(DefaultUserDto dto){
        User user = new User(dto.name, dto.email);
        return user;
    }

    public Avaliation defaultDtoToAvaliationEntity(DefaultAvaliationDto dto){
        Avaliation avaliation = new Avaliation(dto.score, dto.user);
        return avaliation;
    }
    public List<DefaultUserDto> toDefaultUserDtoList(List<User>users){
        List<DefaultUserDto> usersDto = new ArrayList<>();
        for (User user:
             users) {
            usersDto.add(toDefaultUserDto(user));
        }
        return usersDto;
    }

    public List<DefaultAvaliationDto> toDefaultAvaliationDtoList(List<Avaliation>avaliations){
        List<DefaultAvaliationDto> avaliationsDto = new ArrayList<>();
        for (Avaliation avaliation:
                avaliations) {
            avaliationsDto.add(toDefaultAvaliationDto(avaliation));
        }
        return avaliationsDto;
    }

}
