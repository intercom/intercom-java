[![Circle CI](https://circleci.com/gh/intercom/intercom-java.png?style=badge)](https://circleci.com/gh/intercom/intercom-java)

# intercom-java

Java bindings for the [Intercom API](https://api.intercom.io/docs)

 - [Installation](#add-a-dependency)
 - [Resources](#resources)
 - [Authorization](#authorization)
 - [Usage](#usage)
 - [Idioms](#idioms)
 - [Configuration](#configuration)


## Add a dependency

[ ![Download](https://api.bintray.com/packages/intercom/intercom-maven/intercom-java/images/download.svg) ](https://bintray.com/intercom/intercom-maven/intercom-java/_latestVersion)

The distribution is hosted on [bintray](https://bintray.com/intercom/intercom-maven/intercom-java/view).
To use the client, you can add the jcenter repository to your dependencies.

### Maven

Add jcenter to your repositories in `pom.xml` or `settings.xml`:

```xml
<repositories>
  <repository>
    <id>jcenter</id>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>
```  

and add the project declaration to your `pom.xml`:

```xml
<dependency>
  <groupId>io.intercom</groupId>
  <artifactId>intercom-java</artifactId>
  <version>2.2.10</version>
</dependency>
```

### Gradle

Add jcenter to your `repositories` block:

```groovy
repositories {
 jcenter()
}
```

and add the project to the `dependencies` block in your `build.gradle`:

```groovy
dependencies {
  compile 'io.intercom:intercom-java:2.2.10'
}  
```

### SBT

Add jcenter to your `resolvers` in your `build.sbt`:

```scala
resolvers += "jcenter" at "http://jcenter.bintray.com"
```

and add the project to your `libraryDependencies` in your `build.sbt`:

```scala
libraryDependencies += "io.intercom" % "intercom-java" % "2.2.10"
```

## Resources

Resources this API supports:

- [Users](#users)
- [Contacts](#contacts)
- [Companies](#companies)
- [Admins](#admins)
- [Events](#events)
- [Tags](#tags)
- [Segments](#segments)
- [Notes](#notes)
- [Conversations](#conversations)
- [Counts](#counts)
- [Webhooks](#webhooks)



## Authorization

> If you already have an access token you can find it [here](https://app.intercom.com/developers/_). If you want to create or learn more about access tokens then you can find more info [here](https://developers.intercom.io/docs/personal-access-tokens).

```java
# With an OAuth or Access token:
Intercom.setToken("da39a3ee5e6b4b0d3255bfef95601890afd80709");
```
If you are building a third party application you can get your OAuth token by [setting-up-oauth](https://developers.intercom.io/page/setting-up-oauth) for Intercom.


## Usage

### Users

```java
// Create a user
User user = new User()
    .setEmail("malcolm@serenity.io")
    .setUserId("1")
    .addCustomAttribute(CustomAttribute.newStringAttribute("role", "sergeant"))
    .addCustomAttribute(CustomAttribute.newBooleanAttribute("browncoat", true));
User created = User.create(user);

// Find user by id
user = User.find("541a144b201ebf2ec5000001");

// Find user by email
Map<String, String> params = Maps.newHashMap();
params.put("email", "malcolm@serenity.io");
user = User.find(params);

// Find user by user_id
params = Maps.newHashMap();
params.put("user_id", "1");
user = User.find(params);

// Update custom_attributes for a user
user.addCustomAttribute(CustomAttribute.newStringAttribute("role", "captain"));
User.update(user);

// Iterate over all users (up to 10k records, to read all use Scroll API)
UserCollection users = User.list();
while(users.hasNext()) {
    System.out.println(users.next().getUserId());
}

// Retrieve users via Scroll API
ScrollableUserCollection usersScroll = User.scroll();
List<User> users = usersScroll.getPage();
usersScroll = usersScroll.scroll();

// Delete a user
User user = User.find("541a144b201ebf2ec5000001");
User.delete(user.getId());
```

### Contacts

_Contacts were added in version 1.1 of the client._

```java
// Create a Contact
Contact contact = new Contact()
    .setEmail("fantastic@serenity.io")
    .addCustomAttribute(newStringAttribute("role", "fence"));
Contact created = Contact.create(contact);

// Find a single contact by server supplied user id or id
contact = Contact.findByID("541a144b201ebf2ec5000002");
contact = Contact.findByUserID("e1a7d875-d83a-46f7-86f4-73be98a98584");

// Update a contact
contact.setName("Stitch Hessian");
Contact updated = Contact.update(contact);

// Read a contact list by email
ContactCollection contacts = Contact.listByEmail("jubal@serenity.io");
while(contacts.hasNext()) {
    System.out.println(contacts.next());
}

// Iterate over all contacts (up to 10k records, to read all use Scroll API)
ContactCollection allContacts = Contact.list();
while(allContacts.hasNext()) {
    System.out.println(allContacts.next());
}

// Retrieve contacts via Scroll API
ScrollableContactCollection contactsScroll = Contact.scroll();
List<Contact> contacts = contactsScroll.getPage();
contactsScroll = contactsScroll.scroll();


// Remove a contact
Contact.delete(contact);

// Convert a contact
User converted = Contact.convert(contact, user);
```

### Companies

```java
// Create a company
Company company = new Company();
    company.setName("Blue Sun");
    company.setCompanyID("1");
    company.setPlan(new Company.Plan("premium"));
    company.addCustomAttribute(CustomAttribute.newIntegerAttribute("foddstuff-items", 246));
    company.addCustomAttribute(CustomAttribute.newStringAttribute("bestseller", "fruity oaty bar"));
Company.create(company);

// Find a company by company_id
map = Maps.newHashMap();
map.put("company_id", "1");
Company company = Company.find(map);

// Find a company by name
map = Maps.newHashMap();
map.put("name", "Blue Sun");
Company company = Company.find(map);

// Find a company by id
Company company = Company.find("541a144b201ebf2ec5000001");

// Update a company
company.setName("Blue Sun Corporation");
Company.update(company);

// Iterate over all companies
CompanyCollection companies = Company.list();
while(companies.hasNext()) {
    System.out.println(companies.next().getName());
}

// Retrieve companies via Scroll API
ScrollableCompanyCollection companiesScroll = Company.scroll();
List<Company> companies = companiesScroll.getPage();
companiesScroll = companiesScroll.scroll();

// Get a list of users in a company
map = Maps.newHashMap();
map.put("company_id", "6");
UserCollection users = Company.listUsers(map);

// Add a user to one or more companies
User user = User.find("541a144b201ebf2ec5000001");
user.addCompany(company);
User.update(user);
```

### Admins

```java
// Iterate over all admins
AdminCollection admins = Admin.list();
while(admins.hasNext()) {
    System.out.println(admins.next().getName());
}
```


### Events

```java
// Create an event with a user ID
// This is only valid for users
Event event = new Event()
    .setEventName("bought-hat")
    .setUserID("1")
    .putMetadata("invitee_email", "jayne@serenity.io")
    .putMetadata("found_date", System.currentTimeMillis())
    .putMetadata("new_signup", true);
Event.create(event);

// Create an event with an email
// This is only valid for users
Event event = new Event()
    .setEventName("bought-hat")
    .setEmail("test@example.com");
Event.create(event);

// Create an event with an ID
// This is valid for both users and leads
Event event = new Event()
        .setEventName("bought-hat")
        .setId("599d6aeeda850883ed8ba7c2");
Event.create(event);
```


### Tags

```java
// create a tag
Tag tag = new Tag().setName("alliance");
tag = Tag.create(tag);

// update a tag
tag.setName("independent");
tag = Tag.update(tag);

// tag and untag users
User one = new User().setEmail("river@serenity.io");
User two = new User().setEmail("simon@serenity.io").untag();
User.create(one);
User.create(two);
Tag.tag(tag, one, two);

// iterate over all tags
final TagCollection tags = Tag.list();
while (tags.hasNext()) {
    System.out.println(tags.next().getId());
}

// tag and untag companies
Company c1 = new Company().setCompanyID("1");
Company c2 = new Company().setCompanyID("2").untag();
Company.create(c1);
Company.create(c2);
Tag.tag(tag, c1, c2);

// delete a tag
Tag.delete(tag);
```

### Segments

```java
// Find a segment
Segment segment = Segment.find("1");

// Update a segment
segment.setName("new name");
Segment.update(segment);

// Iterate over all segments
SegmentCollection segments = Segment.list();
while(segments.hasNext()) {
    System.out.println(segments.next().getId());
}
```

### Notes

```java
// create a user note
User user = new User().setId("5310d8e8598c9a0b24000005");
Author author = new Author().setId("1");
Note note = new Note()
    .setUser(user)
    .setAuthor(author)
    .setBody("The note");
Note.create(note);

// Find a note by id
note = Note.find("1");

// Iterate over all notes for a user via their user_id
Map<String, String> params = Maps.newHashMap();
params.put("user_id", "1");
NoteCollection notes = Note.list(params);
while(notes.hasNext()) {
    System.out.println(notes.next().getBody());
}

// Iterate over all notes for a user via their email address
params = Maps.newHashMap();
params.put("email", "malcolm@serenity.io");
notes = Note.list(params);
while(notes.hasNext()) {
    System.out.println(notes.next().getBody());
}
```

### Conversations

```java
// send a message to a user
User user = new User().setId("5310d8e8598c9a0b24000005");
Admin admin = new Admin().setId("1");
AdminMessage adminMessage = new AdminMessage()
    .setAdmin(admin)
    .setUser(user)
    .setSubject("This Land")
    .setBody("Har har har! Mine is an evil laugh!")
    .setMessageType("email")
    .setTemplate("plain");
Conversation.create(adminMessage);

// send a message from a user
UserMessage userMessage = new UserMessage()
    .setBody("Hey! Is there, is there a reward?")
    .setUser(user);
Conversation.create(userMessage);

// send a message from a contact
ContactMessage contactMessage = new ContactMessage()
    .setBody("Hey! Is there, is there a reward?")
    .setUser(contact);
Conversation.create(contactMessage);

// find admin conversations
Map<String, String> params = Maps.newHashMap();
params.put("type", "admin");
params.put("admin_id", "1");
ConversationCollection adminConversations = Conversation.list(params);
while (adminConversations.hasNext()) {
    Conversation conversation = adminConversations.next();
}

// find user conversations
params = Maps.newHashMap();
params.put("type", "user");
params.put("user_id", "1");
ConversationCollection userConversations = Conversation.list(params);
while (userConversations.hasNext()) {
    Conversation conversation = userConversations.next();
}

// find a conversation by id
final Conversation conversation = Conversation.find("66");
ConversationMessage conversationMessage = conversation.getConversationMessage();
ConversationPartCollection parts = conversation.getConversationPartCollection();
List<ConversationPart> partList = parts.getPage();
for (ConversationPart part : partList) {
    String partType = part.getPartType();
    Author author = part.getAuthor();
    String body = part.getBody();
}
ConversationPart part = conversation.getMostRecentConversationPart();
Admin assignee = conversation.getAssignee();
User user = conversation.getUser();

// Find all open conversations assigned to an admin and render as plaintext
params = Maps.newHashMap();
params.put("type", "admin");
params.put("admin_id", "7");
params.put("display_as", "plaintext");
ConversationCollection openForAdmin = Conversation.list(params);

// admin reply
Admin admin = new Admin().setId("1");
AdminReply adminReply = new AdminReply(admin);
adminReply.setBody("These apples are healthsome");
adminReply.setAttachmentUrls(new String[]{"http://www.example.com/attachment.jpg"}); // optional - list of attachments
Conversation.reply("66", adminReply);

// admin close
Admin admin = new Admin().setId("1");
AdminReply adminReply = new AdminReply(admin);
adminReply.setMessageType("close");
Conversation.reply("66", adminReply);

// user reply
User user1 = new User().setId("5310d8e8598c9a0b24000005");
UserReply userReply = new UserReply(user1);
userReply.setBody("Mighty fine shindig");
userReply.setAttachmentUrls(new String[]{"http://www.example.com/attachment.jpg"}); // optional - list of attachments
System.out.println(MapperSupport.objectMapper().writeValueAsString(userReply));
Conversation.reply("66", userReply);
```

### Webhooks

```java
// create a subscription
Subscription subscription = new Subscription();
subscription.setUrl(new URI("https://example.org/webhooks/1"));
subscription.addTopic(Subscription.Topic.USER_CREATED);
subscription.addTopic(Subscription.Topic.USER_TAG_CREATED);
subscription.addTopic(Subscription.Topic.COMPANY);
subscription.setAppID("pi3243fa");
Subscription.create(subscription);

// find a subscription
subscription = Subscription.find("nsub_60ca7690-4020-11e4-b789-4961958e51bd");

// list subscriptions
SubscriptionCollection list = Subscription.list();
while(list.hasNext()) {
    Subscription sub = list.next();
    String appID = sub.getAppID();
    String serviceType = sub.getServiceType();
    List<Subscription.Topic> topics = sub.getTopics();
    String hubSecret = sub.getHubSecret();
}

// notification sent feed
NotificationCollection sent = Subscription.sentFeed(subscription.getId());
while(sent.hasNext()) {
    Notification notification = sent.next();
    String id = notification.getId();
    String topic = notification.getTopic();
    NotificationData data = notification.getData();
    String type = data.getType();
    // raw map representation of the payload
    Map item = data.getItem();
}

// notification error feed
NotificationErrorCollection errors = Subscription.errorFeed(subscription.getId());
while (errors.hasNext()) {
    NotificationError notificationError = errors.next();
    RequestResponseCapture capture = notificationError.getCapture();
    URI requestURI = capture.getRequestURI();
    String requestMethod = capture.getRequestMethod();
    Map<String, String> requestHeaders = capture.getRequestHeaders();
    String requestEntity = capture.getRequestEntity();
    int statusCode = capture.getResponseStatusCode();
    Map<String, String> responseHeaders = capture.getResponseHeaders();
    String responseEntity = capture.getResponseEntity();
}

// consume a webhook notification
InputStream jsonStream = ...;
final Notification notification = Notification.readJSON(jsonStream);

String jsonString = ...;
final Notification notification = Notification.readJSON(jsonString);
```

### Counts

```java
// app totals
Counts.Totals totals = Counts.appTotals();
System.out.println("companies: " + totals.getCompany().getValue());
System.out.println("segments: :" + totals.getSegment().getValue());
System.out.println("tags: :" + totals.getTag().getValue());
System.out.println("users: :" + totals.getUser().getValue());

// conversation totals
Counts.Conversation conversationTotals = Counts.conversationTotals();
System.out.println("assigned: " + conversationTotals.getAssigned());
System.out.println("closed: :" + conversationTotals.getClosed());
System.out.println("open: :" + conversationTotals.getOpen());
System.out.println("unassigned: :" + conversationTotals.getUnassigned());

// admin open/close counts
Counts.Conversation adminCounts = Counts.conversationAdmins();
List<Admin> admins = adminCounts.getAdmins();
for (Admin admin : admins) {
    System.out.println(admin.getName() + ": " + admin.getClosed() + ", " + admin.getOpen());
}

// tag user counts
System.out.println("tag user counts: ");
List<Counts.CountItem> tags = Counts.userTags();
for (Counts.CountItem tag : tags) {
    System.out.println(tag.getName()+": " +tag.getValue());
}

// segment user counts
List<Counts.CountItem> segments = Counts.userSegments();
for (Counts.CountItem segment : segments) {
    System.out.println(segment.getName()+": " +segment.getValue());
}

// company user counts
List<Counts.CountItem> companyUsers = Counts.companyUsers();
for (Counts.CountItem company : companyUsers) {
    System.out.println(company.getName()+": " +company.getValue());
}

// company tag counts
List<Counts.CountItem> companyTags = Counts.companyTags();
for (Counts.CountItem tag : companyTags) {
    System.out.println(tag.getName()+": " +tag.getValue());
}
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


## Configuration

### HTTP

The client can be configured to accept any http stack that implements
`java.net.HttpURLConnection` by implementing the `HttpConnectorSupplier`
 interface.

For example, to use [OkHttp](http://square.github.io/okhttp/) as a connection
supplier, create a supplier class -

```java
public class OkHttpSupplier implements HttpConnectorSupplier {
    private final OkUrlFactory urlFactory;

    public OkHttpSupplier(OkUrlFactory urlFactory) {
        this.urlFactory = urlFactory;
    }

    @Override
    public HttpURLConnection connect(URI uri) throws IOException {
        return urlFactory.open(uri.toURL());
    }
}
```

and hand a supplier to the Intercom object -

```
final OkHttpClient client = new OkHttpClient();
final OkUrlFactory factory = new OkUrlFactory(client);
final OkHttpSupplier supplier = new OkHttpSupplier(factory);
Intercom.setHttpConnectorSupplier(supplier);
```            

#### Timeouts

The default connection and request timeouts can be set in milliseconds using the
`Intercom.setConnectionTimeout` and `Intercom.setRequestTimeout` methods.


### Target API Server

The base URI to target can be changed for testing purposes

```java
URI baseURI = new URI("https://example.org/server");
Intercom.setApiBaseURI(baseURI);
```
