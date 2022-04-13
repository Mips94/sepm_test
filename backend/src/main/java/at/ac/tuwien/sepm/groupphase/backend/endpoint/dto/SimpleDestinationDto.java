package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import java.util.Objects;

public class SimpleDestinationDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        if (!(o instanceof SimpleDestinationDto that)) {
            return false;
        }
        return Objects.equals(id, that.id)
            && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "SimpleMessageDto{"
            + "id=" + id
            + ", name=" + name
            + '}';
    }


    public static final class SimpleDestinationDtoBuilder {
        private Long id;
        private String name;

        private SimpleDestinationDtoBuilder() {
        }

        public static SimpleDestinationDto.SimpleDestinationDtoBuilder aSimpleDestinationDto() {
            return new SimpleDestinationDto.SimpleDestinationDtoBuilder();
        }

        public SimpleDestinationDto.SimpleDestinationDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SimpleDestinationDto.SimpleDestinationDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SimpleDestinationDto build() {
            SimpleDestinationDto simpleDestinationDto = new SimpleDestinationDto();
            simpleDestinationDto.setId(id);
            simpleDestinationDto.setName(name);
            return simpleDestinationDto;
        }
    }
}
