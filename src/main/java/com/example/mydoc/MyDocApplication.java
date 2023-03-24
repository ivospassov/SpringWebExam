package com.example.mydoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDocApplication.class, args);
	}

	//TODO: (2) make a Contacts and About us page
	//TODO: (3) think what to do with the search bar
	//TODO: (6) make a review form: write comments, reviews
	//TODO: (7) <u>maybe</u> let users register themselves as doctors, have a form
	//TODO: (8) maybe make a donation page or 'give us your thoughts and suggestions' for making the app better
	//TODO: (9) Run schedule job to delete every N-th day appointments that have a 'cancelled' status
	//TODO: (9) display a review form on doctors page --> https://freefrontend.com/bootstrap-star-ratings/
}
