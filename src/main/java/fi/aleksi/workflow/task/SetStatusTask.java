package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.process.ProcessVariables;
import fi.aleksi.workflow.repository.SongRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import static fi.aleksi.workflow.task.SetLoopStatusTask.songStatus;

public abstract class SetStatusTask implements JavaDelegate {

    protected SongRepository songRepository;

    @Autowired
    public final void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void execute(DelegateExecution execution) {
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);

        Song song = songRepository.getOne(songId);
        song.setStatus(songStatus);
        songRepository.save(song);
    }
}
