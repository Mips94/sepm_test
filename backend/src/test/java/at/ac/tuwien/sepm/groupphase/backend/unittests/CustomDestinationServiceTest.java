package at.ac.tuwien.sepm.groupphase.backend.unittests;


import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.service.DestinationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class CustomDestinationServiceTest {



    @Autowired
    private DestinationService destinationService;

    /**
     * Adding a specific destination and check it if it is successfully added.
     */
    @Test
    @DisplayName("Creating destination and check it")
    public void creatingDestinationAndCheckIt(){

        Destination destination = new Destination();
        destination.setName("Museum 1");
        Destination newDestination = destinationService.publishDestination(destination);

        Destination destinationFormDb = destinationService.findOne(newDestination.getId());

        assertEquals(destination.getName(), destinationFormDb.getName());
    }


    /**
     * Trying to add a destination without name should throw Validation Exception
     */
    @Test
    @DisplayName("Adding destination without name should throw Validation Exception")
    public void creatingDestinationWithoutNameShouldThrowValidationException() {
        Destination destination  = new Destination();
        // destination.setName("Museum 2");
        assertThrows(ValidationException.class,
            () -> destinationService.publishDestination(destination));
    }



}
