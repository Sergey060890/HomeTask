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
import javax.persistence.Table;
/**
 * Class WorkTask
 */
@Data
@Entity
@Table(name = "WorkTask")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("W")
public class WorkTask extends Task {
    /**
     * Cost field.
     */
    @Column
    private Integer cost;
}