package io.github.jonarzz.loan.calculator.loan;

enum UnavailabilityReason {

    MIN_LOAN_AMOUNT_NOT_REACHED("loan.calculation.minLoanAmountNotReached"),
    NET_INCOME_LESS_THAN_MIN_MONTHLY_PAYMENT("loan.calculation.netIncomeLessThanMinMonthlyPayment"),
    MAX_LOAN_AMOUNT_EXCEEDED("loan.calculation.maxLoanAmountExceeded");

    private final String messageCode;

    UnavailabilityReason(String messageCode) {
        this.messageCode = messageCode;
    }

    String getMessageCode() {
        return messageCode;
    }

}
