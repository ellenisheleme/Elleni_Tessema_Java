package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Album;
import com.musicstorecatalog.musicStoreCatalog.model.Artist;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LabelRepository labelRepository;

    @Before
    public void setUp() throws Exception {
        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
        labelRepository.deleteAll();


    }

    @Test
    public void shouldCreateAtrackAndFindAndDelete() {

        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        artist = artistRepository.save(artist);

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        label = labelRepository.save(label);

        Album album = new Album();
        album.setTitle("All you need is Love");
        album.setArtistId(artist.getId());
        album.setrelease_date(LocalDate.of(1969, 10, 01));
        album.setLabelId(label.getId());
        album.setPrice(new BigDecimal("10.99"));

        album = albumRepository.save(album);

        Track track = new Track();
        track.setAlbumId(album.getId());
        track.setTitle("All you need is love");
        track.setRuntime(25);

        track = trackRepository.save(track);

        Optional<Track> optionalTrack = trackRepository.findById(track.getId());
        assertEquals(optionalTrack.get(), track);

        trackRepository.deleteById(track.getId());

        optionalTrack = trackRepository.findById(track.getId());


        assertFalse(optionalTrack.isPresent());

    }

    @Test
    public void shouldUpdateTrack() {

        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        artist = artistRepository.save(artist);

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        label = labelRepository.save(label);

        Album album = new Album();
        album.setTitle("All you need is Love");
        album.setArtistId(artist.getId());
        album.setrelease_date(LocalDate.of(1969, 10, 01));
        album.setLabelId(label.getId());
        album.setPrice(new BigDecimal("10.99"));

        album = albumRepository.save(album);

        Track track = new Track();
        track.setAlbumId(album.getId());
        track.setTitle("All you need is love");
        track.setRuntime(25);

        track = trackRepository.save(track);

        track.setTitle("Give Peace a Chance");
        track.setRuntime(15);

        trackRepository.save(track);

        Optional<Track> updatedTrack = trackRepository.findById(track.getId());

        assertEquals(updatedTrack.get(), track);

    }

    @Test
    public void shouldGetAllTracks() {
        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        Artist artist1 = new Artist();
        artist1.setName("Michael Jackson");
        artist1.setTwitter("@Mjackson");
        artist1.setInstagram("Mjackson");


        artist = artistRepository.save(artist);
        artist1 = artistRepository.save(artist1);

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        Label label1 = new Label();
        label1.setName("M&J");
        label1.setWebsite("www.mjackson.com");

        label = labelRepository.save(label);
        label1 = labelRepository.save(label1);

        Album album = new Album();
        album.setTitle("All you need is Love");
        album.setArtistId(artist.getId());
        album.setrelease_date(LocalDate.of(1969, 10, 01));
        album.setLabelId(label.getId());
        album.setPrice(new BigDecimal("10.99"));

        Album album1 = new Album();
        album1.setTitle("Little Bitty Pretty One");
        album1.setArtistId(artist1.getId());
        album1.setrelease_date(LocalDate.of(1972, 05, 27));
        album1.setLabelId(label1.getId());
        album1.setPrice(new BigDecimal("10.99"));


        album = albumRepository.save(album);
        album1 = albumRepository.save(album1);

        Track track = new Track();
        track.setAlbumId(album.getId());
        track.setTitle("All you need is love");
        track.setRuntime(25);

        Track track1 = new Track();
        track1.setAlbumId(album1.getId());
        track1.setTitle("Little Bitty Pretty One");
        track1.setRuntime(25);

        track = trackRepository.save(track);
        track1 = trackRepository.save(track1);

        List<Track> trackList = trackRepository.findAll();

        assertEquals(trackList.size(), 2);


    }

    @Test
    public void shouldFilterByTitle() {
        Artist artist = new Artist();
        artist.setName("John Lennon");
        artist.setInstagram("@jLonnebn");
        artist.setTwitter("@TheJohnLennon");

        Artist artist1 = new Artist();
        artist1.setName("Michael Jackson");
        artist1.setTwitter("@Mjackson");
        artist1.setInstagram("Mjackson");


        artist = artistRepository.save(artist);
        artist1 = artistRepository.save(artist1);

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        Label label1 = new Label();
        label1.setName("M&J");
        label1.setWebsite("www.mjackson.com");

        label = labelRepository.save(label);
        label1 = labelRepository.save(label1);

        Album album = new Album();
        album.setTitle("All you need is Love");
        album.setArtistId(artist.getId());
        album.setrelease_date(LocalDate.of(1969, 10, 01));
        album.setLabelId(label.getId());
        album.setPrice(new BigDecimal("10.99"));

        Album album1 = new Album();
        album1.setTitle("Little Bitty Pretty One");
        album1.setArtistId(artist1.getId());
        album1.setrelease_date(LocalDate.of(1972, 05, 27));
        album1.setLabelId(label1.getId());
        album1.setPrice(new BigDecimal("10.99"));


        album = albumRepository.save(album);
        album1 = albumRepository.save(album1);

        Track track = new Track();
        track.setAlbumId(album.getId());
        track.setTitle("All you need is love");
        track.setRuntime(25);

        Track track1 = new Track();
        track1.setAlbumId(album1.getId());
        track1.setTitle("Little Bitty Pretty One");
        track1.setRuntime(25);

        track = trackRepository.save(track);
        track1 = trackRepository.save(track1);

        List<Track> trackByTitle = trackRepository.findByTitle("Little Bitty Pretty One");

        assertEquals(new HashSet<Track>(Arrays.asList(track1)), new HashSet<Track>(trackByTitle));

    }

}