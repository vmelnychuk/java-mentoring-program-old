## Topics to cover
* Working with Java Data Types
* Object methods
    * `hashCode()`, `equals()`, `toString()`
* Build tools
    * Gradle
        * Multi-module project
* Code quality tools
    * JaCoCo
    * SpotBugs
* Testing
    * JUnit
    * Mockito
* Design pattern
    * Observer

## Materials
* Working with Java Data Types
    * Test for Java Basics [OCA / OCP Practice Tests](http://www.allitebooks.com/oca-ocp-practice-tests/), Chapter 2
    * [Preparation for Java Programmer Language Certification](https://docs.oracle.com/javase/tutorial/extra/certification/index.html)
* Design Patterns
    * Head First Design Patterns, Chapter 2
    * [Observer Design Pattern](https://sourcemaking.com/design_patterns/observer)
    * [Immediate State Updates for REST/HTTP APIs using Observer Pattern](https://60devs.com/immediate-state-updates-for-rest-http-apis-using-observer-pattern.html)
    * [Observer Gotchas](https://martinfowler.com/eaaDev/OrganizingPresentations.html#observer-gotchas)
* Object methods
    * Effective Java (3rd Edition): Joshua Bloch
        * Item 9, Item 10
* Spring Boot
    * [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)

## Practical task
### Part 1
- Add JaCoCo plugin to project **sorter** from week-1 directory. And increase test coverage.
- Add SpotBugs (FindBugs)

### Part 2
Using Observer pattern implement communication between publisher and subscribers
```text
          +----------------+            +----------------+
          |                |            |                |
+---------+  Subscriber 1  |            |  Subscriber 2  +------------------+
|         |                |            |                |                  |
|         +-------+--------+            +------+---------+                  |
|                 ^                            ^                            |
|                 |                            |    POST /feed              |
|                 +---------------+------------+    {News}                  |
|                                 |                                         |
|                                 |                                         |
|                         +-------+---------+                               |
|                         |                 |                               |
+-----------------------> |                 | <-----------------------------+
          POST /subscribe |    Publisher    | POST /unsubscribe
          {Subscribe}     |                 |
                          |                 |
                          +---------+-------+
                                    ^    POST /publish
                                    |    {News}
                                    |
                          +---------+----------+
                          |                    |
                          |       Client       |
                          |                    |
                          | curl POST /publish |
                          |                    |
                          +--------------------+
```
#### Description
- `Publisher` is Spring Boot microservice that has endpoint for publishing news
    - `/publish` endpoint used for publishing news
    - `/subscribe` endpoint for subscription
    - `/unsubscribe` endpoint for cancel subscription
- `Sunscriber` is Spring Boot microservice that subscribes for news
    - `/feed` endpoint is called during distribution of news by `Publisher`

- Possible workflow
    1. Client publish news to `Publisher`
    2. `Publisher` distributes news across subscribers by calling their `/feed` endpoints.
    3. `Subscriber` calls `/unsubscribe` endpoint to cancel subscription.
