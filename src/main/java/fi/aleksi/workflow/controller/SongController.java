package fi.aleksi.workflow.controller;

import fi.aleksi.workflow.entity.*;
import fi.aleksi.workflow.process.SongProcess;
import fi.aleksi.workflow.repository.SongRepository;
import org.springframework.beans.BeanUtils;
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
        return songRepository.findByStatusNot(SongStatus.FINISHED);
    }

    @PostMapping("/song")
    public Song postSong(@RequestBody Song song) {
        songRepository.save(song);
        return song;
    }

    @PutMapping("/song/{id}")
    public void updateSong(@PathVariable Long id, @RequestBody Song newSong) {
        Song song = songRepository.getOne(id);
        BeanUtils.copyProperties(newSong, song);
        songRepository.save(song);
    }

    @GetMapping("/song/{id}")
    public Song getSong(@PathVariable Long id) throws Exception {
        return songRepository.findById(id).orElseThrow(() -> new Exception("No song found with id " + id));
    }

    @DeleteMapping("/song/{id}")
    public void deleteSong(@PathVariable Long id) throws Exception {
        Song song = songRepository.findById(id).orElseThrow(() -> new Exception("No song found with id " + id));
        songRepository.delete(song);
        songProcess.removeSong(id);
    }

    @PostMapping("/song/{id}/start")
    public void startSong(@PathVariable Long id) {
        songProcess.startSong(id);
    }

    @GetMapping("/instrument")
    public List<Instrument> getAllInstruments() {
        return List.of(Instrument.values());
    }
}