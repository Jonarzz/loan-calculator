package io.jonarzz.credit.calculator.loan;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanDto calculateAvailability(LoanDto loan) {
        // TODO map to entity
        // TODO calculation
        return loan;
    }

}
