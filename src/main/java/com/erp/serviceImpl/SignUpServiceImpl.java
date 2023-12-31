package com.erp.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.binding.LoginForm;
import com.erp.binding.SignUpForm;
import com.erp.constatnt.AppConstant;
import com.erp.entity.SignUpEntity;
import com.erp.repository.SignUpRepo;
import com.erp.service.SignUpService;
import com.erp.utils.EmailUtils;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private SignUpRepo repo;
	
	@Autowired
	private EmailUtils emailUtil;
	
	

	@Override
	public String signUp(SignUpForm form) {
	    if (form.getPassword().equals(form.getConfirmPassword())) {
	    	
	        if (!repo.existsByEmail(form.getEmail())) {
	            SignUpEntity entity = new SignUpEntity();
	            BeanUtils.copyProperties(form, entity);
	            repo.save(entity);
	            return AppConstant.STR_SIGNUP_SUCESS;
	        } else {
	            return AppConstant.STR_EXIST_EMAIL;
	        }
	    }
	    return AppConstant.INVALID_PZZWD_AND_CONFIRMPZZWD;
	}


	@Override
	public Boolean login(LoginForm form) {
	    SignUpEntity emailAndPwd = repo.findByEmailAndPassword(form.getUserId(), form.getPassword());
	    
	    SignUpEntity mobileNumAndPassword = repo.findByMobileNumberAndPassword(form.getUserId(), form.getPassword());

	     if (emailAndPwd != null || mobileNumAndPassword != null) {
	        return true;
	    } 
	     return false;
	}


	@Override
	public boolean forgetpassword(String email) {
		SignUpEntity findByEmail = repo.findByEmail(email);
		
		if (findByEmail == null) {
			return false;
		}
		String subject = AppConstant.RECOVER_PAZZWD;
		String body = AppConstant.STR_MY_PAZZWD + findByEmail.getPassword();
		emailUtil.sendEmail(email, subject, body);
		return true;

	}
}
