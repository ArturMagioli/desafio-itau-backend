package com.magioli.desafiobackenditau.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @NonNull
    BigDecimal valor;

    @NonNull
    OffsetDateTime dataHora;
}
