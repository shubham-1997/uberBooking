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
@Table(name = "DRIVERS")
public class Driver {

	@Column(name = "DRVR_ID")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	@Column(name = "DRVR_NAME", unique = true)
	private String userName;

	@Column(name = "DRVR_EMAIL", unique = true)
	private String email;

	@Column(name = "DRVR_PASSWORD")
	private String password;

	public Driver() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
}
