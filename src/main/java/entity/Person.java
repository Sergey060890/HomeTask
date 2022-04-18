package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

/**
 * Class Person
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Person {
    /**
     * Name of Person
     */
    private String name;
    /**
     * Surname of Person
     */
    private String surname;
}
