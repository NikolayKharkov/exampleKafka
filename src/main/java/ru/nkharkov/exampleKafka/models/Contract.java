package ru.nkharkov.exampleKafka.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Бизнес сущность отражающая договор
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @Column(name = "contract_id")
    private int contractId;

    @Column(name = "number")
    private int number;
}
