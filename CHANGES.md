### Changes

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
