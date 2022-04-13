package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;

public interface DestinationService {
    /**
     * Find a single destination entry by id.
     *
     * @param id the id of the destination entry
     * @return the destination entry
     */
    Destination findOne(Long id);

    /**
     * Publish a single destination entry.
     *
     * @param destination to publish
     * @return published destination entry
     */
    Destination publishDestination(Destination destination);
}
