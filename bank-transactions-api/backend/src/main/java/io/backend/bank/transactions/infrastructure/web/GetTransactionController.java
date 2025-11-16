package io.backend.bank.transactions.infrastructure.web;

import io.backend.bank.transactions.application.command.TransactionFinderCommand;
import io.backend.bank.transactions.application.response.TransactionResponse;
import io.backend.bank.transactions.application.use_case.GetTransactionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = {"/transaction"})
@RequiredArgsConstructor
public class GetTransactionController {

    private final GetTransactionUseCase getTransactionUseCase;

    @Operation(summary = "Get a transaction stored in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction got successfully from the system. Return the list of transactions related with the account iban provided, or all transactions from the system if account iban was not provided"),
            @ApiResponse(responseCode = "404", description = "Account does not exist")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<TransactionResponse>> getTransaction(@Parameter(name = "accountIban", description = "Account iban related to the transaction", example = "ES3930294948393")
                                                                    @RequestParam(required = false) String accountIban,
                                                                    @Parameter(name = "sorting", description = "Sorting type desired [ascending, descending]", example = "ascending")
                                                                    @RequestParam(required = false) String sorting) {

        log.info("Executing get transaction endpoint");

        TransactionFinderCommand transactionFinderCommand = TransactionFinderCommand.of(accountIban, sorting);

        List<TransactionResponse> transactionsList = getTransactionUseCase.find(transactionFinderCommand);

        log.info("Transactions list with {} values got successfully", transactionsList.size());

        return ResponseEntity.ok().body(transactionsList);

    }

}
