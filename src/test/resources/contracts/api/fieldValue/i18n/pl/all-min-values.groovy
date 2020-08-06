package contracts.api.fieldValue.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of all values invalid - message in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: -1,
                amount: 0,
                instalmentCount: 0,
                monthlyIncome: -1,
                monthlyExpenses: -1
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
            header 'Accept-Language', 'pl'
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: ''
        )
        bodyMatchers {
            jsonPath '$.message', byCommand('assertContainsAllMessagesPl($it)')
        }
    }
}