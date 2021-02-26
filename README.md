# java-stress-simulator
A tool to simulate stressed Java applications.

## Stress scenarii

* com.mariasube.cedric.java.stress.simulator.stressor.MemoryStressor : Simulate large numbers of objects in memory;
* com.mariasube.cedric.java.stress.simulator.stressor.process.RecursiveProcessStressor : Simulate large numbers of recursive calculations.
* com.mariasube.cedric.java.stress.simulator.stressor.process.IterativeProcessStressor : Simulate large numbers of iterative calculations.

## Run the scenarii

### Launch simulator

Main class :

```com.mariasube.cedric.java.stress.simulator.JavaStressSimulator```

### VisualVM configuration

It may be necessary to put the following profile classes in the "Memory settings" :

```com.mariasube.cedric.java.stress.simulator.**```
