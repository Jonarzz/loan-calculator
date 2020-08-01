package io.jonarzz.credit.calculator;

import io.jonarzz.credit.calculator.api.LoanController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.properties")
abstract class BaseContractTestClass {

    @Autowired
    private LoanController loanController;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.standaloneSetup(loanController);
    }

}