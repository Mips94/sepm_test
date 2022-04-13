package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class DestinationInquiryDto {
    @NotNull(message = "Name must not be null")
    @Size(max = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DestinationInquiryDto that)) {
            return false;
        }
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MessageInquiryDto{"
            + "name='" + name
            + '}';
    }


    public static final class DestinationInquiryDtoBuilder {
        private String name;

        private DestinationInquiryDtoBuilder() {
        }

        public static DestinationInquiryDto.DestinationInquiryDtoBuilder aDestinationInquiryDto() {
            return new DestinationInquiryDto.DestinationInquiryDtoBuilder();
        }

        public DestinationInquiryDto.DestinationInquiryDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DestinationInquiryDto build() {
            DestinationInquiryDto destinationInquiryDto = new DestinationInquiryDto();
            destinationInquiryDto.setName(name);
            return destinationInquiryDto;
        }
    }
}
