package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class ZipkinUiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinUiServerApplication.class, args);
	}

}
