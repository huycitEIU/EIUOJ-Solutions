package eiu.cse104.extra;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanPaymentCalculator {
    private static final int DECIMAL_PLACES = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    /**
     * Calculate monthly loan payment using standard amortization formula
     * Formula: M = P * [r(1+r)^n] / [(1+r)^n - 1]
     * Where: M = monthly payment, P = principal, r = monthly rate, n = number of payments
     */
    public BigDecimal calculateMonthlyPayment(BigDecimal principal,
                                              BigDecimal annualRate,
                                              int termYears) {
        // Convert annual rate to monthly rate
        BigDecimal monthlyRate = annualRate.divide(new BigDecimal("12"), 10, ROUNDING_MODE);
        int numberOfPayments = termYears * 12;

        // Handle zero interest rate case
        if (monthlyRate.compareTo(BigDecimal.ZERO) == 0) {
            return principal.divide(new BigDecimal(numberOfPayments), DECIMAL_PLACES, ROUNDING_MODE);
        }

        // Calculate (1 + r)^n
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        double compoundFactor = Math.pow(onePlusRate.doubleValue(), numberOfPayments);
        BigDecimal compoundBD = new BigDecimal(String.valueOf(compoundFactor));

        // M = P * [r(1+r)^n] / [(1+r)^n - 1]
        BigDecimal numerator = monthlyRate.multiply(compoundBD);
        BigDecimal denominator = compoundBD.subtract(BigDecimal.ONE);
        BigDecimal paymentFactor = numerator.divide(denominator, 10, ROUNDING_MODE);

        return principal.multiply(paymentFactor).setScale(DECIMAL_PLACES, ROUNDING_MODE);
    }
}

