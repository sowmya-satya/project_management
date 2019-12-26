package com.mindtree.projectmanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.projectmanagement.dto.AccountDto;
import com.mindtree.projectmanagement.entity.Ig;
import com.mindtree.projectmanagement.exception.ApplicationException;
import com.mindtree.projectmanagement.exception.ServiceException;
import com.mindtree.projectmanagement.service.AccountService;
import com.mindtree.projectmanagement.service.IgService;
import com.mindtree.projectmanagement.service.ProjectService;

@Controller
public class ApplicationController {
	
	@Autowired
	private IgService igService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProjectService projectService;
	
	
@PostMapping("/insertIG")
public ResponseEntity<Map<String, Object>> insertIG(@RequestBody Ig ig) throws ServiceException {
	Map<String, Object> response = new HashMap<String, Object>();
	response.put("Header", "Ig inserted");
	response.put("Error", false);
	response.put("Body",igService.insertIG(ig));
	response.put("HttpStatus", HttpStatus.OK);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}
@PostMapping("/insertAccountProduct")
public ResponseEntity<Map<String, Object>> insertAccountProduct(@RequestBody AccountDto accountDto) throws ApplicationException {
	Map<String, Object> response = new HashMap<String, Object>();
	response.put("Header", "Account and Project inserted");
	response.put("Error", false);
	response.put("Body",accountService.insertAccountProduct(accountDto));
	response.put("HttpStatus", HttpStatus.OK);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}

@PutMapping("/assignAccountToIG/{accountId}/{igId}")
public ResponseEntity<Map<String, Object>> assignAccountToIG(@PathVariable int accountId,@PathVariable int igId) throws ApplicationException {
	Map<String, Object> response = new HashMap<String, Object>();
	response.put("Header", "assinged account to ig");
	response.put("Error", false);
	response.put("Body",accountService.assignAccountToIG(accountId,igId));
	response.put("HttpStatus", HttpStatus.OK);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}
	
@GetMapping("/sortAccount/{igId}")
public ResponseEntity<Map<String, Object>> sortAccount(@PathVariable int igId) throws ApplicationException {
	Map<String, Object> response = new HashMap<String, Object>();
	response.put("Header", "assinged account to ig");
	response.put("Error", false);
	response.put("Body",accountService.sortAccount(igId));
	response.put("HttpStatus", HttpStatus.OK);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}
}
