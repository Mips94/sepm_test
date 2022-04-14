package at.ac.tuwien.sepm.groupphase.backend.util;

import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.repository.DestinationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DestinationValidator {


    private static final Logger LOGGER = LoggerFactory.getLogger(DestinationValidator.class);
    private final DestinationRepository destinationRepository;

    public DestinationValidator(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public void validateDestination(Destination destination) {
        LOGGER.trace("validateDestination({})", destination);
        if (destination.getName() == null || destination.getName().trim().length() == 0
            || destination.getName().length() > 255) {
            throw new ValidationException("Name could not be empty or be longer than 255 characters");
        }
    }

}

