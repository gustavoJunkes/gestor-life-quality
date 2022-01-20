package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.Question;
import com.gustavojunkes.gestorlifequality.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoConvert {

    public DefaultUserDto toDefaultUserDto(User user){
        DefaultUserDto dto = new DefaultUserDto(user.getId(), user.getName(), user.getEmail());
        return dto;
    }

    public DefaultAvaliationDto toDefaultAvaliationDto(Avaliation avaliation){
        DefaultAvaliationDto dto = new DefaultAvaliationDto(avaliation.getId(), avaliation.getScore(), avaliation.getTittle(), avaliation.getUser(), avaliation.getDate(), avaliation.getAvaliationThemes());
        return dto;
    }

    public User defaultDtoToUserEntity(DefaultUserDto dto){
        User user = new User(dto.id, dto.name, dto.email);
        return user;
    }

    public Avaliation defaultDtoToAvaliationEntity(DefaultAvaliationDto dto){
        Avaliation avaliation = new Avaliation(dto.score, dto.tittle, dto.user, dto.date, dto.avaliationThemes);
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

//      -=-=--==-==-=-=================-----------------=============================+++++++++=+=+===

    public DefaultQuestionDto toDefaultQuestionDto(Question question){
        DefaultQuestionDto dto = new DefaultQuestionDto(question.getId(), question.getTittle(), question.getScore());
        return dto;
    }

    public Question defaultDtoToQuestionEntity(DefaultQuestionDto dto){
        Question question = new Question(dto.id, dto.tittle, dto.score);
        return question;
    }

    public List<DefaultQuestionDto> toDefaultQuestionDtoList(List<Question>questions){
        List<DefaultQuestionDto> questionsDto = new ArrayList<>();
        for (Question question:
                questions) {
            questionsDto.add(toDefaultQuestionDto(question));
        }
        return questionsDto;
    }

//    -=-=-=--==-=-=-=-=-=--==-=--=+-+=+=+=+=+=

    public DefaultAvaliationThemeDto toDefaultAvaliationThemeDto(AvaliationTheme avaliationTheme){
        DefaultAvaliationThemeDto dto = new DefaultAvaliationThemeDto(avaliationTheme.getId(), avaliationTheme.getThemeName(), avaliationTheme.getScore(), avaliationTheme.getQuestions() );
        return dto;
    }

    public AvaliationTheme defaultDtoToAvaliationThemeEntity(DefaultAvaliationThemeDto dto){
        AvaliationTheme avaliationTheme = new AvaliationTheme(dto.id, dto.themeTittle, dto.score, dto.questions);
        return avaliationTheme;
    }

    public List<DefaultAvaliationThemeDto> toDefaultAvaliationThemeDtoList(List<AvaliationTheme>avaliationThemes){
        List<DefaultAvaliationThemeDto> avaliationThemesDto = new ArrayList<>();
        for (AvaliationTheme avaliationTheme:
                avaliationThemes) {
            avaliationThemesDto.add(toDefaultAvaliationThemeDto(avaliationTheme));
        }
        return avaliationThemesDto;
    }
}
