package com.musicstorerecommendations.musicstorerecommendations.repository;

import com.musicstorerecommendations.musicstorerecommendations.model.TrackRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRecommendationRepository extends JpaRepository<TrackRecommendation, Integer> {

}
