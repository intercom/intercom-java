### Changes

#### 2.5.1
- Adding new release due to issues with previous.

#### 2.5.0
- Fix for #207 to remove a non-existent API call (PR #211)
- Fix for #197 to prioritise user_id when tagging users (PR #199)
- Update of Jackson dependencies (PR #203)
- Fix for #197 to prioritise user_id when tagging users (PR #199)
- Fix for #202 to enable retrieving company session count (PR #213)
- Update Gradle (PR #216)
- Add template for Pull Requests (PR #217)
- Removal of Travis (PR #219)

#### 2.4.0
- Fix for gradle release issue #192
- Update related to API user archive and permanent delete option #195

#### 2.3.3
- Fix for #185: scroll issue where requests not reaching endpoint (PR #186)

#### 2.3.2
- fix for #(174) to Handle records with no avatars (#181)

#### 2.3.1
- Updating release versions due to number of new features ebing added
- Add support for deletion by user_id or email (#175)
- Add support for listing events (#173)
- Add support for updating avatars for Users and Contacts/Leads (#174)
- Add support for more message attributes: url, id and attachments (#177)

#### 2.2.12
- Update readme with more list examples (#165)
- Remove restrictions on listing conversations via user and admin (#171)

#### 2.2.11
- Add support for retrieving conversation tags

#### 2.2.10
- Add option to create events with ID
- Fix issues with README headers

#### 2.2.7
- Add scroll to companies

#### 2.2.6
- Add rate limit fields to `RateLimitException` (submitted by @loonydevil)

#### 2.2.5
- Add scroll to contacts and users

#### 2.2.4

- Add phone attribute
- Fix infinite recursive call on get conversation parts

#### 2.2.3

- Add next page size check for pagination

#### 2.2.2

- Add data_type for bulk user actions

#### 2.2.1

- Add attachment support for replies
- Fix remove user from company bug

#### 2.2.0

- Include company custom attributes when updating a user with an embedded company object
- Include support for Personal Access Token API access

#### 2.1.0

- Dynamically retrieve the parts for a conversation if not present

#### 2.0.0

- Fixes subscription metadata deserialization

#### 1.3.1

- Fixes company removal

#### 1.3.0

- Is a rollup of the 1.3.0 beta releases.

#### 1.3.0-b3

- Configure Jackson ObjectMapper once [76](https://github.com/intercom/intercom-java/issues/76)

#### 1.3.0-b2

- Allow users to be removed from companies.

#### 1.3.0-b1

- Support bulk user and event submission. Save your request rate limit for
a rainy day! You can post and delete users, and post events.  

- Add a currentTimestamp() helper to Intercom. This divides currentTimeMillis
by 1000 to produce a second level value.

#### 1.2.1

- Do not send empty company arrays for user updates. Honestly, what's the point?

#### 1.2.0

- Allow conversations to be assigned to others on your team. Conversations
are the most beautiful things, and now you can share them with others through
the API.    

- Support closing and opening conversations, either directly or with a reply.


#### 1.1.2

 - make setUserAgentData public. Previously this was a protected method.

#### 1.1.1

 - add support for [Contact Messaging](https://github.com/intercom/intercom-java#conversations)

#### 1.1.0

 - add support for [Contacts](https://github.com/intercom/intercom-java#contacts)

#### 1.0.9

 - remove secondary getters on user that stop older jackson versions working  [48](https://github.com/intercom/intercom-java/issues/45) (caused in [40](https://github.com/intercom/intercom-java/issues/48)). Doing a bang up job on regression bugs atm.

#### 1.0.8

 - fix user update regression [45](https://github.com/intercom/intercom-java/issues/45) (caused in [40](https://github.com/intercom/intercom-java/issues/40))

 - don't send values for `unsubscribed_from_emails`, `update_last_request_at` or `new_session` unless set

#### 1.0.7

  - handle more kinds of social urls [35](https://github.com/intercom/intercom-java/issues/35)

#### 1.0.6

 - fix user message sending [40](https://github.com/intercom/intercom-java/issues/40)

#### 1.0.5

allow the signed_up_at user field to be submitted

#### 1.0.4

allow the intercom user id field to be submitted

#### 1.0.3

encode social profile urls for user objects

#### 1.0.2

- fix NPE when errors have no data [30](https://github.com/intercom/intercom-java/pull/30)

#### 1.0.1

 - send custom company attributes on update

 - fix NPE when company has no plan on update

 - invalidate setSessionCount on Company [27](https://github.com/intercom/intercom-java/issues/27)

#### 1.0.0

 - removed tag methods requiring collections

 - handle non-json error entities from server

#### 0.1.0

 - support untag of users and companies

 - renamed of current page and page methods on collections (breaking)

#### 0.0.5

- fix bulk user tagging when using fully populated users  [13](https://github.com/intercom/intercom-java/issues/13)
- add client side validation of events  [14](https://github.com/intercom/intercom-java/issues/14)
- fix npe when updating users [15](https://github.com/intercom/intercom-java/issues/15)


#### 0.0.4

- send false boolean values for user updates [8](https://github.com/intercom/intercom-java/issues/8)

#### 0.0.3

- only send allowed fields when adding a company to a user [7](https://github.com/intercom/intercom-java/issues/7)

#### 0.0.2

 - add toString methods on some classes

#### 0.0.1

 - fix bintray publication task (was sending empty jars)

#### 0.0.0

 - initial client
