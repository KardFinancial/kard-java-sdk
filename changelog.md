## 16.0.0 - 2026-04-17
### Breaking Changes
* **`OrganizationsClient.get()`** / **`AsyncOrganizationsClient.get()`** — the `organizationId` parameter has been removed; the endpoint now resolves to `v2/issuer` automatically. Remove the `organizationId` argument from all call sites.
* **`ChildrenClient.create()`**, **`.get()`**, **`.update()`** (and async / raw variants) — return type changed from `ExternalOrganizationResponse` to `ChildOrganizationResponse`. Update variable declarations and type references accordingly.
* **`MerchantNetwork`** — public class removed with no replacement; delete any references or usages.
* **`MerchantNetworkName`** — public enum-like class removed with no replacement; delete any references or usages.

## 15.4.0 - 2026-04-16
### Added
* **`MerchantAsset`** — new type representing a tracked asset image (logo, banner, etc.) for a merchant, with required `type` and `url` fields and an optional `alt` accessibility string.
* **`MerchantAssetType`** — new enum-like type with `IMG_VIEW` and `BANNER_VIEW` constants used with `MerchantAsset`, supporting a Visitor pattern for exhaustive handling.
* **`TransactionMerchantAttributes.getAssets()`** — new optional `List<MerchantAsset>` field exposing attribution-signed asset URLs; builder gains `assets(List<MerchantAsset>)` and `assets(Optional<List<MerchantAsset>>)` methods.

## 15.3.0 - 2026-04-16
### Added
* **`ListPlacementsRequest.filterType()`** — new optional builder method to filter placements by type (`placementMainPage` or `placementPushNotification`) via the `filter[type]` query parameter.
* **`ListPlacementsRequest.filterName()`** — new optional builder method to filter placements by exact name (unique within an organization per type) via the `filter[name]` query parameter.
* **`PlacementTypeFilter`** — new enum type with `PLACEMENT_MAIN_PAGE` and `PLACEMENT_PUSH_NOTIFICATION` values used with `filterType()`.
### Changed
* **`PlacementsClient`** / **`AsyncPlacementsClient`** — HTTP 400 responses from the list endpoint now throw `InvalidRequest` instead of being silently unhandled.

## 15.2.0 - 2026-04-16
### Added
* **`RewardsClient.placementOffers()`** / **`AsyncRewardsClient.placementOffers()`** — new sync and async methods (plus raw-response variants) that retrieve offers for a specific placement slot via `GET /v2/issuers/{organizationId}/users/{userId}/placements/{placementId}/offers`, returning results sorted by highest cash back and limited to the placement's available slots.
* **`GetOffersByPlacementRequest`** — new request type for `placementOffers()` with optional filter parameters: `filterSearch`, `filterPurchaseChannel`, `filterCategory`, `filterIsTargeted`, `include`, and `supportedComponents`.

## 15.1.0 - 2026-04-16
### Added
* **`KardApiClient.organizations()`** / **`AsyncKardApiClient.organizations()`** — new top-level accessors returning the new `OrganizationsClient` / `AsyncOrganizationsClient` for retrieving organization details.
* **`OrganizationsClient`** / **`AsyncOrganizationsClient`** — new sync and async clients (plus raw-response variants) for managing organizations via `GET /v2/issuers/{organizationId}`, including sub-client accessors `children()` and `placements()`.
* **`ChildrenClient`** / **`AsyncChildrenClient`** — new sync and async clients (plus raw-response variants) for managing child (sub-issuer) organizations via `v2/issuers/{organizationId}/children`, exposing `list()`, `create()`, `get()`, `update()`, and `delete()` methods with cursor-based pagination via `ListChildrenRequest`.
* **`PlacementsClient`** / **`AsyncPlacementsClient`** — new sync and async clients (plus raw-response variants) for managing organization placements via `v2/issuers/{organizationId}/placements`, exposing `list()`, `create()`, `get()`, `update()`, and `delete()` methods with `ListPlacementsRequest` pagination support.
* **New domain types** — `ExternalOrganizationResponse`, `ExternalOrganizationAttributes`, `ChildOrganizationListResponse`, `PlacementListResponse`, `PlacementFormatUnion`, `CreatePlacementDataUnion`, `UpdatePlacementDataUnion`, `Cadence`, `CadenceFrequency`, `DayOfWeek`, and supporting request/response types across the `organizations`, `organizations.children`, and `organizations.placements` packages.

