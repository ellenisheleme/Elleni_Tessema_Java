package com.musicstorerecommendations.musicstorerecommendations.controller;

import com.musicstorerecommendations.musicstorerecommendations.model.ArtistRecommendation;
import com.musicstorerecommendations.musicstorerecommendations.repository.ArtistRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("artistRecommendations")
public class ArtistRecommendationController {
    @Autowired
    ArtistRecommendationRepository artistRecommendationRepo;

    @GetMapping
    public List<ArtistRecommendation> getArtistRecommendations() {
        return artistRecommendationRepo.findAll();
    }

    @GetMapping("{id}")
    public ArtistRecommendation getArtistRecommendationById(@PathVariable Integer id) {
        return artistRecommendationRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistRecommendation createArtistRecommendation(@RequestBody ArtistRecommendation rec) {
        return artistRecommendationRepo.save(rec);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtistRecommendation(@RequestBody ArtistRecommendation rec) {

        artistRecommendationRepo.save(rec);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtistRecommendation(@PathVariable Integer id) {
        Optional<ArtistRecommendation> recToDelete = artistRecommendationRepo.findById(id);
        if (recToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No artist with the id " + id);
        }
        artistRecommendationRepo.deleteById(id);
    }
}
