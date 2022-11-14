package com.musicstorerecommendations.musicstorerecommendations.controller;

import com.musicstorerecommendations.musicstorerecommendations.model.TrackRecommendation;
import com.musicstorerecommendations.musicstorerecommendations.repository.TrackRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackRecommendations")
public class TrackRecommendationController {
    @Autowired
    TrackRecommendationRepository trackRecommendationRepo;

    @GetMapping
    public List<TrackRecommendation> getAllTrackRecommendations() {
        return trackRecommendationRepo.findAll();
    }

    @GetMapping("{id}")
    public TrackRecommendation getTrackRecommendationById(@PathVariable Integer id) {
        return trackRecommendationRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrackRecommendation createTrackRecommendation(@RequestBody TrackRecommendation rec) {
        return trackRecommendationRepo.save(rec);
    }



    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrackRecommendation(@RequestBody TrackRecommendation rec) {

        trackRecommendationRepo.save(rec);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrackRecommendation(@PathVariable Integer id) {
        Optional<TrackRecommendation> trackToDelete = trackRecommendationRepo.findById(id);
        if (trackToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No track with the id " + id);
        }
        trackRecommendationRepo.deleteById(id);
    }
}
