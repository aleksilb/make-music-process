package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.SongStatus;

public class SetFinishedStatusTask extends SetStatusTask {
    protected final static SongStatus songStatus = SongStatus.FINISHED;
}