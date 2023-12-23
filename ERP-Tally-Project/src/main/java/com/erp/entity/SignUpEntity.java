package com.erp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SINGUP_TAB")
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotBlank(message = "Please enter proper firstName name")
	@Size(min = 3, message = "firstName should be atleast 3 characters")
	@Size(max = 15, message = "firstName should not be greater than 15 characters")

	private String firstName;

	@NotBlank(message = "Please enter proper lastName name")
	@Size(min = 2, message = "lastName should be atleast 2 characters")
	@Size(max = 15, message = "lastName should not be greater than 15 characters")
	//@Column(name = "NAME")
	private String lastName;

	@NotBlank(message = "Please enter a valid email address.")
	@Email(message = "Please enter a valid email address.")
	@Size(max = 50, message = "Email should not be greater than 50 characters.")
	//@Column(name = "EMAIL")
	private String email;

	@NotNull(message = "Mobile number must not be null.")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be numeric and have at most 10 digits.")
	//@Column(name = "MOBILE_NO")
	private Long mobileNumber;


	@NotBlank(message = "Password should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	@Size(max = 15, message = "password should not be greater than 16 characters")
	//@Column(name = "PASSWORD")
	private String password;

	@NotBlank(message = "confirmPwd should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	//@Column(name = "CONFIRM_PASSWORD")
	@Size(max = 15, message = "confirmPwd should not be greater than 16 characters")
	private String confirmPassword;

//	@NotBlank(message = "company should not be empty.")
//	@Column(name = "COMPANY")
//	private String company;

	@NotBlank(message = "address should not be empty.")
	//@Column(name = "ADDRESS")
	private String address;

	@NotBlank(message = "country should not be empty.")

	private String country;
	
	
	@NotBlank(message = "state should not be empty.")
	
    private String state;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public SignUpEntity(Integer userId,
			@NotBlank(message = "Please enter proper firstName name") @Size(min = 3, message = "firstName should be atleast 3 characters") @Size(max = 15, message = "firstName should not be greater than 15 characters") String firstName,
			@NotBlank(message = "Please enter proper lastName name") @Size(min = 2, message = "lastName should be atleast 2 characters") @Size(max = 15, message = "lastName should not be greater than 15 characters") String lastName,
			@NotBlank(message = "Please enter a valid email address.") @Email(message = "Please enter a valid email address.") @Size(max = 50, message = "Email should not be greater than 50 characters.") String email,
			@NotNull(message = "Mobile number must not be null.") @Digits(integer = 10, fraction = 0, message = "Mobile number must be numeric and have at most 10 digits.") Long mobileNumber,
			@NotBlank(message = "Password should not be empty.") @Size(min = 6, message = "password should be atleast 6 characters") @Size(max = 15, message = "password should not be greater than 16 characters") String password,
			@NotBlank(message = "confirmPwd should not be empty.") @Size(min = 6, message = "password should be atleast 6 characters") @Size(max = 15, message = "confirmPwd should not be greater than 16 characters") String confirmPassword,
			@NotBlank(message = "address should not be empty.") String address,
			@NotBlank(message = "country should not be empty.") String country,
			@NotBlank(message = "state should not be empty.") String state) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.country = country;
		this.state = state;
	}


	public SignUpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

	
	
	