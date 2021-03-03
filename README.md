# java-stress-simulator
A tool to simulate stressed Java applications.

This code is **not** an example of code to "look up to", quite the contrary ;).

## Stress scenarii

* com.mariasube.cedric.java.stress.simulator.stressor.memory.MemoryStressor : Simulate large numbers of objects in memory;
* com.mariasube.cedric.java.stress.simulator.stressor.process.RecursiveProcessStressor : Simulate large numbers of recursive calculations;
* com.mariasube.cedric.java.stress.simulator.stressor.process.IterativeProcessStressor : Simulate large numbers of iterative calculations;
* com.mariasube.cedric.java.stress.simulator.stressor.memory.centralize.CentralizedResourceStressor : Simulate multiple accesses to a same resource.

## Run the scenarii

### Launch simulator

Main Java class :

```com.mariasube.cedric.java.stress.simulator.JavaStressSimulator```

### VisualVM configuration

It may be necessary to put the following profile classes in the "Memory settings" :

```com.mariasube.cedric.java.stress.simulator.**```

## Presentations

* [French presentation](presentations/presentation_fr.adoc).
