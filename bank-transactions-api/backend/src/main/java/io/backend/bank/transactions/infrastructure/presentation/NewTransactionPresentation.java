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
@Schema(name = "NewTransactionPresentation", description = "New transaction information")
public class NewTransactionPresentation {

    @Schema(description = "Transaction reference", example = "7ade4b27-40b5-4080-bc28-dbb13ef54c50", type = "string")
    private String reference;

    @NotBlank(message = "Account iban is mandatory")
    @Schema(description = "Account iban related to the transaction", example = "ES3930294948393", type = "string", required = true)
    private String accountIban;

    @Schema(description = "Transaction date", example = "2019-07-16T16:55:42.000Z", type = "string")
    private String date;

    @NotNull(message = "Amount is mandatory")
    @Schema(description = "Transaction amount", example = "42.33", type = "double", required = true)
    private Double amount;

    @Schema(description = "Transaction fee", example = "3.50", type = "double")
    private Double fee;

    @Schema(description = "Transaction description", example = "Payment in restaurant", type = "string")
    private String description;
}
