package io.backend.bank.transactions.infrastructure.web;

import io.backend.bank.transactions.application.command.NewAccountCommand;
import io.backend.bank.transactions.application.use_case.CreateAccountUseCase;
import io.backend.bank.transactions.infrastructure.presentation.NewAccountPresentation;
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
@RequestMapping(value = {"/account"})
@RequiredArgsConstructor
public class CreateAccountController {

    private final CreateAccountUseCase createAccountUseCase;

    @Operation(summary = "Store a new account in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successful creation of the new account"),
        @ApiResponse(responseCode = "400", description = "Mandatory body parameter is missing"),
        @ApiResponse(responseCode = "404", description = "Account already exists")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAccount(@Parameter(name = "newAccountPresentation", 
            description = "The information of the new account", required = true)
            @Valid @RequestBody NewAccountPresentation newAccountPresentation) {

        log.info("Executing create account endpoint with newTransactionPresentation: {}", newAccountPresentation);

        NewAccountCommand newAccountCommand = NewAccountCommand.of(newAccountPresentation);

        createAccountUseCase.create(newAccountCommand);

        log.info("Account created successfully");

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
