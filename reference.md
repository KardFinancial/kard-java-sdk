# Reference
## Auth
<details><summary><code>client.auth.getToken(request) -> TokenResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.auth().getToken(
    GetTokenRequest
        .builder()
        .clientId("client_id")
        .clientSecret("client_secret")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**xKardTargetIssuer:** `Optional<String>` — (Beta) Target issuer ID for partners managing multiple issuers on the Kard platform. When set, the auth token will be scoped to this specific issuer. Required if you manage more than one issuer; omit if you operate a single issuer integration.
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Files
<details><summary><code>client.files.getMetadata(organizationId) -> GetFilesMetadataResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves metadata for files associated with a specific issuer/organization.
This endpoint supports pagination and sorting options to efficiently navigate 
through potentially large sets of file metadata.
<b>Required scopes:</b> `files.read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.files().getMetadata(
    "organization-123",
    GetFilesMetadataRequest
        .builder()
        .sort(
            Arrays.asList(FilesMetadataSortOptions.SENT_DATE_DESC)
        )
        .pageSize(5)
        .filterDateFrom("2025-02-20T21:56:23Z")
        .filterDateTo("2025-03-20T21:56:23Z")
        .filterFileType(FileType.EARNED_REWARD_APPROVED_DAILY_RECONCILIATION_FILE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**filterDateFrom:** `Optional<String>` — Start date for filtering files (format ISO8601). If not provided, defaults to current date minus 1 month.
    
</dd>
</dl>

<dl>
<dd>

**filterDateTo:** `Optional<String>` — End date for filtering files (format ISO8601). If not provided, defaults to current date.
    
</dd>
</dl>

<dl>
<dd>

**filterFileType:** `Optional<FileType>` — The document file type.
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — Number of items per page. Defaults to 10 if not specified and maximum value allowed 100 items per page.
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` — Cursor for forward pagination (next page).
    
</dd>
</dl>

<dl>
<dd>

**pageBefore:** `Optional<String>` — Cursor for backward pagination (previous page).
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<FilesMetadataSortOptions>` — If provided, response will be sorted by the specified fields. Defaults to descending sentDate, equivalent to "-sentDate"
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Subscriptions
<details><summary><code>client.notifications.subscriptions.get(organizationId) -> SubscriptionsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to fetch the subscriptions of the provided issuer.<br/>
<b>Required scopes:</b> `notifications:read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.notifications().subscriptions().get(
    "organization-123",
    GetSubscriptionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**filterEventName:** `Optional<NotificationType>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notifications.subscriptions.create(organizationId, request) -> CreateSubscriptionsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to subscribe to notification events.<br/>
<b>Required scopes:</b> `notifications:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.notifications().subscriptions().create(
    "organization-123",
    SubscriptionRequestBody
        .builder()
        .data(
            Arrays.asList(
                SubscriptionRequestUnion.subscription(
                    SubscriptionRequest
                        .builder()
                        .attributes(
                            SubscriptionRequestAttributes
                                .builder()
                                .eventName(NotificationType.EARNED_REWARD_APPROVED)
                                .webhookUrl("https://webhookUrl.com/post")
                                .enabled(true)
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `SubscriptionRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notifications.subscriptions.update(organizationId, subscriptionId, request) -> UpdateSubscriptionsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to update existing notification subscriptions.<br/>
<b>Required scopes:</b> `notifications:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.notifications().subscriptions().update(
    "organization-123",
    "subscription-123",
    UpdateSubscriptionRequestBody
        .builder()
        .data(
            UpdateSubscriptionRequestUnion.subscription(
                UpdateSubscriptionRequest
                    .builder()
                    .attributes(
                        UpdateSubscriptionRequestAttributes
                            .builder()
                            .eventName(NotificationType.EARNED_REWARD_APPROVED)
                            .webhookUrl("https://webhookUrl.com/post")
                            .enabled(true)
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**subscriptionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateSubscriptionRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations
<details><summary><code>client.organizations.get(organizationId) -> ExternalOrganizationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve organization details for the authenticated issuer
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().get("organizationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization (must match the authenticated issuer)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Children
<details><summary><code>client.organizations.children.list(organizationId) -> ChildOrganizationListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List child organizations belonging to the authenticated issuer
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().children().list(
    "organizationId",
    ListChildrenRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the parent organization
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` — Cursor value for the next page of results
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — Maximum number of records to return [1 - 200] (default = 200)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.children.create(organizationId, request) -> ExternalOrganizationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a child organization by cloning the parent and overriding specified fields. An 8-digit numeric ID is generated automatically. The name is required, must be uppercase, and must not contain spaces.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().children().create(
    "organizationId",
    CreateChildRequestBody
        .builder()
        .data(
            CreateChildRequestData
                .builder()
                .attributes(
                    CreateChildAttributes
                        .builder()
                        .name("name")
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the parent organization
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateChildRequestBody` — Child organization data for creation
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.children.get(organizationId, childId) -> ExternalOrganizationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a specific child organization
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().children().get("organizationId", "childId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the parent organization
    
</dd>
</dl>

<dl>
<dd>

**childId:** `String` — Unique identifier of the child organization
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.children.update(organizationId, childId, request) -> ExternalOrganizationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a child organization. Only the name can be changed.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().children().update(
    "organizationId",
    "childId",
    UpdateChildRequestBody
        .builder()
        .data(
            UpdateChildRequestData
                .builder()
                .attributes(
                    UpdateChildAttributes
                        .builder()
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the parent organization
    
</dd>
</dl>

<dl>
<dd>

**childId:** `String` — Unique identifier of the child organization
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateChildRequestBody` — Child organization data for update
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.children.delete(organizationId, childId) -> DeleteResourceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a child organization
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().children().delete("organizationId", "childId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the parent organization
    
</dd>
</dl>

<dl>
<dd>

**childId:** `String` — Unique identifier of the child organization
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Placements
<details><summary><code>client.organizations.placements.create(organizationId, request) -> PlacementFormatUnion</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a placement for the organization. Use type "placementMainPage" for main-page placements (requires name and availableSlots) or "placementPushNotification" for push-notification placements (requires name and cadence; availableSlots is automatically set to 1).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().placements().create(
    "org-123",
    CreatePlacementRequestBody
        .builder()
        .data(
            CreatePlacementDataUnion.placementMainPage(
                CreateMainPagePlacementData
                    .builder()
                    .attributes(
                        CreateMainPageAttributes
                            .builder()
                            .name("Homepage Banner")
                            .availableSlots(5)
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreatePlacementRequestBody` — Placement data for creation
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.placements.list(organizationId) -> PlacementListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List placements belonging to the authenticated organization
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().placements().list(
    "organizationId",
    ListPlacementsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization
    
</dd>
</dl>

<dl>
<dd>

**filterType:** `Optional<PlacementTypeFilter>` — Filter by placement type (placementMainPage or placementPushNotification)
    
</dd>
</dl>

<dl>
<dd>

**filterName:** `Optional<String>` — Filter by exact placement name (unique within an organization per type)
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` — Cursor value for the next page of results
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — Maximum number of records to return [1 - 200] (default = 200)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.placements.get(organizationId, placementId) -> PlacementFormatUnion</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a specific placement
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().placements().get("organizationId", "placementId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization
    
</dd>
</dl>

<dl>
<dd>

**placementId:** `String` — Unique identifier of the placement (UUID v7)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.placements.update(organizationId, placementId, request) -> PlacementFormatUnion</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Replace a placement. All fields must be provided. Use type "placementMainPage" or "placementPushNotification" to set the placement kind. If the type is "placementPushNotification", availableSlots is automatically set to 1.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().placements().update(
    "organizationId",
    "placementId",
    UpdatePlacementRequestBody
        .builder()
        .data(
            UpdatePlacementDataUnion.placementMainPage(
                UpdateMainPagePlacementData
                    .builder()
                    .attributes(
                        UpdateMainPageAttributes
                            .builder()
                            .name("name")
                            .availableSlots(1)
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization
    
</dd>
</dl>

<dl>
<dd>

**placementId:** `String` — Unique identifier of the placement (UUID v7)
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdatePlacementRequestBody` — Placement data for update
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.placements.delete(organizationId, placementId) -> DeleteResourceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a placement
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().placements().delete("organizationId", "placementId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` — Unique identifier of the organization
    
</dd>
</dl>

<dl>
<dd>

**placementId:** `String` — Unique identifier of the placement (UUID v7)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ping
<details><summary><code>client.ping.ping() -> PingResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to verify network connectivity and service availability.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ping().ping();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Transactions
<details><summary><code>client.transactions.create(organizationId, request) -> TransactionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to send all transactions made by all your enrolled users in your rewards program. The request body will depend on the transaction type.<br/>
Please use the correct type when calling the endpoint:
- `transaction`: These incoming transactions will be processed and matched by the Kard system. Learn more about the [Transaction CLO Matching](https://github.com/kard-financial/kard-postman#c-transaction-clo-matching) flow here.
- `matchedTransaction`: For pre-matched transactions that need validation on match by the Kard system.
- `coreTransaction`: For transactions from core banking systems with limited card-level data.<br/>

<b>Required scopes:</b> `transaction:write`<br/>
<b>Note:</b> `Maximum of 500 transactions can be created per request`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.transactions().create(
    "organization-123",
    TransactionsRequestBody
        .builder()
        .data(
            Arrays.asList(
                Transactions.transaction(
                    TransactionsRequest
                        .builder()
                        .id("309rjfoincor3icno3rind093cdow3jciwjdwcm")
                        .attributes(
                            TransactionsAttributes
                                .builder()
                                .userId("6FHt5b6Fnp0qdomMEy5AN6PXcSJIeX69")
                                .amount(1000)
                                .status(TransactionStatus.APPROVED)
                                .currency("USD")
                                .description("ADVANCEAUTO")
                                .cardBin("123456")
                                .cardLastFour("4321")
                                .direction(DirectionType.DEBIT)
                                .paymentType(TransactionPaymentType.CARD)
                                .transactionId("2467de37-cbdc-416d-a359-75de87bfffb0")
                                .subtotal(800)
                                .description2("ADVANCEAUTO")
                                .mcc("1234")
                                .authorizationDate(OffsetDateTime.parse("2021-07-02T17:47:06Z"))
                                .merchant(
                                    Merchant
                                        .builder()
                                        .name("ADVANCEAUTO")
                                        .id("12345678901234567")
                                        .addrStreet("125 Main St")
                                        .addrCity("Philadelphia")
                                        .addrState(States.PA)
                                        .addrZipcode("19147")
                                        .addrCountry("United States")
                                        .latitude("37.9419429")
                                        .longitude("-73.1446869")
                                        .storeId("12345")
                                        .build()
                                )
                                .authorizationCode("123456")
                                .retrievalReferenceNumber("100804333919")
                                .systemTraceAuditNumber("333828")
                                .acquirerReferenceNumber("1234567890123456789012345678")
                                .cardProductId("1234567890123456789012345678")
                                .processorMids(
                                    ProcessorMid.visa(
                                        VisaMid
                                            .builder()
                                            .mids(
                                                VisaMidDetails
                                                    .builder()
                                                    .vmid("12345678901")
                                                    .vsid("12345678")
                                                    .build()
                                            )
                                            .build()
                                    )
                                )
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `TransactionsRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.transactions.createFraudMarkers(organizationId, request) -> FraudulentTransactionObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to flag a submitted transaction as fraudulent. This will prevent it from being rewarded.<br/>

<b>Required scopes:</b>&nbsp;&nbsp;`transaction:write`<br/>
<b>Note:</b> `Maximum of 500 fraudulent transactions can be created per request`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.transactions().createFraudMarkers(
    "organization-123",
    FraudulentTransactionRequestBody
        .builder()
        .data(
            Arrays.asList(
                FraudulentTransactionData
                    .builder()
                    .id("myTxnId12345")
                    .type("fraudulentTransaction")
                    .attributes(
                        FraudulentTransactionAttributes
                            .builder()
                            .userId("userId123")
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `FraudulentTransactionRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.transactions.createAudits(organizationId, userId, request) -> CreateAuditResponseBody</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to request that a particular transaction be audited further by the Kard system, in the event of a missing cashback claim, incorrect cashback amount claim or other mis-match claims.<br/>
<b>Required scopes:</b> `audit:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.transactions().createAudits(
    "organization-123",
    "user-123",
    CreateAuditRequestBody
        .builder()
        .data(
            Arrays.asList(
                CreateAuditRequestDataUnion.audit(
                    AuditRequestData
                        .builder()
                        .attributes(
                            AuditAttributes
                                .builder()
                                .auditCode(8001)
                                .merchantName("Caribbean Goodness")
                                .auditDescription("duplicate transaction")
                                .transactionId("issuerTransaction123")
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user as defined on the issuers system
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateAuditRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.transactions.createBulkTransactionsUploadUrl(organizationId, request) -> CreateFileUploadUrlResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Generates up to 10 presigned PUT URLs for uploading JSONL transaction files (up to 5GB each) directly
to storage. Each URL is valid for 15 minutes. Use the returned URL to upload the file via an HTTP PUT request with the
binary file content as the body. If a URL expires before the upload completes, you must request a new one.
Files can be uploaded as plain JSONL or as a gzip-compressed file.
Only `coreTransaction` type is supported for bulk file uploads.
<b>Required scopes:</b> `transaction:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.transactions().createBulkTransactionsUploadUrl(
    "organization-123",
    CreateFileUploadRequestBody
        .builder()
        .data(
            Arrays.asList(
                CreateFileUploadData
                    .builder()
                    .type(FileUploadType.INCOMING_TRANSACTIONS_FILE)
                    .attributes(
                        CreateFileUploadAttributes
                            .builder()
                            .filename("transaction_12345.jsonl")
                            .build()
                    )
                    .build(),
                CreateFileUploadData
                    .builder()
                    .type(FileUploadType.INCOMING_TRANSACTIONS_FILE)
                    .attributes(
                        CreateFileUploadAttributes
                            .builder()
                            .filename("transaction_67890.jsonl")
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateFileUploadRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.transactions.getEarnedRewards(organizationId, userId) -> GetEarnedRewardsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve rewarded transaction history for a specific user. By default this returns only SETTLED transactions within the last 12 months.
<br/>
<b>Required scopes:</b> `transaction:read`
<br/>
<b>Query Limit:</b> Maximum of 12 months of transaction data can be queried.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.transactions().getEarnedRewards(
    "org-123",
    "user-456",
    GetEarnedRewardsRequest
        .builder()
        .pageSize(10)
        .filterStatus(RewardedTransactionStatus.APPROVED)
        .include("merchant,offer")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user as defined on the issuers system
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` — Cursor for next page (base64-encoded timestamp + transaction ID)
    
</dd>
</dl>

<dl>
<dd>

**pageBefore:** `Optional<String>` — Cursor for previous page (base64-encoded timestamp + transaction ID)
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — Number of results per page
    
</dd>
</dl>

<dl>
<dd>

**filterStatus:** `Optional<RewardedTransactionStatus>` — Filter by transaction status. Supported values are `APPROVED` and `SETTLED`. Defaults to `SETTLED` when omitted. When `APPROVED` is specified, only approved transactions that do not yet have a corresponding settled transaction are returned.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — Comma-separated list of related resources to include in the response. Supported values are `merchant` and `offer`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users
<details><summary><code>client.users.create(organizationId, request) -> CreateUsersObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to enroll a specified user into your rewards program.<br/>

<b>Required scopes:</b>&nbsp;&nbsp;`user:write`<br/>
<b>Note:</b> `Maximum of 100 users can be created per request`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().create(
    "organization-123",
    CreateUsersObject
        .builder()
        .data(
            Arrays.asList(
                UserRequestDataUnion.user(
                    UserRequestData
                        .builder()
                        .id("1234567890")
                        .attributes(
                            UserRequestAttributes
                                .builder()
                                .enrolledRewards(
                                    Arrays.asList(EnrolledRewardsType.CARDLINKED)
                                )
                                .zipCode("11238")
                                .email("user@example.com")
                                .hashedEmail("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3e2d8a5b76e45a1d4c4e2e3a1")
                                .phoneNumber("+14155552671")
                                .birthYear("1990")
                                .historicalTransactionsSent(true)
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateUsersObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.update(organizationId, userId, request) -> UserResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to update the details on a specified user.<br/>

<b>Required scopes:</b> `user:update`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().update(
    "organization-123",
    "user-123",
    UpdateUserObject
        .builder()
        .data(
            UpdateUserRequestDataUnion.user(
                UpdateUserRequestData
                    .builder()
                    .id("1234567890")
                    .attributes(
                        UpdateUserRequestAttributes
                            .builder()
                            .enrolledRewards(
                                Arrays.asList(EnrolledRewardsType.CARDLINKED)
                            )
                            .zipCode("11238")
                            .email("user@example.com")
                            .hashedEmail("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3e2d8a5b76e45a1d4c4e2e3a1")
                            .phoneNumber("+14155552671")
                            .birthYear("1990")
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateUserObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.delete(organizationId, userId) -> DeleteUserResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to delete a specified enrolled user from the rewards program and Kard's system. Users can be re-enrolled into rewards by calling the [Create User](/2024-10-01/api/users/create) endpoint using the same `id` from before.<br/>

<b>Required scopes:</b> `user:delete`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().delete("organization-123", "user-123");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.get(organizationId, userId) -> UserResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to fetch the details on a specified user.<br/>
<br/>
<b>Required scopes:</b>&nbsp;&nbsp;`user:read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().get("organization-123", "user-123");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users Attributions
<details><summary><code>client.users.attributions.create(organizationId, userId, request) -> CreateAttributionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to send attribution events made by a single enrolled user for processing. A maximum of 100 events can be included in a single request.

<b>Required scopes:</b> `attributions:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().attributions().create(
    "organization-123",
    "user-123",
    CreateAttributionRequestObject
        .builder()
        .data(
            Arrays.asList(
                CreateAttributionRequestUnion.offerAttribution(
                    OfferAttributionRequest
                        .builder()
                        .attributes(
                            OfferAttributionAttributes
                                .builder()
                                .entityId("60e4ba1da31c5a22a144c075")
                                .eventCode(EventCode.VIEW)
                                .medium(OfferMedium.SEARCH)
                                .eventDate(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                                .build()
                        )
                        .build()
                ),
                CreateAttributionRequestUnion.offerAttribution(
                    OfferAttributionRequest
                        .builder()
                        .attributes(
                            OfferAttributionAttributes
                                .builder()
                                .entityId("60e4ba1da31c5a22a144c077")
                                .eventCode(EventCode.IMPRESSION)
                                .medium(OfferMedium.EMAIL)
                                .eventDate(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                                .build()
                        )
                        .build()
                ),
                CreateAttributionRequestUnion.notificationAttribution(
                    NotificationAttributionRequest
                        .builder()
                        .attributes(
                            NotificationAttributionAttributes
                                .builder()
                                .entityId("60e4ba1da31c5a22a144c076")
                                .eventCode(EventCode.IMPRESSION)
                                .medium(NotificationMedium.PUSH)
                                .eventDate(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateAttributionRequestObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.attributions.activate(organizationId, userId, offerId) -> ActivateOfferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Record when a user activates an offer. Creates an attribution event with eventCode=ACTIVATE and medium=CTA.
Optionally include the offer data by passing `include=offer`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().attributions().activate(
    "organization-123",
    "user-123",
    "offer-456",
    ActivateOfferRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**offerId:** `String` — The unique identifier of the offer being activated
    
</dd>
</dl>

<dl>
<dd>

**supportedComponents:** `Optional<ComponentType>` — UI component types to include in the offer response (when include=offer).
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<ActivateOfferIncludeOption>` — Related resources to include in the response. Allowed value is `offer`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.attributions.boost(organizationId, userId, offerId) -> BoostOfferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Record when a user boosts an offer. Creates an attribution event with eventCode=BOOST and medium=CTA.
Optionally include the offer data by passing `include=offer`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().attributions().boost(
    "organization-123",
    "user-123",
    "offer-456",
    BoostOfferRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**offerId:** `String` — The unique identifier of the offer being boosted
    
</dd>
</dl>

<dl>
<dd>

**supportedComponents:** `Optional<ComponentType>` — UI component types to include in the offer response (when include=offer).
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<BoostOfferIncludeOption>` — Related resources to include in the response. Allowed value is `offer`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## WebView
<details><summary><code>client.users.auth.getWebViewToken(organizationId, userId) -> WebViewTokenResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves an OAuth token for webview authentication.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().auth().getWebViewToken("organization-123", "user-123");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Rewards
<details><summary><code>client.users.rewards.offers(organizationId, userId) -> OffersResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve national brand offers that a specified user is eligible for. Call this endpoint to build out your
[targeted offers UX experience](/2024-10-01/api/getting-started#b-discover-a-lapsed-customer-clo). Local offers details
can be found by calling the [Get Eligible Locations](/2024-10-01/api/rewards/locations).<br/>
<b>Required scopes:</b> `rewards:read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().rewards().offers(
    "organization-123",
    "user-123",
    GetOffersByUserRequest
        .builder()
        .sort(
            Arrays.asList(OfferSortOptions.START_DATE_DESC)
        )
        .pageSize(1)
        .filterIsTargeted(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**pageBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**filterSearch:** `Optional<String>` — Case-insensitive search string to filter offers by merchant name
    
</dd>
</dl>

<dl>
<dd>

**filterPurchaseChannel:** `Optional<List<PurchaseChannel>>` 
    
</dd>
</dl>

<dl>
<dd>

**filterCategory:** `Optional<CategoryOption>` 
    
</dd>
</dl>

<dl>
<dd>

**filterIsTargeted:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<OfferSortOptions>` — If provided, response will be sorted by the specified fields
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — CSV list of included resources in the response (e.g "categories"). Allowed value is `categories`.
    
</dd>
</dl>

<dl>
<dd>

**supportedComponents:** `Optional<ComponentType>` — UI component types to include in the response.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.rewards.placementOffers(organizationId, userId, placementId) -> OffersResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve offers for a placement slot. Returns offers sorted by highest cash back,
limited by the placement's available slots.<br/>
<b>Required scopes:</b> `rewards:read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().rewards().placementOffers(
    "organizationId",
    "userId",
    "placementId",
    GetOffersByPlacementRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**placementId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**filterSearch:** `Optional<String>` — Case-insensitive search string to filter offers by merchant name
    
</dd>
</dl>

<dl>
<dd>

**filterPurchaseChannel:** `Optional<List<PurchaseChannel>>` 
    
</dd>
</dl>

<dl>
<dd>

**filterCategory:** `Optional<CategoryOption>` 
    
</dd>
</dl>

<dl>
<dd>

**filterIsTargeted:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — CSV list of included resources in the response (e.g "categories"). Allowed value is `categories`.
    
</dd>
</dl>

<dl>
<dd>

**supportedComponents:** `Optional<ComponentType>` — UI component types to include in the response.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.rewards.locations(organizationId, userId) -> LocationsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve national and local geographic locations that a specified user has eligible in-store offers at. Use this endpoint to build
out your [map-specific UX experiences](/2024-10-01/api/getting-started#c-discover-clos-near-you-map-view). Please note
that Longitude and Latitude fields are prioritized over State, City and Zipcode and are the recommended search
pattern.<br/>
<br/>
<b>Required scopes:</b> `rewards:read`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().rewards().locations(
    "organization-123",
    "user-123",
    GetLocationsByUserRequest
        .builder()
        .include(
            Arrays.asList("offers,categories")
        )
        .pageSize(1)
        .filterLatitude(39.9419429)
        .filterLongitude(-75.1446869)
        .filterRadius(10)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**pageBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**filterName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**filterCity:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**filterZipCode:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**filterState:** `Optional<State>` 
    
</dd>
</dl>

<dl>
<dd>

**filterCategory:** `Optional<CategoryOption>` 
    
</dd>
</dl>

<dl>
<dd>

**filterLongitude:** `Optional<Double>` 
    
</dd>
</dl>

<dl>
<dd>

**filterLatitude:** `Optional<Double>` 
    
</dd>
</dl>

<dl>
<dd>

**filterRadius:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<LocationSortOptions>` — If provided, response will be sorted by the specified fields
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — CSV list of included resources in the response (e.g "offers,categories"). Allowed values are `offers` and `categories`.
    
</dd>
</dl>

<dl>
<dd>

**supportedComponents:** `Optional<ComponentType>` — UI component types to include in included offers.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users Uploads
<details><summary><code>client.users.uploads.create(organizationId, userId, request) -> CreateUploadResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to create an upload session and retrieve an upload ID. Using the upload ID in the [Add Upload 
Part](/api/uploads/create-upload-part) endpoint, historical transactions can be sent in batches for further processing.
<b>Required scopes:</b> `transaction:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().uploads().create(
    "organization-123",
    "user-123",
    CreateUploadRequestObject
        .builder()
        .data(
            CreateUploadRequestDataUnion.historicalTransactionStart(
                StartHistoricalUploadNoData
                    .builder()
                    .attributes(
                        EmptyObject
                            .builder()
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user as defined on the issuers system
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateUploadRequestObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.uploads.createPart(organizationId, userId, uploadId, request) -> CreateUploadPartResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint using the upload ID provided in the [Create Upload](/api/uploads/create-upload) endpoint to add parts to your upload. Currently, this endpoint supports adding historical transactions.
<b>Required scopes:</b> `transaction:write`
<b>Note:</b> `Maximum of 500 transactions can be uploaded per request`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().uploads().createPart(
    "organization-123",
    "user-123",
    "upload-123",
    CreateUploadPartRequestObject
        .builder()
        .data(
            Arrays.asList(
                CreateUploadPartDataUnion.historicalTransaction(
                    TransactionsRequest
                        .builder()
                        .id("309rjfoincor3icno3rind093cdow3jciwjdwcm")
                        .attributes(
                            TransactionsAttributes
                                .builder()
                                .userId("6FHt5b6Fnp0qdomMEy5AN6PXcSJIeX69")
                                .amount(1000)
                                .status(TransactionStatus.APPROVED)
                                .currency("USD")
                                .description("ADVANCEAUTO")
                                .cardBin("123456")
                                .cardLastFour("4321")
                                .direction(DirectionType.DEBIT)
                                .paymentType(TransactionPaymentType.CARD)
                                .transactionId("2467de37-cbdc-416d-a359-75de87bfffb0")
                                .subtotal(800)
                                .description2("ADVANCEAUTO")
                                .mcc("1234")
                                .authorizationDate(OffsetDateTime.parse("2021-07-02T17:47:06Z"))
                                .merchant(
                                    Merchant
                                        .builder()
                                        .name("ADVANCEAUTO")
                                        .id("12345678901234567")
                                        .addrStreet("125 Main St")
                                        .addrCity("Philadelphia")
                                        .addrState(States.PA)
                                        .addrZipcode("19147")
                                        .addrCountry("United States")
                                        .latitude("37.9419429")
                                        .longitude("-73.1446869")
                                        .storeId("12345")
                                        .build()
                                )
                                .authorizationCode("123456")
                                .retrievalReferenceNumber("100804333919")
                                .systemTraceAuditNumber("333828")
                                .acquirerReferenceNumber("1234567890123456789012345678")
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user as defined on the issuers system
    
</dd>
</dl>

<dl>
<dd>

**uploadId:** `String` — The upload ID identifying the upload session to add parts
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateUploadPartRequestObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.uploads.update(organizationId, userId, uploadId, request) -> UpdateUploadResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to update your upload session. Currently, you can signal completing a historical transactions upload.
<b>Required scopes:</b> `transaction:write`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().uploads().update(
    "organization-123",
    "user-123",
    "upload-123",
    UpdateUploadRequestObject
        .builder()
        .data(
            UpdateUploadRequestDataUnion.historicalTransactionComplete(
                HistoricalTransactionCompleteNoData
                    .builder()
                    .id("7e382223-b9a5-4825-91fb-436c8957a2e7")
                    .attributes(
                        EmptyObject
                            .builder()
                            .build()
                    )
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user as defined on the issuers system
    
</dd>
</dl>

<dl>
<dd>

**uploadId:** `String` — The upload ID identifying the upload session to update
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateUploadRequestObject` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

