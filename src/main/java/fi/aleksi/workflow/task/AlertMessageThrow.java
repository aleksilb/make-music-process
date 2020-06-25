package fi.aleksi.workflow.task;

import fi.aleksi.workflow.controller.WebSocket;
import fi.aleksi.workflow.process.ProcessVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertMessageThrow implements JavaDelegate {

    private final WebSocket webSocket;

    @Autowired
    public AlertMessageThrow(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    @Override
    public void execute(DelegateExecution execution) {
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);
        String message = (String) execution.getVariable(ProcessVariables.ALERT_MESSAGE);

        webSocket.sendAlert(songId, message);
    }
}