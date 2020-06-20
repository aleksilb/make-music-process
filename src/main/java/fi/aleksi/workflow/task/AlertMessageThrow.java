package fi.aleksi.workflow.task;

import fi.aleksi.workflow.process.ProcessVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AlertMessageThrow implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);
        System.out.println("Alert message " + songId);
    }
}