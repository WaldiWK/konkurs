package pl.kuranc.demo.konkurs.controller;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.kuranc.demo.konkurs.controller.validator.PasswordMatches;
import pl.kuranc.demo.konkurs.controller.validator.ValidEmail;

@PasswordMatches
public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3185414845691148390L;

	private boolean enabled;
	
	private boolean admin;
	
	@NotEmpty
	@Size(max = 45)
	@ValidEmail
	private String email;

	
	@Size(max = 63)
	private String password;
	
	@Size(max = 63)
	private String matchingPassword;

	

	public UserDTO() {
			
		}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UserDTO [enabled=" + enabled + ", admin=" + admin + ", email=" + email + ", password="
				+ password + ", matchingPassword=" + matchingPassword + "]";
	}

	
	
	
	

}
