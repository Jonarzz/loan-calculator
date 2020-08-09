package io.github.jonarzz.loan.calculator.loan;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    private LoanCalculationProperties loanCalculationProperties;
    private LoanRepository loanRepository;
    private ModelMapper modelMapper;

    LoanService(LoanCalculationProperties loanCalculationProperties, LoanRepository loanRepository, ModelMapper modelMapper) {
        this.loanCalculationProperties = loanCalculationProperties;
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
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
        LoanDto outputDto = toDto(loan);
        LOGGER.debug("Is loan available: {}, unavailability reason: {}",
                     outputDto.isLoanAvailable(), outputDto.getUnavailabilityReason());
        return outputDto;
    }

    Loan fromDto(LoanDto dto) {
        Loan loan = new Loan();
        modelMapper.map(dto, loan);
        return loan;
    }

    LoanDto toDto(Loan loan) {
        return modelMapper.map(loan, LoanDto.class);
    }

}
