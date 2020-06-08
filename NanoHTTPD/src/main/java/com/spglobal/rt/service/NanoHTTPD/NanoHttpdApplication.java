package com.spglobal.rt.service.NanoHTTPD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.iki.elonen.NanoHTTPD;

@SpringBootApplication
public class NanoHttpdApplication extends NanoHTTPD {

	public NanoHttpdApplication() {
		super(8000);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SpringApplication.run(NanoHttpdApplication.class, args);
	}

}
