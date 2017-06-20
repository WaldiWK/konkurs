package pl.kuranc.demo.konkurs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 722694304049498880L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "email", length = 45, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 63, nullable = false)
	private String password;

	@Column(name = "role", length = 20, nullable = false)
	private String role;

	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;

	public User() {
		
	}
	
	public User(String email, String password, boolean enabled, String role){
		this.email=email;
		this.password=password;
		this.enabled=enabled;
		this.role=role;
	}

	public long getId() {
		return id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", email" + email + ", password=" + password + ", role=" + role + ", enabled="
				+ enabled + "]";
	}

}
