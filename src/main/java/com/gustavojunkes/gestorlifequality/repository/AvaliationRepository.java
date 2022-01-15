package com.gustavojunkes.gestorlifequality.repository;

import com.gustavojunkes.gestorlifequality.model.Avaliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliationRepository extends JpaRepository<Avaliation, Long> {

}
