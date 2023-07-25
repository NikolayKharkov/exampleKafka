package ru.nkharkov.exampleKafka.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ContractDto {

    private int contractId;

    private int number;

}