## 15.0.0 - 2026-04-16
### Breaking Changes
* **`GetEarnedRewardsRequest.getFilterStatus()`** — now returns `Optional<RewardedTransactionStatus>` instead of `Optional<String>`; update any code that reads this value to use the enum type.
* **`GetEarnedRewardsRequest.Builder.filterStatus()`** — both overloads now accept `RewardedTransactionStatus` (or `Optional<RewardedTransactionStatus>`) instead of `String`; replace raw string literals such as `"APPROVED"` with `RewardedTransactionStatus.APPROVED`.
### Changed
* **`GetEarnedRewardsRequest` `filterStatus` documentation** — clarifies that when `APPROVED` is specified, only approved transactions that do not yet have a corresponding settled transaction are returned.

## 14.0.0 - 2026-04-15
### Breaking Changes
* **`GetEarnedRewardsResponse.Builder`** — `links()` now returns the new `MetaStage` interface instead of `_FinalStage`, inserting a mandatory `.meta(GetEarnedRewardsMeta)` call into every builder chain. Update all callsites from `.links(l).build()` to `.links(l).meta(meta).build()`.
* **`RewardedTransactionStatus.Visitor`** — a new required `visitApproved()` method has been added to the `Visitor<T>` interface; any class implementing this interface must add the method or it will fail to compile.
### Added
* **`GetEarnedRewardsMeta`** — new response type in `com.kard.api.resources.transactions.types` that carries `lifetimeRewardsInCents`, representing the lifetime rewards earned by a user across all matched transactions.
* **`GetEarnedRewardsResponse.getMeta()`** — returns the new `GetEarnedRewardsMeta` object embedded in every earned-rewards response.
* **`GetEarnedRewardsRequest.Builder.filterStatus()`** — new optional builder method that maps to the `filter[status]` query parameter; pass `"APPROVED"`, `"SETTLED"`, or a comma-separated combination to control which transaction statuses are returned (defaults to `SETTLED` when omitted).

## 13.2.0 - 2026-04-14
* [ADDED] **Configurable SDK logging** via the new `LogConfig`, `LogLevel`, `ILogger`, `Logger`, and `ConsoleLogger` types in `com.kard.api.core`. Pass a `LogConfig` to `KardApiClientBuilder.logging(LogConfig)` or `AsyncKardApiClientBuilder.logging(LogConfig)` to capture HTTP request/response activity at your desired level (`DEBUG`, `INFO`, `WARN`, `ERROR`). Logging is silent by default — no output is produced unless explicitly enabled. Supply a custom `ILogger` implementation to redirect output to any logging framework.
* [FIXED] Query-parameter getters on several request types (`GetFilesMetadataRequest`, `GetEarnedRewardsRequest`, `GetLocationsByUserRequest`, `GetOffersByUserRequest`, `GetSubscriptionsRequest`, `ActivateOfferRequest`, `BoostOfferRequest`) were annotated with `@JsonProperty` instead of `@JsonIgnore`. They are now correctly marked `@JsonIgnore`, preventing these fields from being unintentionally serialized into a request body.

## 13.1.0 - 2026-04-10
* `GetEarnedRewardsRequest` now supports an optional `include` parameter that accepts a comma-separated list of related resources (`merchant`, `offer`) to embed in the earned-rewards response. Pass the value via the builder with `.include("merchant,offer")` — existing builder chains require no changes.

## 13.0.0 - 2026-04-10
* The `CardNetwork` class has been moved from `com.kard.api.resources.transactions.types` to `com.kard.api.resources.commons.types`. Existing code that imports `CardNetwork` from the old package will fail to compile. Update all import statements from `import com.kard.api.resources.transactions.types.CardNetwork;` to `import com.kard.api.resources.commons.types.CardNetwork;`.

## 12.1.0 - 2026-04-07
* Two new types — `AttributionState` and `AttributionFilter` — are now available in the `com.kard.api.resources.users.attributions.types` package. `NotificationAttributionAttributes` and `OfferAttributionAttributes` each expose a new optional `getState()` method that returns placement context (offer rank and active filters) recorded at the time of the attribution event. Existing builder chains require no changes.

