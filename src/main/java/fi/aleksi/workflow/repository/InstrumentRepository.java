package fi.aleksi.workflow.repository;

import fi.aleksi.workflow.entity.Instrument;
import fi.aleksi.workflow.entity.InstrumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Instrument getInstrumentByType(InstrumentType type);
}
