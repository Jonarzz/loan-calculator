package contracts.verification.negative

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 100_000,
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2401
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
                instalmentCount: 360,
                monthlyIncome: 2500,
                monthlyExpenses: 2401,
                loanAvailable: false,
                unavailabilityReason: 'NET_INCOME_LESS_THAN_MIN_MONTHLY_PAYMENT',
                availableAmount: null,
                totalRepayment: null,
                lastPaymentMonth: null,
                monthlyPayment: null
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}