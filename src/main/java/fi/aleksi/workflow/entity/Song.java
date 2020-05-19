package fi.aleksi.workflow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @Enumerated(EnumType.STRING)
    private SongStatus status;
    @ManyToMany
    @JoinTable(
            name = "song_instrument",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    private Set<Instrument> instruments;

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }
}
