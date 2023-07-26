package ru.myaccounting.app.dto;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
public class TransferDTO {

    @Id
    private Long id;
    private String category;
    private String comment;
    private String username;
    private BigDecimal sum;

}
