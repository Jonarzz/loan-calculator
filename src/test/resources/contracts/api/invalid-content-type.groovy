package contracts.api

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.1,
                amount: 10_000,
                instalmentCount: 100,
                monthlyIncome: 10_000,
                monthlyExpenses: 1000
        )
        headers {
            contentType('application/json')
        }
    }
    response {
        status UNSUPPORTED_MEDIA_TYPE()
    }
}