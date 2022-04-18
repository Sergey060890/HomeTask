package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;
/**
 * Class HomeTask
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HomeTask")
@Entity
@SuperBuilder
@DiscriminatorValue("H")
@NamedQuery(name = "HomeTask", query = "SELECT ht from HomeTask ht")
public class HomeTask extends Task {
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @AttributeOverrides({
            @AttributeOverride(name = "name",
                    column = @Column(name = "executorName")),
            @AttributeOverride(name = "surname",
                    column = @Column(name = "executorSurname"))
    })
    @Embedded
    private Person executorPerson;

    @Embedded
    private Person observerPerson;
}
