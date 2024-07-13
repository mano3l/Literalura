package com.personal.Literalura;

import com.personal.Literalura.ui.UserInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
		UserInterface userInterface = context.getBean(UserInterface.class);
		userInterface.start();
	}

}
