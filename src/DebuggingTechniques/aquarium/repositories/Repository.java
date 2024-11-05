package DebuggingTechniques.aquarium.repositories;

import DebuggingTechniques.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
