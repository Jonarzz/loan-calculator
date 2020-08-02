package io.github.jonarzz.credit.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties",
                    properties = "logging.level.io.github.jonarzz = DEBUG")
public abstract class BaseContractTestClass {

    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.webAppContextSetup(applicationContext);
    }

    @SuppressWarnings("unused")
    protected void assertContainsAllMessagesEng(String message) {
        assertThat(message, allOf(containsString("Loan amount value has to be a positive number."),
                                  containsString("Instalment count value has to be a positive number."),
                                  containsString("Interest rate value cannot be a negative number."),
                                  containsString("Monthly income value cannot be a negative number."),
                                  containsString("Monthly expenses value cannot be a negative number.")));
    }

    @SuppressWarnings("unused")
    protected void assertContainsAllMessagesPl(String message) {
        assertThat(message, allOf(containsString("Kwota kredytu musi być liczbą dodatnią."),
                                  containsString("Liczba rat musi być liczbą dodatnią."),
                                  containsString("Oprocentowanie nie może być ujemne."),
                                  containsString("Miesięczne wydatki nie mogą być ujemne."),
                                  containsString("Miesięczny dochód nie może być ujemny.")));
    }

}