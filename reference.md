# Reference
## Attributions
<details><summary><code>client.attributions.internalBulkCreateAttributions(request) -> InternalBulkCreateAttributionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to persist attribution events. A maximum of 100 events can be included in a single request.
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
client.attributions().internalBulkCreateAttributions(
    InternalBulkCreateAttributionsRequest
        .builder()
        .data(
            Arrays.asList(
                InternalApiAttribution.offerAttribution(
                    InternalApiOfferAttribution
                        .builder()
                        .attributes(
                            InternalApiOfferAttributionAttributes
                                .builder()
                                .issuerId("issuerId")
                                .userId("userId")
                                .entityId("entityId")
                                .eventCode(InternalEventCode.IMPRESSION)
                                .medium(InternalOfferMedium.BROWSE)
                                .eventDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                                .build()
                        )
                        .build()
                ),
                InternalApiAttribution.offerAttribution(
                    InternalApiOfferAttribution
                        .builder()
                        .attributes(
                            InternalApiOfferAttributionAttributes
                                .builder()
                                .issuerId("issuerId")
                                .userId("userId")
                                .entityId("entityId")
                                .eventCode(InternalEventCode.IMPRESSION)
                                .medium(InternalOfferMedium.BROWSE)
                                .eventDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
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

**request:** `InternalBulkCreateAttributionsRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attributions.internalGetAttributions(organizationId, userId) -> InternalGetAttributionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a list of attribution records with optional filtering and pagination.
Returns attribution events that match the specified criteria.
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
client.attributions().internalGetAttributions(
    "organizationId",
    "userId",
    InternalGetAttributionsRequest
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

**filterType:** `Optional<InternalAttributionType>` — Filter by attribution type (offerAttribution or notificationAttribution)
    
</dd>
</dl>

<dl>
<dd>

**filterEntityId:** `Optional<String>` — Filter by entity ID
    
</dd>
</dl>

<dl>
<dd>

**filterEventCode:** `Optional<InternalEventCode>` — Filter by event code (IMPRESSION or VIEW)
    
</dd>
</dl>

<dl>
<dd>

**filterStartDate:** `Optional<OffsetDateTime>` — Filter attributions after this date (ISO 8601 format)
    
</dd>
</dl>

<dl>
<dd>

**filterEndDate:** `Optional<OffsetDateTime>` — Filter attributions before this date (ISO 8601 format)
    
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

**pageSize:** `Optional<Integer>` — Number of items per page. Defaults to 10 if not specified and maximum value allowed 100 items per page.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

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

## BillingAgent
<details><summary><code>client.billingAgent.createIssuerReward(issuerId, userId, request) -> CreateIssuerRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to create a new reward entry in the ledger.<br/>
<b>Required scopes:</b> `reward:write`
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
client.billingAgent().createIssuerReward(
    "5e27318c9b346f00087fbb32",
    "5e27318c9b346f00087fbb32",
    CreateIssuerRewardRequestBody
        .builder()
        .description("Reward payout for transaction")
        .transactionIds(
            Arrays.asList("billing.TransactionId.Sample")
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateIssuerRewardRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.revertIssuerReward(issuerId, userId, rewardId) -> RevertIssuerRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to revert a reward for the issuer
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
client.billingAgent().revertIssuerReward("5e27318c9b346f00087fbb32", "5e27318c9b346f00087fbb32", UUID.fromString("82ed6e40-f2f6-4f66-be17-52c03ad64414"));
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**rewardId:** `UUID` — ID of the reward entry
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.getIssuerReward(issuerId, userId, rewardId) -> GetIssuerRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to get a reward.<br/>
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
client.billingAgent().getIssuerReward(
    "5e27318c9b346f00087fbb32",
    "5e27318c9b346f00087fbb32",
    UUID.fromString("82ed6e40-f2f6-4f66-be17-52c03ad64414"),
    GetIssuerRewardRequest
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**rewardId:** `UUID` — ID of the reward entry
    
</dd>
</dl>

<dl>
<dd>

**entries:** `Optional<Boolean>` — Include reward entries in the response
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.getIssuerRewards(issuerId, userId) -> GetIssuerRewardsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to list rewards. MUST BE FILTERED<br/>
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
client.billingAgent().getIssuerRewards(
    "5e27318c9b346f00087fbb32",
    "5e27318c9b346f00087fbb32",
    GetIssuerRewardsRequest
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Page>` 
    
</dd>
</dl>

<dl>
<dd>

**filter:** `Optional<RewardsFilterOptions>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.getIssuerMatchedTransactionInfo(issuerId, userId) -> GetIssuerMatchedTransactionInfoResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to get information on a list of matched transactions
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
client.billingAgent().getIssuerMatchedTransactionInfo(
    "5e27318c9b346f00087fbb32",
    "5e27318c9b346f00087fbb32",
    GetIssuerMatchedTransactionRequest
        .builder()
        .transactionIds("123456,876543")
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**transactionIds:** `String` — Comma-separated list of transactions IDs to fetch info for
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.eomUpdates(issuerId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to get information on a list of matched transactions
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
client.billingAgent().eomUpdates(
    "issuerId",
    EomUpdatesRequestBody
        .builder()
        .data(
            Arrays.asList(
                EomUpdatePayload
                    .builder()
                    .id("id")
                    .attributes(
                        new HashMap<String, Object>() {{
                            put("attributes", new 
                            HashMap<String, Object>() {{put("key", "value");
                            }});
                        }}
                    )
                    .build(),
                EomUpdatePayload
                    .builder()
                    .id("id")
                    .attributes(
                        new HashMap<String, Object>() {{
                            put("attributes", new 
                            HashMap<String, Object>() {{put("key", "value");
                            }});
                        }}
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**request:** `EomUpdatesRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingAgent.updateMatchedTransaction(issuerId, userId, transactionId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to update a matched transaction with adjusted commission
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
client.billingAgent().updateMatchedTransaction(
    "5e27318c9b346f00087fbb32",
    "5e27318c9b346f00087fbb32",
    "123456",
    UpdateMatchedTransactionRequestBody
        .builder()
        .data(
            UpdateMatchedTransactionPayload
                .builder()
                .issuerAmount(100)
                .cardholderAmount(100)
                .kardFee(100)
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — The ID of the user
    
</dd>
</dl>

<dl>
<dd>

**transactionId:** `String` — The ID of the transaction
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateMatchedTransactionRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BillingService
<details><summary><code>client.billingService.createReward(request) -> CreateRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to create a new reward entry in the ledger.<br/>
<b>Required scopes:</b> `rewards:write`
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
client.billingService().createReward(
    CreateRewardRequestBody
        .builder()
        .issuerId("5e27318c9b346f00087fbb32")
        .userId("5e27318c9b346f00087fbb32")
        .description("Reward payout for transaction")
        .transactionIds(
            Arrays.asList("5e27318c9b346f00087fbb32")
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

**request:** `CreateRewardRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.getReward(rewardId) -> GetRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to get a reward by its ID.
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
client.billingService().getReward(
    UUID.fromString("abd6e578-d130-44e6-bf4b-8dddb31038b0"),
    GetRewardRequest
        .builder()
        .entries(true)
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

**rewardId:** `UUID` — ID of the reward entry
    
</dd>
</dl>

<dl>
<dd>

**entries:** `Optional<Boolean>` — Include reward entries in the response
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.getRewards() -> GetRewardsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to list rewards. MUST BE FILTERED<br/>
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
client.billingService().getRewards(
    GetRewardsRequest
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

**page:** `Optional<Page>` 
    
</dd>
</dl>

<dl>
<dd>

**filter:** `Optional<RewardsFilterOptions>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.getRewardEntries() -> GetRewardEntriesResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to list reward entries.<br/>
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
client.billingService().getRewardEntries(
    GetRewardEntriesRequest
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

**page:** `Optional<Page>` 
    
</dd>
</dl>

<dl>
<dd>

**filter:** `Optional<RewardsFilterOptions>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.updateReward(rewardId, request) -> UpdateRewardResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to create an adjustment entry in the ledger for a reward.
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
client.billingService().updateReward(
    UUID.fromString("abd6e578-d130-44e6-bf4b-8dddb31038b0"),
    UpdateRewardRequestBody
        .builder()
        .issuerAmount(0)
        .cardHolderAmount(0)
        .kardFees(-50)
        .description("Waive fees for transaction")
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

**rewardId:** `UUID` — ID of the reward entry
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateRewardRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.revertReward(rewardId) -> RevertRewardsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to revert a reward
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
client.billingService().revertReward(UUID.fromString("82ed6e40-f2f6-4f66-be17-52c03ad64414"));
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

**rewardId:** `UUID` — ID of the reward entry
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.revertRewards() -> RevertRewardsResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to revert rewards
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
client.billingService().revertRewards(
    RevertRewardsRequest
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

**filter:** `Optional<RewardsFilterOptions>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.uploadInvoiceStatus() -> InvoiceStatusFileResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint get a presigned URL that can be used to upload the EOM invoice status file.
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
client.billingService().uploadInvoiceStatus();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.billingService.triggerMerchantInvoice(merchantId, request) -> TriggerMerchantInvoiceResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Triggers the job to issue a merchant invoice
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
client.billingService().triggerMerchantInvoice(
    "merchantId",
    TriggerMerchantInvoiceRequestBody
        .builder()
        .startDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
        .endDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
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

**merchantId:** `String` — ID of the reward entry
    
</dd>
</dl>

<dl>
<dd>

**request:** `TriggerMerchantInvoiceRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Eligibility-Broker
<details><summary><code>client.eligibilityBroker.ingest(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Send events to be ingested by the eligibility broker to change a user's eligibility.
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
client.eligibilityBroker().ingest(
    IngestRequestBody
        .builder()
        .data(
            Arrays.asList(
                IngestionEvents.segmentUser(
                    SegmentationIngestionEvent
                        .builder()
                        .attributes(
                            SegmentationIngestionEventAttributes
                                .builder()
                                .userId("6FHt5b6Fnp0qdomMEy5AN6PXcSJIeX69")
                                .issuerId("00073100")
                                .segmentId("5eb2d4a39ce24e00081488c4")
                                .status(IngestionEventStatus.ACTIVE)
                                .eventTime(OffsetDateTime.parse("2021-07-02T17:47:06Z"))
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

**request:** `IngestRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Experiments
<details><summary><code>client.experiments.listExperiments() -> ListExperimentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

A list of experiments.
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
client.experiments().listExperiments(
    ListExperiments
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

**page:** `Optional<Page>` 
    
</dd>
</dl>

<dl>
<dd>

**filter:** `Optional<ListExperimentsFilter>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListExperimentsSort>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.getExperimentById(id) -> ExperimentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get an experiment by id.
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
client.experiments().getExperimentById(
    UUID.fromString("3fc40dd7-f74e-40fc-8236-027fb98ae8a5"),
    GetExperimentById
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

**id:** `UUID` — The id of the experiment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.createExperiment(request) -> ExperimentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create an experiment.
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
client.experiments().createExperiment(
    ExperimentRequest
        .builder()
        .attributes(
            Experiment
                .builder()
                .name("Experiment 1")
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

**request:** `ExperimentRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.updateExperiment(id, request) -> ExperimentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an experiment.
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
client.experiments().updateExperiment(
    UUID.fromString("3fc40dd7-f74e-40fc-8236-027fb98ae8a5"),
    UpdateExperiment
        .builder()
        .body(
            ExperimentRequest
                .builder()
                .attributes(
                    Experiment
                        .builder()
                        .name("Experiment 1")
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

**id:** `UUID` — The id of the experiment.
    
</dd>
</dl>

<dl>
<dd>

**request:** `ExperimentRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.createOfferLink(request) -> OfferLinkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create an offer link for an experiment.
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
client.experiments().createOfferLink(
    OfferLinkRequest
        .builder()
        .attributes(
            OfferLinkUnion.of(
                OfferLinkDraft
                    .builder()
                    .experimentId(UUID.fromString("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8"))
                    .status("DRAFT")
                    .offerId("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8")
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

**request:** `OfferLinkRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.listOfferLinks() -> ListOfferLinksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all offer links for an experiment.
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
client.experiments().listOfferLinks(
    ListOfferLinks
        .builder()
        .experimentId(UUID.fromString("3fc40dd7-f74e-40fc-8236-027fb98ae8a5"))
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

**experimentId:** `UUID` — The id of the experiment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.getOfferLinkById(id) -> OfferLinkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get an offer link by id.
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
client.experiments().getOfferLinkById(
    UUID.fromString("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8"),
    GetOfferLinkById
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

**id:** `UUID` — The id of the offer link.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.updateOfferLink(id, request) -> OfferLinkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an offer link for an experiment.
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
client.experiments().updateOfferLink(
    UUID.fromString("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8"),
    UpdateOfferLink
        .builder()
        .body(
            OfferLinkRequest
                .builder()
                .attributes(
                    OfferLinkUnion.of(
                        OfferLinkDraft
                            .builder()
                            .experimentId(UUID.fromString("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8"))
                            .status("DRAFT")
                            .offerId("a52cd8d3-a6a3-4819-a7e2-8bb5736f8ac8")
                            .build()
                    )
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

**id:** `UUID` — The id of the offer link.
    
</dd>
</dl>

<dl>
<dd>

**request:** `OfferLinkRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.experiments.deleteOfferLink(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an offer link for an experiment.
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
client.experiments().deleteOfferLink(
    UUID.fromString("3fc40dd7-f74e-40fc-8236-027fb98ae8a5"),
    DeleteOfferLink
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

**id:** `UUID` — The id of the offer link.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Files
<details><summary><code>client.files.internalSaveFile(organizationId, request) -> SaveFilesMetadataResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to save conciliation file metadata.
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
client.files().internalSaveFile(
    "organizationId",
    SaveFilesMetadataRequest
        .builder()
        .data(
            Arrays.asList(
                FileMetadataResource
                    .builder()
                    .id("id")
                    .type(FileType.EARNED_REWARD_APPROVED_DAILY_RECONCILIATION_FILE)
                    .attributes(
                        FileMetadataAttributesResource
                            .builder()
                            .fileName("fileName")
                            .bucketName("bucketName")
                            .lastModified("lastModified")
                            .sentAt("sentAt")
                            .build()
                    )
                    .relationships(
                        new HashMap<String, RelationshipSingle>() {{
                            put("relationships", RelationshipSingle
                                .builder()
                                .data(
                                    RelationshipData
                                        .builder()
                                        .type("type")
                                        .id("id")
                                        .build()
                                )
                                .build());
                        }}
                    )
                    .build(),
                FileMetadataResource
                    .builder()
                    .id("id")
                    .type(FileType.EARNED_REWARD_APPROVED_DAILY_RECONCILIATION_FILE)
                    .attributes(
                        FileMetadataAttributesResource
                            .builder()
                            .fileName("fileName")
                            .bucketName("bucketName")
                            .lastModified("lastModified")
                            .sentAt("sentAt")
                            .build()
                    )
                    .relationships(
                        new HashMap<String, RelationshipSingle>() {{
                            put("relationships", RelationshipSingle
                                .builder()
                                .data(
                                    RelationshipData
                                        .builder()
                                        .type("type")
                                        .id("id")
                                        .build()
                                )
                                .build());
                        }}
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

**request:** `SaveFilesMetadataRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

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

## Offers
<details><summary><code>client.offers.getOffers() -> OffersListResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get offers
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
client.offers().getOffers(
    GetOffersRequest
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

**pageAfter:** `Optional<String>` — Represents a cursor value, and if provided, returns the next page of results
    
</dd>
</dl>

<dl>
<dd>

**pageBefore:** `Optional<String>` — Represents a cursor value, and if provided, returns the previous page of results
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — Maximum number of records to be returned [1 - 200], (default = 200)
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — Comma-separated list of related resources to include (e.g., merchant,locations,segments,audiences)
    
</dd>
</dl>

<dl>
<dd>

**filterName:** `Optional<String>` — Filter by offer name
    
</dd>
</dl>

<dl>
<dd>

**filterOfferType:** `Optional<LocationType>` 
    
</dd>
</dl>

<dl>
<dd>

**filterMerchantId:** `Optional<String>` — Filter by merchant ID
    
</dd>
</dl>

<dl>
<dd>

**filterStartDate:** `Optional<String>` — Filter by start date (ISO 8601 format)
    
</dd>
</dl>

<dl>
<dd>

**filterExpirationDate:** `Optional<String>` — Filter by expiration date (ISO 8601 format)
    
</dd>
</dl>

<dl>
<dd>

**filterSource:** `Optional<Source>` 
    
</dd>
</dl>

<dl>
<dd>

**filterCategory:** `Optional<String>` — Filter by offer category
    
</dd>
</dl>

<dl>
<dd>

**filterStatus:** `Optional<Status>` — Filter by offer status
    
</dd>
</dl>

<dl>
<dd>

**filterId:** `Optional<String>` — Filter by id
    
</dd>
</dl>

<dl>
<dd>

**filterIsTargeted:** `Optional<Boolean>` — Filter by isTargeted
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.offers.getOfferById(offerId) -> OfferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a specific offer by ID
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
client.offers().getOfferById(
    "offerId",
    GetOfferByIdRequest
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

**offerId:** `String` — Unique identifier of the offer
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` — Comma-separated list of related resources to include
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.offers.createOffer(request) -> OfferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new offer
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
client.offers().createOffer(
    CreateOfferRequestBody
        .builder()
        .data(
            CreateOfferRequestData
                .builder()
                .attributes(
                    CreateOfferRequestAttributes
                        .builder()
                        .name("name")
                        .merchantId("merchantId")
                        .offerType(LocationType.INSTORE)
                        .isLocationSpecific(true)
                        .status(Status.INACTIVE)
                        .merchantNetwork("merchantNetwork")
                        .optInRequired(true)
                        .commissionType(CommissionType.FLAT)
                        .commissionValue(1.1)
                        .startDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .expirationDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .redeemableOnce(true)
                        .source(Source.NATIONAL)
                        .attribution(
                            Attribution
                                .builder()
                                .isRequired(true)
                                .events(
                                    Arrays.asList(AttributionEventType.IMPRESSION, AttributionEventType.IMPRESSION)
                                )
                                .build()
                        )
                        .qualifiedIssuer(
                            Arrays.asList("qualifiedIssuer", "qualifiedIssuer")
                        )
                        .issuerCommissionsMap(
                            new HashMap<String, Double>() {{
                                put("issuerCommissionsMap", 1.1);
                            }}
                        )
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

**request:** `CreateOfferRequestBody` — Offer data for creation
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.offers.updateOffer(offerId, request) -> OfferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing offer (replaces all fields - omitted optional fields will be removed)
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
client.offers().updateOffer(
    "offerId",
    UpdateOfferRequestBody
        .builder()
        .data(
            UpdateOfferRequestData
                .builder()
                .attributes(
                    UpdateOfferRequestAttributes
                        .builder()
                        .name("name")
                        .merchantId("merchantId")
                        .offerType(LocationType.INSTORE)
                        .isLocationSpecific(true)
                        .status(Status.INACTIVE)
                        .merchantNetwork("merchantNetwork")
                        .optInRequired(true)
                        .commissionType(CommissionType.FLAT)
                        .commissionValue(1.1)
                        .startDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .expirationDate(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .redeemableOnce(true)
                        .source(Source.NATIONAL)
                        .attribution(
                            Attribution
                                .builder()
                                .isRequired(true)
                                .events(
                                    Arrays.asList(AttributionEventType.IMPRESSION, AttributionEventType.IMPRESSION)
                                )
                                .build()
                        )
                        .qualifiedIssuer(
                            Arrays.asList("qualifiedIssuer", "qualifiedIssuer")
                        )
                        .issuerCommissionsMap(
                            new HashMap<String, Double>() {{
                                put("issuerCommissionsMap", 1.1);
                            }}
                        )
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

**offerId:** `String` — Unique identifier of the offer to update
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateOfferRequestBody` — Offer data for update
    
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

## Queue Dispatcher
<details><summary><code>client.queueDispatcher.dispatchEvent(organizationId, issuerName, request) -> GenericNotificationResponseObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to dispatch an event to the notifications service queue.<br/>
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
client.queueDispatcher().dispatchEvent(
    "organizationId",
    "issuerName",
    GenericNotificationRequest
        .builder()
        .xKardIssuerId("X-Kard-IssuerID")
        .body(
            GenericNotificationRequestBody
                .builder()
                .data(
                    Arrays.asList(
                        NotificationResource
                            .builder()
                            .id("id")
                            .type("type")
                            .attributes(
                                new HashMap<String, Object>() {{
                                    put("attributes", new 
                                    HashMap<String, Object>() {{put("key", "value");
                                    }});
                                }}
                            )
                            .relationships(
                                new HashMap<String, NotificationRelationshipUnion>() {{
                                    put("relationships", NotificationRelationshipUnion.of(
                                        RelationshipSingle
                                            .builder()
                                            .data(
                                                RelationshipData
                                                    .builder()
                                                    .type("type")
                                                    .id("id")
                                                    .build()
                                            )
                                            .build()
                                    ));
                                }}
                            )
                            .build(),
                        NotificationResource
                            .builder()
                            .id("id")
                            .type("type")
                            .attributes(
                                new HashMap<String, Object>() {{
                                    put("attributes", new 
                                    HashMap<String, Object>() {{put("key", "value");
                                    }});
                                }}
                            )
                            .relationships(
                                new HashMap<String, NotificationRelationshipUnion>() {{
                                    put("relationships", NotificationRelationshipUnion.of(
                                        RelationshipSingle
                                            .builder()
                                            .data(
                                                RelationshipData
                                                    .builder()
                                                    .type("type")
                                                    .id("id")
                                                    .build()
                                            )
                                            .build()
                                    ));
                                }}
                            )
                            .build()
                    )
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

**organizationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**issuerName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `GenericNotificationRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## SegmentUsers
<details><summary><code>client.segmentUsers.getStatus(issuerId, referringPartnerUserId, request) -> GetStatusResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Check if a user is in a segment
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
client.segmentUsers().getStatus(
    "issuerId",
    "referringPartnerUserId",
    GetStatusRequestBody
        .builder()
        .segmentIds(
            Arrays.asList("segmentIds", "segmentIds")
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**referringPartnerUserId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `GetStatusRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.segmentUsers.getStatuses(issuerId, request) -> GetStatusesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Check if users are in segments
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
client.segmentUsers().getStatuses(
    "issuerId",
    GetStatusesRequest
        .builder()
        .referringPartnerUserIds(
            Arrays.asList("referringPartnerUserIds", "referringPartnerUserIds")
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

**issuerId:** `String` — The id of the issuer
    
</dd>
</dl>

<dl>
<dd>

**referringPartnerUserIds:** `List<String>` — A list of referring partner user IDs
    
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
- `matchedTransaction`: For pre-matched transactions that need validation on match by the Kard system.<br/>

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

<details><summary><code>client.transactions.getEarnedRewards(organizationId, userId) -> GetEarnedRewardsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve rewarded transaction history for a specific user. Returns only SETTLED transactions within the last 12 months.
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
</dd>
</dl>


</dd>
</dl>
</details>

## TxnMapService
<details><summary><code>client.txnMapService.deleteTxnMap(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Call this endpoint to delete one or many transaction maps entry.
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
client.txnMapService().deleteTxnMap(
    DeleteTxnMapRequest
        .builder()
        .data(
            Arrays.asList(
                DeleteTxnData
                    .builder()
                    .id("id")
                    .build(),
                DeleteTxnData
                    .builder()
                    .id("id")
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

**request:** `DeleteTxnMapRequest` 
    
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

<details><summary><code>client.users.update(organizationId, userId, request) -> UpdateUserObject</code></summary>
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

<details><summary><code>client.users.get(organizationId, userId) -> UpdateUserObject</code></summary>
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
can be found by calling the [Get Eligible Locations](/2024-10-01/api/rewards/locations) endpoint with the
`includeLocal` query parameter.<br/>
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

Retrieve national and local geographic locations that a specified user has eligible in-store offers at. To
include local locations, add the `includeLocal` query parameter to your api call. Use this endpoint to build
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
