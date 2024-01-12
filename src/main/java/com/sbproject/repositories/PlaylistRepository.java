package com.sbproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbproject.entities.Playlist;

public interface PlaylistRepository  extends JpaRepository<Playlist,Integer> {

}
