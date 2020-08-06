package contracts.verification.positive

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return available loan parameters with requested amount - low net income and high instalment count'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                requestedAmount: 100_000,
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2150
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }

    response {
        status OK()
        body(
                interestRate: 0.04,
                requestedAmount: 100_000,
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2150,
                loanAvailable: true,
                unavailabilityReason: null,
                availableAmount: 100_000,
                totalRepayment: 104_000,
                lastPaymentMonth: $(producer(regex('^((0[1-9])|(1[0-2]))-20\\d{2}$'))),
                monthlyPayment: 288.89
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }
}