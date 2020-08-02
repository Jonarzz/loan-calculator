package contracts.verification.positive

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 100_000,
                instalmentCount: 60,
                monthlyIncome: 2500,
                monthlyExpenses: 2000
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
                instalmentCount: 60,
                monthlyIncome: 2500,
                monthlyExpenses: 2000,
                loanAvailable: true,
                unavailabilityReason: null,
                availableAmount: 28_846,
                totalRepayment: 29_999,
                lastPaymentMonth: $(producer(regex('^((0[1-9])|(1[0-2]))-20\\d{2}$'))),
                monthlyPayment: 500
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}