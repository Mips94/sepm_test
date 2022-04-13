package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.DestinationInquiryDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.SimpleDestinationDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.mapper.DestinationMapper;
import at.ac.tuwien.sepm.groupphase.backend.service.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;


@RestController
@RequestMapping(value = "/api/v1/destinations")
public class DestinationEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final DestinationService destinationService;
    private final DestinationMapper destinationMapper;

    @Autowired
    public DestinationEndpoint(DestinationService destinationService, DestinationMapper destinationMapper) {
        this.destinationService = destinationService;
        this.destinationMapper = destinationMapper;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get detailed information about a specific destination")
    public SimpleDestinationDto find(@PathVariable Long id) {
        LOGGER.info("GET /api/v1/destination/{}", id);
        return destinationMapper.destinationToSimpleDestinationDto(destinationService.findOne(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Publish a new message", security = @SecurityRequirement(name = "apiKey"))
    public SimpleDestinationDto create(@Valid @RequestBody DestinationInquiryDto destinationDto) {
        LOGGER.info("POST /api/v1/destinations body: {}", destinationDto);
        return destinationMapper.destinationToSimpleDestinationDto(
            destinationService.publishDestination(destinationMapper.destinationInquiryDtoToDestination(destinationDto)));
    }
}
