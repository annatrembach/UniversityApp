package com.university;

import com.university.console.CommandProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class UniversityManagerApplication implements CommandLineRunner {

	public CommandProcessor commandProcessor;

	public UniversityManagerApplication(CommandProcessor commandProcessor) {
		this.commandProcessor = commandProcessor;
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Welcome to University App. Type your command:");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if ("exit".equalsIgnoreCase(input)) break;
			commandProcessor.processCommand(input);
		}
	}
}
