package de.jescode.games.ropasci;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RopasciApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RopasciApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}	
}
