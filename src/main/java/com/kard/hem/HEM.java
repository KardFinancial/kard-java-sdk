package com.kard.hem;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
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

    private static final Set<String> GMAIL_DOMAINS = Set.of("gmail.com", "googlemail.com");

    /**
     * Normalize an email address for HEM generation.
     *
     * @throws IllegalArgumentException if the input is null, empty, or not a valid email format
     */
    public static String normalizeEmail(String raw) {
        if (raw == null || raw.isEmpty()) {
            throw new IllegalArgumentException("Email address must not be null or empty");
        }

        String email = raw.replaceAll("\\s", "").toLowerCase();

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
            throw new IllegalArgumentException("Email address must contain '@': " + raw.trim());
        }
        if (atCount > 1) {
            throw new IllegalArgumentException("Email address must contain exactly one '@': " + raw.trim());
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        if (local.isEmpty()) {
            throw new IllegalArgumentException("Email local-part must not be empty: " + raw.trim());
        }
        if (domain.isEmpty()) {
            throw new IllegalArgumentException("Email domain must not be empty: " + raw.trim());
        }

        if (GMAIL_DOMAINS.contains(domain)) {
            int plus = local.indexOf('+');
            if (plus >= 0) local = local.substring(0, plus);
            local = local.replace(".", "");
            domain = "gmail.com";
        }

        return local + "@" + domain;
    }

    /**
     * Return the lowercase hex SHA-256 digest of the normalized, UTF-8-encoded email.
     */
    public static String generateHEM(String raw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(normalizeEmail(raw).getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("SHA-256 not available", e);
        }
    }
}
