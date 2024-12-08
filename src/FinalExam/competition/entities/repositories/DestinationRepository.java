package FinalExam.competition.entities.repositories;

import FinalExam.competition.entities.destination.Destination;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class DestinationRepository implements Repository<Destination>{
    private Collection<Destination> destinations;

    public DestinationRepository() {
        this.destinations = new LinkedList<>();
    }

    @Override
    public Collection<Destination> getCollection() {
        return Collections.unmodifiableCollection(this.destinations);
    }

    @Override
    public void add(Destination destination) {
        destinations.add(destination);
    }

    @Override
    public boolean remove(Destination destination) {
        return destinations.remove(destination);
    }

    @Override
    public Destination byName(String name) {
        return destinations.stream()
                .filter(destination -> destination.getName().equals(name))
                .findFirst().orElse(null);
    }
}
