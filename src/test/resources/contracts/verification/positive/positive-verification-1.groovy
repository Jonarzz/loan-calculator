package contracts.verification.positive

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return available loan parameters with requested amount'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                requestedAmount: 100_000,
                instalmentCount: 120,
                monthlyIncome: 5000,
                monthlyExpenses: 2300
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
                instalmentCount: 120,
                monthlyIncome: 5000,
                monthlyExpenses: 2300,
                loanAvailable: true,
                unavailabilityReason: null,
                availableAmount: 100_000,
                totalRepayment: 104_000,
                lastPaymentMonth: $(producer(regex('^((0[1-9])|(1[0-2]))-20\\d{2}$'))),
                monthlyPayment: 866.67
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }
}