package com.sbproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbproject.entities.Playlist;

@Service
public interface PlaylistService {
	public void addPlaylist(Playlist playlist) ;

	public List<Playlist> fetchAllPlaylists();
}
