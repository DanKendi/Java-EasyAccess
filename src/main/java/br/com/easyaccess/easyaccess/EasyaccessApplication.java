package br.com.easyaccess.easyaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EasyaccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyaccessApplication.class, args);
	}

}
