package io.jonarzz.credit.calculator.loan;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDto {

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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInstalmentsCount() {
        return instalmentsCount;
    }

    public void setInstalmentsCount(int instalmentsCount) {
        this.instalmentsCount = instalmentsCount;
    }

    public int getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(int monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public boolean isLoanAvailable() {
        return loanAvailable;
    }

    public void setLoanAvailable(boolean loanAvailable) {
        this.loanAvailable = loanAvailable;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(int totalRepayment) {
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

}
