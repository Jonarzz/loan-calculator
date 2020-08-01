package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0.04,
                amount: 100_000,
                instalmentsCount: 120,
                monthlyIncome: 5000,
                monthlyExpenses: 2300
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
                instalmentsCount: 120,
                monthlyIncome: 5000,
                monthlyExpenses: 2300,
                loanAvailable: true,
                availableAmount: 100_000,
                totalRepayment: 104_000,
                lastPaymentMonth: $(producer(regex('(0[1-9])|(1[0-2])-202\\d'))),
                monthlyPayment: 8666.67
        )
        headers {
            contentType('application/loan.calculation.v1+json')
        }
    }
}