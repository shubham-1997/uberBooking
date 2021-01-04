package com.project.uberBooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {

	@Column(name = "USR_ID")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	@Column(name = "USR_NAME", unique = true)
	private String userName;

	@Column(name = "USR_EMAIL", unique = true)
	private String email;

	@Column(name = "USR_PASSWORD")
	private String password;	

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
}
