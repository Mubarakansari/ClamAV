package com.clamav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.capybara.clamav.ClamavClient;

import java.nio.file.Paths;

@SpringBootApplication
public class ClamAVApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClamAVApplication.class, args);
//		ClamavClient client = new ClamavClient("127.0.0.1", 5000);
//		System.out.println("getServer>>" + client.getServer());
//		System.out.println("stats>>" + client.scan(Paths.get("/home/mubarak/Downloads/111/eicar.com")));
	}

}
