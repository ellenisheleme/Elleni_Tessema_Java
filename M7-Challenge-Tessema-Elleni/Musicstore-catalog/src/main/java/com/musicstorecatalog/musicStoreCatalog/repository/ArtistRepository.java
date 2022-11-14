package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByName(String name);

}
