package com.gustavojunkes.gestorlifequality.repository;

import com.gustavojunkes.gestorlifequality.model.Question;
import com.gustavojunkes.gestorlifequality.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
