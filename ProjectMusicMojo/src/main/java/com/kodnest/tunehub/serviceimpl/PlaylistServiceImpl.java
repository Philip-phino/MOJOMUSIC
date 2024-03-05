package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.PlaylistService;


@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository plr;
	
	@Autowired
	SongRepository sr;
	
	@Override
	public void addPlaylist(Playlist playlist) {
		plr.save(playlist);
	}
	
	@Override
	public void addSonglist(Song song) {
		sr.save(song);
	}

	@Override
	public List<Playlist> getPlaylist() {
		return plr.findAll();
	}
}

