package io.github.jonarzz.loan.calculator.loan;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Access(AccessType.FIELD)
class Loan {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loan.class);

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private BigDecimal interestRate;
    @NotNull
    private Integer requestedAmount;
    @NotNull
    private Integer instalmentCount;
    @NotNull
    private Integer monthlyIncome;
    @NotNull
    private Integer monthlyExpenses;

    @NotNull
    private Boolean loanAvailable;

    @Enumerated(EnumType.STRING)
    private UnavailabilityReason unavailabilityReason;

    private Integer availableAmount;
    private BigDecimal totalRepayment;
    private LocalDate lastPaymentMonth;
    private BigDecimal monthlyPayment;

    protected Loan() {
    }

    void calculateAvailability(LoanCalculationProperties calculationProperties) {
        if (requestedAmount < calculationProperties.getMinLoanAmount()) {
            LOGGER.debug("Amount {} is less than min loan amount {}",
                         requestedAmount, calculationProperties.getMinLoanAmount());
            unavailabilityReason = UnavailabilityReason.MIN_LOAN_AMOUNT_NOT_REACHED;
            return;
        }
        int netIncome = monthlyIncome - monthlyExpenses;
        if (netIncome < calculationProperties.getMinMonthlyPayment()) {
            LOGGER.debug("Net income {} is less than min monthly payment {}",
                         netIncome, calculationProperties.getMinMonthlyPayment());
            unavailabilityReason = UnavailabilityReason.NET_INCOME_LESS_THAN_MIN_MONTHLY_PAYMENT;
            return;
        }
        BigDecimal totalRate = BigDecimal.ONE.add(interestRate);// 100% + interest rate %
        int maxAvailableAmount = BigDecimal.valueOf(netIncome * instalmentCount)
                                           .divide(totalRate, 2, RoundingMode.UP)
                                           .intValue();
        availableAmount = Math.min(requestedAmount, maxAvailableAmount);
        if (availableAmount > calculationProperties.getMaxLoanAmount()) {
            LOGGER.debug("Available amount {} is greater than max loan amount {}",
                         availableAmount, calculationProperties.getMaxLoanAmount());
            unavailabilityReason = UnavailabilityReason.MAX_LOAN_AMOUNT_EXCEEDED;
            return;
        }
        totalRepayment = totalRate.multiply(BigDecimal.valueOf(availableAmount));
        monthlyPayment = totalRepayment.divide(BigDecimal.valueOf(instalmentCount), 2, RoundingMode.UP);
        loanAvailable = true;
        lastPaymentMonth = LocalDate.now()
                                    .plusMonths(instalmentCount + 1);
    }

}
