package com.kard.hem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Test runner that validates HEM against the shared JSON test vectors.
 * Parses the JSON with regex to avoid external dependencies.
 */
public class HEMTest {

    static class TestVector {
        final String name;
        final String input;
        final String normalized;
        final String sha256Hex;
        final boolean uid2Validated;

        TestVector(String name, String input, String normalized, String sha256Hex, boolean uid2Validated) {
            this.name = name;
            this.input = input;
            this.normalized = normalized;
            this.sha256Hex = sha256Hex;
            this.uid2Validated = uid2Validated;
        }
    }

    public static void main(String[] args) throws IOException {
        List<TestVector> vectors = parseVectors(Files.readString(Path.of("test_vectors.json")));

        int passed = 0, failed = 0;

        for (TestVector v : vectors) {
            String gotNorm = HEM.normalizeEmail(v.input);
            if (!gotNorm.equals(v.normalized)) {
                System.err.printf(
                        "FAIL [normalize] %s%n  input:    \"%s\"%n  expected: %s%n  got:      %s%n",
                        v.name, v.input, v.normalized, gotNorm);
                failed++;
                continue;
            }

            String gotHex = HEM.generateHEM(v.input);
            if (!gotHex.equals(v.sha256Hex)) {
                System.err.printf(
                        "FAIL [sha256_hex] %s%n  expected: %s%n  got:      %s%n", v.name, v.sha256Hex, gotHex);
                failed++;
                continue;
            }

            String marker = v.uid2Validated ? " ✓UID2" : "";
            System.out.printf("PASS  %s%s%n", v.name, marker);
            passed++;
        }

        System.out.printf("%n%d passed, %d failed, %d total%n", passed, failed, vectors.size());
        System.exit(failed > 0 ? 1 : 0);
    }

    /** Minimal JSON array-of-objects parser — good enough for our known schema. */
    private static List<TestVector> parseVectors(String json) {
        List<TestVector> vectors = new ArrayList<>();
        // Match each { ... } object block
        Pattern objPattern = Pattern.compile("\\{[^}]+}", Pattern.DOTALL);
        Matcher objMatcher = objPattern.matcher(json);

        while (objMatcher.find()) {
            String obj = objMatcher.group();
            String name = extractString(obj, "name");
            String input = extractString(obj, "input");
            String normalized = extractString(obj, "normalized");
            String sha256Hex = extractString(obj, "sha256_hex");
            boolean uid2 = obj.contains("\"uid2_validated\"");
            if (name != null && input != null) {
                vectors.add(new TestVector(name, input, normalized, sha256Hex, uid2));
            }
        }
        return vectors;
    }

    private static String extractString(String obj, String key) {
        // Handles JSON escapes like \t \n \" \\
        Pattern p = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*\"((?:[^\"\\\\]|\\\\.)*)\"");
        Matcher m = p.matcher(obj);
        if (!m.find()) return null;
        return m.group(1)
                .replace("\\t", "\t")
                .replace("\\n", "\n")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
    }
}
