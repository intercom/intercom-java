# Reference
## Admins
<details><summary><code>client.admins.identify() -> Optional&amp;lt;AdminWithApp&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can view the currently authorised admin along with the embedded app object (a "workspace" in legacy terminology).

> 🚧 Single Sign On
>
> If you are building a custom "Log in with Intercom" flow for your site, and you call the `/me` endpoint to identify the logged-in user, you should not accept any sign-ins from users with unverified email addresses as it poses a potential impersonation security risk.
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
client.admins().identify();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.admins.away(adminId, request) -> Optional&amp;lt;Admin&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can set an Admin as away for the Inbox.
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
client.admins().away(
    ConfigureAwayAdminRequest
        .builder()
        .adminId(1)
        .awayModeEnabled(true)
        .awayModeReassign(true)
        .awayStatusReasonId(12345)
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

**adminId:** `Integer` — The unique identifier of a given admin
    
</dd>
</dl>

<dl>
<dd>

**awayModeEnabled:** `Boolean` — Set to "true" to change the status of the admin to away.
    
</dd>
</dl>

<dl>
<dd>

**awayModeReassign:** `Boolean` — Set to "true" to assign any new conversation replies to your default inbox.
    
</dd>
</dl>

<dl>
<dd>

**awayStatusReasonId:** `Optional<Integer>` — The unique identifier of the away status reason
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.admins.listAllActivityLogs() -> ActivityLogList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a log of activities by all admins in an app.
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
client.admins().listAllActivityLogs(
    ListAllActivityLogsRequest
        .builder()
        .createdAtAfter("1677253093")
        .createdAtBefore("1677861493")
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

**createdAtAfter:** `String` — The start date that you request data for. It must be formatted as a UNIX timestamp.
    
</dd>
</dl>

<dl>
<dd>

**createdAtBefore:** `Optional<String>` — The end date that you request data for. It must be formatted as a UNIX timestamp.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.admins.list() -> AdminList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of admins for a given workspace.
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
client.admins().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.admins.find(adminId) -> Optional&amp;lt;Admin&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve the details of a single admin.
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
client.admins().find(
    FindAdminRequest
        .builder()
        .adminId(1)
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

**adminId:** `Integer` — The unique identifier of a given admin
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## AI Content
<details><summary><code>client.aiContent.listContentImportSources() -> ContentImportSourcesList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve a list of all content import sources for a workspace.
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
client.aiContent().listContentImportSources();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.createContentImportSource(request) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new content import source by sending a POST request to this endpoint.
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
client.aiContent().createContentImportSource(
    CreateContentImportSourceRequest
        .builder()
        .url("https://www.example.com")
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

**syncBehavior:** `String` — If you intend to create or update External Pages via the API, this should be set to `api`.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<CreateContentImportSourceRequestStatus>` — The status of the content import source.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the content import source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.getContentImportSource(sourceId) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.aiContent().getContentImportSource(
    GetContentImportSourceRequest
        .builder()
        .sourceId("source_id")
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

**sourceId:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.updateContentImportSource(sourceId, request) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing content import source.
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
client.aiContent().updateContentImportSource(
    UpdateContentImportSourceRequest
        .builder()
        .sourceId("source_id")
        .syncBehavior(UpdateContentImportSourceRequestSyncBehavior.API)
        .url("https://www.example.com")
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

**sourceId:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**syncBehavior:** `UpdateContentImportSourceRequestSyncBehavior` — If you intend to create or update External Pages via the API, this should be set to `api`. You can not change the value to or from api.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<UpdateContentImportSourceRequestStatus>` — The status of the content import source.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the content import source. This may only be different from the existing value if the sync behavior is API.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.deleteContentImportSource(sourceId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a content import source by making a DELETE request this endpoint. This will also delete all external pages that were imported from this source.
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
client.aiContent().deleteContentImportSource(
    DeleteContentImportSourceRequest
        .builder()
        .sourceId("source_id")
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

**sourceId:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.listExternalPages() -> ExternalPagesList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve a list of all external pages for a workspace.
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
client.aiContent().listExternalPages();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.createExternalPage(request) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new external page by sending a POST request to this endpoint. If an external page already exists with the specified source_id and external_id, it will be updated instead.
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
client.aiContent().createExternalPage(
    CreateExternalPageRequest
        .builder()
        .title("Test")
        .html("<html><body><h1>Test</h1></body></html>")
        .sourceId(44)
        .externalId("abc1234")
        .url("https://www.example.com")
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

**title:** `String` — The title of the external page.
    
</dd>
</dl>

<dl>
<dd>

**html:** `String` — The body of the external page in HTML.
    
</dd>
</dl>

<dl>
<dd>

**url:** `Optional<String>` — The URL of the external page. This will be used by Fin to link end users to the page it based its answer on. When a URL is not present, Fin will not reference the source.
    
</dd>
</dl>

<dl>
<dd>

**aiAgentAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by AI Agent. Will not default when updating an existing external page.
    
</dd>
</dl>

<dl>
<dd>

**aiCopilotAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by AI Copilot. Will not default when updating an existing external page.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `String` — Always en
    
</dd>
</dl>

<dl>
<dd>

**sourceId:** `Integer` — The unique identifier for the source of the external page which was given by Intercom. Every external page must be associated with a Content Import Source which represents the place it comes from and from which it inherits a default audience (configured in the UI). For a new source, make a POST request to the Content Import Source endpoint and an ID for the source will be returned in the response.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` — The identifier for the external page which was given by the source. Must be unique for the source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.getExternalPage(pageId) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve an external page.
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
client.aiContent().getExternalPage(
    GetExternalPageRequest
        .builder()
        .pageId("page_id")
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

**pageId:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.updateExternalPage(pageId, request) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing external page (if it was created via the API).
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
client.aiContent().updateExternalPage(
    UpdateExternalPageRequest
        .builder()
        .pageId("page_id")
        .title("Test")
        .html("<html><body><h1>Test</h1></body></html>")
        .url("https://www.example.com")
        .sourceId(47)
        .externalId("5678")
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

**pageId:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `String` — The title of the external page.
    
</dd>
</dl>

<dl>
<dd>

**html:** `String` — The body of the external page in HTML.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the external page. This will be used by Fin to link end users to the page it based its answer on.
    
</dd>
</dl>

<dl>
<dd>

**finAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by Fin.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `String` — Always en
    
</dd>
</dl>

<dl>
<dd>

**sourceId:** `Integer` — The unique identifier for the source of the external page which was given by Intercom. Every external page must be associated with a Content Import Source which represents the place it comes from and from which it inherits a default audience (configured in the UI). For a new source, make a POST request to the Content Import Source endpoint and an ID for the source will be returned in the response.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — The identifier for the external page which was given by the source. Must be unique for the source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.aiContent.deleteExternalPage(pageId) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sending a DELETE request for an external page will remove it from the content library UI and from being used for AI answers.
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
client.aiContent().deleteExternalPage(
    DeleteExternalPageRequest
        .builder()
        .pageId("page_id")
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

**pageId:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Articles
<details><summary><code>client.articles.list() -> SyncPagingIterable&amp;lt;ArticleListItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all articles by making a GET request to `https://api.intercom.io/articles`.

> 📘 How are the articles sorted and ordered?
>
> Articles will be returned in descending order on the `updated_at` attribute. This means if you need to iterate through results then we'll show the most recently updated articles first.
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
client.articles().list(
    ListArticlesRequest
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.articles.create(request) -> Article</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new article by making a POST request to `https://api.intercom.io/articles`.
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
client.articles().create(
    Optional.of(
        CreateArticleRequest
            .builder()
            .title("Thanks for everything")
            .authorId(991267497)
            .description("Description of the Article")
            .body("Body of the Article")
            .state(CreateArticleRequestState.PUBLISHED)
            .parentId(145)
            .parentType(CreateArticleRequestParentType.COLLECTION)
            .translatedContent(
                ArticleTranslatedContent
                    .builder()
                    .fr(
                        ArticleContent
                            .builder()
                            .title("Merci pour tout")
                            .description("Description de l'article")
                            .body("Corps de l'article")
                            .authorId(991267497)
                            .state(ArticleContentState.PUBLISHED)
                            .build()
                    )
                    .build()
            )
            .build()
    )
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

**request:** `Optional<CreateArticleRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.articles.find(articleId) -> Article</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single article by making a GET request to `https://api.intercom.io/articles/<id>`.
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
client.articles().find(
    FindArticleRequest
        .builder()
        .articleId(1)
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

**articleId:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.articles.update(articleId, request) -> Article</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update the details of a single article by making a PUT request to `https://api.intercom.io/articles/<id>`.
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
client.articles().update(
    UpdateArticleRequest
        .builder()
        .articleId(1)
        .title("Christmas is here!")
        .body("<p>New gifts in store for the jolly season</p>")
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

**articleId:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — The title of the article.For multilingual articles, this will be the title of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the article. For multilingual articles, this will be the description of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**body:** `Optional<String>` — The content of the article. For multilingual articles, this will be the body of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**authorId:** `Optional<Integer>` — The id of the author of the article. For multilingual articles, this will be the id of the author of the default language's content. Must be a teammate on the help center's workspace.
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<UpdateArticleRequestState>` — Whether the article will be `published` or will be a `draft`. Defaults to draft. For multilingual articles, this will be the state of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the article's parent collection or section. An article without this field stands alone.
    
</dd>
</dl>

<dl>
<dd>

**parentType:** `Optional<String>` — The type of parent, which can either be a `collection` or `section`.
    
</dd>
</dl>

<dl>
<dd>

**translatedContent:** `Optional<ArticleTranslatedContent>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.articles.delete(articleId) -> DeletedArticleObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single article by making a DELETE request to `https://api.intercom.io/articles/<id>`.
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
client.articles().delete(
    DeleteArticleRequest
        .builder()
        .articleId(1)
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

**articleId:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.articles.search() -> ArticleSearchResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for articles by making a GET request to `https://api.intercom.io/articles/search`.
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
client.articles().search(
    SearchArticlesRequest
        .builder()
        .phrase("Getting started")
        .state("published")
        .helpCenterId(1)
        .highlight(true)
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

**phrase:** `Optional<String>` — The phrase within your articles to search for.
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` — The state of the Articles returned. One of `published`, `draft` or `all`.
    
</dd>
</dl>

<dl>
<dd>

**helpCenterId:** `Optional<Integer>` — The ID of the Help Center to search in.
    
</dd>
</dl>

<dl>
<dd>

**highlight:** `Optional<Boolean>` — Return a highlighted version of the matching content within your articles. Refer to the response schema for more details.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Away Status Reasons
<details><summary><code>client.awayStatusReasons.listAwayStatusReasons() -> List&amp;lt;AwayStatusReason&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all away status reasons configured for the workspace, including deleted ones.
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
client.awayStatusReasons().listAwayStatusReasons();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Export
<details><summary><code>client.export.enqueueANewReportingDataExportJob(request) -> PostExportReportingDataEnqueueResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.export().enqueueANewReportingDataExportJob(
    PostExportReportingDataEnqueueRequest
        .builder()
        .datasetId("conversation")
        .startTime(1717490000L)
        .endTime(1717510000L)
        .attributeIds(
            Arrays.asList("conversation_id", "conversation_started_at")
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

**datasetId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**attributeIds:** `List<String>` 
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Long` 
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Long` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.export.listAvailableDatasetsAndAttributes() -> GetExportReportingDataGetDatasetsResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.export().listAvailableDatasetsAndAttributes();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Data Export
<details><summary><code>client.dataExport.exportReportingData(jobIdentifier) -> DataExportExportReportingDataResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.dataExport().exportReportingData(
    ExportReportingDataRequest
        .builder()
        .jobIdentifier("job_identifier")
        .appId("app_id")
        .clientId("client_id")
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

**jobIdentifier:** `String` — Unique identifier of the job.
    
</dd>
</dl>

<dl>
<dd>

**appId:** `String` — The Intercom defined code of the workspace the company is associated to.
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataExport.downloadReportingDataExport(jobIdentifier)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Download the data from a completed reporting data export job.

> Octet header required
>
> You will have to specify the header Accept: `application/octet-stream` when hitting this endpoint.
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
client.dataExport().downloadReportingDataExport(
    DownloadReportingDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
        .appId("app_id")
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

**jobIdentifier:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**appId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**accept:** `String` — Required header for downloading the export file
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataExport.create(request) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

To create your export job, you need to send a `POST` request to the export endpoint `https://api.intercom.io/export/content/data`.

The only parameters you need to provide are the range of dates that you want exported.

>🚧 Limit of one active job
>
> You can only have one active job per workspace. You will receive a HTTP status code of 429 with the message Exceeded rate limit of 1 pending message data export jobs if you attempt to create a second concurrent job.

>❗️ Updated_at not included
>
> It should be noted that the timeframe only includes messages sent during the time period and not messages that were only updated during this period. For example, if a message was updated yesterday but sent two days ago, you would need to set the created_at_after date before the message was sent to include that in your retrieval job.

>📘 Date ranges are inclusive
>
> Requesting data for 2018-06-01 until 2018-06-30 will get all data for those days including those specified - e.g. 2018-06-01 00:00:00 until 2018-06-30 23:59:99.
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
client.dataExport().create(
    CreateDataExportRequest
        .builder()
        .createdAtAfter(1734519776)
        .createdAtBefore(1734537776)
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

**createdAtAfter:** `Integer` — The start date that you request data for. It must be formatted as a unix timestamp.
    
</dd>
</dl>

<dl>
<dd>

**createdAtBefore:** `Integer` — The end date that you request data for. It must be formatted as a unix timestamp.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataExport.find(jobIdentifier) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can view the status of your job by sending a `GET` request to the URL
`https://api.intercom.io/export/content/data/{job_identifier}` - the `{job_identifier}` is the value returned in the response when you first created the export job. More on it can be seen in the Export Job Model.

> 🚧 Jobs expire after two days
> All jobs that have completed processing (and are thus available to download from the provided URL) will have an expiry limit of two days from when the export ob completed. After this, the data will no longer be available.
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
client.dataExport().find(
    FindDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataExport.cancel(jobIdentifier) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can cancel your job
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
client.dataExport().cancel(
    CancelDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataExport.download(jobIdentifier)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

When a job has a status of complete, and thus a filled download_url, you can download your data by hitting that provided URL, formatted like so: https://api.intercom.io/download/content/data/xyz1234.

Your exported message data will be streamed continuously back down to you in a gzipped CSV format.

> 📘 Octet header required
>
> You will have to specify the header Accept: `application/octet-stream` when hitting this endpoint.
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
client.dataExport().download(
    DownloadDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## HelpCenters
<details><summary><code>client.helpCenters.find(helpCenterId) -> HelpCenter</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single Help Center by making a GET request to `https://api.intercom.io/help_center/help_center/<id>`.
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
client.helpCenters().find(
    FindHelpCenterRequest
        .builder()
        .helpCenterId(1)
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

**helpCenterId:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.helpCenters.list() -> SyncPagingIterable&amp;lt;HelpCenter&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list all Help Centers by making a GET request to `https://api.intercom.io/help_center/help_centers`.
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
client.helpCenters().list(
    ListHelpCentersRequest
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Internal Articles
<details><summary><code>client.internalArticles.listInternalArticles() -> InternalArticleList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all internal articles by making a GET request to `https://api.intercom.io/internal_articles`.
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
client.internalArticles().listInternalArticles();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.internalArticles.createInternalArticle(request) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new internal article by making a POST request to `https://api.intercom.io/internal_articles`.
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
client.internalArticles().createInternalArticle(
    Optional.of(
        CreateInternalArticleRequest
            .builder()
            .title("Thanks for everything")
            .authorId(991266252)
            .ownerId(991266252)
            .body("Body of the Article")
            .build()
    )
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

**request:** `Optional<CreateInternalArticleRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.internalArticles.retrieveInternalArticle(internalArticleId) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single internal article by making a GET request to `https://api.intercom.io/internal_articles/<id>`.
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
client.internalArticles().retrieveInternalArticle(
    RetrieveInternalArticleRequest
        .builder()
        .internalArticleId(1)
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

**internalArticleId:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.internalArticles.updateInternalArticle(internalArticleId, request) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update the details of a single internal article by making a PUT request to `https://api.intercom.io/internal_articles/<id>`.
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
client.internalArticles().updateInternalArticle(
    UpdateInternalArticleRequestBody
        .builder()
        .internalArticleId(1)
        .title("Christmas is here!")
        .body("<p>New gifts in store for the jolly season</p>")
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

**internalArticleId:** `Integer` — The unique identifier for the internal article which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — The title of the article.
    
</dd>
</dl>

<dl>
<dd>

**body:** `Optional<String>` — The content of the article.
    
</dd>
</dl>

<dl>
<dd>

**authorId:** `Optional<Integer>` — The id of the author of the article.
    
</dd>
</dl>

<dl>
<dd>

**ownerId:** `Optional<Integer>` — The id of the author of the article.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.internalArticles.deleteInternalArticle(internalArticleId) -> DeletedInternalArticleObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single internal article by making a DELETE request to `https://api.intercom.io/internal_articles/<id>`.
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
client.internalArticles().deleteInternalArticle(
    DeleteInternalArticleRequest
        .builder()
        .internalArticleId(1)
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

**internalArticleId:** `Integer` — The unique identifier for the internal article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.internalArticles.searchInternalArticles() -> InternalArticleSearchResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for internal articles by making a GET request to `https://api.intercom.io/internal_articles/search`.
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
client.internalArticles().searchInternalArticles(
    SearchInternalArticlesRequest
        .builder()
        .folderId("folder_id")
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

**folderId:** `Optional<String>` — The ID of the folder to search in.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## IP Allowlist
<details><summary><code>client.ipAllowlist.getIpAllowlist() -> IpAllowlist</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the current IP allowlist configuration for the workspace.
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
client.ipAllowlist().getIpAllowlist();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ipAllowlist.updateIpAllowlist(request) -> IpAllowlist</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the IP allowlist configuration for the workspace.

{% admonition type="warning" name="Lockout Protection" %}
  The API will reject updates that would lock out the caller's IP address. Ensure your current IP is included in the allowlist when enabling the feature.
{% /admonition %}
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
client.ipAllowlist().updateIpAllowlist(
    IpAllowlist
        .builder()
        .enabled(true)
        .ipAllowlist(
            Optional.of(
                Arrays.asList("192.168.1.0/24", "10.0.0.1")
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

**request:** `IpAllowlist` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Companies
<details><summary><code>client.companies.retrieve() -> CompaniesRetrieveResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a single company by passing in `company_id` or `name`.

  `https://api.intercom.io/companies?name={name}`

  `https://api.intercom.io/companies?company_id={company_id}`

You can fetch all companies and filter by `segment_id` or `tag_id` as a query parameter.

  `https://api.intercom.io/companies?tag_id={tag_id}`

  `https://api.intercom.io/companies?segment_id={segment_id}`
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
client.companies().retrieve(
    RetrieveCompanyRequest
        .builder()
        .name("my company")
        .companyId("12345")
        .tagId("678910")
        .segmentId("98765")
        .page(1)
        .perPage(1)
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

**name:** `Optional<String>` — The `name` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The `company_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `Optional<String>` — The `tag_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**segmentId:** `Optional<String>` — The `segment_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.createOrUpdate(request) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create or update a company.

Companies will be only visible in Intercom when there is at least one associated user.

Companies are looked up via `company_id` in a `POST` request, if not found via `company_id`, the new company will be created, if found, that company will be updated.

{% admonition type="warning" name="Using `company_id`" %}
  You can set a unique `company_id` value when creating a company. However, it is not possible to update `company_id`. Be sure to set a unique value once upon creation of the company.
{% /admonition %}
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
client.companies().createOrUpdate(
    Optional.of(
        CreateOrUpdateCompanyRequest
            .builder()
            .name("my company")
            .companyId("company_remote_id")
            .remoteCreatedAt(1374138000)
            .build()
    )
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

**request:** `Optional<CreateOrUpdateCompanyRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.find(companyId) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a single company.
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
client.companies().find(
    FindCompanyRequest
        .builder()
        .companyId("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.update(companyId, request) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update a single company using the Intercom provisioned `id`.

{% admonition type="warning" name="Using `company_id`" %}
  When updating a company it is not possible to update `company_id`. This can only be set once upon creation of the company.
{% /admonition %}
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
client.companies().update(
    UpdateCompanyRequest
        .builder()
        .companyId("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
        .body(
            UpdateCompanyRequestBody
                .builder()
                .name("my company")
                .website("http://www.mycompany.com/")
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

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**request:** `Optional<UpdateCompanyRequestBody>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.delete(companyId) -> DeletedCompanyObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single company.
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
client.companies().delete(
    DeleteCompanyRequest
        .builder()
        .companyId("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.listAttachedContacts(companyId) -> CompanyAttachedContacts</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all contacts that belong to a company.
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
client.companies().listAttachedContacts(
    ListAttachedContactsRequest
        .builder()
        .companyId("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.listAttachedSegments(companyId) -> CompanyAttachedSegments</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all segments that belong to a company.
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
client.companies().listAttachedSegments(
    ListSegmentsAttachedToCompanyRequest
        .builder()
        .companyId("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.list() -> SyncPagingIterable&amp;lt;Company&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list companies. The company list is sorted by the `last_request_at` field and by default is ordered descending, most recently requested first.

Note that the API does not include companies who have no associated users in list responses.

When using the Companies endpoint and the pages object to iterate through the returned companies, there is a limit of 10,000 Companies that can be returned. If you need to list or iterate on more than 10,000 Companies, please use the [Scroll API](https://developers.intercom.com/reference#iterating-over-all-companies).
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.companies().list(
    ListCompaniesRequest
        .builder()
        .page(1)
        .perPage(1)
        .order("desc")
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to return per page. Defaults to 15
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<String>` — `asc` or `desc`. Return the companies in ascending or descending order. Defaults to desc
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.scroll() -> SyncPagingIterable&amp;lt;Company&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

      The `list all companies` functionality does not work well for huge datasets, and can result in errors and performance problems when paging deeply. The Scroll API provides an efficient mechanism for iterating over all companies in a dataset.

- Each app can only have 1 scroll open at a time. You'll get an error message if you try to have more than one open per app.
- If the scroll isn't used for 1 minute, it expires and calls with that scroll param will fail
- If the end of the scroll is reached, "companies" will be empty and the scroll parameter will expire

{% admonition type="info" name="Scroll Parameter" %}
  You can get the first page of companies by simply sending a GET request to the scroll endpoint.
  For subsequent requests you will need to use the scroll parameter from the response.
{% /admonition %}
{% admonition type="danger" name="Scroll network timeouts" %}
  Since scroll is often used on large datasets network errors such as timeouts can be encountered. When this occurs you will see a HTTP 500 error with the following message:
  "Request failed due to an internal network error. Please restart the scroll operation."
  If this happens, you will need to restart your scroll query: It is not possible to continue from a specific point when using scroll.
{% /admonition %}
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
client.companies().scroll(
    ScrollCompaniesRequest
        .builder()
        .scrollParam("scroll_param")
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

**scrollParam:** `Optional<String>` — 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.attachContact(contactId, request) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can attach a company to a single contact.
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
client.companies().attachContact(
    AttachContactToCompanyRequest
        .builder()
        .contactId("contact_id")
        .companyId("6762f09a1bb69f9f2193bb34")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.companies.detachContact(contactId, companyId) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can detach a company from a single contact.
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
client.companies().detachContact(
    DetachContactFromCompanyRequest
        .builder()
        .contactId("58a430d35458202d41b1e65b")
        .companyId("58a430d35458202d41b1e65b")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Contacts
<details><summary><code>client.contacts.listAttachedCompanies(contactId) -> SyncPagingIterable&amp;lt;Company&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of companies that are associated to a contact.
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
client.contacts().listAttachedCompanies(
    ListAttachedCompaniesRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .page(1)
        .perPage(1)
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.listAttachedSegments(contactId) -> ContactSegments</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of segments that are associated to a contact.
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
client.contacts().listAttachedSegments(
    ListSegmentsAttachedToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.listAttachedSubscriptions(contactId) -> SubscriptionTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of subscription types that are attached to a contact. These can be subscriptions that a user has 'opted-in' to or has 'opted-out' from, depending on the subscription type.
This will return a list of Subscription Type objects that the contact is associated with.

The data property will show a combined list of:

  1.Opt-out subscription types that the user has opted-out from.
  2.Opt-in subscription types that the user has opted-in to receiving.
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
client.contacts().listAttachedSubscriptions(
    ListAttachedSubscriptionsRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.attachSubscription(contactId, request) -> SubscriptionType</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add a specific subscription to a contact. In Intercom, we have two different subscription types based on user consent - opt-out and opt-in:

  1.Attaching a contact to an opt-out subscription type will opt that user out from receiving messages related to that subscription type.

  2.Attaching a contact to an opt-in subscription type will opt that user in to receiving messages related to that subscription type.

This will return a subscription type model for the subscription type that was added to the contact.
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
client.contacts().attachSubscription(
    AttachSubscriptionToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .subscriptionId("37846")
        .consentType("opt_in")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**subscriptionId:** `String` — The unique identifier for the subscription which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**consentType:** `String` — The consent_type of a subscription, opt_out or opt_in.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.detachSubscription(contactId, subscriptionId) -> SubscriptionType</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove a specific subscription from a contact. This will return a subscription type model for the subscription type that was removed from the contact.
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
client.contacts().detachSubscription(
    DetachSubscriptionFromContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .subscriptionId("37846")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**subscriptionId:** `String` — The unique identifier for the subscription type which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.listAttachedTags(contactId) -> TagList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all tags that are attached to a specific contact.
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
client.contacts().listAttachedTags(
    ListTagsAttachedToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.find(contactId) -> ContactsFindResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single contact.
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
client.contacts().find(
    FindContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — contact_id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.update(contactId, request) -> ContactsUpdateResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing contact (ie. user or lead).

{% admonition type="info" %}
  This endpoint handles both **contact updates** and **custom object associations**.

  See _`update a contact with an association to a custom object instance`_ in the request/response examples to see the custom object association format.
{% /admonition %}
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
client.contacts().update(
    UpdateContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .email("joebloggs@intercom.io")
        .name("joe bloggs")
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

**contactId:** `String` — id
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — The role of the contact.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — A unique identifier for the contact which is given to Intercom
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — The contacts email
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — The contacts phone
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The contacts name
    
</dd>
</dl>

<dl>
<dd>

**avatar:** `Optional<String>` — An image URL containing the avatar of a contact
    
</dd>
</dl>

<dl>
<dd>

**signedUpAt:** `Optional<Integer>` — The time specified for when a contact signed up
    
</dd>
</dl>

<dl>
<dd>

**lastSeenAt:** `Optional<Integer>` — The time when the contact was last seen (either where the Intercom Messenger was installed or when specified manually)
    
</dd>
</dl>

<dl>
<dd>

**ownerId:** `Optional<Integer>` — The id of an admin that has been assigned account ownership of the contact
    
</dd>
</dl>

<dl>
<dd>

**unsubscribedFromEmails:** `Optional<Boolean>` — Whether the contact is unsubscribed from emails
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, Object>>` — The custom attributes which are set for the contact
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.delete(contactId) -> ContactDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single contact.
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
client.contacts().delete(
    DeleteContactRequest
        .builder()
        .contactId("contact_id")
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

**contactId:** `String` — contact_id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.mergeLeadInUser(request) -> ContactsMergeLeadInUserResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can merge a contact with a `role` of `lead` into a contact with a `role` of `user`.
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
client.contacts().mergeLeadInUser(
    MergeContactsRequest
        .builder()
        .leadId("6762f0d51bb69f9f2193bb7f")
        .contactId("6762f0d51bb69f9f2193bb80")
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

**leadId:** `Optional<String>` — The unique identifier for the contact to merge away from. Must be a lead.
    
</dd>
</dl>

<dl>
<dd>

**contactId:** `Optional<String>` — The unique identifier for the contact to merge into. Must be a user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.search(request) -> SyncPagingIterable&amp;lt;Contact&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple contacts by the value of their attributes in order to fetch exactly who you want.

To search for contacts, you need to send a `POST` request to `https://api.intercom.io/contacts/search`.

This will accept a query object in the body which will define your filters in order to search for contacts.

{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `50` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}
### Contact Creation Delay

If a contact has recently been created, there is a possibility that it will not yet be available when searching. This means that it may not appear in the response. This delay can take a few minutes. If you need to be instantly notified it is recommended to use webhooks and iterate to see if they match your search filters.

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiple's there can be:
* There's a limit of max 2 nested filters
* There's a limit of max 15 filters for each AND or OR group

### Searching for Timestamp Fields

All timestamp fields (created_at, updated_at etc.) are indexed as Dates for Contact Search queries; Datetime queries are not currently supported. This means you can only query for timestamp fields by day - not hour, minute or second.
For example, if you search for all Contacts with a created_at value greater (>) than 1577869200 (the UNIX timestamp for January 1st, 2020 9:00 AM), that will be interpreted as 1577836800 (January 1st, 2020 12:00 AM). The search results will then include Contacts created from January 2nd, 2020 12:00 AM onwards.
If you'd like to get contacts created on January 1st, 2020 you should search with a created_at value equal (=) to 1577836800 (January 1st, 2020 12:00 AM).
This behaviour applies only to timestamps used in search queries. The search results will still contain the full UNIX timestamp and be sorted accordingly.

### Accepted Fields

Most key listed as part of the Contacts Model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foorbar"`).

| Field                              | Type                           |
| ---------------------------------- | ------------------------------ |
| id                                 | String                         |
| role                               | String<br>Accepts user or lead |
| name                               | String                         |
| avatar                             | String                         |
| owner_id                           | Integer                        |
| email                              | String                         |
| email_domain                       | String                         |
| phone                              | String                         |
| external_id                        | String                         |
| created_at                         | Date (UNIX Timestamp)          |
| signed_up_at                       | Date (UNIX Timestamp)          |
| updated_at                         | Date (UNIX Timestamp)          |
| last_seen_at                       | Date (UNIX Timestamp)          |
| last_contacted_at                  | Date (UNIX Timestamp)          |
| last_replied_at                    | Date (UNIX Timestamp)          |
| last_email_opened_at               | Date (UNIX Timestamp)          |
| last_email_clicked_at              | Date (UNIX Timestamp)          |
| language_override                  | String                         |
| browser                            | String                         |
| browser_language                   | String                         |
| os                                 | String                         |
| location.country                   | String                         |
| location.region                    | String                         |
| location.city                      | String                         |
| unsubscribed_from_emails           | Boolean                        |
| marked_email_as_spam               | Boolean                        |
| has_hard_bounced                   | Boolean                        |
| ios_last_seen_at                   | Date (UNIX Timestamp)          |
| ios_app_version                    | String                         |
| ios_device                         | String                         |
| ios_app_device                     | String                         |
| ios_os_version                     | String                         |
| ios_app_name                       | String                         |
| ios_sdk_version                    | String                         |
| android_last_seen_at               | Date (UNIX Timestamp)          |
| android_app_version                | String                         |
| android_device                     | String                         |
| android_app_name                   | String                         |
| andoid_sdk_version                 | String                         |
| segment_id                         | String                         |
| tag_id                             | String                         |
| custom_attributes.{attribute_name} | String                         |

### Accepted Operators

{% admonition type="warning" name="Searching based on `created_at`" %}
  You cannot use the `<=` or `>=` operators to search by `created_at`.
{% /admonition %}

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                      | Description                                                      |
| :------- | :------------------------------- | :--------------------------------------------------------------- |
| =        | All                              | Equals                                                           |
| !=       | All                              | Doesn't Equal                                                    |
| IN       | All                              | In<br>Shortcut for `OR` queries<br>Values must be in Array       |
| NIN      | All                              | Not In<br>Shortcut for `OR !` queries<br>Values must be in Array |
| >        | Integer<br>Date (UNIX Timestamp) | Greater than                                                     |
| <       | Integer<br>Date (UNIX Timestamp) | Lower than                                                       |
| ~        | String                           | Contains                                                         |
| !~       | String                           | Doesn't Contain                                                  |
| ^        | String                           | Starts With                                                      |
| $        | String                           | Ends With                                                        |
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
client.unstable().contacts().searchContacts(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.list() -> SyncPagingIterable&amp;lt;Contact&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all contacts (ie. users or leads) in your workspace.
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `50` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.contacts().list(
    ListContactsRequest
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — String used to get the next page of conversations.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.create(request) -> ContactsCreateResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new contact (ie. user or lead).
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
client.contacts().create(
    CreateContactRequest.of(
        CreateContactRequestWithEmail
            .builder()
            .email("joebloggs@intercom.io")
            .build()
    )
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

**request:** `CreateContactRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.showContactByExternalId(externalId) -> ShowContactByExternalIdResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single contact by external ID. Note that this endpoint only supports users and not leads.
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
client.contacts().showContactByExternalId(
    ShowContactByExternalIdRequest
        .builder()
        .externalId("cdd29344-5e0c-4ef0-ac56-f9ba2979bc27")
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

**externalId:** `String` — The external ID of the user that you want to retrieve
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.archive(contactId) -> ContactArchived</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can archive a single contact.
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
client.contacts().archive(
    ArchiveContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — contact_id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.unarchive(contactId) -> ContactUnarchived</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can unarchive a single contact.
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
client.contacts().unarchive(
    UnarchiveContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — contact_id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.contacts.blockContact(contactId) -> ContactBlocked</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Block a single contact.<br>**Note:** conversations of the contact will also be archived during the process.<br>More details in [FAQ How do I block Inbox spam?](https://www.intercom.com/help/en/articles/8838656-inbox-faqs)
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
client.contacts().blockContact(
    BlockContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — contact_id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Notes
<details><summary><code>client.notes.list(contactId) -> SyncPagingIterable&amp;lt;Note&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of notes that are associated to a contact.
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
client.notes().list(
    ListContactNotesRequest
        .builder()
        .contactId("contact_id")
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

**contactId:** `String` — The unique identifier of a contact.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notes.create(contactId, request) -> Note</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add a note to a single contact.
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
client.notes().create(
    CreateContactNoteRequest
        .builder()
        .contactId("123")
        .body("Hello")
        .adminId("123")
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

**contactId:** `String` — The unique identifier of a given contact.
    
</dd>
</dl>

<dl>
<dd>

**body:** `String` — The text of the note.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<String>` — The unique identifier of a given admin.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.notes.find(noteId) -> Note</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single note.
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
client.notes().find(
    FindNoteRequest
        .builder()
        .noteId(1)
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

**noteId:** `Integer` — The unique identifier of a given note
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tags
<details><summary><code>client.tags.tagContact(contactId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific contact. This will return a tag object for the tag that was added to the contact.
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
client.tags().tagContact(
    TagContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .tagId("7522907")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.untagContact(contactId, tagId) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific contact. This will return a tag object for the tag that was removed from the contact.
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
client.tags().untagContact(
    UntagContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .tagId("7522907")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.tagConversation(conversationId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific conversation. This will return a tag object for the tag that was added to the conversation.
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
client.tags().tagConversation(
    TagConversationRequest
        .builder()
        .conversationId("64619700005694")
        .tagId("7522907")
        .adminId("780")
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

**conversationId:** `String` — conversation_id
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.untagConversation(conversationId, tagId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific conversation. This will return a tag object for the tag that was removed from the conversation.
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
client.tags().untagConversation(
    UntagConversationRequest
        .builder()
        .conversationId("64619700005694")
        .tagId("7522907")
        .adminId("123")
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

**conversationId:** `String` — conversation_id
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — tag_id
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.list() -> TagList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all tags for a given workspace.

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
client.tags().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.create(request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can use this endpoint to perform the following operations:

  **1. Create a new tag:** You can create a new tag by passing in the tag name as specified in "Create or Update Tag Request Payload" described below.

  **2. Update an existing tag:** You can update an existing tag by passing the id of the tag as specified in "Create or Update Tag Request Payload" described below.

  **3. Tag Companies:** You can tag single company or a list of companies. You can tag a company by passing in the tag name and the company details as specified in "Tag Company Request Payload" described below. Also, if the tag doesn't exist then a new one will be created automatically.

  **4. Untag Companies:** You can untag a single company or a list of companies. You can untag a company by passing in the tag id and the company details as specified in "Untag Company Request Payload" described below.

  **5. Tag Multiple Users:** You can tag a list of users. You can tag the users by passing in the tag name and the user details as specified in "Tag Users Request Payload" described below.

Each operation will return a tag object.
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
client.tags().create(
    TagsCreateRequestBody.of(
        CreateOrUpdateTagRequest
            .builder()
            .name("test")
            .build()
    )
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

**request:** `TagsCreateRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.find(tagId) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of tags that are on the workspace by their id.
This will return a tag object.
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
client.tags().find(
    FindTagRequest
        .builder()
        .tagId("123")
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

**tagId:** `String` — The unique identifier of a given tag
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.delete(tagId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete the details of tags that are on the workspace by passing in the id.
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
client.tags().delete(
    DeleteTagRequest
        .builder()
        .tagId("123")
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

**tagId:** `String` — The unique identifier of a given tag
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.tagTicket(ticketId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific ticket. This will return a tag object for the tag that was added to the ticket.
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
client.tags().tagTicket(
    TagTicketRequest
        .builder()
        .ticketId("64619700005694")
        .tagId("7522907")
        .adminId("780")
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

**ticketId:** `String` — ticket_id
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tags.untagTicket(ticketId, tagId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific ticket. This will return a tag object for the tag that was removed from the ticket.
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
client.tags().untagTicket(
    UntagTicketRequest
        .builder()
        .ticketId("64619700005694")
        .tagId("7522907")
        .adminId("123")
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

**ticketId:** `String` — ticket_id
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Conversations
<details><summary><code>client.conversations.list() -> SyncPagingIterable&amp;lt;Conversation&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all conversations.

You can optionally request the result page size and the cursor to start after to fetch the result.
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.conversations().list(
    ListConversationsRequest
        .builder()
        .perPage(1)
        .startingAfter("starting_after")
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

**perPage:** `Optional<Integer>` — How many results per page
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — String used to get the next page of conversations.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.create(request) -> Message</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a conversation that has been initiated by a contact (ie. user or lead).
The conversation can be an in-app message only.

{% admonition type="info" name="Sending for visitors" %}
You can also send a message from a visitor by specifying their `user_id` or `id` value in the `from` field, along with a `type` field value of `contact`.
This visitor will be automatically converted to a contact with a lead role once the conversation is created.
{% /admonition %}

This will return the Message model that has been created.

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
client.conversations().create(
    CreateConversationRequest
        .builder()
        .from(
            CreateConversationRequestFrom
                .builder()
                .type(CreateConversationRequestFromType.USER)
                .id("6762f11b1bb69f9f2193bba3")
                .build()
        )
        .body("Hello there")
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

**from:** `CreateConversationRequestFrom` 
    
</dd>
</dl>

<dl>
<dd>

**body:** `String` — The content of the message. HTML is not supported.
    
</dd>
</dl>

<dl>
<dd>

**createdAt:** `Optional<Integer>` — The time the conversation was created as a UTC Unix timestamp. If not provided, the current time will be used. This field is only recommneded for migrating past conversations from another source into Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.find(conversationId) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can fetch the details of a single conversation.

This will return a single Conversation model with all its conversation parts.

{% admonition type="warning" name="Hard limit of 500 parts" %}
The maximum number of conversation parts that can be returned via the API is 500. If you have more than that we will return the 500 most recent conversation parts.
{% /admonition %}

For AI agent conversation metadata, please note that you need to have the agent enabled in your workspace, which is a [paid feature](https://www.intercom.com/help/en/articles/8205718-fin-resolutions#h_97f8c2e671).
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
client.conversations().find(
    FindConversationRequest
        .builder()
        .conversationId("123")
        .displayAs("plaintext")
        .includeTranslations(true)
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

**conversationId:** `String` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**displayAs:** `Optional<String>` — Set to plaintext to retrieve conversation messages in plain text.
    
</dd>
</dl>

<dl>
<dd>

**includeTranslations:** `Optional<Boolean>` — If set to true, conversation parts will be translated to the detected language of the conversation.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.update(conversationId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can update an existing conversation.

{% admonition type="info" name="Replying and other actions" %}
If you want to reply to a coveration or take an action such as assign, unassign, open, close or snooze, take a look at the reply and manage endpoints.
{% /admonition %}

{% admonition type="info" %}
  This endpoint handles both **conversation updates** and **custom object associations**.

  See _`update a conversation with an association to a custom object instance`_ in the request/response examples to see the custom object association format.
{% /admonition %}

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
client.conversations().update(
    UpdateConversationRequest
        .builder()
        .conversationId("conversation_id")
        .displayAs("plaintext")
        .read(true)
        .title("new conversation title")
        .customAttributes(
            new HashMap<String, CustomAttributesValue>() {{
                put("issue_type", CustomAttributesValue.of("Billing"));
                put("priority", CustomAttributesValue.of("High"));
            }}
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

**conversationId:** `String` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**displayAs:** `Optional<String>` — Set to plaintext to retrieve conversation messages in plain text.
    
</dd>
</dl>

<dl>
<dd>

**read:** `Optional<Boolean>` — Mark a conversation as read within Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — The title given to the conversation
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, CustomAttributesValue>>` 
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The ID of the company that the conversation is associated with. The unique identifier for the company which is given by Intercom. Set to nil to remove company.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.deleteConversation(conversationId) -> ConversationDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single conversation.
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
client.conversations().deleteConversation(
    DeleteConversationRequest
        .builder()
        .conversationId(1)
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

**conversationId:** `Integer` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.search(request) -> SyncPagingIterable&amp;lt;Conversation&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple conversations by the value of their attributes in order to fetch exactly which ones you want.

To search for conversations, you need to send a `POST` request to `https://api.intercom.io/conversations/search`.

This will accept a query object in the body which will define your filters in order to search for conversations.
{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `20` results per page and maximum is `150`.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiple's there can be:
- There's a limit of max 2 nested filters
- There's a limit of max 15 filters for each AND or OR group

### Accepted Fields

Most keys listed in the conversation model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foorbar"`).
The `source.body` field is unique as the search will not be performed against the entire value, but instead against every element of the value separately. For example, when searching for a conversation with a `"I need support"` body - the query should contain a `=` operator with the value `"support"` for such conversation to be returned. A query with a `=` operator and a `"need support"` value will not yield a result.

| Field                                     | Type                                                                                                                                                   |
| :---------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                                        | String                                                                                                                                                 |
| created_at                                | Date (UNIX timestamp)                                                                                                                                  |
| updated_at                                | Date (UNIX timestamp)                                                                                                                                  |
| source.type                               | String<br>Accepted fields are `conversation`, `email`, `facebook`, `instagram`, `phone_call`, `phone_switch`, `push`, `sms`, `twitter` and `whatsapp`. |
| source.id                                 | String                                                                                                                                                 |
| source.delivered_as                       | String                                                                                                                                                 |
| source.subject                            | String                                                                                                                                                 |
| source.body                               | String                                                                                                                                                 |
| source.author.id                          | String                                                                                                                                                 |
| source.author.type                        | String                                                                                                                                                 |
| source.author.name                        | String                                                                                                                                                 |
| source.author.email                       | String                                                                                                                                                 |
| source.url                                | String                                                                                                                                                 |
| contact_ids                               | String                                                                                                                                                 |
| teammate_ids                              | String                                                                                                                                                 |
| admin_assignee_id                         | String                                                                                                                                                 |
| team_assignee_id                          | String                                                                                                                                                 |
| channel_initiated                         | String                                                                                                                                                 |
| open                                      | Boolean                                                                                                                                                |
| read                                      | Boolean                                                                                                                                                |
| state                                     | String                                                                                                                                                 |
| waiting_since                             | Date (UNIX timestamp)                                                                                                                                  |
| snoozed_until                             | Date (UNIX timestamp)                                                                                                                                  |
| tag_ids                                   | String                                                                                                                                                 |
| priority                                  | String                                                                                                                                                 |
| statistics.time_to_assignment             | Integer                                                                                                                                                |
| statistics.time_to_admin_reply            | Integer                                                                                                                                                |
| statistics.time_to_first_close            | Integer                                                                                                                                                |
| statistics.time_to_last_close             | Integer                                                                                                                                                |
| statistics.median_time_to_reply           | Integer                                                                                                                                                |
| statistics.first_contact_reply_at         | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_assignment_at            | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_admin_reply_at           | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_close_at                 | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_assignment_at             | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_assignment_admin_reply_at | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_contact_reply_at          | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_admin_reply_at            | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_close_at                  | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_closed_by_id              | String                                                                                                                                                 |
| statistics.count_reopens                  | Integer                                                                                                                                                |
| statistics.count_assignments              | Integer                                                                                                                                                |
| statistics.count_conversation_parts       | Integer                                                                                                                                                |
| conversation_rating.requested_at          | Date (UNIX timestamp)                                                                                                                                  |
| conversation_rating.replied_at            | Date (UNIX timestamp)                                                                                                                                  |
| conversation_rating.score                 | Integer                                                                                                                                                |
| conversation_rating.remark                | String                                                                                                                                                 |
| conversation_rating.contact_id            | String                                                                                                                                                 |
| conversation_rating.admin_d               | String                                                                                                                                                 |
| ai_agent_participated                     | Boolean                                                                                                                                                |
| ai_agent.resolution_state                 | String                                                                                                                                                 |
| ai_agent.last_answer_type                 | String                                                                                                                                                 |
| ai_agent.rating                           | Integer                                                                                                                                                |
| ai_agent.rating_remark                    | String                                                                                                                                                 |
| ai_agent.source_type                      | String                                                                                                                                                 |
| ai_agent.source_title                     | String                                                                                                                                                 |

### Accepted Operators

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type  (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                    | Description                                                  |
| :------- | :----------------------------- | :----------------------------------------------------------- |
| =        | All                            | Equals                                                       |
| !=       | All                            | Doesn't Equal                                                |
| IN       | All                            | In  Shortcut for `OR` queries  Values most be in Array       |
| NIN      | All                            | Not In  Shortcut for `OR !` queries  Values must be in Array |
| >        | Integer  Date (UNIX Timestamp) | Greater (or equal) than                                      |
| <       | Integer  Date (UNIX Timestamp) | Lower (or equal) than                                        |
| ~        | String                         | Contains                                                     |
| !~       | String                         | Doesn't Contain                                              |
| ^        | String                         | Starts With                                                  |
| $        | String                         | Ends With                                                    |
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
client.unstable().conversations().searchConversations(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.reply(conversationId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can reply to a conversation with a message from an admin or on behalf of a contact, or with a note for admins.
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
client.conversations().reply(
            ReplyToConversationRequest
                .builder()
                .conversationId("123 or \"last\"")
                .body(
                    ReplyConversationRequest.of(
                        ContactReplyConversationRequest.of(
                            ContactReplyIntercomUserIdRequest
                                .builder()
                                .messageType("comment")
                                .type("user")
                                .body("Thanks again :)")
                                .intercomUserId("6762f1571bb69f9f2193bbbb")
                                .build()
                        )
                    )
                )
                .build()
        );
    }
}
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

**conversationId:** `String` — The Intercom provisioned identifier for the conversation or the string "last" to reply to the last part of the conversation
    
</dd>
</dl>

<dl>
<dd>

**request:** `ReplyConversationRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.manage(conversationId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

For managing conversations you can:
- Close a conversation
- Snooze a conversation to reopen on a future date
- Open a conversation which is `snoozed` or `closed`
- Assign a conversation to an admin and/or team.
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
client.conversations().manage(
    ManageConversationPartsRequest
        .builder()
        .conversationId("123")
        .body(
            ConversationsManageRequestBody.close(
                CloseConversationRequest
                    .builder()
                    .type("admin")
                    .adminId("12345")
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

**conversationId:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**request:** `ConversationsManageRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.attachContactAsAdmin(conversationId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add participants who are contacts to a conversation, on behalf of either another contact or an admin.

{% admonition type="warning" name="Contacts without an email" %}
If you add a contact via the email parameter and there is no user/lead found on that workspace with he given email, then we will create a new contact with `role` set to `lead`.
{% /admonition %}

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
client.conversations().attachContactAsAdmin(
    AttachContactToConversationRequest
        .builder()
        .conversationId("123")
        .adminId("12345")
        .customer(
            AttachContactToConversationRequestCustomer.of(
                AttachContactToConversationRequestCustomerIntercomUserId
                    .builder()
                    .intercomUserId("6762f19b1bb69f9f2193bbd4")
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

**conversationId:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<String>` — The `id` of the admin who is adding the new participant.
    
</dd>
</dl>

<dl>
<dd>

**customer:** `Optional<AttachContactToConversationRequestCustomer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.detachContactAsAdmin(conversationId, contactId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add participants who are contacts to a conversation, on behalf of either another contact or an admin.

{% admonition type="warning" name="Contacts without an email" %}
If you add a contact via the email parameter and there is no user/lead found on that workspace with he given email, then we will create a new contact with `role` set to `lead`.
{% /admonition %}

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
client.conversations().detachContactAsAdmin(
    DetachContactFromConversationRequest
        .builder()
        .conversationId("123")
        .contactId("123")
        .adminId("5017690")
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

**conversationId:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**contactId:** `String` — The identifier for the contact as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The `id` of the admin who is performing the action.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.redactConversationPart(request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can redact a conversation part or the source message of a conversation (as seen in the source object).

{% admonition type="info" name="Redacting parts and messages" %}
If you are redacting a conversation part, it must have a `body`. If you are redacting a source message, it must have been created by a contact. We will return a `conversation_part_not_redactable` error if these criteria are not met.
{% /admonition %}

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
client.conversations().redactConversationPart(
    RedactConversationRequest.conversationPart(
        RedactConversationRequestConversationPart
            .builder()
            .conversationId("19894788788")
            .conversationPartId("19381789428")
            .build()
    )
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

**request:** `RedactConversationRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.convertToTicket(conversationId, request) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can convert a conversation to a ticket.
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
client.conversations().convertToTicket(
    ConvertConversationToTicketRequest
        .builder()
        .conversationId(1)
        .ticketTypeId("53")
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

**conversationId:** `Integer` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**ticketTypeId:** `String` — The ID of the type of ticket you want to convert the conversation to
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conversations.runAssignmentRules(conversationId) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

{% admonition type="danger" name="Deprecation of Run Assignment Rules" %}
Run assignment rules is now deprecated in version 2.12 and future versions and will be permanently removed on December 31, 2026. After this date, any requests made to this endpoint will fail.
{% /admonition %}
You can let a conversation be automatically assigned following assignment rules.
{% admonition type="warning" name="When using workflows" %}
It is not possible to use this endpoint with Workflows.
{% /admonition %}
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
client.conversations().runAssignmentRules(
    AutoAssignConversationRequest
        .builder()
        .conversationId("123")
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

**conversationId:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Custom Channel Events
<details><summary><code>client.customChannelEvents.notifyNewConversation(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a new conversation was created in your custom channel/platform. This triggers conversation creation and workflow automations within Intercom for your custom channel integration.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyNewConversation(
    CustomChannelBaseEvent
        .builder()
        .eventId("event_id")
        .externalConversationId("external_conversation_id")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("external_id")
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

**request:** `CustomChannelBaseEvent` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customChannelEvents.notifyNewMessage(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a new message was sent in a conversation on your custom channel/platform. This allows Intercom to process the message and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyNewMessage(
    NotifyNewMessageRequest
        .builder()
        .eventId("event_id")
        .externalConversationId("external_conversation_id")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("external_id")
                .build()
        )
        .body("body")
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

**body:** `String` — The message content sent by the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customChannelEvents.notifyQuickReplySelected(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a user selected a quick reply option in your custom channel/platform. This allows Intercom to process the response and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyQuickReplySelected(
    NotifyQuickReplySelectedRequest
        .builder()
        .eventId("evt_67890")
        .externalConversationId("conv_13579")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("user_003")
                .name("Alice Example")
                .email("alice@example.com")
                .build()
        )
        .quickReplyOptionId("1234")
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

**quickReplyOptionId:** `String` — Id of the selected quick reply option.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customChannelEvents.notifyAttributeCollected(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a user provided a response to an attribute collector in your custom channel/platform. This allows Intercom to process the attribute and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyAttributeCollected(
    NotifyAttributeCollectedRequest
        .builder()
        .eventId("event_id")
        .externalConversationId("external_conversation_id")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("external_id")
                .build()
        )
        .attribute(
            CustomChannelAttribute
                .builder()
                .id("id")
                .value("value")
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

**attribute:** `CustomChannelAttribute` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Custom Object Instances
<details><summary><code>client.customObjectInstances.getCustomObjectInstancesByExternalId(customObjectTypeIdentifier) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch a Custom Object Instance by external_id.
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
client.customObjectInstances().getCustomObjectInstancesByExternalId(
    GetCustomObjectInstancesByExternalIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("external_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customObjectInstances.createCustomObjectInstances(customObjectTypeIdentifier, request) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create or update a custom object instance
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
client.customObjectInstances().createCustomObjectInstances(
    CreateOrUpdateCustomObjectInstanceRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("123")
        .externalCreatedAt(1392036272)
        .externalUpdatedAt(1392036272)
        .customAttributes(
            new HashMap<String, Optional<String>>() {{
                put("order_number", Optional.of("ORDER-12345"));
                put("total_amount", Optional.of("custom_attributes"));
            }}
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — A unique identifier for the Custom Object instance in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**externalCreatedAt:** `Optional<Integer>` — The time when the Custom Object instance was created in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**externalUpdatedAt:** `Optional<Integer>` — The time when the Custom Object instance was last updated in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, Optional<String>>>` — The custom attributes which are set for the Custom Object instance.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customObjectInstances.deleteCustomObjectInstancesById(customObjectTypeIdentifier) -> CustomObjectInstanceDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a single Custom Object instance by external_id.
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
client.customObjectInstances().deleteCustomObjectInstancesById(
    DeleteCustomObjectInstancesByIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("external_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customObjectInstances.getCustomObjectInstancesById(customObjectTypeIdentifier, customObjectInstanceId) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch a Custom Object Instance by id.
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
client.customObjectInstances().getCustomObjectInstancesById(
    GetCustomObjectInstancesByIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .customObjectInstanceId("custom_object_instance_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**customObjectInstanceId:** `String` — The id or external_id of the custom object instance
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customObjectInstances.deleteCustomObjectInstancesByExternalId(customObjectTypeIdentifier, customObjectInstanceId) -> CustomObjectInstanceDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a single Custom Object instance using the Intercom defined id.
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
client.customObjectInstances().deleteCustomObjectInstancesByExternalId(
    DeleteCustomObjectInstancesByExternalIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .customObjectInstanceId("custom_object_instance_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**customObjectInstanceId:** `String` — The Intercom defined id of the custom object instance
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Data Attributes
<details><summary><code>client.dataAttributes.list() -> DataAttributeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all data attributes belonging to a workspace for contacts, companies or conversations.
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
client.dataAttributes().list(
    ListDataAttributesRequest
        .builder()
        .model(DataAttributesListRequestModel.CONTACT)
        .includeArchived(true)
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

**model:** `Optional<DataAttributesListRequestModel>` — Specify the data attribute model to return.
    
</dd>
</dl>

<dl>
<dd>

**includeArchived:** `Optional<Boolean>` — Include archived attributes in the list. By default we return only non archived data attributes.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataAttributes.create(request) -> DataAttribute</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a data attributes for a `contact` or a `company`.
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
client.dataAttributes().create(
    CreateDataAttributeRequest.of(
        CreateDataAttributeRequestOptions
            .builder()
            .dataType("string")
            .build()
    )
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

**request:** `CreateDataAttributeRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.dataAttributes.update(dataAttributeId, request) -> DataAttribute</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can update a data attribute.

> 🚧 Updating the data type is not possible
>
> It is currently a dangerous action to execute changing a data attribute's type via the API. You will need to update the type via the UI instead.
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
client.dataAttributes().update(
    UpdateDataAttributeRequest
        .builder()
        .dataAttributeId(1)
        .body(
            UpdateDataAttributeRequestBody.of(
                UpdateDataAttributeRequestOptions
                    .builder()
                    .options(
                        Arrays.asList(
                            UpdateDataAttributeRequestOptionsOptionsItem
                                .builder()
                                .value("1-10")
                                .build(),
                            UpdateDataAttributeRequestOptionsOptionsItem
                                .builder()
                                .value("11-20")
                                .build()
                        )
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

**dataAttributeId:** `Integer` — The data attribute id
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateDataAttributeRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Events
<details><summary><code>client.events.list() -> DataEventSummary</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


> 🚧
>
> Please note that you can only 'list' events that are less than 90 days old. Event counts and summaries will still include your events older than 90 days but you cannot 'list' these events individually if they are older than 90 days

The events belonging to a customer can be listed by sending a GET request to `https://api.intercom.io/events` with a user or lead identifier along with a `type` parameter. The identifier parameter can be one of `user_id`, `email` or `intercom_user_id`. The `type` parameter value must be `user`.

- `https://api.intercom.io/events?type=user&user_id={user_id}`
- `https://api.intercom.io/events?type=user&email={email}`
- `https://api.intercom.io/events?type=user&intercom_user_id={id}` (this call can be used to list leads)

The `email` parameter value should be [url encoded](http://en.wikipedia.org/wiki/Percent-encoding) when sending.

You can optionally define the result page size as well with the `per_page` parameter.
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
client.events().list(
    ListEventsRequest
        .builder()
        .type("type")
        .userId("user_id")
        .intercomUserId("intercom_user_id")
        .email("email")
        .summary(true)
        .perPage(1)
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

**userId:** `Optional<String>` — user_id query parameter
    
</dd>
</dl>

<dl>
<dd>

**intercomUserId:** `Optional<String>` — intercom_user_id query parameter
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — email query parameter
    
</dd>
</dl>

<dl>
<dd>

**type:** `String` — The value must be user
    
</dd>
</dl>

<dl>
<dd>

**summary:** `Optional<Boolean>` — summary flag
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.create(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You will need an Access Token that has write permissions to send Events. Once you have a key you can submit events via POST to the Events resource, which is located at https://api.intercom.io/events, or you can send events using one of the client libraries. When working with the HTTP API directly a client should send the event with a `Content-Type` of `application/json`.

When using the JavaScript API, [adding the code to your app](http://docs.intercom.io/configuring-Intercom/tracking-user-events-in-your-app) makes the Events API available. Once added, you can submit an event using the `trackEvent` method. This will associate the event with the Lead or currently logged-in user or logged-out visitor/lead and send it to Intercom. The final parameter is a map that can be used to send optional metadata about the event.

With the Ruby client you pass a hash describing the event to `Intercom::Event.create`, or call the `track_user` method directly on the current user object (e.g. `user.track_event`).

**NB: For the JSON object types, please note that we do not currently support nested JSON structure.**

| Type            | Description                                                                                                                                                                                                     | Example                                                                           |
| :-------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------- |
| String          | The value is a JSON String                                                                                                                                                                                      | `"source":"desktop"`                                                              |
| Number          | The value is a JSON Number                                                                                                                                                                                      | `"load": 3.67`                                                                    |
| Date            | The key ends with the String `_date` and the value is a [Unix timestamp](http://en.wikipedia.org/wiki/Unix_time), assumed to be in the [UTC](http://en.wikipedia.org/wiki/Coordinated_Universal_Time) timezone. | `"contact_date": 1392036272`                                                      |
| Link            | The value is a HTTP or HTTPS URI.                                                                                                                                                                               | `"article": "https://example.org/ab1de.html"`                                     |
| Rich Link       | The value is a JSON object that contains `url` and `value` keys.                                                                                                                                                | `"article": {"url": "https://example.org/ab1de.html", "value":"the dude abides"}` |
| Monetary Amount | The value is a JSON object that contains `amount` and `currency` keys. The `amount` key is a positive integer representing the amount in cents. The price in the example to the right denotes €349.99.          | `"price": {"amount": 34999, "currency": "eur"}`                                   |

**Lead Events**

When submitting events for Leads, you will need to specify the Lead's `id`.

**Metadata behaviour**

- We currently limit the number of tracked metadata keys to 10 per event. Once the quota is reached, we ignore any further keys we receive. The first 10 metadata keys are determined by the order in which they are sent in with the event.
- It is not possible to change the metadata keys once the event has been sent. A new event will need to be created with the new keys and you can archive the old one.
- There might be up to 24 hrs delay when you send a new metadata for an existing event.

**Event de-duplication**

The API may detect and ignore duplicate events. Each event is uniquely identified as a combination of the following data - the Workspace identifier, the Contact external identifier, the Data Event name and the Data Event created time. As a result, it is **strongly recommended** to send a second granularity Unix timestamp in the `created_at` field.

Duplicated events are responded to using the normal `202 Accepted` code - an error is not thrown, however repeat requests will be counted against any rate limit that is in place.

### HTTP API Responses

- Successful responses to submitted events return `202 Accepted` with an empty body.
- Unauthorised access will be rejected with a `401 Unauthorized` or `403 Forbidden` response code.
- Events sent about users that cannot be found will return a `404 Not Found`.
- Event lists containing duplicate events will have those duplicates ignored.
- Server errors will return a `500` response code and may contain an error message in the body.

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
client.events().create(
    CreateDataEventRequest.of(
        CreateDataEventRequestWithId
            .builder()
            .id("8a88a590-e1c3-41e2-a502-e0649dbf721c")
            .eventName("invited-friend")
            .createdAt(1671028894)
            .build()
    )
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

**request:** `CreateDataEventRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.summaries(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create event summaries for a user. Event summaries are used to track the number of times an event has occurred, the first time it occurred and the last time it occurred.

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
client.events().summaries(
    ListEventSummariesRequest
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

**userId:** `Optional<String>` — Your identifier for the user.
    
</dd>
</dl>

<dl>
<dd>

**eventSummaries:** `Optional<CreateDataEventSummariesRequestEventSummaries>` — A list of event summaries for the user. Each event summary should contain the event name, the time the event occurred, and the number of times the event occurred. The event name should be a past tense 'verb-noun' combination, to improve readability, for example `updated-plan`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Jobs
<details><summary><code>client.jobs.status(jobId) -> Jobs</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the status of job execution.
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
client.jobs().status(
    JobsStatusRequest
        .builder()
        .jobId("job_id")
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

**jobId:** `String` — The unique identifier for the job which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Messages
<details><summary><code>client.messages.create(request) -> Message</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a message that has been initiated by an admin. The conversation can be either an in-app message or an email.

> 🚧 Sending for visitors
>
> There can be a short delay between when a contact is created and when a contact becomes available to be messaged through the API. A 404 Not Found error will be returned in this case.

This will return the Message model that has been created.

> 🚧 Retrieving Associated Conversations
>
> As this is a message, there will be no conversation present until the contact responds. Once they do, you will have to search for a contact's conversations with the id of the message.
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
client.messages().create(
    Optional.of(
        CreateMessageRequest.email(
            CreateMessageRequestWithEmail
                .builder()
                .subject("Thanks for everything")
                .body("Hello there")
                .template("plain")
                .from(
                    CreateMessageRequestFrom
                        .builder()
                        .type("admin")
                        .id(394051)
                        .build()
                )
                .to(
                    CreateMessageRequestTo
                        .builder()
                        .type(CreateMessageRequestType.USER)
                        .id("536e564f316c83104c000020")
                        .build()
                )
                .build()
        )
    )
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

**request:** `Optional<CreateMessageRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Segments
<details><summary><code>client.segments.list() -> SegmentList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all segments.
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
client.segments().list(
    ListSegmentsRequest
        .builder()
        .includeCount(true)
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

**includeCount:** `Optional<Boolean>` — It includes the count of contacts that belong to each segment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.segments.find(segmentId) -> Segment</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single segment.
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
client.segments().find(
    FindSegmentRequest
        .builder()
        .segmentId("123")
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

**segmentId:** `String` — The unique identified of a given segment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Subscription Types
<details><summary><code>client.subscriptionTypes.list() -> SubscriptionTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list all subscription types. A list of subscription type objects will be returned.
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
client.subscriptionTypes().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## PhoneCallRedirects
<details><summary><code>client.phoneCallRedirects.create(request) -> Optional&amp;lt;PhoneSwitch&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can use the API to deflect phone calls to the Intercom Messenger.
Calling this endpoint will send an SMS with a link to the Messenger to the phone number specified.

If custom attributes are specified, they will be added to the user or lead's custom data attributes.
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
client.phoneCallRedirects().create(
    Optional.of(
        CreatePhoneSwitchRequest
            .builder()
            .phone("+353832345678")
            .customAttributes(
                new HashMap<String, CustomAttributesValue>() {{
                    put("issue_type", CustomAttributesValue.of("Billing"));
                    put("priority", CustomAttributesValue.of("High"));
                }}
            )
            .build()
    )
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

**request:** `Optional<CreatePhoneSwitchRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Calls
<details><summary><code>client.calls.listCalls() -> CallList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a paginated list of calls.
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
client.calls().listCalls(
    ListCallsRequest
        .builder()
        .page(1)
        .perPage(1)
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 25. Max 25.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.calls.showCall(callId) -> Call</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a single call by id.
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
client.calls().showCall(
    ShowCallRequest
        .builder()
        .callId("call_id")
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

**callId:** `String` — The id of the call to retrieve
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.calls.showCallRecording(callId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Redirects to a signed URL for the call's recording if it exists.
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
client.calls().showCallRecording(
    ShowCallRecordingRequest
        .builder()
        .callId("call_id")
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

**callId:** `String` — The id of the call
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.calls.showCallTranscript(callId) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the transcript for the specified call as a downloadable text file.
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
client.calls().showCallTranscript(
    ShowCallTranscriptRequest
        .builder()
        .callId("call_id")
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

**callId:** `String` — The id of the call
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.calls.listCallsWithTranscripts(request) -> ListCallsWithTranscriptsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve calls by a list of conversation ids and include transcripts when available.
A maximum of 20 `conversation_ids` can be provided. If none are provided or more than 20 are provided, a 400 error is returned.
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
client.calls().listCallsWithTranscripts(
    ListCallsWithTranscriptsRequest
        .builder()
        .conversationIds(
            Arrays.asList("64619700005694", "64619700005695")
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

**conversationIds:** `List<String>` — A list of conversation ids to fetch calls for. Maximum 20.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Teams
<details><summary><code>client.teams.list() -> TeamList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This will return a list of team objects for the App.
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
client.teams().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teams.find(teamId) -> Team</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single team, containing an array of admins that belong to this team.
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
client.teams().find(
    FindTeamRequest
        .builder()
        .teamId("123")
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

**teamId:** `String` — The unique identifier of a given team.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ticket States
<details><summary><code>client.ticketStates.listTicketStates() -> TicketStateList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a list of all ticket states for a workspace.
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
client.ticketStates().listTicketStates();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ticket Types
<details><summary><code>client.ticketTypes.list() -> TicketTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a list of all ticket types for a workspace.
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
client.ticketTypes().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ticketTypes.create(request) -> Optional&amp;lt;TicketType&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new ticket type.
> 📘 Creating ticket types.
>
> Every ticket type will be created with two default attributes: _default_title_ and _default_description_.
> For the `icon` propery, use an emoji from [Twemoji Cheatsheet](https://twemoji-cheatsheet.vercel.app/)
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
client.ticketTypes().create(
    Optional.of(
        CreateTicketTypeRequest
            .builder()
            .name("Customer Issue")
            .description("Customer Report Template")
            .category(CreateTicketTypeRequestCategory.CUSTOMER)
            .icon("🎟️")
            .build()
    )
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

**request:** `Optional<CreateTicketTypeRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ticketTypes.get(ticketTypeId) -> Optional&amp;lt;TicketType&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single ticket type.
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
client.ticketTypes().get(
    FindTicketTypeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ticketTypes.update(ticketTypeId, request) -> Optional&amp;lt;TicketType&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can update a ticket type.

> 📘 Updating a ticket type.
>
> For the `icon` propery, use an emoji from [Twemoji Cheatsheet](https://twemoji-cheatsheet.vercel.app/)
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
client.ticketTypes().update(
    UpdateTicketTypeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
        .name("Bug Report 2")
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**category:** `Optional<UpdateTicketTypeRequestCategory>` — Category of the Ticket Type.
    
</dd>
</dl>

<dl>
<dd>

**icon:** `Optional<String>` — The icon of the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**archived:** `Optional<Boolean>` — The archived status of the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**isInternal:** `Optional<Boolean>` — Whether the tickets associated with this ticket type are intended for internal use only or will be shared with customers. This is currently a limited attribute.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tickets
<details><summary><code>client.tickets.reply(ticketId, request) -> TicketReply</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can reply to a ticket with a message from an admin or on behalf of a contact, or with a note for admins.
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
client.tickets().reply(
            ReplyToTicketRequest
                .builder()
                .ticketId("123")
                .body(
                    TicketsReplyRequestBody.of(
                        ContactReplyTicketRequest.of(
                            ContactReplyTicketIntercomUserIdRequest
                                .builder()
                                .messageType("comment")
                                .type("user")
                                .body("Thanks again :)")
                                .intercomUserId("6762f2971bb69f9f2193bc49")
                                .build()
                        )
                    )
                )
                .build()
        );
    }
}
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

**ticketId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `TicketsReplyRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.create(request) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new ticket.
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
client.tickets().create(
    CreateTicketRequest
        .builder()
        .ticketTypeId("1234")
        .contacts(
            Arrays.asList(
                CreateTicketRequestContactsItem.of(
                    CreateTicketRequestContactsItemId
                        .builder()
                        .id("6762f2d81bb69f9f2193bc54")
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

**skipNotifications:** `Optional<Boolean>` — Option to disable notifications when a Ticket is created.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.enqueueCreateTicket(request) -> Jobs</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Enqueues ticket creation for asynchronous processing, returning if the job was enqueued successfully to be processed. We attempt to perform a best-effort validation on inputs before tasks are enqueued. If the given parameters are incorrect, we won't enqueue the job.
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
client.tickets().enqueueCreateTicket(
    EnqueueCreateTicketRequest
        .builder()
        .ticketTypeId("1234")
        .contacts(
            Arrays.asList(
                CreateTicketRequestContactsItem.of(
                    CreateTicketRequestContactsItemId
                        .builder()
                        .id("6762f2d81bb69f9f2193bc54")
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

**skipNotifications:** `Optional<Boolean>` — Option to disable notifications when a Ticket is created.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.get(ticketId) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single ticket.
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
client.tickets().get(
    FindTicketRequest
        .builder()
        .ticketId("ticket_id")
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

**ticketId:** `String` — The unique identifier for the ticket which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.update(ticketId, request) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update a ticket.
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
client.tickets().update(
    UpdateTicketRequest
        .builder()
        .ticketId("ticket_id")
        .ticketAttributes(
            new HashMap<String, Object>() {{
                put("_default_title_", "example");
                put("_default_description_", "there is a problem");
            }}
        )
        .ticketStateId("123")
        .open(true)
        .snoozedUntil(1673609604)
        .adminId(991268011)
        .assigneeId("123")
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

**ticketId:** `String` — The unique identifier for the ticket which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**ticketAttributes:** `Optional<Map<String, Object>>` — The attributes set on the ticket.
    
</dd>
</dl>

<dl>
<dd>

**ticketStateId:** `Optional<String>` — The ID of the ticket state associated with the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The ID of the company that the ticket is associated with. The unique identifier for the company which is given by Intercom. Set to nil to remove company.
    
</dd>
</dl>

<dl>
<dd>

**open:** `Optional<Boolean>` — Specify if a ticket is open. Set to false to close a ticket. Closing a ticket will also unsnooze it.
    
</dd>
</dl>

<dl>
<dd>

**isShared:** `Optional<Boolean>` — Specify whether the ticket is visible to users.
    
</dd>
</dl>

<dl>
<dd>

**snoozedUntil:** `Optional<Integer>` — The time you want the ticket to reopen.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<Integer>` — The ID of the admin performing ticket update. Needed for workflows execution and attributing actions to specific admins.
    
</dd>
</dl>

<dl>
<dd>

**assigneeId:** `Optional<String>` — The ID of the admin or team to which the ticket is assigned. Set this 0 to unassign it.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.deleteTicket(ticketId) -> DeleteTicketResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a ticket using the Intercom provided ID.
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
client.tickets().deleteTicket(
    DeleteTicketRequest
        .builder()
        .ticketId("ticket_id")
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

**ticketId:** `String` — The unique identifier for the ticket which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.tickets.search(request) -> SyncPagingIterable&amp;lt;Optional&amp;lt;Ticket&amp;gt;&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple tickets by the value of their attributes in order to fetch exactly which ones you want.

To search for tickets, you send a `POST` request to `https://api.intercom.io/tickets/search`.

This will accept a query object in the body which will define your filters.
{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiples there can be:
- There's a limit of max 2 nested filters
- There's a limit of max 15 filters for each AND or OR group

### Accepted Fields

Most keys listed as part of the Ticket model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foobar"`).
The `source.body` field is unique as the search will not be performed against the entire value, but instead against every element of the value separately. For example, when searching for a conversation with a `"I need support"` body - the query should contain a `=` operator with the value `"support"` for such conversation to be returned. A query with a `=` operator and a `"need support"` value will not yield a result.

| Field                                     | Type                                                                                     |
| :---------------------------------------- | :--------------------------------------------------------------------------------------- |
| id                                        | String                                                                                   |
| created_at                                | Date (UNIX timestamp)                                                                    |
| updated_at                                | Date (UNIX timestamp)                                                                    |
| title                           | String                                                                                   |
| description                     | String                                                                                   |
| category                                  | String                                                                                   |
| ticket_type_id                            | String                                                                                   |
| contact_ids                               | String                                                                                   |
| teammate_ids                              | String                                                                                   |
| admin_assignee_id                         | String                                                                                   |
| team_assignee_id                          | String                                                                                   |
| open                                      | Boolean                                                                                  |
| state                                     | String                                                                                   |
| snoozed_until                             | Date (UNIX timestamp)                                                                    |
| ticket_attribute.{id}                     | String or Boolean or Date (UNIX timestamp) or Float or Integer                           |

{% admonition type="info" name="Searching by Category" %}
When searching for tickets by the **`category`** field, specific terms must be used instead of the category names:
* For **Customer** category tickets, use the term `request`.
* For **Back-office** category tickets, use the term `task`.
* For **Tracker** category tickets, use the term `tracker`.
{% /admonition %}

### Accepted Operators

{% admonition type="info" name="Searching based on `created_at`" %}
  You may use the `<=` or `>=` operators to search by `created_at`.
{% /admonition %}

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type  (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                    | Description                                                  |
| :------- | :----------------------------- | :----------------------------------------------------------- |
| =        | All                            | Equals                                                       |
| !=       | All                            | Doesn't Equal                                                |
| IN       | All                            | In  Shortcut for `OR` queries  Values most be in Array       |
| NIN      | All                            | Not In  Shortcut for `OR !` queries  Values must be in Array |
| >        | Integer  Date (UNIX Timestamp) | Greater (or equal) than                                      |
| <       | Integer  Date (UNIX Timestamp) | Lower (or equal) than                                        |
| ~        | String                         | Contains                                                     |
| !~       | String                         | Doesn't Contain                                              |
| ^        | String                         | Starts With                                                  |
| $        | String                         | Ends With                                                    |
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
client.unstable().tickets().searchTickets(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Visitors
<details><summary><code>client.visitors.find() -> Optional&amp;lt;Visitor&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single visitor.
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
client.visitors().find(
    FindVisitorRequest
        .builder()
        .userId("user_id")
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

**userId:** `String` — The user_id of the Visitor you want to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.visitors.update(request) -> Optional&amp;lt;Visitor&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sending a PUT request to `/visitors` will result in an update of an existing Visitor.

**Option 1.** You can update a visitor by passing in the `user_id` of the visitor in the Request body.

**Option 2.** You can update a visitor by passing in the `id` of the visitor in the Request body.
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
client.visitors().update(
    UpdateVisitorRequest.of(
        UpdateVisitorRequestWithId
            .builder()
            .id("6762f30c1bb69f9f2193bc5e")
            .name("Gareth Bale")
            .build()
    )
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

**request:** `UpdateVisitorRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.visitors.mergeToContact(request) -> Contact</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can merge a Visitor to a Contact of role type `lead` or `user`.

> 📘 What happens upon a visitor being converted?
>
> If the User exists, then the Visitor will be merged into it, the Visitor deleted and the User returned. If the User does not exist, the Visitor will be converted to a User, with the User identifiers replacing it's Visitor identifiers.
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
client.unstable().visitors().convertVisitor(
    ConvertVisitorRequest
        .builder()
        .type("user")
        .user(new 
            HashMap<String, Object>() {{put("id", "8a88a590-e1c3-41e2-a502-e0649dbf721c");
                put("email", "foo@bar.com");
            }})
        .visitor(new 
            HashMap<String, Object>() {{put("user_id", "3ecf64d0-9ed1-4e9f-88e1-da7d6e6782f3");
            }})
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

**type:** `String` — Represents the role of the Contact model. Accepts `lead` or `user`.
    
</dd>
</dl>

<dl>
<dd>

**user:** `ConvertVisitorRequestUser` — The unique identifiers retained after converting or merging.
    
</dd>
</dl>

<dl>
<dd>

**visitor:** `ConvertVisitorRequestVisitor` — The unique identifiers to convert a single Visitor.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## HelpCenters Collections
<details><summary><code>client.helpCenters.collections.list() -> SyncPagingIterable&amp;lt;Collection&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all collections by making a GET request to `https://api.intercom.io/help_center/collections`.

Collections will be returned in descending order on the `updated_at` attribute. This means if you need to iterate through results then we'll show the most recently updated collections first.
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
client.helpCenters().collections().list(
    ListCollectionsRequest
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.helpCenters.collections.create(request) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new collection by making a POST request to `https://api.intercom.io/help_center/collections.`
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
client.helpCenters().collections().create(
    CreateCollectionRequest
        .builder()
        .name("Thanks for everything")
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

**name:** `String` — The name of the collection. For multilingual collections, this will be the name of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the collection. For multilingual collections, this will be the description of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**translatedContent:** `Optional<GroupTranslatedContent>` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the parent collection. If `null` then it will be created as the first level collection.
    
</dd>
</dl>

<dl>
<dd>

**helpCenterId:** `Optional<Integer>` — The id of the help center where the collection will be created. If `null` then it will be created in the default help center.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.helpCenters.collections.find(collectionId) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single collection by making a GET request to `https://api.intercom.io/help_center/collections/<id>`.
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
client.helpCenters().collections().find(
    FindCollectionRequest
        .builder()
        .collectionId(1)
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

**collectionId:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.helpCenters.collections.update(collectionId, request) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update the details of a single collection by making a PUT request to `https://api.intercom.io/collections/<id>`.
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
client.helpCenters().collections().update(
    UpdateCollectionRequest
        .builder()
        .collectionId(1)
        .name("Update collection name")
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

**collectionId:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the collection. For multilingual collections, this will be the name of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the collection. For multilingual collections, this will be the description of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**translatedContent:** `Optional<GroupTranslatedContent>` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the parent collection. If `null` then it will be updated as the first level collection.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.helpCenters.collections.delete(collectionId) -> DeletedCollectionObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single collection by making a DELETE request to `https://api.intercom.io/collections/<id>`.
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
client.helpCenters().collections().delete(
    DeleteCollectionRequest
        .builder()
        .collectionId(1)
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

**collectionId:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## News Items
<details><summary><code>client.news.items.list() -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all news items
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
client.news().items().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.items.create(request) -> NewsItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a news item
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
client.news().items().create(
    NewsItemRequest
        .builder()
        .title("Halloween is here!")
        .senderId(991267834)
        .body("<p>New costumes in store for this spooky season</p>")
        .state(NewsItemRequestState.LIVE)
        .deliverSilently(true)
        .labels(
            Optional.of(
                Arrays.asList("Product", "Update", "New")
            )
        )
        .reactions(
            Optional.of(
                Arrays.asList(Optional.of("😆"), Optional.of("😅"))
            )
        )
        .newsfeedAssignments(
            Optional.of(
                Arrays.asList(
                    NewsfeedAssignment
                        .builder()
                        .newsfeedId(53)
                        .publishedAt(1664638214)
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

**request:** `NewsItemRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.items.find(newsItemId) -> NewsItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single news item.
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
client.news().items().find(
    FindNewsItemRequest
        .builder()
        .newsItemId(1)
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

**newsItemId:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.items.update(newsItemId, request) -> NewsItem</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.news().items().update(
    UpdateNewsItemRequest
        .builder()
        .newsItemId(1)
        .body(
            NewsItemRequest
                .builder()
                .title("Christmas is here!")
                .senderId(991267845)
                .body("<p>New gifts in store for the jolly season</p>")
                .reactions(
                    Optional.of(
                        Arrays.asList(Optional.of("😝"), Optional.of("😂"))
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

**newsItemId:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**request:** `NewsItemRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.items.delete(newsItemId) -> DeletedObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single news item.
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
client.news().items().delete(
    DeleteNewsItemRequest
        .builder()
        .newsItemId(1)
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

**newsItemId:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## News Feeds
<details><summary><code>client.news.feeds.listItems(newsfeedId) -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all news items that are live on a given newsfeed
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
client.news().feeds().listItems(
    ListNewsFeedItemsRequest
        .builder()
        .newsfeedId("123")
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

**newsfeedId:** `String` — The unique identifier for the news feed item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.feeds.list() -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all newsfeeds
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
client.news().feeds().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.news.feeds.find(newsfeedId) -> Newsfeed</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single newsfeed
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
client.news().feeds().find(
    FindNewsFeedRequest
        .builder()
        .newsfeedId("123")
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

**newsfeedId:** `String` — The unique identifier for the news feed item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## TicketTypes Attributes
<details><summary><code>client.ticketTypes.attributes.create(ticketTypeId, request) -> Optional&amp;lt;TicketTypeAttribute&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new attribute for a ticket type.
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
client.ticketTypes().attributes().create(
    CreateTicketTypeAttributeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
        .name("Attribute Title")
        .description("Attribute Description")
        .dataType(CreateTicketTypeAttributeRequestDataType.STRING)
        .requiredToCreate(false)
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The name of the ticket type attribute
    
</dd>
</dl>

<dl>
<dd>

**description:** `String` — The description of the attribute presented to the teammate or contact
    
</dd>
</dl>

<dl>
<dd>

**dataType:** `CreateTicketTypeAttributeRequestDataType` — The data type of the attribute
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreate:** `Optional<Boolean>` — Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreateForContacts:** `Optional<Boolean>` — Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**visibleOnCreate:** `Optional<Boolean>` — Whether the attribute is visible to teammates when creating a ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**visibleToContacts:** `Optional<Boolean>` — Whether the attribute is visible to contacts when creating a ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**multiline:** `Optional<Boolean>` — Whether the attribute allows multiple lines of text (only applicable to string attributes)
    
</dd>
</dl>

<dl>
<dd>

**listItems:** `Optional<String>` — A comma delimited list of items for the attribute value (only applicable to list attributes)
    
</dd>
</dl>

<dl>
<dd>

**allowMultipleValues:** `Optional<Boolean>` — Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ticketTypes.attributes.update(ticketTypeId, attributeId, request) -> Optional&amp;lt;TicketTypeAttribute&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing attribute for a ticket type.
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
client.ticketTypes().attributes().update(
    UpdateTicketTypeAttributeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
        .attributeId("attribute_id")
        .description("New Attribute Description")
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**attributeId:** `String` — The unique identifier for the ticket type attribute which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the ticket type attribute
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the attribute presented to the teammate or contact
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreate:** `Optional<Boolean>` — Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreateForContacts:** `Optional<Boolean>` — Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**visibleOnCreate:** `Optional<Boolean>` — Whether the attribute is visible to teammates when creating a ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**visibleToContacts:** `Optional<Boolean>` — Whether the attribute is visible to contacts when creating a ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**multiline:** `Optional<Boolean>` — Whether the attribute allows multiple lines of text (only applicable to string attributes)
    
</dd>
</dl>

<dl>
<dd>

**listItems:** `Optional<String>` — A comma delimited list of items for the attribute value (only applicable to list attributes)
    
</dd>
</dl>

<dl>
<dd>

**allowMultipleValues:** `Optional<Boolean>` — Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)
    
</dd>
</dl>

<dl>
<dd>

**archived:** `Optional<Boolean>` — Whether the attribute should be archived and not shown during creation of the ticket (it will still be present on previously created tickets)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Admins
<details><summary><code>client.unstable.admins.identifyAdmin() -> Optional&amp;lt;AdminWithApp&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can view the currently authorised admin along with the embedded app object (a "workspace" in legacy terminology).

> 🚧 Single Sign On
>
> If you are building a custom "Log in with Intercom" flow for your site, and you call the `/me` endpoint to identify the logged-in user, you should not accept any sign-ins from users with unverified email addresses as it poses a potential impersonation security risk.
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
client.admins().identify();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.admins.setAwayAdmin(id, request) -> Optional&amp;lt;Admin&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can set an Admin as away for the Inbox.
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
client.unstable().admins().setAwayAdmin(
    SetAwayAdminRequest
        .builder()
        .id(1)
        .awayModeEnabled(true)
        .awayModeReassign(true)
        .awayStatusReasonId(12345)
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

**id:** `Integer` — The unique identifier of a given admin
    
</dd>
</dl>

<dl>
<dd>

**awayModeEnabled:** `Boolean` — Set to "true" to change the status of the admin to away.
    
</dd>
</dl>

<dl>
<dd>

**awayModeReassign:** `Boolean` — Set to "true" to assign any new conversation replies to your default inbox.
    
</dd>
</dl>

<dl>
<dd>

**awayStatusReasonId:** `Optional<Integer>` — The unique identifier of the away status reason
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.admins.listActivityLogs() -> ActivityLogList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a log of activities by all admins in an app.
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
client.admins().listAllActivityLogs(
    ListAllActivityLogsRequest
        .builder()
        .createdAtAfter("1677253093")
        .createdAtBefore("1677861493")
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

**createdAtAfter:** `String` — The start date that you request data for. It must be formatted as a UNIX timestamp.
    
</dd>
</dl>

<dl>
<dd>

**createdAtBefore:** `Optional<String>` — The end date that you request data for. It must be formatted as a UNIX timestamp.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.admins.listAdmins() -> AdminList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of admins for a given workspace.
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
client.admins().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.admins.retrieveAdmin(id) -> Optional&amp;lt;Admin&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve the details of a single admin.
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
client.unstable().admins().retrieveAdmin(
    RetrieveAdminRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier of a given admin
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## AI Content
<details><summary><code>client.unstable.aiContent.listContentImportSources() -> ContentImportSourcesList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve a list of all content import sources for a workspace.
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
client.aiContent().listContentImportSources();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.createContentImportSource(request) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new content import source by sending a POST request to this endpoint.
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
client.aiContent().createContentImportSource(
    CreateContentImportSourceRequest
        .builder()
        .url("https://www.example.com")
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

**syncBehavior:** `String` — If you intend to create or update External Pages via the API, this should be set to `api`.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<CreateContentImportSourceRequestStatus>` — The status of the content import source.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the content import source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.getContentImportSource(id) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.unstable().aiContent().getContentImportSource(
    GetContentImportSourceRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.updateContentImportSource(id, request) -> ContentImportSource</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing content import source.
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
client.unstable().aiContent().updateContentImportSource(
    UpdateContentImportSourceRequest
        .builder()
        .id("id")
        .syncBehavior(UpdateContentImportSourceRequestSyncBehavior.API)
        .url("https://www.example.com")
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

**id:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**syncBehavior:** `UpdateContentImportSourceRequestSyncBehavior` — If you intend to create or update External Pages via the API, this should be set to `api`. You can not change the value to or from api.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<UpdateContentImportSourceRequestStatus>` — The status of the content import source.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the content import source. This may only be different from the existing value if the sync behavior is API.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.deleteContentImportSource(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a content import source by making a DELETE request this endpoint. This will also delete all external pages that were imported from this source.
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
client.unstable().aiContent().deleteContentImportSource(
    DeleteContentImportSourceRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the content import source which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.listExternalPages() -> ExternalPagesList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve a list of all external pages for a workspace.
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
client.aiContent().listExternalPages();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.createExternalPage(request) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new external page by sending a POST request to this endpoint. If an external page already exists with the specified source_id and external_id, it will be updated instead.
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
client.aiContent().createExternalPage(
    CreateExternalPageRequest
        .builder()
        .title("Test")
        .html("<html><body><h1>Test</h1></body></html>")
        .sourceId(44)
        .externalId("abc1234")
        .url("https://www.example.com")
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

**title:** `String` — The title of the external page.
    
</dd>
</dl>

<dl>
<dd>

**html:** `String` — The body of the external page in HTML.
    
</dd>
</dl>

<dl>
<dd>

**url:** `Optional<String>` — The URL of the external page. This will be used by Fin to link end users to the page it based its answer on. When a URL is not present, Fin will not reference the source.
    
</dd>
</dl>

<dl>
<dd>

**aiAgentAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by AI Agent. Will not default when updating an existing external page.
    
</dd>
</dl>

<dl>
<dd>

**aiCopilotAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by AI Copilot. Will not default when updating an existing external page.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `String` — Always en
    
</dd>
</dl>

<dl>
<dd>

**sourceId:** `Integer` — The unique identifier for the source of the external page which was given by Intercom. Every external page must be associated with a Content Import Source which represents the place it comes from and from which it inherits a default audience (configured in the UI). For a new source, make a POST request to the Content Import Source endpoint and an ID for the source will be returned in the response.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` — The identifier for the external page which was given by the source. Must be unique for the source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.getExternalPage(id) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can retrieve an external page.
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
client.unstable().aiContent().getExternalPage(
    GetExternalPageRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.updateExternalPage(id, request) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing external page (if it was created via the API).
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
client.unstable().aiContent().updateExternalPage(
    UpdateExternalPageRequest
        .builder()
        .id("id")
        .title("Test")
        .html("<html><body><h1>Test</h1></body></html>")
        .url("https://www.example.com")
        .sourceId(47)
        .externalId("5678")
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

**id:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `String` — The title of the external page.
    
</dd>
</dl>

<dl>
<dd>

**html:** `String` — The body of the external page in HTML.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The URL of the external page. This will be used by Fin to link end users to the page it based its answer on.
    
</dd>
</dl>

<dl>
<dd>

**finAvailability:** `Optional<Boolean>` — Whether the external page should be used to answer questions by Fin.
    
</dd>
</dl>

<dl>
<dd>

**locale:** `String` — Always en
    
</dd>
</dl>

<dl>
<dd>

**sourceId:** `Integer` — The unique identifier for the source of the external page which was given by Intercom. Every external page must be associated with a Content Import Source which represents the place it comes from and from which it inherits a default audience (configured in the UI). For a new source, make a POST request to the Content Import Source endpoint and an ID for the source will be returned in the response.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — The identifier for the external page which was given by the source. Must be unique for the source.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.aiContent.deleteExternalPage(id) -> ExternalPage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sending a DELETE request for an external page will remove it from the content library UI and from being used for AI answers.
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
client.unstable().aiContent().deleteExternalPage(
    DeleteExternalPageRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the external page which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Articles
<details><summary><code>client.unstable.articles.listArticles() -> ArticleList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all articles by making a GET request to `https://api.intercom.io/articles`.

> 📘 How are the articles sorted and ordered?
>
> Articles will be returned in descending order on the `updated_at` attribute. This means if you need to iterate through results then we'll show the most recently updated articles first.
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
client.articles().list(
    ListArticlesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.articles.createArticle(request) -> Article</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new article by making a POST request to `https://api.intercom.io/articles`.
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
client.unstable().articles().createArticle(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.articles.retrieveArticle(id) -> Article</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single article by making a GET request to `https://api.intercom.io/articles/<id>`.
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
client.unstable().articles().retrieveArticle(
    RetrieveArticleRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.articles.deleteArticle(id) -> DeletedArticleObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single article by making a DELETE request to `https://api.intercom.io/articles/<id>`.
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
client.unstable().articles().deleteArticle(
    DeleteArticleRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.articles.searchArticles() -> ArticleSearchResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for articles by making a GET request to `https://api.intercom.io/articles/search`.
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
client.articles().search(
    SearchArticlesRequest
        .builder()
        .phrase("Getting started")
        .state("published")
        .helpCenterId(1)
        .highlight(true)
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

**phrase:** `Optional<String>` — The phrase within your articles to search for.
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` — The state of the Articles returned. One of `published`, `draft` or `all`.
    
</dd>
</dl>

<dl>
<dd>

**helpCenterId:** `Optional<Integer>` — The ID of the Help Center to search in.
    
</dd>
</dl>

<dl>
<dd>

**highlight:** `Optional<Boolean>` — Return a highlighted version of the matching content within your articles. Refer to the response schema for more details.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Away Status Reasons
<details><summary><code>client.unstable.awayStatusReasons.listAwayStatusReasons() -> List&amp;lt;AwayStatusReason&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all away status reasons configured for the workspace, including deleted ones.
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
client.awayStatusReasons().listAwayStatusReasons();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Unstable Export
<details><summary><code>client.unstable.export.enqueueANewReportingDataExportJob(request) -> PostExportReportingDataEnqueueResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.export().enqueueANewReportingDataExportJob(
    PostExportReportingDataEnqueueRequest
        .builder()
        .datasetId("conversation")
        .startTime(1717490000L)
        .endTime(1717510000L)
        .attributeIds(
            Arrays.asList("conversation_id", "conversation_started_at")
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

**datasetId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**attributeIds:** `List<String>` 
    
</dd>
</dl>

<dl>
<dd>

**startTime:** `Long` 
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Long` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.export.listAvailableDatasetsAndAttributes() -> GetExportReportingDataGetDatasetsResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.export().listAvailableDatasetsAndAttributes();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Help Center
<details><summary><code>client.unstable.helpCenter.listAllCollections() -> CollectionList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all collections by making a GET request to `https://api.intercom.io/help_center/collections`.

Collections will be returned in descending order on the `updated_at` attribute. This means if you need to iterate through results then we'll show the most recently updated collections first.
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
client.helpCenters().collections().list(
    ListCollectionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.createCollection(request) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new collection by making a POST request to `https://api.intercom.io/help_center/collections.`
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
client.helpCenters().collections().create(
    CreateCollectionRequest
        .builder()
        .name("Thanks for everything")
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

**name:** `String` — The name of the collection. For multilingual collections, this will be the name of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the collection. For multilingual collections, this will be the description of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**translatedContent:** `Optional<GroupTranslatedContent>` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the parent collection. If `null` then it will be created as the first level collection.
    
</dd>
</dl>

<dl>
<dd>

**helpCenterId:** `Optional<Integer>` — The id of the help center where the collection will be created. If `null` then it will be created in the default help center.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.retrieveCollection(id) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single collection by making a GET request to `https://api.intercom.io/help_center/collections/<id>`.
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
client.unstable().helpCenter().retrieveCollection(
    RetrieveCollectionRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.updateCollection(id, request) -> Collection</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update the details of a single collection by making a PUT request to `https://api.intercom.io/collections/<id>`.
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
client.unstable().helpCenter().updateCollection(
    UpdateCollectionRequest
        .builder()
        .id(1)
        .name("Update collection name")
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

**id:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the collection. For multilingual collections, this will be the name of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the collection. For multilingual collections, this will be the description of the default language's content.
    
</dd>
</dl>

<dl>
<dd>

**translatedContent:** `Optional<GroupTranslatedContent>` 
    
</dd>
</dl>

<dl>
<dd>

**parentId:** `Optional<String>` — The id of the parent collection. If `null` then it will be updated as the first level collection.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.deleteCollection(id) -> DeletedCollectionObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single collection by making a DELETE request to `https://api.intercom.io/collections/<id>`.
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
client.unstable().helpCenter().deleteCollection(
    DeleteCollectionRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.retrieveHelpCenter(id) -> HelpCenter</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single Help Center by making a GET request to `https://api.intercom.io/help_center/help_center/<id>`.
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
client.unstable().helpCenter().retrieveHelpCenter(
    RetrieveHelpCenterRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the collection which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.helpCenter.listHelpCenters() -> HelpCenterList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list all Help Centers by making a GET request to `https://api.intercom.io/help_center/help_centers`.
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
client.helpCenters().list(
    ListHelpCentersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Internal Articles
<details><summary><code>client.unstable.internalArticles.listInternalArticles() -> InternalArticleList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all internal articles by making a GET request to `https://api.intercom.io/internal_articles`.
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
client.internalArticles().listInternalArticles();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.internalArticles.createInternalArticle(request) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new internal article by making a POST request to `https://api.intercom.io/internal_articles`.
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
client.internalArticles().createInternalArticle(
    Optional.of(
        CreateInternalArticleRequest
            .builder()
            .title("Thanks for everything")
            .authorId(991266252)
            .ownerId(991266252)
            .body("Body of the Article")
            .build()
    )
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

**request:** `Optional<CreateInternalArticleRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.internalArticles.retrieveInternalArticle(id) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single internal article by making a GET request to `https://api.intercom.io/internal_articles/<id>`.
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
client.unstable().internalArticles().retrieveInternalArticle(
    RetrieveInternalArticleRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.internalArticles.updateInternalArticle(id, request) -> InternalArticleListItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update the details of a single internal article by making a PUT request to `https://api.intercom.io/internal_articles/<id>`.
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
client.unstable().internalArticles().updateInternalArticle(
    UpdateInternalArticleRequestBody
        .builder()
        .id(1)
        .title("Christmas is here!")
        .body("<p>New gifts in store for the jolly season</p>")
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

**id:** `Integer` — The unique identifier for the internal article which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — The title of the article.
    
</dd>
</dl>

<dl>
<dd>

**body:** `Optional<String>` — The content of the article.
    
</dd>
</dl>

<dl>
<dd>

**authorId:** `Optional<Integer>` — The id of the author of the article.
    
</dd>
</dl>

<dl>
<dd>

**ownerId:** `Optional<Integer>` — The id of the author of the article.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.internalArticles.deleteInternalArticle(id) -> DeletedInternalArticleObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single internal article by making a DELETE request to `https://api.intercom.io/internal_articles/<id>`.
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
client.unstable().internalArticles().deleteInternalArticle(
    DeleteInternalArticleRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the internal article which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.internalArticles.searchInternalArticles() -> InternalArticleSearchResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for internal articles by making a GET request to `https://api.intercom.io/internal_articles/search`.
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
client.internalArticles().searchInternalArticles(
    SearchInternalArticlesRequest
        .builder()
        .folderId("folder_id")
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

**folderId:** `Optional<String>` — The ID of the folder to search in.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Companies
<details><summary><code>client.unstable.companies.retrieveCompany() -> CompanyList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a single company by passing in `company_id` or `name`.

  `https://api.intercom.io/companies?name={name}`

  `https://api.intercom.io/companies?company_id={company_id}`

You can fetch all companies and filter by `segment_id` or `tag_id` as a query parameter.

  `https://api.intercom.io/companies?tag_id={tag_id}`

  `https://api.intercom.io/companies?segment_id={segment_id}`
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
client.companies().retrieve(
    RetrieveCompanyRequest
        .builder()
        .name("my company")
        .companyId("12345")
        .tagId("678910")
        .segmentId("98765")
        .page(1)
        .perPage(1)
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

**name:** `Optional<String>` — The `name` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The `company_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**tagId:** `Optional<String>` — The `tag_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**segmentId:** `Optional<String>` — The `segment_id` of the company to filter by.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 15
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.createOrUpdateCompany(request) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create or update a company.

Companies will be only visible in Intercom when there is at least one associated user.

Companies are looked up via `company_id` in a `POST` request, if not found via `company_id`, the new company will be created, if found, that company will be updated.

{% admonition type="warning" name="Using `company_id`" %}
  You can set a unique `company_id` value when creating a company. However, it is not possible to update `company_id`. Be sure to set a unique value once upon creation of the company.
{% /admonition %}
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
client.unstable().companies().createOrUpdateCompany(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.retrieveACompanyById(id) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a single company.
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
client.unstable().companies().retrieveACompanyById(
    RetrieveACompanyByIdRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.updateCompany(id) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update a single company using the Intercom provisioned `id`.

{% admonition type="warning" name="Using `company_id`" %}
  When updating a company it is not possible to update `company_id`. This can only be set once upon creation of the company.
{% /admonition %}
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
client.unstable().companies().updateCompany(
    UpdateCompanyRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.deleteCompany(id) -> DeletedCompanyObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single company.
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
client.unstable().companies().deleteCompany(
    DeleteCompanyRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.listAttachedContacts(id) -> CompanyAttachedContacts</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all contacts that belong to a company.
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
client.unstable().companies().listAttachedContacts(
    ListAttachedContactsRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.listAttachedSegmentsForCompanies(id) -> CompanyAttachedSegments</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all segments that belong to a company.
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
client.unstable().companies().listAttachedSegmentsForCompanies(
    ListAttachedSegmentsForCompaniesRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.listAllCompanies() -> CompanyList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list companies. The company list is sorted by the `last_request_at` field and by default is ordered descending, most recently requested first.

Note that the API does not include companies who have no associated users in list responses.

When using the Companies endpoint and the pages object to iterate through the returned companies, there is a limit of 10,000 Companies that can be returned. If you need to list or iterate on more than 10,000 Companies, please use the [Scroll API](https://developers.intercom.com/reference#iterating-over-all-companies).
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.companies().list(
    ListCompaniesRequest
        .builder()
        .page(1)
        .perPage(1)
        .order("desc")
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to return per page. Defaults to 15
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<String>` — `asc` or `desc`. Return the companies in ascending or descending order. Defaults to desc
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.scrollOverAllCompanies() -> Optional&amp;lt;CompanyScroll&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

      The `list all companies` functionality does not work well for huge datasets, and can result in errors and performance problems when paging deeply. The Scroll API provides an efficient mechanism for iterating over all companies in a dataset.

- Each app can only have 1 scroll open at a time. You'll get an error message if you try to have more than one open per app.
- If the scroll isn't used for 1 minute, it expires and calls with that scroll param will fail
- If the end of the scroll is reached, "companies" will be empty and the scroll parameter will expire

{% admonition type="info" name="Scroll Parameter" %}
  You can get the first page of companies by simply sending a GET request to the scroll endpoint.
  For subsequent requests you will need to use the scroll parameter from the response.
{% /admonition %}
{% admonition type="danger" name="Scroll network timeouts" %}
  Since scroll is often used on large datasets network errors such as timeouts can be encountered. When this occurs you will see a HTTP 500 error with the following message:
  "Request failed due to an internal network error. Please restart the scroll operation."
  If this happens, you will need to restart your scroll query: It is not possible to continue from a specific point when using scroll.
{% /admonition %}
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
client.companies().scroll(
    ScrollCompaniesRequest
        .builder()
        .scrollParam("scroll_param")
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

**scrollParam:** `Optional<String>` — 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.attachContactToACompany(id, request) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can attach a company to a single contact.
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
client.unstable().companies().attachContactToACompany(
    AttachContactToACompanyRequest
        .builder()
        .id("id")
        .companyId("6762f09a1bb69f9f2193bb34")
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

**id:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.companies.detachContactFromACompany(contactId, id) -> Company</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can detach a company from a single contact.
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
client.unstable().companies().detachContactFromACompany(
    DetachContactFromACompanyRequest
        .builder()
        .contactId("58a430d35458202d41b1e65b")
        .id("58a430d35458202d41b1e65b")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Notes
<details><summary><code>client.unstable.notes.listCompanyNotes(id) -> NoteList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of notes that are associated to a company.
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
client.unstable().notes().listCompanyNotes(
    ListCompanyNotesRequest
        .builder()
        .id("5f4d3c1c-7b1b-4d7d-a97e-6095715c6632")
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

**id:** `String` — The unique identifier for the company which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.notes.listNotes(id) -> NoteList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of notes that are associated to a contact.
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
client.unstable().notes().listNotes(
    ListNotesRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier of a contact.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.notes.createNote(id, request) -> Note</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add a note to a single contact.
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
client.unstable().notes().createNote(
    CreateNoteRequest
        .builder()
        .id(1)
        .body("Hello")
        .contactId("6762f0ad1bb69f9f2193bb62")
        .adminId("123")
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

**id:** `Integer` — The unique identifier of a given contact.
    
</dd>
</dl>

<dl>
<dd>

**body:** `String` — The text of the note.
    
</dd>
</dl>

<dl>
<dd>

**contactId:** `Optional<String>` — The unique identifier of a given contact.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<String>` — The unique identifier of a given admin.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.notes.retrieveNote(id) -> Note</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single note.
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
client.unstable().notes().retrieveNote(
    RetrieveNoteRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier of a given note
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Contacts
<details><summary><code>client.unstable.contacts.listCompaniesForAContact(id) -> ContactAttachedCompanies</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of companies that are associated to a contact.
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
client.unstable().contacts().listCompaniesForAContact(
    ListCompaniesForAContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
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

**id:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.listSegmentsForAContact(contactId) -> ContactSegments</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of segments that are associated to a contact.
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
client.contacts().listAttachedSegments(
    ListSegmentsAttachedToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.listSubscriptionsForAContact(contactId) -> SubscriptionTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of subscription types that are attached to a contact. These can be subscriptions that a user has 'opted-in' to or has 'opted-out' from, depending on the subscription type.
This will return a list of Subscription Type objects that the contact is associated with.

The data property will show a combined list of:

  1.Opt-out subscription types that the user has opted-out from.
  2.Opt-in subscription types that the user has opted-in to receiving.
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
client.contacts().listAttachedSubscriptions(
    ListAttachedSubscriptionsRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.listTagsForAContact(contactId) -> TagList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all tags that are attached to a specific contact.
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
client.contacts().listAttachedTags(
    ListTagsAttachedToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.showContact(id) -> ShowContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single contact.
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
client.unstable().contacts().showContact(
    ShowContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
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

**id:** `String` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.updateContact(id, request) -> UpdateContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing contact (ie. user or lead).

{% admonition type="info" %}
  This endpoint handles both **contact updates** and **custom object associations**.

  See _`update a contact with an association to a custom object instance`_ in the request/response examples to see the custom object association format.
{% /admonition %}
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
client.unstable().contacts().updateContact(
    UpdateContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
        .email("joebloggs@intercom.io")
        .name("joe bloggs")
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

**id:** `String` — id
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<String>` — The role of the contact.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — A unique identifier for the contact which is given to Intercom
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — The contacts email
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — The contacts phone
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The contacts name
    
</dd>
</dl>

<dl>
<dd>

**avatar:** `Optional<String>` — An image URL containing the avatar of a contact
    
</dd>
</dl>

<dl>
<dd>

**signedUpAt:** `Optional<Integer>` — The time specified for when a contact signed up
    
</dd>
</dl>

<dl>
<dd>

**lastSeenAt:** `Optional<Integer>` — The time when the contact was last seen (either where the Intercom Messenger was installed or when specified manually)
    
</dd>
</dl>

<dl>
<dd>

**ownerId:** `Optional<Integer>` — The id of an admin that has been assigned account ownership of the contact
    
</dd>
</dl>

<dl>
<dd>

**unsubscribedFromEmails:** `Optional<Boolean>` — Whether the contact is unsubscribed from emails
    
</dd>
</dl>

<dl>
<dd>

**languageOverride:** `Optional<String>` — A preferred language setting for the contact, used by Intercom as the language of Fin and the Messenger even if their browser has a different setting. Supports ISO 639-1 two-letter language codes. If an unsupported code is supplied, the field will be set to null.
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, Object>>` — The custom attributes which are set for the contact
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.deleteContact(id) -> ContactDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single contact.
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
client.unstable().contacts().deleteContact(
    DeleteContactRequest
        .builder()
        .id("id")
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

**id:** `String` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.mergeContact(request) -> MergeContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can merge a contact with a `role` of `lead` into a contact with a `role` of `user`.
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
client.contacts().mergeLeadInUser(
    MergeContactsRequest
        .builder()
        .leadId("6762f0d51bb69f9f2193bb7f")
        .contactId("6762f0d51bb69f9f2193bb80")
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

**from:** `Optional<String>` — The unique identifier for the contact to merge away from. Must be a lead.
    
</dd>
</dl>

<dl>
<dd>

**into:** `Optional<String>` — The unique identifier for the contact to merge into. Must be a user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.searchContacts(request) -> ContactList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple contacts by the value of their attributes in order to fetch exactly who you want.

To search for contacts, you need to send a `POST` request to `https://api.intercom.io/contacts/search`.

This will accept a query object in the body which will define your filters in order to search for contacts.

{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `50` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}
### Contact Creation Delay

If a contact has recently been created, there is a possibility that it will not yet be available when searching. This means that it may not appear in the response. This delay can take a few minutes. If you need to be instantly notified it is recommended to use webhooks and iterate to see if they match your search filters.

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiple's there can be:
* There's a limit of max 2 nested filters
* There's a limit of max 15 filters for each AND or OR group

### Searching for Timestamp Fields

All timestamp fields (created_at, updated_at etc.) are indexed as Dates for Contact Search queries; Datetime queries are not currently supported. This means you can only query for timestamp fields by day - not hour, minute or second.
For example, if you search for all Contacts with a created_at value greater (>) than 1577869200 (the UNIX timestamp for January 1st, 2020 9:00 AM), that will be interpreted as 1577836800 (January 1st, 2020 12:00 AM). The search results will then include Contacts created from January 2nd, 2020 12:00 AM onwards.
If you'd like to get contacts created on January 1st, 2020 you should search with a created_at value equal (=) to 1577836800 (January 1st, 2020 12:00 AM).
This behaviour applies only to timestamps used in search queries. The search results will still contain the full UNIX timestamp and be sorted accordingly.

### Accepted Fields

Most key listed as part of the Contacts Model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foorbar"`).

| Field                              | Type                           |
| ---------------------------------- | ------------------------------ |
| id                                 | String                         |
| role                               | String<br>Accepts user or lead |
| name                               | String                         |
| avatar                             | String                         |
| owner_id                           | Integer                        |
| email                              | String                         |
| email_domain                       | String                         |
| phone                              | String                         |
| formatted_phone                    | String                         |
| external_id                        | String                         |
| created_at                         | Date (UNIX Timestamp)          |
| signed_up_at                       | Date (UNIX Timestamp)          |
| updated_at                         | Date (UNIX Timestamp)          |
| last_seen_at                       | Date (UNIX Timestamp)          |
| last_contacted_at                  | Date (UNIX Timestamp)          |
| last_replied_at                    | Date (UNIX Timestamp)          |
| last_email_opened_at               | Date (UNIX Timestamp)          |
| last_email_clicked_at              | Date (UNIX Timestamp)          |
| language_override                  | String                         |
| browser                            | String                         |
| browser_language                   | String                         |
| os                                 | String                         |
| location.country                   | String                         |
| location.region                    | String                         |
| location.city                      | String                         |
| unsubscribed_from_emails           | Boolean                        |
| marked_email_as_spam               | Boolean                        |
| has_hard_bounced                   | Boolean                        |
| ios_last_seen_at                   | Date (UNIX Timestamp)          |
| ios_app_version                    | String                         |
| ios_device                         | String                         |
| ios_app_device                     | String                         |
| ios_os_version                     | String                         |
| ios_app_name                       | String                         |
| ios_sdk_version                    | String                         |
| android_last_seen_at               | Date (UNIX Timestamp)          |
| android_app_version                | String                         |
| android_device                     | String                         |
| android_app_name                   | String                         |
| andoid_sdk_version                 | String                         |
| segment_id                         | String                         |
| tag_id                             | String                         |
| custom_attributes.{attribute_name} | String                         |

### Accepted Operators

{% admonition type="warning" name="Searching based on `created_at`" %}
  You cannot use the `<=` or `>=` operators to search by `created_at`.
{% /admonition %}

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                      | Description                                                      |
| :------- | :------------------------------- | :--------------------------------------------------------------- |
| =        | All                              | Equals                                                           |
| !=       | All                              | Doesn't Equal                                                    |
| IN       | All                              | In<br>Shortcut for `OR` queries<br>Values must be in Array       |
| NIN      | All                              | Not In<br>Shortcut for `OR !` queries<br>Values must be in Array |
| >        | Integer<br>Date (UNIX Timestamp) | Greater than                                                     |
| <       | Integer<br>Date (UNIX Timestamp) | Lower than                                                       |
| ~        | String                           | Contains                                                         |
| !~       | String                           | Doesn't Contain                                                  |
| ^        | String                           | Starts With                                                      |
| $        | String                           | Ends With                                                        |
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
client.unstable().contacts().searchContacts(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.listContacts() -> ContactList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all contacts (ie. users or leads) in your workspace.
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `50` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.contacts().list(
    ListContactsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.createContact(request) -> CreateContactResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new contact (ie. user or lead).
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
client.contacts().create(
    CreateContactRequest.of(
        CreateContactRequestWithEmail
            .builder()
            .email("joebloggs@intercom.io")
            .build()
    )
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.showContactByExternalId(externalId) -> ShowContactByExternalIdResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single contact by external ID. Note that this endpoint only supports users and not leads.
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
client.contacts().showContactByExternalId(
    ShowContactByExternalIdRequest
        .builder()
        .externalId("cdd29344-5e0c-4ef0-ac56-f9ba2979bc27")
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

**externalId:** `String` — The external ID of the user that you want to retrieve
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.archiveContact(id) -> ContactArchived</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can archive a single contact.
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
client.unstable().contacts().archiveContact(
    ArchiveContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
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

**id:** `String` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.unarchiveContact(id) -> ContactUnarchived</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can unarchive a single contact.
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
client.unstable().contacts().unarchiveContact(
    UnarchiveContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
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

**id:** `String` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.contacts.blockContact(id) -> ContactBlocked</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Block a single contact.<br>**Note:** conversations of the contact will also be archived during the process.<br>More details in [FAQ How do I block Inbox spam?](https://www.intercom.com/help/en/articles/8838656-inbox-faqs)
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
client.unstable().contacts().blockContact(
    BlockContactRequest
        .builder()
        .id("63a07ddf05a32042dffac965")
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

**id:** `String` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Subscription Types
<details><summary><code>client.unstable.subscriptionTypes.attachSubscriptionTypeToContact(contactId, request) -> SubscriptionType</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add a specific subscription to a contact. In Intercom, we have two different subscription types based on user consent - opt-out and opt-in:

  1.Attaching a contact to an opt-out subscription type will opt that user out from receiving messages related to that subscription type.

  2.Attaching a contact to an opt-in subscription type will opt that user in to receiving messages related to that subscription type.

This will return a subscription type model for the subscription type that was added to the contact.
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
client.contacts().attachSubscription(
    AttachSubscriptionToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .subscriptionId("37846")
        .consentType("opt_in")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the subscription which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**consentType:** `String` — The consent_type of a subscription, opt_out or opt_in.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.subscriptionTypes.detachSubscriptionTypeToContact(contactId, id) -> SubscriptionType</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove a specific subscription from a contact. This will return a subscription type model for the subscription type that was removed from the contact.
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
client.unstable().subscriptionTypes().detachSubscriptionTypeToContact(
    DetachSubscriptionTypeToContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .id("37846")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the subscription type which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.subscriptionTypes.listSubscriptionTypes() -> SubscriptionTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can list all subscription types. A list of subscription type objects will be returned.
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
client.subscriptionTypes().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tags
<details><summary><code>client.unstable.tags.attachTagToContact(contactId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific contact. This will return a tag object for the tag that was added to the contact.
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
client.tags().tagContact(
    TagContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .tagId("7522907")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.detachTagFromContact(contactId, id) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific contact. This will return a tag object for the tag that was removed from the contact.
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
client.unstable().tags().detachTagFromContact(
    DetachTagFromContactRequest
        .builder()
        .contactId("63a07ddf05a32042dffac965")
        .id("7522907")
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

**contactId:** `String` — The unique identifier for the contact which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.attachTagToConversation(conversationId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific conversation. This will return a tag object for the tag that was added to the conversation.
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
client.tags().tagConversation(
    TagConversationRequest
        .builder()
        .conversationId("64619700005694")
        .tagId("7522907")
        .adminId("780")
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

**conversationId:** `String` — conversation_id
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.detachTagFromConversation(conversationId, id, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific conversation. This will return a tag object for the tag that was removed from the conversation.
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
client.unstable().tags().detachTagFromConversation(
    DetachTagFromConversationRequest
        .builder()
        .conversationId("64619700005694")
        .id("7522907")
        .adminId("123")
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

**conversationId:** `String` — conversation_id
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — id
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.listTags() -> TagList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all tags for a given workspace.

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
client.tags().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.createTag(request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can use this endpoint to perform the following operations:

  **1. Create a new tag:** You can create a new tag by passing in the tag name as specified in "Create or Update Tag Request Payload" described below.

  **2. Update an existing tag:** You can update an existing tag by passing the id of the tag as specified in "Create or Update Tag Request Payload" described below.

  **3. Tag Companies:** You can tag single company or a list of companies. You can tag a company by passing in the tag name and the company details as specified in "Tag Company Request Payload" described below. Also, if the tag doesn't exist then a new one will be created automatically.

  **4. Untag Companies:** You can untag a single company or a list of companies. You can untag a company by passing in the tag id and the company details as specified in "Untag Company Request Payload" described below.

  **5. Tag Multiple Users:** You can tag a list of users. You can tag the users by passing in the tag name and the user details as specified in "Tag Users Request Payload" described below.

Each operation will return a tag object.
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
client.tags().create(
    TagsCreateRequestBody.of(
        CreateOrUpdateTagRequest
            .builder()
            .name("test")
            .build()
    )
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

**request:** `CreateTagRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.findTag(id) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of tags that are on the workspace by their id.
This will return a tag object.
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
client.unstable().tags().findTag(
    FindTagRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier of a given tag
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.deleteTag(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete the details of tags that are on the workspace by passing in the id.
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
client.unstable().tags().deleteTag(
    DeleteTagRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier of a given tag
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.attachTagToTicket(ticketId, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can tag a specific ticket. This will return a tag object for the tag that was added to the ticket.
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
client.tags().tagTicket(
    TagTicketRequest
        .builder()
        .ticketId("64619700005694")
        .tagId("7522907")
        .adminId("780")
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

**ticketId:** `String` — ticket_id
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tags.detachTagFromTicket(ticketId, id, request) -> Tag</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can remove tag from a specific ticket. This will return a tag object for the tag that was removed from the ticket.
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
client.unstable().tags().detachTagFromTicket(
    DetachTagFromTicketRequest
        .builder()
        .ticketId("64619700005694")
        .id("7522907")
        .adminId("123")
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

**ticketId:** `String` — ticket_id
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the tag which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The unique identifier for the admin which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Conversations
<details><summary><code>client.unstable.conversations.listConversations() -> ConversationList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all conversations.

You can optionally request the result page size and the cursor to start after to fetch the result.
{% admonition type="warning" name="Pagination" %}
  You can use pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#pagination-for-list-apis) for more details on how to use the `starting_after` param.
{% /admonition %}
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
client.conversations().list(
    ListConversationsRequest
        .builder()
        .perPage(1)
        .startingAfter("starting_after")
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

**perPage:** `Optional<Integer>` — How many results per page
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — String used to get the next page of conversations.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.createConversation(request) -> Message</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a conversation that has been initiated by a contact (ie. user or lead).
The conversation can be an in-app message only.

{% admonition type="info" name="Sending for visitors" %}
You can also send a message from a visitor by specifying their `user_id` or `id` value in the `from` field, along with a `type` field value of `contact`.
This visitor will be automatically converted to a contact with a lead role once the conversation is created.
{% /admonition %}

This will return the Message model that has been created.

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
client.conversations().create(
    CreateConversationRequest
        .builder()
        .from(
            CreateConversationRequestFrom
                .builder()
                .type(CreateConversationRequestFromType.USER)
                .id("6762f11b1bb69f9f2193bba3")
                .build()
        )
        .body("Hello there")
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

**from:** `CreateConversationRequestFrom` 
    
</dd>
</dl>

<dl>
<dd>

**body:** `String` — The content of the message. HTML is not supported.
    
</dd>
</dl>

<dl>
<dd>

**createdAt:** `Optional<Integer>` — The time the conversation was created as a UTC Unix timestamp. If not provided, the current time will be used. This field is only recommneded for migrating past conversations from another source into Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.retrieveConversation(id) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can fetch the details of a single conversation.

This will return a single Conversation model with all its conversation parts.

{% admonition type="warning" name="Hard limit of 500 parts" %}
The maximum number of conversation parts that can be returned via the API is 500. If you have more than that we will return the 500 most recent conversation parts.
{% /admonition %}

For AI agent conversation metadata, please note that you need to have the agent enabled in your workspace, which is a [paid feature](https://www.intercom.com/help/en/articles/8205718-fin-resolutions#h_97f8c2e671).
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
client.unstable().conversations().retrieveConversation(
    RetrieveConversationRequest
        .builder()
        .id(1)
        .displayAs("plaintext")
        .includeTranslations(true)
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

**id:** `Integer` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**displayAs:** `Optional<String>` — Set to plaintext to retrieve conversation messages in plain text. This affects both the body and subject fields.
    
</dd>
</dl>

<dl>
<dd>

**includeTranslations:** `Optional<Boolean>` — If set to true, conversation parts will be translated to the detected language of the conversation.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.updateConversation(id, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can update an existing conversation.

{% admonition type="info" name="Replying and other actions" %}
If you want to reply to a coveration or take an action such as assign, unassign, open, close or snooze, take a look at the reply and manage endpoints.
{% /admonition %}

{% admonition type="info" %}
  This endpoint handles both **conversation updates** and **custom object associations**.

  See _`update a conversation with an association to a custom object instance`_ in the request/response examples to see the custom object association format.
{% /admonition %}

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
client.unstable().conversations().updateConversation(
    UpdateConversationRequest
        .builder()
        .id(1)
        .displayAs("plaintext")
        .read(true)
        .title("new conversation title")
        .customAttributes(
            new HashMap<String, CustomAttributesValue>() {{
                put("issue_type", CustomAttributesValue.of("Billing"));
                put("priority", CustomAttributesValue.of("High"));
            }}
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

**id:** `Integer` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**displayAs:** `Optional<String>` — Set to plaintext to retrieve conversation messages in plain text. This affects both the body and subject fields.
    
</dd>
</dl>

<dl>
<dd>

**read:** `Optional<Boolean>` — Mark a conversation as read within Intercom.
    
</dd>
</dl>

<dl>
<dd>

**title:** `Optional<String>` — The title given to the conversation
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, CustomAttributesValue>>` 
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The ID of the company that the conversation is associated with. The unique identifier for the company which is given by Intercom. Set to nil to remove company.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.deleteConversation(id) -> ConversationDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single conversation.
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
client.unstable().conversations().deleteConversation(
    DeleteConversationRequest
        .builder()
        .id(1)
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

**id:** `Integer` — id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.searchConversations(request) -> ConversationList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple conversations by the value of their attributes in order to fetch exactly which ones you want.

To search for conversations, you need to send a `POST` request to `https://api.intercom.io/conversations/search`.

This will accept a query object in the body which will define your filters in order to search for conversations.
{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `20` results per page and maximum is `150`.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiple's there can be:
- There's a limit of max 2 nested filters
- There's a limit of max 15 filters for each AND or OR group

### Accepted Fields

Most keys listed in the conversation model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foorbar"`).
The `source.body` field is unique as the search will not be performed against the entire value, but instead against every element of the value separately. For example, when searching for a conversation with a `"I need support"` body - the query should contain a `=` operator with the value `"support"` for such conversation to be returned. A query with a `=` operator and a `"need support"` value will not yield a result.

| Field                                     | Type                                                                                                                                                   |
| :---------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------- |
| id                                        | String                                                                                                                                                 |
| created_at                                | Date (UNIX timestamp)                                                                                                                                  |
| updated_at                                | Date (UNIX timestamp)                                                                                                                                  |
| source.type                               | String<br>Accepted fields are `conversation`, `email`, `facebook`, `instagram`, `phone_call`, `phone_switch`, `push`, `sms`, `twitter` and `whatsapp`. |
| source.id                                 | String                                                                                                                                                 |
| source.delivered_as                       | String                                                                                                                                                 |
| source.subject                            | String                                                                                                                                                 |
| source.body                               | String                                                                                                                                                 |
| source.author.id                          | String                                                                                                                                                 |
| source.author.type                        | String                                                                                                                                                 |
| source.author.name                        | String                                                                                                                                                 |
| source.author.email                       | String                                                                                                                                                 |
| source.url                                | String                                                                                                                                                 |
| contact_ids                               | String                                                                                                                                                 |
| teammate_ids                              | String                                                                                                                                                 |
| admin_assignee_id                         | String                                                                                                                                                 |
| team_assignee_id                          | String                                                                                                                                                 |
| channel_initiated                         | String                                                                                                                                                 |
| open                                      | Boolean                                                                                                                                                |
| read                                      | Boolean                                                                                                                                                |
| state                                     | String                                                                                                                                                 |
| waiting_since                             | Date (UNIX timestamp)                                                                                                                                  |
| snoozed_until                             | Date (UNIX timestamp)                                                                                                                                  |
| tag_ids                                   | String                                                                                                                                                 |
| priority                                  | String                                                                                                                                                 |
| statistics.time_to_assignment             | Integer                                                                                                                                                |
| statistics.time_to_admin_reply            | Integer                                                                                                                                                |
| statistics.time_to_first_close            | Integer                                                                                                                                                |
| statistics.time_to_last_close             | Integer                                                                                                                                                |
| statistics.median_time_to_reply           | Integer                                                                                                                                                |
| statistics.first_contact_reply_at         | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_assignment_at            | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_admin_reply_at           | Date (UNIX timestamp)                                                                                                                                  |
| statistics.first_close_at                 | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_assignment_at             | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_assignment_admin_reply_at | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_contact_reply_at          | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_admin_reply_at            | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_close_at                  | Date (UNIX timestamp)                                                                                                                                  |
| statistics.last_closed_by_id              | String                                                                                                                                                 |
| statistics.count_reopens                  | Integer                                                                                                                                                |
| statistics.count_assignments              | Integer                                                                                                                                                |
| statistics.count_conversation_parts       | Integer                                                                                                                                                |
| conversation_rating.requested_at          | Date (UNIX timestamp)                                                                                                                                  |
| conversation_rating.replied_at            | Date (UNIX timestamp)                                                                                                                                  |
| conversation_rating.score                 | Integer                                                                                                                                                |
| conversation_rating.remark                | String                                                                                                                                                 |
| conversation_rating.contact_id            | String                                                                                                                                                 |
| conversation_rating.admin_d               | String                                                                                                                                                 |
| ai_agent_participated                     | Boolean                                                                                                                                                |
| ai_agent.resolution_state                 | String                                                                                                                                                 |
| ai_agent.last_answer_type                 | String                                                                                                                                                 |
| ai_agent.rating                           | Integer                                                                                                                                                |
| ai_agent.rating_remark                    | String                                                                                                                                                 |
| ai_agent.source_type                      | String                                                                                                                                                 |
| ai_agent.source_title                     | String                                                                                                                                                 |

### Accepted Operators

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type  (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                    | Description                                                  |
| :------- | :----------------------------- | :----------------------------------------------------------- |
| =        | All                            | Equals                                                       |
| !=       | All                            | Doesn't Equal                                                |
| IN       | All                            | In  Shortcut for `OR` queries  Values most be in Array       |
| NIN      | All                            | Not In  Shortcut for `OR !` queries  Values must be in Array |
| >        | Integer  Date (UNIX Timestamp) | Greater (or equal) than                                      |
| <       | Integer  Date (UNIX Timestamp) | Lower (or equal) than                                        |
| ~        | String                         | Contains                                                     |
| !~       | String                         | Doesn't Contain                                              |
| ^        | String                         | Starts With                                                  |
| $        | String                         | Ends With                                                    |
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
client.unstable().conversations().searchConversations(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.replyConversation(id, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can reply to a conversation with a message from an admin or on behalf of a contact, or with a note for admins.
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
client.unstable().conversations().replyConversation(
            ReplyConversationRequest
                .builder()
                .id("123 or \"last\"")
                .body(
                    ReplyConversationRequestBody.of(
                        ContactReplyConversationRequest.of(
                            ContactReplyIntercomUserIdRequest
                                .builder()
                                .messageType("comment")
                                .type("user")
                                .body("Thanks again :)")
                                .intercomUserId("6762f1571bb69f9f2193bbbb")
                                .build()
                        )
                    )
                )
                .build()
        );
    }
}
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

**id:** `String` — The Intercom provisioned identifier for the conversation or the string "last" to reply to the last part of the conversation
    
</dd>
</dl>

<dl>
<dd>

**request:** `ReplyConversationRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.manageConversation(id, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

For managing conversations you can:
- Close a conversation
- Snooze a conversation to reopen on a future date
- Open a conversation which is `snoozed` or `closed`
- Assign a conversation to an admin and/or team.
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
client.unstable().conversations().manageConversation(
    ManageConversationRequest
        .builder()
        .id("123")
        .body(
            ManageConversationRequestBody.close(
                CloseConversationRequest
                    .builder()
                    .type("admin")
                    .adminId("12345")
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

**id:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**request:** `ManageConversationRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.attachContactToConversation(id, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add participants who are contacts to a conversation, on behalf of either another contact or an admin.

{% admonition type="warning" name="Contacts without an email" %}
If you add a contact via the email parameter and there is no user/lead found on that workspace with he given email, then we will create a new contact with `role` set to `lead`.
{% /admonition %}

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
client.unstable().conversations().attachContactToConversation(
    AttachContactToConversationRequest
        .builder()
        .id("123")
        .adminId("12345")
        .customer(
            AttachContactToConversationRequestCustomer.of(
                AttachContactToConversationRequestCustomerIntercomUserId
                    .builder()
                    .intercomUserId("6762f19b1bb69f9f2193bbd4")
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

**id:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<String>` — The `id` of the admin who is adding the new participant.
    
</dd>
</dl>

<dl>
<dd>

**customer:** `Optional<AttachContactToConversationRequestCustomer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.detachContactFromConversation(conversationId, contactId, request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can add participants who are contacts to a conversation, on behalf of either another contact or an admin.

{% admonition type="warning" name="Contacts without an email" %}
If you add a contact via the email parameter and there is no user/lead found on that workspace with he given email, then we will create a new contact with `role` set to `lead`.
{% /admonition %}

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
client.conversations().detachContactAsAdmin(
    DetachContactFromConversationRequest
        .builder()
        .conversationId("123")
        .contactId("123")
        .adminId("5017690")
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

**conversationId:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**contactId:** `String` — The identifier for the contact as given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `String` — The `id` of the admin who is performing the action.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.listHandlingEvents(id) -> HandlingEventList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all pause/resume events for a conversation. These events track when teammates paused or resumed handling a conversation.

Requires the `read_conversations` OAuth scope.
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
client.unstable().conversations().listHandlingEvents(
    ListHandlingEventsRequest
        .builder()
        .id("123")
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

**id:** `String` — The identifier for the conversation as given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.redactConversation(request) -> Conversation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can redact a conversation part or the source message of a conversation (as seen in the source object).

{% admonition type="info" name="Redacting parts and messages" %}
If you are redacting a conversation part, it must have a `body`. If you are redacting a source message, it must have been created by a contact. We will return a `conversation_part_not_redactable` error if these criteria are not met.
{% /admonition %}

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
client.conversations().redactConversationPart(
    RedactConversationRequest.conversationPart(
        RedactConversationRequestConversationPart
            .builder()
            .conversationId("19894788788")
            .conversationPartId("19381789428")
            .build()
    )
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

**request:** `RedactConversationRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.conversations.convertConversationToTicket(id, request) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can convert a conversation to a ticket.
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
client.unstable().conversations().convertConversationToTicket(
    ConvertConversationToTicketRequest
        .builder()
        .id(1)
        .ticketTypeId("53")
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

**id:** `Integer` — The id of the conversation to target
    
</dd>
</dl>

<dl>
<dd>

**ticketTypeId:** `String` — The ID of the type of ticket you want to convert the conversation to
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<Map<String, TicketRequestCustomAttributesValue>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Unstable CustomChannelEvents
<details><summary><code>client.unstable.customChannelEvents.notifyNewConversation(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a new conversation was created in your custom channel/platform. This triggers conversation creation and workflow automations within Intercom for your custom channel integration.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyNewConversation(
    CustomChannelBaseEvent
        .builder()
        .eventId("evt_12345")
        .externalConversationId("conv_67890")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("user_001")
                .name("Jane Doe")
                .email("jane.doe@example.com")
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

**request:** `CustomChannelBaseEvent` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customChannelEvents.notifyNewMessage(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a new message was sent in a conversation on your custom channel/platform. This allows Intercom to process the message and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyNewMessage(
    NotifyNewMessageRequest
        .builder()
        .eventId("evt_54321")
        .externalConversationId("conv_98765")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("user_002")
                .name("John Smith")
                .email("john.smith@example.com")
                .build()
        )
        .body("Hello, I need help with my order.")
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

**body:** `String` — The message content sent by the user.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customChannelEvents.notifyQuickReplySelected(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a user selected a quick reply option in your custom channel/platform. This allows Intercom to process the response and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyQuickReplySelected(
    NotifyQuickReplySelectedRequest
        .builder()
        .eventId("evt_67890")
        .externalConversationId("conv_13579")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("user_003")
                .name("Alice Example")
                .email("alice@example.com")
                .build()
        )
        .quickReplyOptionId("1234")
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

**quickReplyOptionId:** `String` — Id of the selected quick reply option.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customChannelEvents.notifyAttributeCollected(request) -> CustomChannelNotificationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Notifies Intercom that a user provided a response to an attribute collector in your custom channel/platform. This allows Intercom to process the attribute and trigger any relevant workflow automations.
> **Note:** This endpoint is currently under managed availability. Please reach out to your accounts team to discuss access and tailored, hands-on support.
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
client.customChannelEvents().notifyAttributeCollected(
    NotifyAttributeCollectedRequest
        .builder()
        .eventId("evt_24680")
        .externalConversationId("conv_11223")
        .contact(
            CustomChannelContact
                .builder()
                .type(CustomChannelContactType.USER)
                .externalId("user_004")
                .name("Bob Example")
                .email("bob@example.com")
                .build()
        )
        .attribute(
            CustomChannelAttribute
                .builder()
                .id("shipping_address")
                .value("123 Main St, Springfield")
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

**attribute:** `CustomChannelAttribute` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Custom Object Instances
<details><summary><code>client.unstable.customObjectInstances.getCustomObjectInstancesByExternalId(customObjectTypeIdentifier) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch a Custom Object Instance by external_id.
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
client.customObjectInstances().getCustomObjectInstancesByExternalId(
    GetCustomObjectInstancesByExternalIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("external_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customObjectInstances.createCustomObjectInstances(customObjectTypeIdentifier, request) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create or update a custom object instance
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
client.customObjectInstances().createCustomObjectInstances(
    CreateOrUpdateCustomObjectInstanceRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("123")
        .externalCreatedAt(1392036272)
        .externalUpdatedAt(1392036272)
        .customAttributes(
            new HashMap<String, Optional<String>>() {{
                put("order_number", Optional.of("ORDER-12345"));
                put("total_amount", Optional.of("custom_attributes"));
            }}
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — A unique identifier for the Custom Object instance in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**externalCreatedAt:** `Optional<Integer>` — The time when the Custom Object instance was created in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**externalUpdatedAt:** `Optional<Integer>` — The time when the Custom Object instance was last updated in the external system it originated from.
    
</dd>
</dl>

<dl>
<dd>

**customAttributes:** `Optional<Map<String, Optional<String>>>` — The custom attributes which are set for the Custom Object instance.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customObjectInstances.deleteCustomObjectInstancesById(customObjectTypeIdentifier) -> CustomObjectInstanceDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a single Custom Object instance by external_id.
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
client.customObjectInstances().deleteCustomObjectInstancesById(
    DeleteCustomObjectInstancesByIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .externalId("external_id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customObjectInstances.getCustomObjectInstancesById(customObjectTypeIdentifier, id) -> Optional&amp;lt;CustomObjectInstance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetch a Custom Object Instance by id.
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
client.unstable().customObjectInstances().getCustomObjectInstancesById(
    GetCustomObjectInstancesByIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .id("id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The id or external_id of the custom object instance
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.customObjectInstances.deleteCustomObjectInstancesByExternalId(customObjectTypeIdentifier, id) -> CustomObjectInstanceDeleted</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a single Custom Object instance using the Intercom defined id.
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
client.unstable().customObjectInstances().deleteCustomObjectInstancesByExternalId(
    DeleteCustomObjectInstancesByExternalIdRequest
        .builder()
        .customObjectTypeIdentifier("Order")
        .id("id")
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

**customObjectTypeIdentifier:** `String` — The unique identifier of the custom object type that defines the structure of the custom object instance.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The Intercom defined id of the custom object instance
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Data Attributes
<details><summary><code>client.unstable.dataAttributes.lisDataAttributes() -> DataAttributeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all data attributes belonging to a workspace for contacts, companies or conversations.
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
client.dataAttributes().list(
    ListDataAttributesRequest
        .builder()
        .model(DataAttributesListRequestModel.CONTACT)
        .includeArchived(true)
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

**model:** `Optional<LisDataAttributesRequestModel>` — Specify the data attribute model to return.
    
</dd>
</dl>

<dl>
<dd>

**includeArchived:** `Optional<Boolean>` — Include archived attributes in the list. By default we return only non archived data attributes.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataAttributes.createDataAttribute(request) -> DataAttribute</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a data attributes for a `contact` or a `company`.
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
client.unstable().dataAttributes().createDataAttribute(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataAttributes.updateDataAttribute(id, request) -> DataAttribute</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You can update a data attribute.

> 🚧 Updating the data type is not possible
>
> It is currently a dangerous action to execute changing a data attribute's type via the API. You will need to update the type via the UI instead.
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
client.unstable().dataAttributes().updateDataAttribute(
    UpdateDataAttributeRequest
        .builder()
        .id(1)
        .body(new 
            HashMap<String, Object>() {{put("key", "value");
            }})
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

**id:** `Integer` — The data attribute id
    
</dd>
</dl>

<dl>
<dd>

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Data Events
<details><summary><code>client.unstable.dataEvents.lisDataEvents() -> DataEventSummary</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


> 🚧
>
> Please note that you can only 'list' events that are less than 90 days old. Event counts and summaries will still include your events older than 90 days but you cannot 'list' these events individually if they are older than 90 days

The events belonging to a customer can be listed by sending a GET request to `https://api.intercom.io/events` with a user or lead identifier along with a `type` parameter. The identifier parameter can be one of `user_id`, `email` or `intercom_user_id`. The `type` parameter value must be `user`.

- `https://api.intercom.io/events?type=user&user_id={user_id}`
- `https://api.intercom.io/events?type=user&email={email}`
- `https://api.intercom.io/events?type=user&intercom_user_id={id}` (this call can be used to list leads)

The `email` parameter value should be [url encoded](http://en.wikipedia.org/wiki/Percent-encoding) when sending.

You can optionally define the result page size as well with the `per_page` parameter.
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
client.unstable().dataEvents().lisDataEvents(
    LisDataEventsRequest
        .builder()
        .filter(
            LisDataEventsRequestFilter.of(
                LisDataEventsRequestFilterUserId
                    .builder()
                    .userId("user_id")
                    .build()
            )
        )
        .type("type")
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

**filter:** `LisDataEventsRequestFilter` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `String` — The value must be user
    
</dd>
</dl>

<dl>
<dd>

**summary:** `Optional<Boolean>` — summary flag
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataEvents.createDataEvent(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


You will need an Access Token that has write permissions to send Events. Once you have a key you can submit events via POST to the Events resource, which is located at https://api.intercom.io/events, or you can send events using one of the client libraries. When working with the HTTP API directly a client should send the event with a `Content-Type` of `application/json`.

When using the JavaScript API, [adding the code to your app](http://docs.intercom.io/configuring-Intercom/tracking-user-events-in-your-app) makes the Events API available. Once added, you can submit an event using the `trackEvent` method. This will associate the event with the Lead or currently logged-in user or logged-out visitor/lead and send it to Intercom. The final parameter is a map that can be used to send optional metadata about the event.

With the Ruby client you pass a hash describing the event to `Intercom::Event.create`, or call the `track_user` method directly on the current user object (e.g. `user.track_event`).

**NB: For the JSON object types, please note that we do not currently support nested JSON structure.**

| Type            | Description                                                                                                                                                                                                     | Example                                                                           |
| :-------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------- |
| String          | The value is a JSON String                                                                                                                                                                                      | `"source":"desktop"`                                                              |
| Number          | The value is a JSON Number                                                                                                                                                                                      | `"load": 3.67`                                                                    |
| Date            | The key ends with the String `_date` and the value is a [Unix timestamp](http://en.wikipedia.org/wiki/Unix_time), assumed to be in the [UTC](http://en.wikipedia.org/wiki/Coordinated_Universal_Time) timezone. | `"contact_date": 1392036272`                                                      |
| Link            | The value is a HTTP or HTTPS URI.                                                                                                                                                                               | `"article": "https://example.org/ab1de.html"`                                     |
| Rich Link       | The value is a JSON object that contains `url` and `value` keys.                                                                                                                                                | `"article": {"url": "https://example.org/ab1de.html", "value":"the dude abides"}` |
| Monetary Amount | The value is a JSON object that contains `amount` and `currency` keys. The `amount` key is a positive integer representing the amount in cents. The price in the example to the right denotes €349.99.          | `"price": {"amount": 34999, "currency": "eur"}`                                   |

**Lead Events**

When submitting events for Leads, you will need to specify the Lead's `id`.

**Metadata behaviour**

- We currently limit the number of tracked metadata keys to 10 per event. Once the quota is reached, we ignore any further keys we receive. The first 10 metadata keys are determined by the order in which they are sent in with the event.
- It is not possible to change the metadata keys once the event has been sent. A new event will need to be created with the new keys and you can archive the old one.
- There might be up to 24 hrs delay when you send a new metadata for an existing event.

**Event de-duplication**

The API may detect and ignore duplicate events. Each event is uniquely identified as a combination of the following data - the Workspace identifier, the Contact external identifier, the Data Event name and the Data Event created time. As a result, it is **strongly recommended** to send a second granularity Unix timestamp in the `created_at` field.

Duplicated events are responded to using the normal `202 Accepted` code - an error is not thrown, however repeat requests will be counted against any rate limit that is in place.

### HTTP API Responses

- Successful responses to submitted events return `202 Accepted` with an empty body.
- Unauthorised access will be rejected with a `401 Unauthorized` or `403 Forbidden` response code.
- Events sent about users that cannot be found will return a `404 Not Found`.
- Event lists containing duplicate events will have those duplicates ignored.
- Server errors will return a `500` response code and may contain an error message in the body.

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
client.unstable().dataEvents().createDataEvent(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataEvents.dataEventSummaries(request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create event summaries for a user. Event summaries are used to track the number of times an event has occurred, the first time it occurred and the last time it occurred.

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
client.events().summaries(
    ListEventSummariesRequest
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

**userId:** `Optional<String>` — Your identifier for the user.
    
</dd>
</dl>

<dl>
<dd>

**eventSummaries:** `Optional<CreateDataEventSummariesRequestEventSummaries>` — A list of event summaries for the user. Each event summary should contain the event name, the time the event occurred, and the number of times the event occurred. The event name should be a past tense 'verb-noun' combination, to improve readability, for example `updated-plan`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Data Export
<details><summary><code>client.unstable.dataExport.createDataExport(request) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

To create your export job, you need to send a `POST` request to the export endpoint `https://api.intercom.io/export/content/data`.

The only parameters you need to provide are the range of dates that you want exported.

>🚧 Limit of one active job
>
> You can only have one active job per workspace. You will receive a HTTP status code of 429 with the message Exceeded rate limit of 1 pending message data export jobs if you attempt to create a second concurrent job.

>❗️ Updated_at not included
>
> It should be noted that the timeframe only includes messages sent during the time period and not messages that were only updated during this period. For example, if a message was updated yesterday but sent two days ago, you would need to set the created_at_after date before the message was sent to include that in your retrieval job.

>📘 Date ranges are inclusive
>
> Requesting data for 2018-06-01 until 2018-06-30 will get all data for those days including those specified - e.g. 2018-06-01 00:00:00 until 2018-06-30 23:59:99.
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
client.dataExport().create(
    CreateDataExportRequest
        .builder()
        .createdAtAfter(1734519776)
        .createdAtBefore(1734537776)
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

**createdAtAfter:** `Integer` — The start date that you request data for. It must be formatted as a unix timestamp.
    
</dd>
</dl>

<dl>
<dd>

**createdAtBefore:** `Integer` — The end date that you request data for. It must be formatted as a unix timestamp.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataExport.getDataExport(jobIdentifier) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can view the status of your job by sending a `GET` request to the URL
`https://api.intercom.io/export/content/data/{job_identifier}` - the `{job_identifier}` is the value returned in the response when you first created the export job. More on it can be seen in the Export Job Model.

> 🚧 Jobs expire after two days
> All jobs that have completed processing (and are thus available to download from the provided URL) will have an expiry limit of two days from when the export ob completed. After this, the data will no longer be available.
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
client.dataExport().find(
    FindDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataExport.cancelDataExport(jobIdentifier) -> DataExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can cancel your job
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
client.dataExport().cancel(
    CancelDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.dataExport.downloadDataExport(jobIdentifier)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

When a job has a status of complete, and thus a filled download_url, you can download your data by hitting that provided URL, formatted like so: https://api.intercom.io/download/content/data/xyz1234.

Your exported message data will be streamed continuously back down to you in a gzipped CSV format.

> 📘 Octet header required
>
> You will have to specify the header Accept: `application/octet-stream` when hitting this endpoint.
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
client.dataExport().download(
    DownloadDataExportRequest
        .builder()
        .jobIdentifier("job_identifier")
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

**jobIdentifier:** `String` — job_identifier
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Workflows
<details><summary><code>client.unstable.workflows.exportWorkflow(id) -> WorkflowExport</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Export a workflow configuration by its ID. This endpoint returns the complete workflow definition including its steps, targeting rules, and attributes.

This endpoint is designed for EU Data Act compliance, allowing customers to export their workflow configurations.

{% admonition type="warning" name="Unstable API" %}
  This API is currently in the Unstable version. Its behavior may change in future releases.
{% /admonition %}
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
client.unstable().workflows().exportWorkflow(
    ExportWorkflowRequest
        .builder()
        .id("12345")
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

**id:** `String` — The unique identifier for the workflow
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Jobs
<details><summary><code>client.unstable.jobs.status(id) -> Jobs</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the status of job execution.
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
client.unstable().jobs().status(
    JobsStatusRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the job which is given by Intercom
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Macros
<details><summary><code>client.unstable.macros.listMacros() -> MacroList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all macros (saved replies) in your workspace for use in automating responses.

The macros are returned in descending order by updated_at.

**Pagination**

This endpoint uses cursor-based pagination via the `starting_after` parameter. The cursor is a Base64-encoded JSON array containing `[updated_at, id]` of the last item from the previous page.

**Placeholder Transformation**

The API transforms Intercom placeholders to a more standard XML-like format:
- From: `{{user.name | fallback: 'there'}}`
- To: `<attribute key="user.name" default="there"/>`
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
client.unstable().macros().listMacros(
    ListMacrosRequest
        .builder()
        .perPage(1)
        .startingAfter("WzE3MTk0OTM3NTcuMCwgIjEyMyJd")
        .updatedSince(1000000L)
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

**perPage:** `Optional<Integer>` — The number of results per page
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Base64-encoded cursor containing [updated_at, id] for pagination
    
</dd>
</dl>

<dl>
<dd>

**updatedSince:** `Optional<Long>` — Unix timestamp to filter macros updated after this time
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.macros.getMacro(id) -> Optional&amp;lt;Macro&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a single macro (saved reply) by its ID. The macro will only be returned if it is visible to the authenticated user based on its visibility settings.

**Visibility Rules**

A macro is returned based on its `visible_to` setting:
- `everyone`: Always visible to all team members
- `specific_teams`: Only visible if the authenticated user belongs to one of the teams specified in `visible_to_team_ids`

If a macro exists but is not visible to the authenticated user, a 404 error is returned.

**Placeholder Transformation**

The API transforms Intercom placeholders to a more standard XML-like format in the `body` field:
- From: `{{user.name | fallback: 'there'}}`
- To: `<attribute key="user.name" default="there"/>`

Default values in placeholders are HTML-escaped for security.
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
client.unstable().macros().getMacro(
    GetMacroRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier of the macro
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Messages
<details><summary><code>client.unstable.messages.createMessage(request) -> Message</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a message that has been initiated by an admin. The conversation can be either an in-app message, an email, sms or whatsapp.

> 🚧 Sending for visitors
>
> There can be a short delay between when a contact is created and when a contact becomes available to be messaged through the API. A 404 Not Found error will be returned in this case.

This will return the Message model that has been created.

> 🚧 Retrieving Associated Conversations
>
> As this is a message, there will be no conversation present until the contact responds. Once they do, you will have to search for a contact's conversations with the id of the message.
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
client.unstable().messages().createMessage(new 
HashMap<String, Object>() {{put("from", new 
    HashMap<String, Object>() {{put("type", "user");
        put("id", "6762f2341bb69f9f2193bc17");
    }});
    put("body", "heyy");
    put("referer", "https://twitter.com/bob");
}});
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

**request:** `Optional<Object>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.messages.getWhatsAppMessageStatus() -> WhatsappMessageStatusList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves statuses of messages sent from the Outbound module. Currently, this API only supports WhatsApp messages.


This endpoint returns paginated status events for WhatsApp messages sent via the Outbound module, providing
information about delivery state and related message details.
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
client.unstable().messages().getWhatsAppMessageStatus(
    GetWhatsAppMessageStatusRequest
        .builder()
        .rulesetId("ruleset_id")
        .perPage(1)
        .startingAfter("starting_after")
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

**rulesetId:** `String` — The unique identifier for the set of messages to check status for
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — Number of results per page (default 50, max 100)
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Cursor for pagination, used to fetch the next page of results
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## News
<details><summary><code>client.unstable.news.listNewsItems() -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all news items
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
client.news().items().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.createNewsItem(request) -> NewsItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a news item
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
client.news().items().create(
    NewsItemRequest
        .builder()
        .title("Halloween is here!")
        .senderId(991267834)
        .body("<p>New costumes in store for this spooky season</p>")
        .state(NewsItemRequestState.LIVE)
        .deliverSilently(true)
        .labels(
            Optional.of(
                Arrays.asList("Product", "Update", "New")
            )
        )
        .reactions(
            Optional.of(
                Arrays.asList(Optional.of("😆"), Optional.of("😅"))
            )
        )
        .newsfeedAssignments(
            Optional.of(
                Arrays.asList(
                    NewsfeedAssignment
                        .builder()
                        .newsfeedId(53)
                        .publishedAt(1664638214)
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

**request:** `NewsItemRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.retrieveNewsItem(id) -> NewsItem</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single news item.
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
client.unstable().news().retrieveNewsItem(
    RetrieveNewsItemRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.updateNewsItem(id, request) -> NewsItem</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.unstable().news().updateNewsItem(
    UpdateNewsItemRequest
        .builder()
        .id(1)
        .body(
            NewsItemRequest
                .builder()
                .title("Christmas is here!")
                .senderId(991267845)
                .body("<p>New gifts in store for the jolly season</p>")
                .reactions(
                    Optional.of(
                        Arrays.asList(Optional.of("😝"), Optional.of("😂"))
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

**id:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**request:** `NewsItemRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.deleteNewsItem(id) -> DeletedObject</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a single news item.
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
client.unstable().news().deleteNewsItem(
    DeleteNewsItemRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The unique identifier for the news item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.listLiveNewsfeedItems(id) -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all news items that are live on a given newsfeed
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
client.unstable().news().listLiveNewsfeedItems(
    ListLiveNewsfeedItemsRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier for the news feed item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.listNewsfeeds() -> PaginatedResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all newsfeeds
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
client.news().feeds().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.news.retrieveNewsfeed(id) -> Newsfeed</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single newsfeed
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
client.unstable().news().retrieveNewsfeed(
    RetrieveNewsfeedRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier for the news feed item which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Segments
<details><summary><code>client.unstable.segments.listSegments() -> SegmentList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch a list of all segments.
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
client.segments().list(
    ListSegmentsRequest
        .builder()
        .includeCount(true)
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

**includeCount:** `Optional<Boolean>` — It includes the count of contacts that belong to each segment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.segments.retrieveSegment(id) -> Segment</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single segment.
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
client.unstable().segments().retrieveSegment(
    RetrieveSegmentRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identified of a given segment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Switch
<details><summary><code>client.unstable.switch_.createPhoneSwitch(request) -> Optional&amp;lt;PhoneSwitch&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can use the API to deflect phone calls to the Intercom Messenger.
Calling this endpoint will send an SMS with a link to the Messenger to the phone number specified.

If custom attributes are specified, they will be added to the user or lead's custom data attributes.
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
client.unstable().switch_().createPhoneSwitch(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Calls
<details><summary><code>client.unstable.calls.listCalls() -> CallList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a paginated list of calls.
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
client.calls().listCalls(
    ListCallsRequest
        .builder()
        .page(1)
        .perPage(1)
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

**page:** `Optional<Integer>` — The page of results to fetch. Defaults to first page
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — How many results to display per page. Defaults to 25. Max 25.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.showCall(id) -> Call</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a single call by id.
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
client.unstable().calls().showCall(
    ShowCallRequest
        .builder()
        .id("id")
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

**id:** `String` — The id of the call to retrieve
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.showCallRecording(id)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Redirects to a signed URL for the call's recording if it exists.
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
client.unstable().calls().showCallRecording(
    ShowCallRecordingRequest
        .builder()
        .id("id")
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

**id:** `String` — The id of the call
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.showCallTranscript(id) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the transcript for the specified call as a downloadable text file.
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
client.unstable().calls().showCallTranscript(
    ShowCallTranscriptRequest
        .builder()
        .id("id")
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

**id:** `String` — The id of the call
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.listCallsWithTranscripts(request) -> ListCallsWithTranscriptsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve calls by a list of conversation ids and include transcripts when available.
A maximum of 20 `conversation_ids` can be provided. If none are provided or more than 20 are provided, a 400 error is returned.
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
client.calls().listCallsWithTranscripts(
    ListCallsWithTranscriptsRequest
        .builder()
        .conversationIds(
            Arrays.asList("64619700005694", "64619700005695")
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

**conversationIds:** `List<String>` — A list of conversation ids to fetch calls for. Maximum 20.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.registerFinVoiceCall(request) -> AiCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Register a Fin Voice call with Intercom. This endpoint creates an external reference
that links an external call identifier to an Intercom call and conversation.

The call can be from different sources:
- AWS Connect (default)
- Five9
- Zoom Phone
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
client.unstable().calls().registerFinVoiceCall(
    Optional.of(
        RegisterFinVoiceCallRequest
            .builder()
            .phoneNumber("+1234567890")
            .callId("call-123-abc")
            .build()
    )
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

**request:** `Optional<RegisterFinVoiceCallRequest>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.collectFinVoiceCallById(id) -> AiCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve information about a Fin Voice call using the external reference ID.
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
client.unstable().calls().collectFinVoiceCallById(
    CollectFinVoiceCallByIdRequest
        .builder()
        .id(1)
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

**id:** `Integer` — The external reference ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.collectFinVoiceCallByExternalId(externalId) -> AiCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve information about a Fin Voice call using the external call identifier.
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
client.unstable().calls().collectFinVoiceCallByExternalId(
    CollectFinVoiceCallByExternalIdRequest
        .builder()
        .externalId("external_id")
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

**externalId:** `String` — The external call identifier from the call provider
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.calls.collectFinVoiceCallByPhoneNumber(phoneNumber) -> Error</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve information about a Fin Voice call using the phone number.

Returns the most recent matched call for the given phone number, ordered by creation date.
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
client.unstable().calls().collectFinVoiceCallByPhoneNumber(
    CollectFinVoiceCallByPhoneNumberRequest
        .builder()
        .phoneNumber("phone_number")
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

**phoneNumber:** `String` — Phone number in E.164 format
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Teams
<details><summary><code>client.unstable.teams.listTeams() -> TeamList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

This will return a list of team objects for the App.
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
client.teams().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.teams.retrieveTeam(id) -> Team</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single team, containing an array of admins that belong to this team.
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
client.unstable().teams().retrieveTeam(
    RetrieveTeamRequest
        .builder()
        .id("123")
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

**id:** `String` — The unique identifier of a given team.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ticket States
<details><summary><code>client.unstable.ticketStates.listTicketStates() -> TicketStateList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a list of all ticket states for a workspace.
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
client.ticketStates().listTicketStates();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ticket Type Attributes
<details><summary><code>client.unstable.ticketTypeAttributes.createTicketTypeAttribute(ticketTypeId, request) -> Optional&amp;lt;TicketTypeAttribute&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new attribute for a ticket type.
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
client.ticketTypes().attributes().create(
    CreateTicketTypeAttributeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
        .name("Attribute Title")
        .description("Attribute Description")
        .dataType(CreateTicketTypeAttributeRequestDataType.STRING)
        .requiredToCreate(false)
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The name of the ticket type attribute
    
</dd>
</dl>

<dl>
<dd>

**description:** `String` — The description of the attribute presented to the teammate or contact
    
</dd>
</dl>

<dl>
<dd>

**dataType:** `CreateTicketTypeAttributeRequestDataType` — The data type of the attribute
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreate:** `Optional<Boolean>` — Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreateForContacts:** `Optional<Boolean>` — Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**visibleOnCreate:** `Optional<Boolean>` — Whether the attribute is visible to teammates when creating a ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**visibleToContacts:** `Optional<Boolean>` — Whether the attribute is visible to contacts when creating a ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**multiline:** `Optional<Boolean>` — Whether the attribute allows multiple lines of text (only applicable to string attributes)
    
</dd>
</dl>

<dl>
<dd>

**listItems:** `Optional<String>` — A comma delimited list of items for the attribute value (only applicable to list attributes)
    
</dd>
</dl>

<dl>
<dd>

**allowMultipleValues:** `Optional<Boolean>` — Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.ticketTypeAttributes.updateTicketTypeAttribute(ticketTypeId, id, request) -> Optional&amp;lt;TicketTypeAttribute&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update an existing attribute for a ticket type.
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
client.unstable().ticketTypeAttributes().updateTicketTypeAttribute(
    UpdateTicketTypeAttributeRequest
        .builder()
        .ticketTypeId("ticket_type_id")
        .id("id")
        .description("New Attribute Description")
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

**ticketTypeId:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**id:** `String` — The unique identifier for the ticket type attribute which is given by Intercom.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The name of the ticket type attribute
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — The description of the attribute presented to the teammate or contact
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreate:** `Optional<Boolean>` — Whether the attribute is required to be filled in when teammates are creating the ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**requiredToCreateForContacts:** `Optional<Boolean>` — Whether the attribute is required to be filled in when contacts are creating the ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**visibleOnCreate:** `Optional<Boolean>` — Whether the attribute is visible to teammates when creating a ticket in Inbox.
    
</dd>
</dl>

<dl>
<dd>

**visibleToContacts:** `Optional<Boolean>` — Whether the attribute is visible to contacts when creating a ticket in Messenger.
    
</dd>
</dl>

<dl>
<dd>

**multiline:** `Optional<Boolean>` — Whether the attribute allows multiple lines of text (only applicable to string attributes)
    
</dd>
</dl>

<dl>
<dd>

**listItems:** `Optional<String>` — A comma delimited list of items for the attribute value (only applicable to list attributes)
    
</dd>
</dl>

<dl>
<dd>

**allowMultipleValues:** `Optional<Boolean>` — Whether the attribute allows multiple files to be attached to it (only applicable to file attributes)
    
</dd>
</dl>

<dl>
<dd>

**archived:** `Optional<Boolean>` — Whether the attribute should be archived and not shown during creation of the ticket (it will still be present on previously created tickets)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Ticket Types
<details><summary><code>client.unstable.ticketTypes.listTicketTypes() -> TicketTypeList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can get a list of all ticket types for a workspace.
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
client.ticketTypes().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.ticketTypes.createTicketType(request) -> Optional&amp;lt;TicketType&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can create a new ticket type.
> 📘 Creating ticket types.
>
> Every ticket type will be created with two default attributes: _default_title_ and _default_description_.
> For the `icon` propery, use an emoji from [Twemoji Cheatsheet](https://twemoji-cheatsheet.vercel.app/)
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
client.unstable().ticketTypes().createTicketType(new 
HashMap<String, Object>() {{put("key", "value");
}});
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.ticketTypes.getTicketType(id) -> Optional&amp;lt;TicketType&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single ticket type.
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
client.unstable().ticketTypes().getTicketType(
    GetTicketTypeRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the ticket type which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Tickets
<details><summary><code>client.unstable.tickets.replyTicket(id, request) -> TicketReply</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can reply to a ticket with a message from an admin or on behalf of a contact, or with a note for admins.
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
client.unstable().tickets().replyTicket(
            ReplyTicketRequest
                .builder()
                .id("123")
                .body(
                    ReplyTicketRequestBody.of(
                        ContactReplyTicketRequest.of(
                            ContactReplyTicketIntercomUserIdRequest
                                .builder()
                                .messageType("comment")
                                .type("user")
                                .body("Thanks again :)")
                                .intercomUserId("6762f2971bb69f9f2193bc49")
                                .build()
                        )
                    )
                )
                .build()
        );
    }
}
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

**id:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `ReplyTicketRequestBody` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tickets.enqueueCreateTicket(request) -> Jobs</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Enqueues ticket creation for asynchronous processing, returning if the job was enqueued successfully to be processed. We attempt to perform a best-effort validation on inputs before tasks are enqueued. If the given parameters are incorrect, we won't enqueue the job.
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
client.tickets().enqueueCreateTicket(
    EnqueueCreateTicketRequest
        .builder()
        .ticketTypeId("1234")
        .contacts(
            Arrays.asList(
                CreateTicketRequestContactsItem.of(
                    CreateTicketRequestContactsItemId
                        .builder()
                        .id("6762f2d81bb69f9f2193bc54")
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

**skipNotifications:** `Optional<Boolean>` — Option to disable notifications when a Ticket is created.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tickets.getTicket(id) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single ticket.
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
client.unstable().tickets().getTicket(
    GetTicketRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the ticket which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tickets.updateTicket(id, request) -> Optional&amp;lt;Ticket&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can update a ticket.
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
client.unstable().tickets().updateTicket(
    UpdateTicketRequest
        .builder()
        .id("id")
        .ticketAttributes(
            new HashMap<String, Object>() {{
                put("_default_title_", "example");
                put("_default_description_", "there is a problem");
            }}
        )
        .ticketStateId("123")
        .open(true)
        .snoozedUntil(1673609604)
        .adminId(991268011)
        .assigneeId("123")
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

**id:** `String` — The unique identifier for the ticket which is given by Intercom
    
</dd>
</dl>

<dl>
<dd>

**ticketAttributes:** `Optional<Map<String, Object>>` — The attributes set on the ticket.
    
</dd>
</dl>

<dl>
<dd>

**ticketStateId:** `Optional<String>` — The ID of the ticket state associated with the ticket type.
    
</dd>
</dl>

<dl>
<dd>

**companyId:** `Optional<String>` — The ID of the company that the ticket is associated with. The unique identifier for the company which is given by Intercom. Set to nil to remove company.
    
</dd>
</dl>

<dl>
<dd>

**open:** `Optional<Boolean>` — Specify if a ticket is open. Set to false to close a ticket. Closing a ticket will also unsnooze it.
    
</dd>
</dl>

<dl>
<dd>

**isShared:** `Optional<Boolean>` — Specify whether the ticket is visible to users.
    
</dd>
</dl>

<dl>
<dd>

**snoozedUntil:** `Optional<Integer>` — The time you want the ticket to reopen.
    
</dd>
</dl>

<dl>
<dd>

**adminId:** `Optional<Integer>` — The ID of the admin performing ticket update. Needed for workflows execution and attributing actions to specific admins.
    
</dd>
</dl>

<dl>
<dd>

**assigneeId:** `Optional<String>` — The ID of the admin or team to which the ticket is assigned. Set this 0 to unassign it.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tickets.deleteTicket(id) -> DeleteTicketResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can delete a ticket using the Intercom provided ID.
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
client.unstable().tickets().deleteTicket(
    DeleteTicketRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier for the ticket which is given by Intercom.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.tickets.searchTickets(request) -> TicketList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can search for multiple tickets by the value of their attributes in order to fetch exactly which ones you want.

To search for tickets, you send a `POST` request to `https://api.intercom.io/tickets/search`.

This will accept a query object in the body which will define your filters.
{% admonition type="warning" name="Optimizing search queries" %}
  Search queries can be complex, so optimizing them can help the performance of your search.
  Use the `AND` and `OR` operators to combine multiple filters to get the exact results you need and utilize
  pagination to limit the number of results returned. The default is `20` results per page.
  See the [pagination section](https://developers.intercom.com/docs/build-an-integration/learn-more/rest-apis/pagination/#example-search-conversations-request) for more details on how to use the `starting_after` param.
{% /admonition %}

### Nesting & Limitations

You can nest these filters in order to get even more granular insights that pinpoint exactly what you need. Example: (1 OR 2) AND (3 OR 4).
There are some limitations to the amount of multiples there can be:
- There's a limit of max 2 nested filters
- There's a limit of max 15 filters for each AND or OR group

### Accepted Fields

Most keys listed as part of the Ticket model are searchable, whether writeable or not. The value you search for has to match the accepted type, otherwise the query will fail (ie. as `created_at` accepts a date, the `value` cannot be a string such as `"foobar"`).
The `source.body` field is unique as the search will not be performed against the entire value, but instead against every element of the value separately. For example, when searching for a conversation with a `"I need support"` body - the query should contain a `=` operator with the value `"support"` for such conversation to be returned. A query with a `=` operator and a `"need support"` value will not yield a result.

| Field                                     | Type                                                                                     |
| :---------------------------------------- | :--------------------------------------------------------------------------------------- |
| id                                        | String                                                                                   |
| created_at                                | Date (UNIX timestamp)                                                                    |
| updated_at                                | Date (UNIX timestamp)                                                                    |
| title                           | String                                                                                   |
| description                     | String                                                                                   |
| category                                  | String                                                                                   |
| ticket_type_id                            | String                                                                                   |
| contact_ids                               | String                                                                                   |
| teammate_ids                              | String                                                                                   |
| admin_assignee_id                         | String                                                                                   |
| team_assignee_id                          | String                                                                                   |
| open                                      | Boolean                                                                                  |
| state                                     | String                                                                                   |
| snoozed_until                             | Date (UNIX timestamp)                                                                    |
| ticket_attribute.{id}                     | String or Boolean or Date (UNIX timestamp) or Float or Integer                           |

{% admonition type="info" name="Searching by Category" %}
When searching for tickets by the **`category`** field, specific terms must be used instead of the category names:
* For **Customer** category tickets, use the term `request`.
* For **Back-office** category tickets, use the term `task`.
* For **Tracker** category tickets, use the term `tracker`.
{% /admonition %}

### Accepted Operators

{% admonition type="info" name="Searching based on `created_at`" %}
  You may use the `<=` or `>=` operators to search by `created_at`.
{% /admonition %}

The table below shows the operators you can use to define how you want to search for the value.  The operator should be put in as a string (`"="`). The operator has to be compatible with the field's type  (eg. you cannot search with `>` for a given string value as it's only compatible for integer's and dates).

| Operator | Valid Types                    | Description                                                  |
| :------- | :----------------------------- | :----------------------------------------------------------- |
| =        | All                            | Equals                                                       |
| !=       | All                            | Doesn't Equal                                                |
| IN       | All                            | In  Shortcut for `OR` queries  Values most be in Array       |
| NIN      | All                            | Not In  Shortcut for `OR !` queries  Values must be in Array |
| >        | Integer  Date (UNIX Timestamp) | Greater (or equal) than                                      |
| <       | Integer  Date (UNIX Timestamp) | Lower (or equal) than                                        |
| ~        | String                         | Contains                                                     |
| !~       | String                         | Doesn't Contain                                              |
| ^        | String                         | Starts With                                                  |
| $        | String                         | Ends With                                                    |
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
client.unstable().tickets().searchTickets(
    SearchRequest
        .builder()
        .query(
            SearchRequestQuery.of(
                SingleFilterSearchRequest
                    .builder()
                    .value(
                        SingleFilterSearchRequestValue.of()
                    )
                    .build()
            )
        )
        .pagination(
            StartingAfterPaging
                .builder()
                .perPage(5)
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

**request:** `SearchRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Visitors
<details><summary><code>client.unstable.visitors.retrieveVisitorWithUserId() -> Optional&amp;lt;Visitor&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can fetch the details of a single visitor.
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
client.visitors().find(
    FindVisitorRequest
        .builder()
        .userId("user_id")
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

**userId:** `String` — The user_id of the Visitor you want to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.visitors.updateVisitor(request) -> Optional&amp;lt;Visitor&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Sending a PUT request to `/visitors` will result in an update of an existing Visitor.

**Option 1.** You can update a visitor by passing in the `user_id` of the visitor in the Request body.

**Option 2.** You can update a visitor by passing in the `id` of the visitor in the Request body.
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
client.visitors().update(
    UpdateVisitorRequest.of(
        UpdateVisitorRequestWithId
            .builder()
            .id("6762f30c1bb69f9f2193bc5e")
            .name("Gareth Bale")
            .build()
    )
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

**request:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.visitors.convertVisitor(request) -> Contact</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

You can merge a Visitor to a Contact of role type `lead` or `user`.

> 📘 What happens upon a visitor being converted?
>
> If the User exists, then the Visitor will be merged into it, the Visitor deleted and the User returned. If the User does not exist, the Visitor will be converted to a User, with the User identifiers replacing it's Visitor identifiers.
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
client.unstable().visitors().convertVisitor(
    ConvertVisitorRequest
        .builder()
        .type("user")
        .user(new 
            HashMap<String, Object>() {{put("email", "foo@bar.com");
            }})
        .visitor(new 
            HashMap<String, Object>() {{put("user_id", "3ecf64d0-9ed1-4e9f-88e1-da7d6e6782f3");
            }})
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

**type:** `String` — Represents the role of the Contact model. Accepts `lead` or `user`.
    
</dd>
</dl>

<dl>
<dd>

**user:** `Object` 
    
</dd>
</dl>

<dl>
<dd>

**visitor:** `Object` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Brands
<details><summary><code>client.unstable.brands.listBrands() -> BrandList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves all brands for the workspace, including the default brand.
The default brand id always matches the workspace
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
client.unstable().brands().listBrands();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.brands.retrieveBrand(id) -> Brand</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetches a specific brand by its unique identifier
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
client.unstable().brands().retrieveBrand(
    RetrieveBrandRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier of the brand
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Emails
<details><summary><code>client.unstable.emails.listEmails() -> EmailList</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all sender email address settings for the workspace
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
client.unstable().emails().listEmails();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.unstable.emails.retrieveEmail(id) -> EmailSetting</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Fetches a specific email setting by its unique identifier
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
client.unstable().emails().retrieveEmail(
    RetrieveEmailRequest
        .builder()
        .id("id")
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

**id:** `String` — The unique identifier of the email setting
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>
