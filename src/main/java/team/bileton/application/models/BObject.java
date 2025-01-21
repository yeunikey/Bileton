package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bileton.application.models.interfaces.Identifyable;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public abstract class BObject implements Identifyable {

    private UUID uniqueId = generateId();

}
