package com.university;

import com.university.data.DbContext;
import com.university.console.CommandInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class UniversityManagerApplication implements CommandLineRunner {

	@Autowired
	private CommandInvoker commandInvoker;

	@Autowired
	private DbContext dbContext;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		dbContext.initTestData();

		System.out.println("Welcome to University App");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Type your command: \n");
			String input = scanner.nextLine();
			if ("exit".equalsIgnoreCase(input)) break;
			commandInvoker.executeCommand(input);
		}
	}
}
