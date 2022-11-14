package com.musicstorecatalog.musicStoreCatalog.controller;

import com.musicstorecatalog.musicStoreCatalog.model.Artist;
import com.musicstorecatalog.musicStoreCatalog.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {

        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getAnArtist(@PathVariable int id){
        Optional<Artist>optionalArtist = artistRepository.findById(id);
                if(optionalArtist.isPresent()){
                    return optionalArtist.get();
                }else{
                    return null;
                }
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getArtistsByName(@PathVariable String name){
        return artistRepository.findByName(name);

    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createAnewArist(@RequestBody @Valid Artist artist){

        return artistRepository.save(artist);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Artist updateAnArtist(@RequestBody @Valid Artist artist){
        return artistRepository.save(artist);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnArtist(@PathVariable int id){
        artistRepository.deleteById(id);
    }

}
