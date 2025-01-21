package team.bileton.application.models.interfaces;

import java.util.UUID;

public interface Identifyable {

    UUID getUniqueId();

    default UUID generateId() {
        return UUID.randomUUID();
    }

}
