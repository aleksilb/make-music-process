package fi.aleksi.workflow.controller;

import fi.aleksi.workflow.entity.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class WebSocket {

    private final SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public WebSocket(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendAlert(Long songId, String message) {
        messagingTemplate.convertAndSend("/topic/alert/" + songId, new Alert(message));
    }
}
