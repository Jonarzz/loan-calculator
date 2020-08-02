package io.jonarzz.credit.calculator.loan;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

@Entity
@Access(AccessType.FIELD)
class Loan {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration()
                    .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                    .setFieldMatchingEnabled(true);
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private double interestRate;
    @NotNull
    private int amount;
    @NotNull
    private int instalmentCount;
    @NotNull
    private int monthlyIncome;
    @NotNull
    private int monthlyExpenses;

    @NotNull
    private boolean loanAvailable;

    private int availableAmount;
    private int totalRepayment;
    private LocalDate lastPaymentMonth;
    private BigDecimal monthlyPayment;

    protected Loan() {
    }

    static Loan fromDto(LoanDto dto) {
        Loan loan = new Loan();
        MODEL_MAPPER.map(dto, loan);
        return loan;
    }

    LoanDto toDto() {
        return MODEL_MAPPER.map(this, LoanDto.class);
    }

    void calculateAvailability() {
        // TODO actual calculation
    }

}
