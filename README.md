# java-stress-simulator
A tool to simulate stressed Java applications.

This code is **not** an example of code to "look up to", quite the contrary ;). I wanted to keep things light and simple, so I avoided some frameworks, but may reconsider them later.

## Technical stack
* Java 11;
* Docker;
* Testcontainers.

## Stress scenarii

* com.mariasube.cedric.java.stress.simulator.stressor.memory.MemoryStressor : Simulate large numbers of objects in memory;
* com.mariasube.cedric.java.stress.simulator.stressor.process.RecursiveProcessStressor : Simulate large numbers of recursive calculations;
* com.mariasube.cedric.java.stress.simulator.stressor.process.IterativeProcessStressor : Simulate large numbers of iterative calculations;
* com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize.CentralizedResourceStressor : Simulate multiple accesses to a same resource;
* com.mariasube.cedric.java.stress.simulator.stressor.database.DatabaseStressor : Simulates calls to a database in order to monitor database requests.

## Run the scenarii

### Build simulator
```mvnw clean compile assembly:single```

### Launch simulator

Main Java class :

```com.mariasube.cedric.java.stress.simulator.JavaStressSimulator```

Run JAR :

```java -jar ./target/java-stress-simulator-1.0-SNAPSHOT-jar-with-dependencies.jar```

### VisualVM configuration

It may be necessary to put the following profile classes in the "Memory settings" :

```com.mariasube.cedric.java.stress.simulator.**```

## Presentations

* [French presentation](presentations/presentation_fr.adoc).
