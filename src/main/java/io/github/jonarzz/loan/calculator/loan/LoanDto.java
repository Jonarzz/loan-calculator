package io.github.jonarzz.loan.calculator.loan;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class LoanDto {

    @Min(value = 0, message = "loan.validation.message.interestRate.minValue")
    private double interestRate;
    @Min(value = 1, message = "loan.validation.message.requestedAmount.minValue")
    private int requestedAmount;
    @Min(value = 1, message = "loan.validation.message.instalmentCount.minValue")
    private int instalmentCount;
    @Min(value = 0, message = "loan.validation.message.monthlyIncome.minValue")
    private int monthlyIncome;
    @Min(value = 0, message = "loan.validation.message.monthlyExpenses.minValue")
    private int monthlyExpenses;

    private LoanAvailability loanAvailability;
    @JsonSerialize(using = UnavailabilityReasonSerializer.class)
    private UnavailabilityReason unavailabilityReason;

    private Integer availableAmount;
    private Integer totalRepayment;
    @JsonFormat(pattern = "MM-yyyy")
    private LocalDate lastPaymentMonth;
    private BigDecimal monthlyPayment;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getInstalmentCount() {
        return instalmentCount;
    }

    public void setInstalmentCount(int instalmentCount) {
        this.instalmentCount = instalmentCount;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(int monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public LoanAvailability getLoanAvailability() {
        return loanAvailability;
    }

    public void setLoanAvailability(LoanAvailability loanAvailability) {
        this.loanAvailability = loanAvailability;
    }

    public UnavailabilityReason getUnavailabilityReason() {
        return unavailabilityReason;
    }

    public void setUnavailabilityReason(UnavailabilityReason unavailabilityReason) {
        this.unavailabilityReason = unavailabilityReason;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Integer getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(Integer totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    public LocalDate getLastPaymentMonth() {
        return lastPaymentMonth;
    }

    public void setLastPaymentMonth(LocalDate lastPaymentMonth) {
        this.lastPaymentMonth = lastPaymentMonth;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "LoanDto{" +
               "interestRate=" + interestRate +
               ", amount=" + requestedAmount +
               ", instalmentCount=" + instalmentCount +
               ", monthlyIncome=" + monthlyIncome +
               ", monthlyExpenses=" + monthlyExpenses +
               ", loanAvailability=" + loanAvailability +
               ", unavailabilityReason=" + unavailabilityReason +
               ", availableAmount=" + availableAmount +
               ", totalRepayment=" + totalRepayment +
               ", lastPaymentMonth=" + lastPaymentMonth +
               ", monthlyPayment=" + monthlyPayment +
               '}';
    }

}
