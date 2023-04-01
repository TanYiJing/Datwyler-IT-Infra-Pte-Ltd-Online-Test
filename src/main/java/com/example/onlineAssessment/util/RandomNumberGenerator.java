package com.example.onlineAssessment.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    private static final long LOWER_BOUND = 100000000000L;
    private static final long UPPER_BOUND = 999999999999L;

    // To ensure thread safety, we use ThreadLocalRandom instead of Random
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    // We use a Set to keep track of previously generated loan numbers to avoid collisions
    private static final Set<Long> generatedLoanNumbers = new HashSet<>();

    public static synchronized long generateLoanNumber() throws Exception {
        long loanNumber;
        do {
            // Generate a random loan number between the lower and upper bounds
            loanNumber = random.nextLong(LOWER_BOUND, UPPER_BOUND + 1);
        } while (!generatedLoanNumbers.add(loanNumber));

        // If we generate more loan numbers than the number of possible unique numbers
        // (UPPER_BOUND - LOWER_BOUND + 1), we will eventually exhaust all possibilities
        if (generatedLoanNumbers.size() > UPPER_BOUND - LOWER_BOUND + 1) {
            throw new Exception("All possible loan numbers have been generated");
        }

        return loanNumber;
    }
}
