package io.project.acl.adapter.in.rest;

import io.project.acl.application.CustomerInquiryService;
import io.project.acl.domain.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerController {

    private final CustomerInquiryService customerInquiryService;

    public CustomerController(CustomerInquiryService customerInquiryService) {
        this.customerInquiryService = customerInquiryService;
    }

    @GetMapping("/{id}/data")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return customerInquiryService.findCustomerById(id);
    }
}