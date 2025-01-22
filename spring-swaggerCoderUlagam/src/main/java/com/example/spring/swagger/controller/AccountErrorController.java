package com.example.spring.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.swagger.model.Account;

@RestController
public class AccountErrorController {

	@Autowired
public GlobleExceptionHandler globleExceptionHandler ;
	
    @RequestMapping("/api/accounts/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable("accountId") String accountId){
		
		Account account = new Account();
		account.setAccountId(accountId);
		account.setName("CoderUlagam");
		
		if(accountId.equals("1")) {
			//throw new  globleExceptionHandler();
			throw new IllegalArgumentException();
		}
		
		if(accountId.equals("2")) {
			
			throw new IllegalStateException();
		}
		
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
    
    @ExceptionHandler(IllegalStateException.class)
    protected ResponseEntity<Object> handleException(IllegalStateException e){
    	return new ResponseEntity<Object>("Illegal State Exception",HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleException(IllegalArgumentException e){
    	return new ResponseEntity<Object>("Illegal Argument Exception in controller",HttpStatus.BAD_REQUEST);
    }

}
