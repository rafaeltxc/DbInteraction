package com.webapp.model;

import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {

	private Long idUser;
	private String nicknameUser;
	private Calendar birthUser;
	private String password;
	
	public User(Long idUser, String nicknameUser, Calendar birthUser, String password) {
		super();
		this.idUser = idUser;
		this.nicknameUser = nicknameUser;
		this.birthUser = birthUser;
		this.password = password;
	}
	
}
