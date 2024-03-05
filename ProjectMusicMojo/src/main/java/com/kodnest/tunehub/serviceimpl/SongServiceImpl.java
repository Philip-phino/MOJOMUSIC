package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	@Autowired
	SongRepository sr;
	
	@Override
	public String addSong(Song song) {
		try {
		    // Validate the song object
		    if (song != null) {
		        sr.save(song);
		    } else {
		        System.out.println("Invalid song data. Skipping save operation.");
		    }
		} catch (Exception e) {
		    System.out.println("Error occurred while saving the song: " + e.getMessage());
		}
		return "Song added Successfully";
	}
	
	@Override
	public List<Song> getSongs() {
		List<Song> songs = sr.findAll();
		return songs;
	}
	@Override
	public boolean nameExists(String name) {
		if (sr.findByName(name) != null) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String getLink(String name) {
	    Song s = sr.findByName(name);
	    if (s != null) {
	        String link = s.getLink();
	        System.out.println(link);
	        return link;
	    } else {
	    	System.out.println("Song Not Exists");
	        return ""; 
	    }
	}

	public void updateSong(Song song) {
		sr.save(song);
		
	}

	
}
