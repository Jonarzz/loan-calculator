package contracts.verification.negative.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'max loan amount exceeded - reason in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                requestedAmount: 1_000_001,
                instalmentCount: 360,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
            header "Accept-Language", 'pl'
        }
    }

    response {
        status OK()
        body(
                interestRate: 0.04,
                requestedAmount: 1_000_001,
                instalmentCount: 360,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000,
                loanAvailability: 'UNAVAILABLE',
                unavailabilityReason: 'MAX_LOAN_AMOUNT_EXCEEDED',
                unavailabilityReasonMessage: 'Kwota kredytu jest zbyt wysoka',
                availableAmount: 1_000_001
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
        }
    }
}