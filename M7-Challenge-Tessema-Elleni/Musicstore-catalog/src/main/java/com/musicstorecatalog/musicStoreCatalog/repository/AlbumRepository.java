package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByTitle(String title);
}
