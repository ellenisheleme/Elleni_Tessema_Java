package com.musicstorerecommendations.musicstorerecommendations.controller;

import com.musicstorerecommendations.musicstorerecommendations.model.AlbumRecommendation;
import com.musicstorerecommendations.musicstorerecommendations.repository.AlbumRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albumRecommendations")
public class AlbumRecommendationController {

    @Autowired
    AlbumRecommendationRepository albumRecommendationRepo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumRecommendation> getAlbumRecommendations() {
        return albumRecommendationRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumRecommendation getAlbumRecommendationById(@PathVariable Integer id) {
        return albumRecommendationRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumRecommendation createAlbumRecommendation(@RequestBody AlbumRecommendation rec) {
        return albumRecommendationRepo.save(rec);
    }



    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbumRecommendation(@RequestBody AlbumRecommendation album) {

        albumRecommendationRepo.save(album);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbumRecommendation(@PathVariable Integer id) {
        Optional<AlbumRecommendation> albumToDelete = albumRecommendationRepo.findById(id);
        if (albumToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No album with the id " + id);
        }
        albumRecommendationRepo.deleteById(id);
    }
}
