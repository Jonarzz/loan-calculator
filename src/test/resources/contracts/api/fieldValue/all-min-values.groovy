package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of all values invalid'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: -1,
                requestedAmount: 0,
                instalmentCount: 0,
                monthlyIncome: -1,
                monthlyExpenses: -1
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: ''
        )
        bodyMatchers {
            jsonPath '$.message', byCommand('assertContainsAllMessagesEng($it)')
        }
    }
}