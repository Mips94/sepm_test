package at.ac.tuwien.sepm.groupphase.backend.endpoint.mapper;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.DestinationInquiryDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.SimpleDestinationDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface DestinationMapper {

    @Named("simpleDestination")
    SimpleDestinationDto destinationToSimpleDestinationDto(Destination destination);

    /**
     * This is necessary since the SimpleMessageDto misses the text property and the collection mapper can't handle
     * missing fields.
     **/
    @IterableMapping(qualifiedByName = "simpleDestination")

    Destination destinationInquiryDtoToDestination(DestinationInquiryDto destinationInquiryDto);

    DestinationInquiryDto destinationToDestinationInquiryDto(Destination destination);
}
