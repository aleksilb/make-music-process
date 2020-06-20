package fi.aleksi.workflow.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Alert {
    @NonNull
    private String message;
}
