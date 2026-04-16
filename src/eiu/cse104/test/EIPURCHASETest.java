package eiu.cse104.test;

import eiu.cse104.lab7.EIPURCHASE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EIPURCHASETest {

    @Test
    void calculateInterestRateBinarySearch() {
        double principal = 20_000_000 - 5_000_000;
        double monthlyPayment = 2_000_000;
        int months = 8;
        EIPURCHASE test = new EIPURCHASE();

        double expected = test.calculateInterestRate(principal, monthlyPayment, months);
        double actual = test.calculateInterestRateBinarySearch(principal, monthlyPayment, months);

        expected = Math.round(expected * 1e7) / 1e7;
        actual = Math.round(actual * 1e7) / 1e7;
        
        assertEquals(expected, actual);
    }
}