package com.musicstorerecommendations.musicstorerecommendations.repository;

import com.musicstorerecommendations.musicstorerecommendations.model.ArtistRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRecommendationRepository extends JpaRepository<ArtistRecommendation, Integer> {

}
