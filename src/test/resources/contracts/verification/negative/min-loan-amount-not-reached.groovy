package contracts.verification.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'min loan amount not reached'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                requestedAmount: 100,
                instalmentCount: 10,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }

    response {
        status OK()
        body(
                interestRate: 0.04,
                requestedAmount: 100,
                instalmentCount: 10,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000,
                loanAvailability: 'UNAVAILABLE',
                unavailabilityReason: 'MIN_LOAN_AMOUNT_NOT_REACHED',
                unavailabilityReasonMessage: 'Loan amount is too low',
                availableAmount: null,
                totalRepayment: null,
                lastPaymentMonth: null,
                monthlyPayment: null
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }
}