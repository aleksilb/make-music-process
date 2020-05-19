package fi.aleksi.workflow.task;

import fi.aleksi.workflow.entity.Instrument;
import fi.aleksi.workflow.entity.InstrumentType;
import fi.aleksi.workflow.entity.Song;
import fi.aleksi.workflow.process.ProcessVariables;
import fi.aleksi.workflow.repository.InstrumentRepository;
import fi.aleksi.workflow.repository.SongRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InstrumentFinishedTask implements JavaDelegate {

    private final SongRepository songRepository;
    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentFinishedTask(SongRepository songRepository, InstrumentRepository instrumentRepository) {
        this.songRepository = songRepository;
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public void execute(DelegateExecution execution) {
        InstrumentType selectedInstrument = (InstrumentType) execution.getVariable(ProcessVariables.SELECTED_INSTRUMENT);
        Instrument instrument = instrumentRepository.getInstrumentByType(selectedInstrument);
        Long songId = (Long) execution.getVariable(ProcessVariables.SONG_ID);

        Song song = songRepository.getOne(songId);
        song.addInstrument(instrument);
        songRepository.save(song);

        List<Instrument> allInstruments = instrumentRepository.findAll();

        Integer instrumentsLeft = allInstruments.size() - song.getInstruments().size();

        execution.setVariable(ProcessVariables.MISSING_INSTRUMENTS, instrumentsLeft);
    }
}