package contracts.verification.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 1000,
                instalmentCount: 100,
                monthlyIncome: 2500,
                monthlyExpenses: 2400
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
    response {
        status OK()
        body(
                interestRate: 0.04,
                amount: 1000,
                instalmentCount: 100,
                monthlyIncome: 2500,
                monthlyExpenses: 2400,
                loanAvailable: false
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}