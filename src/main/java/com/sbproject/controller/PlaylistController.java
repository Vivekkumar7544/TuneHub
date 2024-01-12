package com.sbproject.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbproject.entities.Playlist;
import com.sbproject.entities.Song;
import com.sbproject.services.PlaylistService;
import com.sbproject.services.SongService;

@Controller
public class PlaylistController
{
	
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService	 playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		// updating Playlist table
		playlistService.addPlaylist(playlist);
		
		System.out.println(playlist);
		
		//updating song table
		List<Song> songList = playlist.getSongs();
		for(Song s : songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		return "adminHome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		
		List<Playlist> allPlaylists= playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylists";
	}
		


}
