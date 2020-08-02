package contracts.verification.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 1_000_000,
                instalmentCount: 360,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
    response {
        status OK()
        body(
                interestRate: 0.04,
                amount: 1_000_000,
                instalmentCount: 360,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000,
                loanAvailable: false
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}