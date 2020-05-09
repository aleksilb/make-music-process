package fi.aleksi.workflow;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Make Music Application")
public class MakeMusicProcessApplication extends ServletProcessApplication {
}