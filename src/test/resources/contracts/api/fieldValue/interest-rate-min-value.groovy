package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid interest rate value'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: -10,
                requestedAmount: 1,
                instalmentCount: 1,
                monthlyIncome: 0,
                monthlyExpenses: 0
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: 'Interest rate value cannot be a negative number.'
        )
    }
}