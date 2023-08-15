package dev.raniery.jpa.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

}
