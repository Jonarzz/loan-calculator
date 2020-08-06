package io.github.jonarzz.loan.calculator;

import io.github.jonarzz.loan.calculator.common.I18nConfiguration;
import io.github.jonarzz.loan.calculator.loan.LoanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({ I18nConfiguration.class, LoanConfiguration.class})
@ComponentScan("io.github.jonarzz.loan.calculator.api")
public class LoanCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculatorApplication.class, args);
	}

}
