## Provide entry point in manifest
```shell
jar cfe app.jar Main Main.class
```

## Provide manifest file
```shell
jar cmf manifest.txt app.jar *.class
```

## Run with agent
```shell
java -javaagent:agent/agent.jar -jar app/app.jar
```
