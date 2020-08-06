package contracts.api.fieldValue.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid interest rate value - message in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: -10,
                requestedAmount: 1000,
                instalmentCount: 10,
                monthlyIncome: 1000,
                monthlyExpenses: 100
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
            header 'Accept-Language', 'pl'
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: 'Oprocentowanie nie może być ujemne.'
        )
    }
}