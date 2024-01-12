package com.sbproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbproject.entities.Song;

public interface SongRepository
                  extends JpaRepository<Song,Integer>{

	public Song findByName(String name);

}
