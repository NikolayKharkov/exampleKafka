package ru.nkharkov.exampleKafka.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ContractEvent {

    private ContractDto contractDto;

    private LocalDateTime start;

    private LocalDateTime end;
}
