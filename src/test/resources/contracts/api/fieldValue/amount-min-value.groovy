package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid loan amount value'

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
        }
    }

    response {
        status BAD_REQUEST()
        body(
                message: 'Loan amount value has to be a positive number.'
        )
    }
}