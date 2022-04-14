package at.ac.tuwien.sepm.groupphase.backend.unittests;

import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import at.ac.tuwien.sepm.groupphase.backend.repository.DestinationRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class DestinationRepositoryTest {


    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    PlatformTransactionManager txm;
    TransactionStatus txstatus;

    @BeforeEach
    public void setupDBTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        txstatus = txm.getTransaction(def);
        assumeTrue(txstatus.isNewTransaction());
        txstatus.setRollbackOnly();
    }

    @AfterEach
    public void tearDownDBData() {
        txm.rollback(txstatus);
    }


    @Test
    @DisplayName("Adding destination without name should throw Validation Exception")
    public void creatingDestinationWithoutNameShouldThrowValidationException() {
        Destination destination  = new Destination();
        // destination.setName("Museum 2");
        assertThrows(DataIntegrityViolationException.class,
            () -> destinationRepository.save(destination));
    }



    @Test
    @DisplayName("Creating destination and find it with id")
    public void creatingDestinationAndFindThat() {
        Destination destination = new Destination();
        destination.setName("Museum 2");
        destinationRepository.save(destination);
        assertNotNull(destinationRepository.getById(destination.getId()));
    }


}
