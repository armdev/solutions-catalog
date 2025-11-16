package io.backend.bank.transactions.infrastructure.presentation;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Schema(name = "NewAccountPresentation", description = "New account information")
public class NewAccountPresentation {

    @NotBlank(message = "Account iban is mandatory")
    @Schema(description = "Iban account", example = "ES3930294948393", type = "string")
    private String iban;

    @NotNull(message = "Balance is mandatory")
    @Schema(description = "Account balance", example = "42.33", type = "double", required = true)
    private Double balance;

}
