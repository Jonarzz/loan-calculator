package io.github.jonarzz.loan.calculator.loan;

class LoanCalculationProperties {

    private int minLoanAmount;
    private int maxLoanAmount;
    private int minMonthlyPayment;

    LoanCalculationProperties(int minLoanAmount, int maxLoanAmount, int minMonthlyPayment) {
        this.minLoanAmount = minLoanAmount;
        this.maxLoanAmount = maxLoanAmount;
        this.minMonthlyPayment = minMonthlyPayment;
    }

    int getMinLoanAmount() {
        return minLoanAmount;
    }

    int getMaxLoanAmount() {
        return maxLoanAmount;
    }

    int getMinMonthlyPayment() {
        return minMonthlyPayment;
    }

    @Override
    public String toString() {
        return "LoanCalculationProperties{" +
               "minLoanAmount=" + minLoanAmount +
               ", maxLoanAmount=" + maxLoanAmount +
               ", minMonthlyPayment=" + minMonthlyPayment +
               '}';
    }

}
