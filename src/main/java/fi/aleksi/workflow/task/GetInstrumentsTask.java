package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Instrument;
import fi.aleksi.workflow.process.ProcessVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.EnumSet;

import static org.camunda.spin.Spin.JSON;

public class GetInstrumentsTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        EnumSet<Instrument> instruments = EnumSet.allOf(Instrument.class);

        String instrumentsJson = JSON(instruments).toString();
        execution.setVariable(ProcessVariables.MISSING_INSTRUMENTS, instrumentsJson);
    }
}