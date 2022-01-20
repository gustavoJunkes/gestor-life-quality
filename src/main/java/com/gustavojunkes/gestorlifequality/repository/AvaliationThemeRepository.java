package com.gustavojunkes.gestorlifequality.repository;

import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliationThemeRepository extends JpaRepository<AvaliationTheme, Long>{

//    Optional<List<AvaliationTheme>> findByAvaliation(Long id);

    //
//    @Query("select A")
//    List<AvaliationTheme> searchByAvaliation(Long id);
//
//            select from AvaliationTheme avaliationTheme w
}
