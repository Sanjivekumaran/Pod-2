package com.cts.authorizationmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
@Component
public class UserModel {
	
	@Id
	@Column(name = "userId")
	private String id;
	
	@Column(name = "userName")
	private String name;
	
	@Column(name = "userPassword")
	private String password;
	

	private String authToken;
}
