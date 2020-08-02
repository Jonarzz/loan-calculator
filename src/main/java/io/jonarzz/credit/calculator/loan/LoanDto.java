package io.jonarzz.credit.calculator.loan;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDto {

    @Min(value = 0, message = "loan.validation.message.interestRate.minValue")
    private double interestRate;
    @Min(value = 1, message = "loan.validation.message.amount.minValue")
    private int amount;
    @Min(value = 1, message = "loan.validation.message.instalmentCount.minValue")
    private int instalmentCount;
    @Min(value = 0, message = "loan.validation.message.monthlyIncome.minValue")
    private int monthlyIncome;
    @Min(value = 0, message = "loan.validation.message.monthlyExpenses.minValue")
    private int monthlyExpenses;

    private Boolean loanAvailable;
    private Integer availableAmount;
    private Integer totalRepayment;
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

    public Boolean isLoanAvailable() {
        return loanAvailable;
    }

    public void setLoanAvailable(Boolean loanAvailable) {
        this.loanAvailable = loanAvailable;
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

}
