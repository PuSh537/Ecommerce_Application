package com.wipro.ecommerce.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
public class Admin {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int adminID;
	@NotBlank
    private String adminName;
	@NotBlank
	@Email
    private String email;
	@Pattern(regexp = "\\d{10}")
    private String phoneNumber;
 
    @Size(min = 7, message="Password should have a minimum length of 7.")
    private String password;
    @NotNull
    private LocalDate joiningDate;
    
    @NotBlank(message = "Username is required")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores")
	private String username;
    
    private String role;
    
	
    public Admin() {
		super();
	}


	public Admin(@NotNull int adminID, @NotBlank String adminName, @NotBlank @Email String email,
			@Pattern(regexp = "\\d{10}") String phoneNumber, @NotBlank @Size(min = 8) String password,
			@NotNull LocalDate joiningDate,
			@NotBlank(message = "Username is required") @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores") String username,
			String role) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.joiningDate = joiningDate;
		this.username = username;
		this.role = role;
	}


	public int getAdminID() {
		return adminID;
	}


	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", joiningDate=" + joiningDate + ", username=" + username
				+ ", role=" + role + "]";
	}

}
