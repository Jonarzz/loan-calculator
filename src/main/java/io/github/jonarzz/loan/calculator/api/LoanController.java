package io.github.jonarzz.loan.calculator.api;

import javax.validation.Valid;

import io.github.jonarzz.loan.calculator.common.LocaleUtil;
import io.github.jonarzz.loan.calculator.loan.LoanDto;
import io.github.jonarzz.loan.calculator.loan.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loan/calculation")
class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    private LoanService loanService;

    LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(consumes = Versioning.MEDIA_TYPE_APPLICATION_JSON_V1,
                 produces = Versioning.MEDIA_TYPE_APPLICATION_JSON_V1)
    LoanDto calculateLoanAvailability(@RequestBody @Valid LoanDto loan,
                                      @RequestHeader(name = HttpHeaders.ACCEPT_LANGUAGE, required = false) String language) {
        LocaleUtil.save(language);
        LOGGER.debug("Received loan availability calculation request with input {}", loan);
        return loanService.calculateAvailability(loan);
    }

}
