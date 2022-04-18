package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Task.
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Task")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TASK_TYPE",
        discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("T")
@NamedQuery(name = "Task", query = "SELECT t from Task t")
public class Task implements Serializable {
    /**
     * Id field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Integer id;
    /**
     * Name field.
     */
    @Column(name = "TASK_NAME")
    private String name;
    /**
     * Description field.
     */
    @Column
    private String description;
}
