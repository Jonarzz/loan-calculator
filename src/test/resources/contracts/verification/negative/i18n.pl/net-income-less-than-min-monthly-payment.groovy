package contracts.verification.negative.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'net income less than min monthly payment - reason in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                requestedAmount: 100_000,
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2401
        )
        headers {
            contentType 'application/loan.calculation.v1+json'
            header 'Accept-Language', 'pl'
        }
    }

    response {
        status OK()
        body(
                interestRate: 0.04,
                requestedAmount: 100_000,
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2401,
                loanAvailability: 'UNAVAILABLE',
                unavailabilityReason: 'NET_INCOME_LESS_THAN_MIN_MONTHLY_PAYMENT',
                unavailabilityReasonMessage: 'Dochód miesięczny netto jest zbyt niski',
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