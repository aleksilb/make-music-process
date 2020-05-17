package fi.aleksi.workflow.process;

import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class SongProcess {
    public static final String MAKE_SONG_PROCESS_KEY = "make_song";

    public void startSong(Long id) {
        String businessKey = "song-" + id;
        Map<String, Object> variables = Collections.singletonMap("songId", id);

        RuntimeService runtimeService = ProcessEngines.getDefaultProcessEngine().getRuntimeService();
        runtimeService.startProcessInstanceByKey(MAKE_SONG_PROCESS_KEY, businessKey, variables);
    }
}
