package io.github.jonarzz.loan.calculator.loan;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

@Configuration
public class LoanConfiguration {

    @Bean
    public LoanService loanService(LoanCalculationProperties loanCalculationProperties,
                                   LoanRepository loanRepository,
                                   ModelMapper modelMapper) {
        return new LoanService(loanCalculationProperties, loanRepository, modelMapper);
    }

    @Bean
    LoanCalculationProperties loanCalculationProperties(
            @Value("${loan.calculator.loan-calculation.min-loan-amount:0}") int minLoanAmount,
            @Value("${loan.calculator.loan-calculation.max-loan-amount:1_000_000}") int maxLoanAmount,
            @Value("${loan.calculator.loan-calculation.min-monthly-payment:0}") int minMonthlyPayment) {
        return new LoanCalculationProperties(minLoanAmount, maxLoanAmount, minMonthlyPayment);
    }

    @Bean
    JpaRepositoryFactoryBean<LoanRepository, Loan, Long> loanRepository() {
        return new JpaRepositoryFactoryBean<>(LoanRepository.class);
    }

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                   .setFieldMatchingEnabled(true);
        return modelMapper;
    }

}
