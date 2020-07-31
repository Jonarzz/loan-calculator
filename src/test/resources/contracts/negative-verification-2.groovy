package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 1000,
                instalmentsCount: 100,
                monthlyIncome: 2500,
                monthlyExpenses: 2400
        )
        headers {
            contentType('application/load.calculation.v1+json')
        }
    }
    response {
        status OK()
        body(
                interestRate: 0.04,
                amount: 1000,
                instalmentsCount: 100,
                monthlyIncome: 2500,
                monthlyExpenses: 2400,
                loadAvailable: false
        )
        headers {
            contentType('application/load.calculation.v1+json')
        }
    }
}