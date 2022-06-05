package com.paulamata.bloodbowlteams.dto;

import java.io.Serializable;

public class RespuestaLoginDTO  implements Serializable{
	
	private String accessToken;
	
	public RespuestaLoginDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
