package io.jonarzz.credit.calculator.loan;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Transactional
    public LoanDto calculateAvailability(LoanDto loanDto) {
        Loan loan = Loan.fromDto(loanDto);
        loan.calculateAvailability();
        loanRepository.save(loan);
        return loan.toDto();
    }

}
