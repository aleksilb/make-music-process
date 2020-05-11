package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.SongStatus;
import fi.aleksi.workflow.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SetLoopStatusTask extends SetStatusTask {
    protected final static SongStatus songStatus = SongStatus.LOOP;

    @Autowired
    public final void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
}