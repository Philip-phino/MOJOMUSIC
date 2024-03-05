package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.serviceimpl.SongServiceImpl;

@Controller
public class SongController {
	@Autowired
	SongServiceImpl ssi;

	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		String name = song.getName();
		boolean status = ssi.nameExists(name);
		if (status == false) {
			ssi.addSong(song);
			System.out.println("Song Added");
		} else {
			System.out.println("Song Already Exists");
		}
		return "NewSong";
	}

	@GetMapping("/viewsong")
	public String getSongs(Model m) {
		List<Song> songlist = ssi.getSongs();
		m.addAttribute("songs",songlist );
		return "songs";
	}

	@GetMapping("/playsong")
	public String getSongsOfCustomer(Model m) {
		boolean premium = true;
		if (premium) {
			m.addAttribute("songs", ssi.getSongs());
			return "songs";
		} else {
			return "SubscriptionForm";
		}
	}

	@GetMapping("/searchsong")
	public String getLink(@RequestParam("search") String name, Model m) {
		String link = ssi.getLink(name);
		if (link != null) {
			m.addAttribute("audioLink", link);
			m.addAttribute("songName", name);
		}
		return "searchsong";
	}

}
