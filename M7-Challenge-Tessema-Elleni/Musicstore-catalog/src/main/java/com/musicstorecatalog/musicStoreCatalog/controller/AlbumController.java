package com.musicstorecatalog.musicStoreCatalog.controller;

import com.musicstorecatalog.musicStoreCatalog.model.Album;
import com.musicstorecatalog.musicStoreCatalog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbum(@PathVariable int id) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if(optionalAlbum.isPresent()){
            return optionalAlbum.get();
        }else{
            return  null;
        }
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAlbumByTitle(String title){
        return albumRepository.findByTitle(title);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAnewAlbum(@RequestBody @Valid Album album){
        return albumRepository.save(album);

    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnAlbum(@RequestBody @Valid Album album){
     albumRepository.save(album);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnAlbum(@PathVariable int id){
        albumRepository.deleteById(id);
    }

}
