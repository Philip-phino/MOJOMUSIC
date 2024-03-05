package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;

public interface PlaylistService {

	public void addPlaylist(Playlist pl);

	public void addSonglist(Song song);

	public List<Playlist> getPlaylist();

}
