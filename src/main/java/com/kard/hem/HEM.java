package com.kard.hem;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Hashed Email (HEM) generation following UID2/LiveRamp industry standards.
 *
 * <ul>
 *   <li>Remove all whitespace</li>
 *   <li>Lowercase</li>
 *   <li>Gmail/Googlemail only: remove dots from local-part, strip '+' suffix</li>
 *   <li>Canonicalize googlemail.com → gmail.com</li>
 *   <li>SHA-256 hash the UTF-8 bytes</li>
 * </ul>
 */
public final class HEM {

    private HEM() {}

    private static final Set<String> GMAIL_DOMAINS = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList("gmail.com", "googlemail.com")));

    /**
     * Normalize an email address for HEM generation.
     *
     * @throws IllegalArgumentException if the input is null, empty, or not a valid email format
     */
    public static String normalizeEmail(String raw) {
        if (raw == null || raw.isEmpty()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }

        String email = raw.replaceAll("\\s", "").toLowerCase(Locale.ROOT);

        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email address must not be blank");
        }

        int atCount = 0;
        int atIndex = -1;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atCount++;
                atIndex = i;
            }
        }

        if (atCount == 0) {
            throw new IllegalArgumentException("Invalid email format: missing '@'");
        }
        if (atCount > 1) {
            throw new IllegalArgumentException("Invalid email format: multiple '@' characters");
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        if (local.isEmpty()) {
            throw new IllegalArgumentException("Invalid email format: empty local-part");
        }
        if (domain.isEmpty()) {
            throw new IllegalArgumentException("Invalid email format: empty domain");
        }

        if (GMAIL_DOMAINS.contains(domain)) {
            int plus = local.indexOf('+');
            if (plus >= 0) local = local.substring(0, plus);
            local = local.replace(".", "");
            domain = "gmail.com";

            if (local.isEmpty()) {
                throw new IllegalArgumentException(
                        "Invalid email format: empty local-part after Gmail normalization");
            }
        }

        return local + "@" + domain;
    }

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hex = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hex[i * 2] = HEX_CHARS[v >>> 4];
            hex[i * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hex);
    }

    /**
     * Return the lowercase hex SHA-256 digest of the normalized, UTF-8-encoded email.
     */
    public static String generateHEM(String raw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(normalizeEmail(raw).getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("SHA-256 not available", e);
        }
    }
}
