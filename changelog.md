## 3.0.0 - 2026-03-03
* refactor: replace string-based financial institution name with enum type
* Replace the String-based financialInstitutionName field with a new FinancialInstitutionName enum type to provide better type safety and validation for transaction data. This change strengthens the API by preventing invalid financial institution names and provides a comprehensive list of supported institutions.
* Key changes:
* Create new FinancialInstitutionName enum with 33 predefined financial institution constants
* Update CoreTransactionAttributes field type from String to FinancialInstitutionName
* Implement visitor pattern for type-safe enum handling
* Add JSON serialization/deserialization support with fallback for unknown values
* Update all method signatures and builders to use the new enum type
* 🌿 Generated with Fern

## 2.1.0 - 2026-03-02
* feat: add startIcon property to CtaComponent
* Add optional startIcon field to the CtaComponent class to support displaying icons on buttons. This backward-compatible enhancement allows specifying an icon identifier that will be displayed on the button.
* Key changes:
* Add startIcon field as Optional<String> to CtaComponent
* Update constructor, builder methods, equals(), and hashCode() to include startIcon
* Add getter method with proper documentation
* Add builder methods for both Optional<String> and String variants
* 🌿 Generated with Fern

## 2.0.1 - 2026-02-27
* chore: update Fern CLI version to 3.93.2
* Updated the Fern CLI version from 3.79.2 to 3.93.2 in the project metadata. This update brings the latest improvements and bug fixes from the Fern CLI toolchain to the project build process.
* Key changes:
* Update cliVersion from 3.79.2 to 3.93.2 in .fern/metadata.json
* Maintain existing generator configuration and version
* Keep publish-to-central configuration unchanged
* 🌿 Generated with Fern

## 2.0.0 - 2026-02-27
* Initial release of the Java SDK.
* Provides core client functionality, authentication support, and documented usage examples to help you get started quickly.
