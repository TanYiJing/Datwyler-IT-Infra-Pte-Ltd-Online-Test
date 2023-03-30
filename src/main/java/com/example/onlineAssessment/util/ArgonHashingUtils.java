package com.example.onlineAssessment.util;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

/**
 * @author yijing.tan
 */
public class ArgonHashingUtils {


    private static final int ITERATIONS = 1;
    private static final int CPU_Threads = 4; // 1 core = 2 threads
    private static final int SALT_BYTE = 8;
    private static final int HASHED_PASSWORD_BYTE = 32;
    private static final int Kibibytes = 1024000;

    public static String hashPasswordWithSalt(String password, String salt) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder();

        //hash 128 should be sufficient for password
        byte[] hashedPassword = new byte[HASHED_PASSWORD_BYTE];
        builder.withIterations(ITERATIONS);
        builder.withMemoryAsKB(Kibibytes);

        // Argon2d: 0 (Resistance to GPU attack, hence great usage in Crypto)
        // Argon2i: 1 (Best for password hashing)
        // Argon2id: 2 (Mix of both Argon2d and Argon2i)
        builder.withVersion(1);

        //Add in salt for added securtiy
        builder.withSalt(salt.getBytes());

        //Choose how many threads when hashing a password
        builder.withParallelism(CPU_Threads);

        //initialize builder param into algorithm
        Argon2Parameters parameters = builder.build();
        generator.init(parameters);
        //hash password
        generator.generateBytes(password.toCharArray(), hashedPassword);

        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public static String generateSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[SALT_BYTE];
        SecureRandom.getInstanceStrong().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static boolean verifyPassword(String password, String salt, String hashedPassword) throws NoSuchAlgorithmException {
        return hashPasswordWithSalt(password, salt).equals(hashedPassword);
    }

}
