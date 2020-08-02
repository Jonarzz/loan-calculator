package io.github.jonarzz.credit.calculator.loan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoanConfiguration {

    @Bean
    LoanCalculationProperties loanCalculationProperties(
            @Value("${credit.calculator.loan-calculation.min-loan-amount:0}") int minLoanAmount,
            @Value("${credit.calculator.loan-calculation.max-loan-amount:1_000_000}") int maxLoanAmount,
            @Value("${credit.calculator.loan-calculation.min-monthly-payment:0}") int minMonthlyPayment) {
        return new LoanCalculationProperties(minLoanAmount, maxLoanAmount, minMonthlyPayment);
    }

}
