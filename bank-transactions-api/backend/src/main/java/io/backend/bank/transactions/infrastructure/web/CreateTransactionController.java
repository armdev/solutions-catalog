package io.backend.bank.transactions.infrastructure.web;

import io.backend.bank.transactions.application.command.NewTransactionCommand;
import io.backend.bank.transactions.application.use_case.CreateTransactionUseCase;
import io.backend.bank.transactions.infrastructure.presentation.NewTransactionPresentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Slf4j
@RequestMapping(value = {"/transaction"})
@RequiredArgsConstructor
public class CreateTransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;

    @Operation(summary = "Store a new transaction in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",  description = "Successful creation of the new transaction"),
            @ApiResponse(responseCode = "400", description = "Mandatory body parameter is missing"),
            @ApiResponse(responseCode = "404", description = "Account does not exist")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransaction(@Parameter(name = "newTransactionPresentation", description = "The information of the new transaction", required = true)
                                                  @Valid @RequestBody NewTransactionPresentation newTransactionPresentation) {

        log.info("Executing create transaction endpoint with newTransactionPresentation: {}", newTransactionPresentation);

        NewTransactionCommand newTransactionCommand = NewTransactionCommand.of(newTransactionPresentation);

        createTransactionUseCase.create(newTransactionCommand);

        log.info("Transaction created successfully");

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
