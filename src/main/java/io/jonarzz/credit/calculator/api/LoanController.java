package io.jonarzz.credit.calculator.api;

import javax.validation.Valid;

import io.jonarzz.credit.calculator.loan.LoanDto;
import io.jonarzz.credit.calculator.loan.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loan/calculation")
public class LoanController {

    private LoanService loanService;

    LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(consumes = Versioning.MEDIA_TYPE_APPLICATION_JSON_V1,
                 produces = Versioning.MEDIA_TYPE_APPLICATION_JSON_V1)
    LoanDto calculateLoanAvailability(@RequestBody @Valid LoanDto loan) {
        return loanService.calculateAvailability(loan);
    }

}
