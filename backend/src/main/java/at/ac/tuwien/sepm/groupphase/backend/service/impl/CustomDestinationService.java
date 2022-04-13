package at.ac.tuwien.sepm.groupphase.backend.service.impl;

import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.repository.DestinationRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.DestinationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Service
public class CustomDestinationService implements DestinationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final DestinationRepository destinationRepository;

    public CustomDestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination findOne(Long id) {
        LOGGER.debug("Find message with id {}", id);
        Optional<Destination> destination = destinationRepository.findById(id);
        if (destination.isPresent()) {
            return destination.get();
        } else {
            throw new NotFoundException(String.format("Could not find message with id %s", id));
        }
    }

    @Override
    public Destination publishDestination(Destination destination) {
        LOGGER.debug("Publish new message {}", destination);
        return destinationRepository.save(destination);
    }
}
