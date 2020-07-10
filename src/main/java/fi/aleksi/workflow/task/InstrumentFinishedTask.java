package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Instrument;
import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.process.ProcessVariables;
import fi.aleksi.workflow.repository.SongRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InstrumentFinishedTask implements JavaDelegate {

    private final SongRepository songRepository;

    @Autowired
    public InstrumentFinishedTask(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void execute(DelegateExecution execution) {
        Instrument selectedInstrument = Instrument.valueOf((String) execution.getVariable(ProcessVariables.SELECTED_INSTRUMENT));
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);

        Song song = songRepository.getOne(songId);
        song.addInstrument(selectedInstrument);
        songRepository.save(song);

        List<Instrument> allInstruments = List.of(Instrument.values());

        Integer instrumentsLeft = allInstruments.size() - song.getInstruments().size();

        execution.setVariable(ProcessVariables.MISSING_INSTRUMENTS, instrumentsLeft);
    }
}