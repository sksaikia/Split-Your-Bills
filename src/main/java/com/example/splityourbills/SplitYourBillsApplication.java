package com.example.splityourbills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SplitYourBillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitYourBillsApplication.class, args);
	}

}
