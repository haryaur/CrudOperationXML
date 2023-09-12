package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Biodata;

public interface BiodataRepository  extends JpaRepository<Biodata, Integer >{


}
