package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should fail because of invalid instalment count value'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0,
                amount: 1,
                instalmentCount: 0,
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
                message: 'Instalment count value has to be a positive number.'
        )
    }
}