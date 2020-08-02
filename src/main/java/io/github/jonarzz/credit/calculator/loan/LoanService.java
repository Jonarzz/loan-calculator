package io.github.jonarzz.credit.calculator.loan;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    private LoanCalculationProperties loanCalculationProperties;
    private LoanRepository loanRepository;

    LoanService(LoanCalculationProperties loanCalculationProperties, LoanRepository loanRepository) {
        this.loanCalculationProperties = loanCalculationProperties;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public LoanDto calculateAvailability(LoanDto inputDto) {
        Loan loan = Loan.fromDto(inputDto);
        LOGGER.debug("Created entity from DTO");
        LOGGER.debug("Starting loan availability calculation with properties: {}", loanCalculationProperties);
        loan.calculateAvailability(loanCalculationProperties);
        LOGGER.debug("Loan availability calculation done");
        loanRepository.save(loan);
        LOGGER.debug("Saved loan entity");
        LoanDto outputDto = loan.toDto();
        LOGGER.debug("Is loan available: {}, unavailability reason: {}",
                     outputDto.isLoanAvailable(), outputDto.getUnavailabilityReason());
        return outputDto;
    }

}
