package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.process.ProcessVariables;
import fi.aleksi.workflow.repository.SongRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static fi.aleksi.workflow.task.SetLoopStatusTask.songStatus;

public abstract class SetStatusTask implements JavaDelegate {

    protected SongRepository songRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);

        Song song = songRepository.getOne(songId);
        song.setStatus(songStatus);
        songRepository.save(song);
    }
}
