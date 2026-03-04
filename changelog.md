## 3.3.0 - 2026-03-04
* feat: add logo flare component and secondary button style support
* This update introduces logo flare functionality for enhanced offer presentation and adds secondary button style support. The changes expand UI component customization capabilities while removing outdated component type documentation.
* Key changes:
* Add LogoFlare, LogoFlareBadge, and related position/color enums for offer logo customization
* Add SECONDARY button style option to ButtonStyle enum
* Add BOOSTED_REWARD and LOGO_FLARE component types to ComponentType enum
* Add boostedReward and logoFlare fields to OfferComponents
* Remove specific valid values documentation from supportedComponents parameter descriptions
* 🌿 Generated with Fern

## 3.2.0 - 2026-03-03
* feat: add bulk transactions file upload API endpoint
* Add new API endpoint for generating presigned URLs to upload JSONL transaction files directly to storage. This feature enables bulk transaction uploads with support for up to 10 files per request, each up to 5GB.
* Key changes:
* Add createBulkTransactionsUploadUrl method to transactions client
* Create new data types for file upload requests and responses
* Move ForbiddenError to commons errors package for reuse
* Add comprehensive documentation and usage examples
* Support for gzip-compressed files and 15-minute URL expiration
* 🌿 Generated with Fern

## 3.1.0 - 2026-03-03
* feat: add file processing result notification support
* This change extends the notification system to handle file processing results by introducing a new notification type and associated data structures. The implementation enables the API to properly communicate file processing outcomes to clients through the existing notification framework.
* Key changes:
* Add FILE_PROCESSING_RESULT notification type to NotificationType enum with visitor pattern support
* Create FileResultData class to encapsulate file processing notification data with ID and file metadata attributes
* Extend NotificationDataUnion to support file processing result notifications with serialization support
* Add optional errors field to NotificationPayload for improved error reporting in notifications
* 🌿 Generated with Fern

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
