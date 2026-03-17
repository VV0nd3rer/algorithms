package com.home.algorithms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AlgorithmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome in the world af algorithms, a set approaches for solving typical tasks...");
		System.out.println("Enjoy and have fun :)");

		if (args.length > 0) {
			System.out.println("Let's start with educational " +
					"and effective for small datasets Bubble sort algorithm." +
					"Enter unsorted set of integer numbers: ");

			for(String arg: args) {
				System.out.println(" - " + arg);
			}
			System.exit(0);
		}
	}
}
