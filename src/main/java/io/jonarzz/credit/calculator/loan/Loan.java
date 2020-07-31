package io.jonarzz.credit.calculator.loan;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Access(AccessType.FIELD)
class Loan {

    @Id
    private Long id;

    @NotNull
    private double interestRate;
    @NotNull
    private int amount;
    @NotNull
    private int instalmentsCount;
    @NotNull
    private int monthlyExpenses;
    @NotNull
    private boolean loanAvailable;

    private int availableAmount;
    private int totalRepayment;
    private LocalDate lastPaymentMonth;
    private BigDecimal monthlyPayment;

}
