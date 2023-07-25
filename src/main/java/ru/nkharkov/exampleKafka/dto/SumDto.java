package ru.nkharkov.exampleKafka.dto;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class SumDto {

    private BigDecimal sum;

}
