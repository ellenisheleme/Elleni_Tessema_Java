package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Artist;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistRepositoryTest {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    TrackRepository trackRepository;

    @Before
    public void setUp() {

        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();

    }
    @Test
    public void shouldCreateFindAndDelete() {
        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        artist = artistRepository.save(artist);

        Optional<Artist>optionalArtist = artistRepository.findById(artist.getId());

        assertEquals(optionalArtist.get(), artist);

        artistRepository.deleteById(artist.getId());

        optionalArtist = artistRepository.findById(artist.getId());

        assertFalse(optionalArtist.isPresent());

    }

    @Test
    public void shouldUpdateArtist() {
        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        artist = artistRepository.save(artist);

        artist.setInstagram("@johnlennon");
        artistRepository.save(artist);

        Optional<Artist>updatedArtist = artistRepository.findById(artist.getId());

        assertEquals(updatedArtist.get(), artist);

    }

@Test
    public void shouldGetArtistByName() {
    Artist artist = new Artist();
    artist.setName("John Lennon");
    artist.setInstagram("@jLonnebn");
    artist.setTwitter("@TheJohnLennon");

    Artist artist1 = new Artist();
    artist1.setName("Michael Jackson");
    artist1.setTwitter("@Mjackson");
    artist1.setInstagram("Mjackson");

    artistRepository.save(artist);
    artistRepository.save(artist1);

    List<Artist> artistList = artistRepository.findByName("Michael Jackson");

    assertEquals(new HashSet<Artist>(Arrays.asList(artist1)), new HashSet<Artist>(artistList));

}

}