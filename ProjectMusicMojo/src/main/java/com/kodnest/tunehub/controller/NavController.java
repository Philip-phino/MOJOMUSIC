package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/Registration")
	public String registration() {
		return "Registration";
	}

	@GetMapping("/Login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/NewSong")
	public String NewSong() {
		return "NewSong";
	}
	
	@GetMapping("/SongList")
	public String SongList() {
		return "SongList";
	}
}
