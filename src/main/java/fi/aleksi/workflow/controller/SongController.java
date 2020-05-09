package fi.aleksi.workflow.controller;

import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.process.SongProcess;
import fi.aleksi.workflow.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    private final SongRepository songRepository;
    private final SongProcess songProcess;

    @Autowired
    public SongController(SongRepository songRepository, SongProcess songProcess) {
        this.songRepository = songRepository;
        this.songProcess = songProcess;
    }

    @GetMapping("/song")
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @PostMapping("/song")
    public void postSong(@RequestBody Song song) {
        songRepository.save(song);
    }

    @PostMapping("/song/{id}/start")
    public void startSong(@PathVariable Long id) {
        songProcess.startSong(id);
    }
}
