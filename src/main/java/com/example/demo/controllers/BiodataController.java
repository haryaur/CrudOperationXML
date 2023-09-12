package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Biodata;
import com.example.demo.repository.BiodataRepository;

@RestController
public class BiodataController {
	
	@Autowired
	BiodataRepository biodataRepository;

	
	@GetMapping("/biodata")
	  public ResponseEntity<List<Biodata>> getAllCreated() {
	    try {
	      List<Biodata> biodata = biodataRepository.findAll();
	      if (biodata.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(biodata, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/biodata/{id}")
	  public ResponseEntity<Biodata> getTutorialById(@PathVariable("id") int id) {
	    Optional<Biodata> data = biodataRepository.findById(id);
	    if (data.isPresent()) {
	      return new ResponseEntity<>(data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/createData")
	  public ResponseEntity<Biodata> CreateXML(@RequestBody Biodata biodata) {
	    try {
	      Biodata save = biodataRepository.save(biodata);
	      return new ResponseEntity<>(save, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }


}
