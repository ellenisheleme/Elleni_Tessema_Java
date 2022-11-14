package com.musicstorecatalog.musicStoreCatalog.controller;

import com.musicstorecatalog.musicStoreCatalog.model.Track;
import com.musicstorecatalog.musicStoreCatalog.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackRepository trackRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getAtrack(@PathVariable int id) {
        Optional<Track>optionalTrack = trackRepository.findById(id);
                if(optionalTrack.isPresent()){
                    return optionalTrack.get();
                }else{
                    return null;
                }
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getTrackByTitle(@PathVariable String title) {
        return trackRepository.findByTitle(title);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Track createAnewTrack(@RequestBody Track track) {
        return trackRepository.save(track);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAtrack(@RequestBody Track track) {
        trackRepository.save(track);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAtrack(@PathVariable int id) {
        trackRepository.deleteById(id);
    }

}
