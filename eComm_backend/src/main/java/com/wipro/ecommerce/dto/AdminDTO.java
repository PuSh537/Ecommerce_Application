package com.wipro.ecommerce.dto;

import java.time.LocalDate;

public class AdminDTO {

	 private int adminID;
	    private String adminName;
	    private String email;
	    private String phoneNumber;
	    private String username;
	    private String password;
	    private LocalDate joiningDate;
	    private String role;

		public AdminDTO() {
			super();
		}

		public AdminDTO(int adminID, String adminName, String email, String phoneNumber, String username,
				String password, LocalDate joiningDate, String role) {
			super();
			this.adminID = adminID;
			this.adminName = adminName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
			this.joiningDate = joiningDate;
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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "AdminDTO [adminID=" + adminID + ", adminName=" + adminName + ", email=" + email + ", phoneNumber="
					+ phoneNumber + ", username=" + username + ", password=" + password + ", joiningDate=" + joiningDate
					+ ", role=" + role + "]";
		}

		
		
		
}
