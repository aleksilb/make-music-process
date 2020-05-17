package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Instrument;
import fi.aleksi.workflow.process.ProcessVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.EnumSet;

import static org.camunda.spin.Spin.JSON;

public class InstrumentFinishedTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        String instrumentsJson = (String) execution.getVariable(ProcessVariables.MISSING_INSTRUMENTS);
        EnumSet<Instrument> instruments = JSON(instrumentsJson).mapTo("java.util.EnumSet<Instrument>");

        Instrument selectedInstrument = (Instrument) execution.getVariable(ProcessVariables.SELECTED_INSTRUMENT);
        instruments.remove(selectedInstrument);

        execution.setVariable(ProcessVariables.MISSING_INSTRUMENTS, JSON(instruments).toString());
    }
}