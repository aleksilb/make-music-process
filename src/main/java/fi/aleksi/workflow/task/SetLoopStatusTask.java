package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.SongStatus;
import org.springframework.stereotype.Component;

@Component
public class SetLoopStatusTask extends SetStatusTask {
    protected final static SongStatus songStatus = SongStatus.LOOP;
}