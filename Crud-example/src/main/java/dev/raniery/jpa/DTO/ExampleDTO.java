package dev.raniery.jpa.DTO;

import dev.raniery.jpa.entity.Example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public ExampleDTO(Example entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

}
