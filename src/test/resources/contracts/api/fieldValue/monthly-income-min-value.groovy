package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid monthly income value'

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
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: 'Monthly income value cannot be a negative number.'
        )
    }
}