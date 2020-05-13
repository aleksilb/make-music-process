package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.SongStatus;
import org.springframework.stereotype.Component;

@Component
public class SetFinishedStatusTask extends SetStatusTask {
    public SetFinishedStatusTask() {
        this.songStatus = SongStatus.FINISHED;
    }
}