## 12.0.0 - 2026-04-07
* The `getType()` method on `CreateFileUploadData` and `FileUploadUrlData` now returns a `FileUploadType` enum instead of a hardcoded `String`. The new `FileUploadType` enum exposes constants `INCOMING_TRANSACTIONS_FILE` and `HISTORICAL_TRANSACTIONS_FILE` and a `Visitor<T>` interface for exhaustive handling. Additionally, `type` is now a required first step in both classes' staged builders — code that calls `CreateFileUploadData.builder().attributes(...)` or `FileUploadUrlData.builder().id(...)` directly will fail to compile and must be updated to call `.type(FileUploadType.INCOMING_TRANSACTIONS_FILE)` (or the appropriate variant) first.

## 11.0.0 - 2026-04-06
* Four `NotificationType` constants — `LOCATION`, `USER_OFFER`, `OFFER`, and `MERCHANT` — have been removed, along with their corresponding `Value` enum entries and `Visitor` interface methods (`visitLocation()`, `visitUserOffer()`, `visitOffer()`, `visitMerchant()`). Any exhaustive visitor implementations or switch statements referencing these values must be updated. Additionally, the following public classes have been deleted: `BrokerAmount`, `BrokerAmountType`, `BrokerAsset`, `BrokerAssetType`, `BrokerOperationHours`, `BrokerOperationPeriod`, `BrokerPurchaseChannel`, and `BrokerReward`. Code that references any of these removed types will fail to compile and must be migrated accordingly.
* The `offer`, `merchant`, `location`, and `userOffer` variants have been removed from `NotificationDataUnion`. The corresponding factory methods (`offer()`, `merchant()`, `location()`, `userOffer()`), accessors (`getOffer()`, `getMerchant()`, `getLocation()`, `getUserOffer()`), type-check methods (`isOffer()`, `isMerchant()`, `isLocation()`, `isUserOffer()`), and `Visitor` interface methods (`visitOffer()`, `visitMerchant()`, `visitLocation()`, `visitUserOffer()`) have all been removed. Additionally, the public classes `BrokerRewardType`, `LocationAddress`, `LocationCoordinates`, `LocationStatus`, `MerchantSource`, `OfferStatus`, `OfferType`, and `TimePeriod` have been deleted. Existing code that references any of these APIs will fail to compile and must be updated.
* The `UserOfferStatus`, `WebhookLocationsAttributes`, `WebhookLocationsData`, and `WebhookLocationsRelationships` classes have been removed from the `com.kard.api.resources.notifications.types` package. Existing code that references any of these types will fail to compile and must be updated — remove all usages and consult the updated API documentation for any replacement types.
* The `WebhookMerchantAttributes`, `WebhookMerchantData`, and `WebhookMerchantRelationships` classes have been removed from the `com.kard.api.resources.notifications.types` package. Existing code that references these classes or their builder stage interfaces (such as `MerchantIdStage`, `NameStage`, `AttributesStage`, etc.) will fail to compile and must be updated. Review the updated API definition for replacement types to handle webhook merchant payloads.
* The `WebhookOfferAttributes` and `WebhookOfferData` classes have been removed from the SDK. Code that references either class — including their staged builder interfaces and getter methods — will fail to compile. Remove all usages of these types; replacement types may be introduced in a future release.
* The following public classes have been removed from the `com.kard.api.resources.notifications.types` package: `WebhookOfferRelationships`, `WebhookUserOfferAttributes`, `WebhookUserOfferData`, and `WebhookUserOfferRelationships`, along with all of their associated builder interfaces and getter methods. Existing code that references any of these types will fail to compile and must be updated to remove or replace those usages.

## 10.0.0 - 2026-04-03
* The `getFinancialInstitutionName()` method on `CoreTransactionAttributes` now returns `Optional<String>` instead of `String`. Existing code that calls this method without unwrapping the `Optional` will fail to compile and must be updated. Additionally, the `FinancialInstitutionNameStage` builder interface has been removed — `financialInstitutionName` is no longer a required builder step and is instead set via optional overloaded methods on `_FinalStage`. Builder chains that previously passed through `FinancialInstitutionNameStage` must be updated accordingly.

