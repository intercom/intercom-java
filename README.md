# Intercom Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2Fintercom%2Fintercom-java)

The Intercom Java library provides convenient access to the Intercom API from Java.

## Project Updates

### Retirement of Bintray/JCenter

This project was previously publishing releases to JCenter, which is being retired by JFrog on May 1st 2021.

To allow continued access to past versions, we've migrated them to Maven Central.

### Maintenance

We're currently building a new team to provide in-depth and dedicated SDK support.

In the meantime, we'll be operating on limited capacity, meaning all pull requests will be evaluated on a best effort basis and will be limited to critical issues.

We'll communicate all relevant updates as we build this new team and support strategy in the coming months.

- [Installation](#add-a-dependency)
- [Resources](#resources)
- [Authorization](#authorization)
- [Usage](#usage)
- [Idioms](#idioms)
- [Configuration](#configuration)

## Add a dependency

The distribution is hosted on [mavenCentral](https://search.maven.org/artifact/io.intercom/intercom-java).
To use the client, you can add the mavenCentral repository to your dependencies.

### Maven

Add the project declaration to your `pom.xml`:

```xml
<dependency>
  <groupId>io.intercom</groupId>
  <artifactId>intercom-java</artifactId>
  <version>2.8.2</version>
</dependency>
```

### Gradle

Add mavenCentral to your `repositories` block:

```groovy
repositories {
 mavenCentral()
}
```

and add the project to the `dependencies` block in your `build.gradle`:

```groovy
dependencies {
  implementation 'io.intercom:intercom-java:2.8.2'
}  
```

### SBT

Add mavenCentral to your `resolvers` in your `build.sbt`:

```scala
resolvers += "mavenCentral" at "https://repo1.maven.org/maven2"
```

and add the project to your `libraryDependencies` in your `build.sbt`:

```scala
libraryDependencies += "io.intercom" % "intercom-java" % "2.8.2"
```

## Resources

Resources this API supports:

- [Users](#users)
- [Contacts](#contacts)
- [Visitors](#visitors)
- [Companies](#companies)
- [Admins](#admins)
- [Events](#events)
- [Tags](#tags)
- [Segments](#segments)
- [Notes](#notes)
- [Conversations](#conversations)
- [Webhooks](#webhooks)
- [Counts](#counts)

## Authorization

> If you already have an access token you can find it [here](https://app.intercom.com/developers/_). If you want to create or learn more about access tokens then you can find more info [here](https://developers.intercom.io/docs/personal-access-tokens).

```java
# With an OAuth or Access token:
Intercom.setToken("da39a3ee5e6b4b0d3255bfef95601890afd80709");
```

If you are building a third party application you can get your OAuth token by [setting-up-oauth](https://developers.intercom.io/page/setting-up-oauth) for Intercom.

## Usage

Instantiate and use the client with the following:

```java
package com.example.usage;

import com.intercom.api.Intercom;
import com.intercom.api.resources.articles.requests.CreateArticleRequest;
import com.intercom.api.resources.articles.types.CreateArticleRequestState;

public class Example {
    public static void main(String[] args) {
        Intercom client = Intercom
            .builder()
            .token("<token>")
            .build();

        client.articles().create(
            CreateArticleRequest
                .builder()
                .title("Thanks for everything")
                .authorId(1295)
                .description("Description of the Article")
                .body("Body of the Article")
                .state(CreateArticleRequestState.PUBLISHED)
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

try {
    client.articles().create(...);
} catch (IntercomApiApiException e) {
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
as the request is deemed retriable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2).

A request is deemed retriable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` request option to configure this behavior.

```java
import com.intercom.api.core.RequestOptions;

client.articles().create(
    ...,
    RequestOptions
        .builder()
        .maxRetries(1)
        .build()
);
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
client.articles().create(
    ...,
    RequestOptions
        .builder()
        .timeout(10)
        .build()
);
```

## Idioms

### HTTP requests

To signal local versus remote methods, calls that result in HTTP requests are performed
using static methods, for example `User.find()`. The objects returned by static methods
are built from server responses. The exception to the static idiom is where the `next()`,
`hasNext()` and `nextPage()` methods on Collections are used to abstract over pagination.  

### Pagination

Some API classes have static `list()` methods that correspond to paginated API responses.
These return a Collection object (eg `UserCollection`) which can be iterated in two
 ways

- The collection's `getPage()`, `hasNextPage()` and `nextPage()` methods - these are useful when you want to fetch one or just a few pages directly.  

- Java's inbuilt iterator methods `next()` and `hasNext()` - these are useful when you want to fetch data without manually handling pagination.

- User and Contact listing only works up to 10k records. To retrieve all records use the Scroll API via `scroll()`

### Error handling

You do not need to deal with the HTTP response from an API call directly.
If there is an unsuccessful response then an IntercomException or a subclass
of IntercomException will be thrown. The exception will have Error objects
 that can be examined via `getErrorCollection` and `getFirstError` for more detail.

The API throws the following runtime exceptions -

- AuthorizationException: for a 401 or 403 response
- InvalidException: for a 422 response or a local validation failure
- RateLimitException: for a 429 rate limit exceeded response
- ClientException: for a general 4xx response
- ServerException: for a 500 or 503 response
- IntercomException: general exception

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!