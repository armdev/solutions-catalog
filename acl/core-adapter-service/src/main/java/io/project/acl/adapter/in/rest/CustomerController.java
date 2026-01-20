package io.project.acl.adapter.in.rest;

import io.project.acl.application.CustomerInquiryService;
import io.project.acl.domain.dto.CustomerRecord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/customers")
@AllArgsConstructor
@Tag(
    name = "Customer Inquiry",
    description = "Read-only customer inquiry APIs backed by core banking system"
)
public class CustomerController {

    private final CustomerInquiryService customerInquiryService;

    @Operation(
        summary = "Get customer by internal customer ID",
        description = "Returns customer data using the internal core-banking customer ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Customer found",
            content = @Content(schema = @Schema(implementation = CustomerRecord.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Customer not found"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerRecord> getById(
            @Parameter(
                description = "Internal customer identifier",
                example = "123456789",
                required = true
            )
            @PathVariable("id") Long id) {

        CustomerRecord customer = customerInquiryService.findCustomerById(id);
        return customer != null
                ? ResponseEntity.ok(customer)
                : ResponseEntity.notFound().build();
    }

    @Operation(
        summary = "Get customer by SSN / personal number",
        description = "Returns customer data using national personal number (SSN)"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Customer found",
            content = @Content(schema = @Schema(implementation = CustomerRecord.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Customer not found"
        )
    })
    @GetMapping("/by-ssn/{ssn}")
    public ResponseEntity<CustomerRecord> getBySsn(
            @Parameter(
                description = "Personal number / SSN",
                example = "AB1234567",
                required = true
            )
            @PathVariable("ssn") String ssn) {

        CustomerRecord customer = customerInquiryService.findCustomerBySsn(ssn);
        return customer != null
                ? ResponseEntity.ok(customer)
                : ResponseEntity.notFound().build();
    }

    @Operation(
        summary = "Get customer by email address",
        description = "Returns customer data using email address"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Customer found",
            content = @Content(schema = @Schema(implementation = CustomerRecord.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Customer not found"
        )
    })
    @GetMapping("/by-email")
    public ResponseEntity<CustomerRecord> getByEmail(
            @Parameter(
                description = "Customer email address",
                example = "john.doe@example.com",
                required = true
            )
            @RequestParam("email") String email) {

        CustomerRecord customer = customerInquiryService.findCustomerByEmail(email);
        return customer != null
                ? ResponseEntity.ok(customer)
                : ResponseEntity.notFound().build();
    }
}
