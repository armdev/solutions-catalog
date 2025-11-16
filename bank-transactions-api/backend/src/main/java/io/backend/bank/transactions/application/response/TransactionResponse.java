package io.backend.bank.transactions.application.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.backend.bank.transactions.domain.model.TransactionEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Schema(name = "TransactionResponse", description = "Transaction response information")
public class TransactionResponse {

    @Schema(description = "Transaction reference", example = "7ade4b27-40b5-4080-bc28-dbb13ef54c50", type = "String")
    private String reference;

    @Schema(description = "Account iban related to the transaction", example = "ES3930294948393", type = "String")
    private String accountIban;

    @Schema(description = "Transaction date", example = "2019-07-16T16:55:42.000Z", type = "String")
    private String date;

    @Schema(description = "Transaction amount", example = "42.33", type = "double")
    private double amount;

    @Schema(description = "Transaction fee", example = "3.50", type = "String")
    private double fee;

    @Schema(description = "Transaction description", example = "Payment in restaurant", type = "String")
    private String description;

    public static TransactionResponse of(TransactionEntity transactionEntity) {

        return TransactionResponse.builder()
                                  .reference(transactionEntity.getId())
                                  .accountIban(transactionEntity.getAccount().getId())
                                  .date(transactionEntity.getDate())
                                  .amount(transactionEntity.getAmount())
                                  .fee(transactionEntity.getFee())
                                  .description(transactionEntity.getDescription())
                                  .build();
    }
}
