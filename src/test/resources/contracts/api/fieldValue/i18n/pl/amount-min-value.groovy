package contracts.api.fieldValue.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid loan amount value - message in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0,
                requestedAmount: 0,
                instalmentCount: 1,
                monthlyIncome: 0,
                monthlyExpenses: 0
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
            header 'Accept-Language', 'pl'
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: 'Kwota kredytu musi być liczbą dodatnią.'
        )
    }
}