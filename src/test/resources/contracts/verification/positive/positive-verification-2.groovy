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
                availableAmount: 30_000,
                totalRepayment: 31_200,
                lastPaymentMonth: $(producer(regex('(0[1-9])|(1[0-2])-202\\d'))),
                monthlyPayment: 520
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}