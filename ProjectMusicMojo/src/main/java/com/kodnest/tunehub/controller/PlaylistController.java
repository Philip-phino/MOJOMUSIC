package com.kodnest.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlaylistService;
import com.kodnest.tunehub.serviceimpl.SongServiceImpl;


@Controller
public class PlaylistController {
	@Autowired
	SongServiceImpl ssi;
	
	@Autowired
	PlaylistService pls;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model m) {
		m.addAttribute("songs",ssi.getSongs());
		return "createplaylist";
	}
	
	@GetMapping("/viewplaylist")
	public String displayPlaylist(Model m) {
		m.addAttribute("playlist",pls.getPlaylist());
		return "DisplayPlaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		pls.addPlaylist(playlist);
		List<Song> songlist = playlist.getSongs();
		for (Song song : songlist) {
			song.getPlaylist().add(playlist);
			ssi.updateSong(song);
		}
		return "admin";
	}
	
}
