package io.github.jonarzz.loan.calculator.loan;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration()
                    .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                    .setFieldMatchingEnabled(true);
    }

    private LoanCalculationProperties loanCalculationProperties;
    private LoanRepository loanRepository;

    LoanService(LoanCalculationProperties loanCalculationProperties, LoanRepository loanRepository) {
        this.loanCalculationProperties = loanCalculationProperties;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public LoanDto calculateAvailability(LoanDto inputDto) {
        LOGGER.debug("Creating entity from DTO");
        Loan loan = fromDto(inputDto);
        LOGGER.debug("Starting loan availability calculation with properties: {}", loanCalculationProperties);
        loan.calculateAvailability(loanCalculationProperties);
        LOGGER.debug("Loan availability calculation done");
        loanRepository.save(loan);
        LOGGER.debug("Saved loan entity");
        LoanDto outputDto = toDto();
        LOGGER.debug("Is loan available: {}, unavailability reason: {}",
                     outputDto.isLoanAvailable(), outputDto.getUnavailabilityReason());
        return outputDto;
    }

    static Loan fromDto(LoanDto dto) {
        Loan loan = new Loan();
        MODEL_MAPPER.map(dto, loan);
        return loan;
    }

    LoanDto toDto() {
        return MODEL_MAPPER.map(this, LoanDto.class);
    }

}
