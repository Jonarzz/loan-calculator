package contracts.api.fieldValue.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid monthly income value - message in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0,
                requestedAmount: 1,
                instalmentCount: 1,
                monthlyIncome: -1,
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
                message: 'Miesięczny dochód nie może być ujemny.'
        )
    }
}