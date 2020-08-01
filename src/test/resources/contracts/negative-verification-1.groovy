package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 100_000,
                instalmentsCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2300
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
    response {
        status OK()
        body(
                interestRate: 0.04,
                amount: 100_000,
                instalmentsCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2300,
                loanAvailable: false
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}