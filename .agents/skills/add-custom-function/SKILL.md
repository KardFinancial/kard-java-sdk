---
name: add-custom-function
description: Add a custom Java class to this Fern-generated SDK. Use when adding new utility classes, helpers, or custom functions that should persist across Fern regenerations.
argument-hint: [package-name] [class-description]
allowed-tools: Read, Write, Edit, Glob, Grep, Bash
---

# Add Custom Function to Kard Java SDK

This is a Fern-generated Java SDK. Custom code must follow specific conventions to survive regeneration and pass CI.

## Step-by-step process

### 1. Understand the constraints

Read these files to understand current project state:

- `build.gradle` - Java source/target compatibility (currently Java 8), dependencies, Spotless config
- `.fernignore` - files already protected from Fern regeneration
- `.github/workflows/ci.yml` - CI environment (currently Java 11)

### 2. Java compatibility rules

**This project targets Java 8 source/target and CI runs on Java 11.** You MUST NOT use:

- `record` types (Java 16+)
- `Set.of()`, `List.of()`, `Map.of()` (Java 9+) - use `Collections.unmodifiableSet(new HashSet<>(Arrays.asList(...)))` instead
- `HexFormat` (Java 17+) - use manual byte-to-hex conversion instead
- `Files.readString()` / `Path.of()` (Java 11+) in main source - acceptable in test source only since CI is Java 11
- Text blocks (Java 15+)
- `var` local variable type inference (Java 10+)
- Pattern matching, sealed classes, switch expressions

### 3. Create the source file

Place the class under `src/main/java/com/kard/<package>/` using an appropriate package name under `com.kard`.

Every custom class MUST:

- Use a `private` no-arg constructor for utility classes (classes with only static members)
- Use `toLowerCase(Locale.ROOT)` instead of `toLowerCase()` for locale-stable behavior
- Never include PII (emails, names, etc.) in exception messages - use generic descriptions only
- Keep imports sorted alphabetically within each group

### 4. Create tests

Place tests under `src/test/java/com/kard/<package>/`. Tests can use Java 11 APIs since CI runs Java 11, but avoid Java 16+ language features (no records).

### 5. Protect files from Fern regeneration

Add ALL new custom files to `.fernignore` with a descriptive comment:

```
# Custom <description>
src/main/java/com/kard/<package>/<ClassName>.java
src/test/java/com/kard/<package>/<TestClassName>.java
```

### 6. Verify formatting

This project uses **Spotless with PalantirJavaFormat**. Key formatting rules:

- Imports must be sorted alphabetically
- Long method chains / assignments may need specific line-break placement
- `printf`/`format` calls: break BEFORE the format string, not after
- Long string arguments in `throw` statements should stay on one line when possible

Run `./gradlew compileJava compileTestJava` to verify compilation. If `./gradlew spotlessApply` works locally, run it. Otherwise, manually check:

- Imports are in alphabetical order
- No lines exceed ~120 characters (PalantirJavaFormat default)
- Method arguments break consistently

### 7. Checklist before committing

- [ ] Java 8 compatible (no Java 9+ APIs in main source)
- [ ] Private constructor on utility classes
- [ ] `Locale.ROOT` on all `toLowerCase()` / `toUpperCase()` calls
- [ ] No PII in exception messages
- [ ] Imports sorted alphabetically
- [ ] All new files added to `.fernignore`
- [ ] `./gradlew compileJava compileTestJava` passes
- [ ] Spotless formatting verified

## Reference: existing custom code

See the HEM (Hashed Email) utility as a reference implementation:

- Source: `src/main/java/com/kard/hem/HEM.java`
- Tests: `src/test/java/com/kard/hem/HEMTest.java`
