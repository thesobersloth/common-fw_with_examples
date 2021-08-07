package com.testfw.astracassandraapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testfw.astracassandraapp.model.Student;
import com.testfw.astracassandraapp.repo.TestRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TestController {

	@Autowired
	TestRepository repo;

	@ApiOperation(value = "Create Student", notes = "This method creates a new Student")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Saved Successfully!", response = String.class) })
	@GetMapping("/testDBOps")
	public ResponseEntity<String> testDBOps(@RequestBody Student stud) {
		repo.save(stud);
		return ResponseEntity.status(HttpStatus.OK).body("Saved Successfully!");
	}

}