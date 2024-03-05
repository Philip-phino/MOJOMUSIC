package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {
	public String addSong(Song song);
	public List<Song> getSongs();
	public boolean nameExists(String name);
	public String getLink(String name);
	public void updateSong(Song song);
	
}