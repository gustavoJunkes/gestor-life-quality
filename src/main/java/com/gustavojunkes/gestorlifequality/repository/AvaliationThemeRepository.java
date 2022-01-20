package com.gustavojunkes.gestorlifequality.repository;

import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliationThemeRepository extends JpaRepository<AvaliationTheme, Long>{

}
