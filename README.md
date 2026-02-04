# Intercom Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2Fintercom%2Fintercom-java)
[![Maven Central](https://img.shields.io/maven-central/v/io.intercom/intercom-java)](https://central.sonatype.com/artifact/io.intercom/intercom-java)

The Intercom Java library provides convenient access to the Intercom APIs from Java.

## Table of Contents

- [Installation](#installation)
- [Reference](#reference)
- [Usage](#usage)
- [Environments](#environments)
- [Base Url](#base-url)
- [Exception Handling](#exception-handling)
- [Advanced](#advanced)
  - [Custom Client](#custom-client)
  - [Retries](#retries)
  - [Timeouts](#timeouts)
  - [Custom Headers](#custom-headers)
  - [Access Raw Response Data](#access-raw-response-data)
- [Contributing](#contributing)

## Installation

### Gradle

Add the dependency in your `build.gradle` file:

```groovy
dependencies {
  implementation 'io.intercom:intercom-java'
}
```

### Maven

Add the dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>io.intercom</groupId>
  <artifactId>intercom-java</artifactId>
  <version>4.0.4</version>
</dependency>
```

## Reference

A full reference for this library is available [here](https://github.com/intercom/intercom-java/blob/HEAD/./reference.md).

## Usage

Instantiate and use the client with the following:

```java
package com.example.usage;

import com.intercom.api.Intercom;
import com.intercom.api.resources.aicontent.requests.CreateContentImportSourceRequest;

public class Example {
    public static void main(String[] args) {
        Intercom client = Intercom
            .builder()
            .token("<token>")
            .build();

        client.aiContent().createContentImportSource(
            CreateContentImportSourceRequest
                .builder()
                .url("https://www.example.com")
                .build()
        );
    }
}
```

## Environments

This SDK allows you to configure different environments for API requests.

```java
import com.intercom.api.Intercom;
import com.intercom.api.core.Environment;

Intercom client = Intercom
    .builder()
    .environment(Environment.USProduction)
    .build();
```

## Base Url

You can set a custom base URL when constructing the client.

```java
import com.intercom.api.Intercom;

Intercom client = Intercom
    .builder()
    .url("https://example.com")
    .build();
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import com.intercom.api.core.IntercomApiApiException;

try{
    client.aiContent().createContentImportSource(...);
} catch (IntercomApiApiException e){
    // Do something with the API exception...
}
```

## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one.
However, you can pass your own client like so:

```java
import com.intercom.api.Intercom;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

Intercom client = Intercom
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2). Before defaulting to exponential backoff, the SDK will first attempt to respect
the `Retry-After` header (as either in seconds or as an HTTP date), and then the `X-RateLimit-Reset` header
(as a Unix timestamp in epoch seconds); failing both of those, it will fall back to exponential backoff.

A request is deemed retryable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` client option to configure this behavior.

```java
import com.intercom.api.Intercom;

Intercom client = Intercom
    .builder()
    .maxRetries(1)
    .build();
```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.

```java
import com.intercom.api.Intercom;
import com.intercom.api.core.RequestOptions;

// Client level
Intercom client = Intercom
    .builder()
    .timeout(10)
    .build();

// Request level
client.aiContent().createContentImportSource(
    ...,
    RequestOptions
        .builder()
        .timeout(10)
        .build()
);
```

### Custom Headers

The SDK allows you to add custom headers to requests. You can configure headers at the client level or at the request level.

```java
import com.intercom.api.Intercom;
import com.intercom.api.core.RequestOptions;

// Client level
Intercom client = Intercom
    .builder()
    .addHeader("X-Custom-Header", "custom-value")
    .addHeader("X-Request-Id", "abc-123")
    .build();
;

// Request level
client.aiContent().createContentImportSource(
    ...,
    RequestOptions
        .builder()
        .addHeader("X-Request-Header", "request-value")
        .build()
);
```

### Access Raw Response Data

The SDK provides access to raw response data, including headers, through the `withRawResponse()` method.
The `withRawResponse()` method returns a raw client that wraps all responses with `body()` and `headers()` methods.
(A normal client's `response` is identical to a raw client's `response.body()`.)

```java
CreateContentImportSourceHttpResponse response = client.aiContent().withRawResponse().createContentImportSource(...);

System.out.println(response.body());
System.out.println(response.headers().get("X-My-Header"));
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!

## For Maintainers

### Regenerating the SDK

This SDK is generated using [Fern](https://buildwithfern.com). To regenerate the SDK after API changes:

#### Prerequisites

- Ensure you have Fern CLI installed
- Navigate to the `fern/` directory of the Fern config repo
- If you only need regeneration without publishing, you can empty credentials in `generators.yml` to skip the publish step:
  ```yaml
  # Example: Clear Maven credentials to skip publish
  username: ""
  password: ""
  signing-key-id: ""
  ```

#### Regeneration Command

```bash
fern generate --group java-sdk
```

#### Common Issues

- **Integration tests failing**: Fix the tests locally and push updates to the PR branch
- **Spotless formatting errors**: Run the Spotless formatter locally to fix formatting issues
- **Maven signing errors**: If publishing is enabled, ensure these environment variables are set:
  - `MAVEN_SIGNING_KEY_ID`
  - `MAVEN_SIGNING_KEY`
  - `MAVEN_SIGNING_PASSWORD`
- **GitHub Actions delays**: If CI is degraded, pipelines may need retries

### Publishing to Maven Central

After regenerating the SDK and merging the PR:

#### 1. Create a Release Tag

Manually create and push a Git tag for the release:

```bash
git tag v4.0.x
git push origin v4.0.x
```

#### 2. Trigger Publish Workflow

The tag push triggers the publish workflow automatically. Ensure the version in the repo config aligns with the intended release.

#### 3. Verify Publication

- Check [Maven Central](https://central.sonatype.com/artifact/io.intercom/intercom-java/overview) for the new version
- Note: Maven Central indexing can take some time to appear

#### Required Credentials

Publishing requires:
- Maven Central credentials (username/password)
- GPG signing key configuration:
  - `MAVEN_SIGNING_KEY_ID`
  - `MAVEN_SIGNING_KEY`
  - `MAVEN_SIGNING_PASSWORD`

Contributors without publish credentials can open regeneration PRs. Team members with credentials can complete the publish steps.

### Example Workflow

1. **Update OpenAPI spec** (if needed): Add overrides in `openapi-overrides.yml` in the Intercom-OpenAPI repo
2. **Regenerate SDK**: Run `fern generate --group java-sdk`
3. **Fix any issues**: Address integration test failures or formatting issues
4. **Create PR**: Open a pull request with the regenerated code
5. **Merge PR**: After review and approval
6. **Tag release**: Create and push a Git tag
7. **Verify publish**: Check Maven Central for the new version

### Related Resources

- [Fern Documentation](https://buildwithfern.com)
- [Maven Central Repository](https://central.sonatype.com/artifact/io.intercom/intercom-java)
- [Intercom OpenAPI Spec](https://github.com/intercom/Intercom-OpenAPI)