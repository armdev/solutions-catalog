package io.backend.bank.transactions.infrastructure.web;

import io.backend.bank.transactions.application.command.TransactionStatusFinderCommand;
import io.backend.bank.transactions.application.response.TransactionStatusResponse;
import io.backend.bank.transactions.application.use_case.SearchTransactionStatusUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@Slf4j
@RequestMapping(value = {"/transaction-status"})
@RequiredArgsConstructor
public class SearchTransactionStatusController {

    private final SearchTransactionStatusUseCase searchTransactionStatusUseCase;

    @Operation(summary = "Get a transaction status stored in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction status got successfully from the system"),
            @ApiResponse(responseCode = "400", description = "Reference is missing or channel provided is not correct"),
            @ApiResponse(responseCode = "404", description = "Account does not exist")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TransactionStatusResponse> getTransaction(@Parameter(name = "reference", description = "Transaction reference", example = "7ade4b27-40b5-4080-bc28-dbb13ef54c50")
                                                                    @RequestParam String reference,
                                                                    @Parameter(name = "channel", description = "Transaction channel [CLIENT, ATM, INTERNAL]", example = "INTERNAL")
                                                                    @RequestParam(required = false) String channel) throws ParseException {

        log.info("Executing search transaction status endpoint");

        TransactionStatusFinderCommand transactionStatusFinderCommand = TransactionStatusFinderCommand.of(reference, channel);

        TransactionStatusResponse transactionStatusResponse = searchTransactionStatusUseCase.find(transactionStatusFinderCommand);

        log.info("Transaction status got successfully: {}", transactionStatusResponse);

        return ResponseEntity.ok().body(transactionStatusResponse);

    }

}
