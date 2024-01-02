package com.erp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.binding.LoginForm;
import com.erp.binding.SignUpForm;
import com.erp.constatnt.AppConstant;
import com.erp.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/erpTally")
public class SingUpController {

	@Autowired
	private SignUpService service;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody SignUpForm form) {
		String save = service.signUp(form);
		return new ResponseEntity<String>(save, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginForm form) {
		Boolean status = service.login(form);
		if (status) {
			return new ResponseEntity<String>(AppConstant.LOGIN_SUCCES, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(AppConstant.INVALID_CREDENTIAL, HttpStatus.OK);
		}
	}

	@GetMapping("/forgot/{email}")
	public ResponseEntity<String> forgetPwd(@PathVariable String email) {
		Boolean status = service.forgetpassword(email);
		if (status) {
			return new ResponseEntity<>(AppConstant.CHECK_EMAIL,
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppConstant.INVALID_EMAIL, HttpStatus.NOT_FOUND);
	}

}