## 9.1.0 - 2026-04-02
* The `CoreTransactionAttributes` class now includes an optional `financialInstitutionId` field that provides a unique identifier for the financial institution. The existing `financialInstitutionName` field has been deprecated — consumers should migrate to `financialInstitutionId` going forward.

## 9.0.0 - 2026-03-30
* The `cardLastFour` field in `CoreTransactionAttributes` has been renamed to `cardLastFours` and changed from `Optional<String>` to `Optional<List<String>>`. This supports cases where multiple card candidates may be provided when the issuer cannot determine which specific card was used. Existing code accessing `getCardLastFour()` must be updated to use `getCardLastFours()` and handle the list type.

## 8.0.0 - 2026-03-27
* The `xKardTargetIssuer` configuration method has been moved from the main client builders (`KardApiClientBuilder` and `AsyncKardApiClientBuilder`) to the authentication builders. When using credential-based authentication, call `xKardTargetIssuer()` on the credentials builder returned by `.credentials()` instead of on the main client builder.

## 7.1.0 - 2026-03-25
* The `CoreTransactionAttributes` class now includes an optional `cardLastFour` field that provides the last four digits of the card used for the transaction.

## 7.0.0 - 2026-03-18
* ### Breaking Changes
* **User operations** now return `UserResponseObject` instead of `UpdateUserObject`. Update your variable types and field access patterns.
* ### Added
* **`UpdateUserRequestDataUnion`** type for enhanced user data operations.
* **`historicalTransactionsSent`** optional field when updating user attributes.

## 6.0.0 - 2026-03-18
* The ProgressBar API has been restructured with breaking changes. The `segmentIcon` field has been replaced with a `segments` configuration object. The `ProgressBarLabel` class has been renamed to `ProgressBarSegment`, and `ProgressBarLabels` now uses `ProgressBarLabelPair` objects instead of `ProgressBarLabel`. Update your code to use the new type names and field structures when working with progress bar configurations.

## 5.0.0 - 2026-03-17
* The ProgressBar class now includes a new required 'labels' field that enables configurable label placement for different layout views. Three new types are available: ProgressBarLabels (containing details and default view configurations), ProgressBarLabel (with text and position properties), and ProgressBarLabelPosition enum (supporting LEFT and RIGHT positions).

## 4.3.0 - 2026-03-17
* The ProgressBar type now includes an optional segmentIcon field for specifying custom SVG icons when the progress bar is segmented.

## 4.2.0 - 2026-03-16
* The SDK now supports configuring the X-Kard-Target-Issuer header through the client builders. Use the `xKardTargetIssuer()` method on `KardApiClientBuilder` or `AsyncKardApiClientBuilder` to set this header for all requests.

## 4.1.0 - 2026-03-16
* New `ProgressBar` component support added to offer rewards, allowing tracking of redemption progress with configurable display options including total count, current progress, labels, and segmented views.

## 4.0.0 - 2026-03-13
* The `financialInstitutionName` field in `CoreTransactionAttributes` has been changed from a custom enum type to a String. Existing code that uses `FinancialInstitutionName` constants or methods will need to be updated to use String values directly.

## 3.5.0 - 2026-03-13
* The SDK now supports metadata in offers API responses. The OffersResponseObject includes a new optional meta field that provides additional context about available categories across the entire filtered result set.

## 3.4.0 - 2026-03-09
* The `GetOffersByUserRequest` now supports filtering offers by merchant name using the new `filterSearch` parameter. Pass a case-insensitive search string to filter offers based on merchant names.

## 3.3.1 - 2026-03-09
* fix: correct API endpoint path for transaction uploads
* Update the transaction upload endpoint path from "transactions/upload" to
* "transactions/uploads" to match the correct API specification. This change
* affects both synchronous and asynchronous transaction clients.
* Key changes:
* Update endpoint path in AsyncRawTransactionsClient from upload to uploads
* Update endpoint path in RawTransactionsClient from upload to uploads
* Ensure consistency with server-side API expectations
* 🌿 Generated with Fern

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
