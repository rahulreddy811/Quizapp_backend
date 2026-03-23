package com.example.demo.repository;

import com.example.demo.model.FillinBlanksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FillinBlanksrepo extends JpaRepository<FillinBlanksModel,Integer> {
}
