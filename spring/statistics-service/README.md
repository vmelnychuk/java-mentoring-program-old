## Statistic Service
This is simple statistics service for transactions.
Calculates realtime statistics from last 60 seconds.

## Questions
- Same amount and timestamp for transactions? Is this same instances and should keep only one on it?
- Wrong format of request. Should handle this situation?

### Prerequisites
* JDK 8
* curl
* bash
* IDE with [Lombok](https://projectlombok.org/) plug-in installed and activated.

### Quick Start
Follow these steps to build and run service.
1. Build service.
    ```shell
    ./gradlew clean
    ./gradlew build
    ```
    **Optional**: Check test reports in `build/reports/jacoco/test/html/index.html` file.
2. Start service.
    ```shell
    java -jar build/libs/statistics-service.jar
    ```
3. Run integration tests.
In new shell run integration tests.
    ```shell
    ./gradlew integrationTest
    ```
4. Use service
    ```shell
    # todo
    ```

### Technologies Stack
* Java 8
* Spring Boot
* Gradle
