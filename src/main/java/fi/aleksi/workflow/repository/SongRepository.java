package fi.aleksi.workflow.repository;

import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.entity.SongStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByStatusNot(SongStatus status);
}
