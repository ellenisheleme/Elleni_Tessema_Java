package com.musicstorerecommendations.musicstorerecommendations.controller;

import com.musicstorerecommendations.musicstorerecommendations.model.LabelRecommendation;
import com.musicstorerecommendations.musicstorerecommendations.repository.LabelRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/labelRecommendations")
public class LabelRecommendationController {
    @Autowired
    LabelRecommendationRepository labelRecommendationRepo;

    @GetMapping
    public List<LabelRecommendation> getLabelRecommendations() {
        return labelRecommendationRepo.findAll();
    }

    @GetMapping("{id}")
    public LabelRecommendation getLabelRecommendationById(@PathVariable Integer id) {
        return labelRecommendationRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LabelRecommendation createLabelRecommendation(@RequestBody LabelRecommendation rec) {
        return labelRecommendationRepo.save(rec);
    }



    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabelRecommendation(@RequestBody LabelRecommendation rec) {

        labelRecommendationRepo.save(rec);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabelRecommendation(@PathVariable Integer id) {
        Optional<LabelRecommendation> albumToDelete = labelRecommendationRepo.findById(id);
        if (albumToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No label with the id " + id);
        }
        labelRecommendationRepo.deleteById(id);
    }
}
