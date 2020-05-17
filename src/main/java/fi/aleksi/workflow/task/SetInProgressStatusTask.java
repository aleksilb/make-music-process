package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.SongStatus;
import org.springframework.stereotype.Component;

@Component
public class SetInProgressStatusTask extends SetStatusTask {
    public SetInProgressStatusTask() {
        this.songStatus = SongStatus.IN_PROGRESS;
    }
}