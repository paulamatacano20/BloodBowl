package com.paulamata.bloodbowlteams.security;

import java.security.Key;

import io.jsonwebtoken.impl.crypto.MacProvider;

public class SecurityConstants {
	public static final Key SECRET_KEY = MacProvider.generateKey();
}
