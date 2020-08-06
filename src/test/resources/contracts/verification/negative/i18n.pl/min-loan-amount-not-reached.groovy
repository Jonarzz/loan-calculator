package contracts.verification.negative.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'min loan amount not reached - reason in Polish'

    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 100,
                instalmentCount: 10,
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
                amount: 100,
                instalmentCount: 10,
                monthlyIncome: 10_000,
                monthlyExpenses: 3000,
                loanAvailable: false,
                unavailabilityReason: 'MIN_LOAN_AMOUNT_NOT_REACHED',
                unavailabilityReasonMessage: 'Kwota kredytu jest zbyt niska',
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