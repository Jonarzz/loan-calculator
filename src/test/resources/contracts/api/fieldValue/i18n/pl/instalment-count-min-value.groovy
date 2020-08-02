package contracts.api.fieldValue.i18n.pl

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/loan/calculation'
        body(
                interestRate: 0,
                amount: 1,
                instalmentCount: 0,
                monthlyIncome: 0,
                monthlyExpenses: 0
        )
        headers {
            contentType('application/loan.calculation.v1+json')
            header("Accept-Language", 'pl')
        }
    }
    response {
        status BAD_REQUEST()
        body(
                message: 'Liczba rat musi być liczbą dodatnią.'
        )
    }
}