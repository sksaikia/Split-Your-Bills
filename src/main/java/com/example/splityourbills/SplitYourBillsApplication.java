package com.example.splityourbills;

import com.example.splityourbills.service.interfaces.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@SpringBootApplication
public class SplitYourBillsApplication implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SplitYourBillsApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		storageService.init();
	}
}
