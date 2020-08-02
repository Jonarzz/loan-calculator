package contracts.api.fieldValue

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: -10,
                amount: 1,
                instalmentCount: 1,
                monthlyIncome: 0,
                monthlyExpenses: 0
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
    response {
        status BAD_REQUEST()
        body(
                message: 'Interest rate value cannot be a negative number.'
        )
    }
}