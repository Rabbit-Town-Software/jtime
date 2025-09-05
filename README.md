# JTime

`JTime` is a lightweight standalone Java library for **game timing and scheduling**.

It provides:
- A flexible **TimeSystem** for simulating in-game clocks (hours, minutes, days).
- A simple **Timer** utility for cooldowns, stopwatches, and delays.
- A **Scheduler** for running tasks after a set delay.

Perfect for RPGs, simulations, and any game that needs time-based mechanics.

---

## Features

- Simulate **day/night cycles** with a progression rate.
- Track in-game **hours, minutes, seconds, days**.
- **Pause/resume/reset** the clock.
- Run callbacks on hour change.
- Simple **cooldown & stopwatch** support via `Timer`.
- Schedule delayed tasks via `Scheduler`.

---

## Installation

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/jtime/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/jtime-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=jtime-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=jtime   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `jtime-1.0.0-sources.jar` and `jtime-1.0.0-javadoc.jar` for inline docs in your IDE.

---

## Usage

### TimeSystem Example
```java
TimeSystem time = new TimeSystem(60f); // 1 real sec = 60 in-game secs

// update each frame
time.update(deltaTime);

// print current in-game time
System.out.println(time.getCurrentTime()); // e.g. 03:45:12
```

### Timer Example
```java
Timer cooldown = new Timer(5f); // 5 second cooldown
cooldown.start();

// update loop
cooldown.update(deltaTime);
if (cooldown.isFinished()) 
{
    System.out.println("Cooldown complete!");
}
```

### Scheduler Example
```java
Scheduler scheduler = new Scheduler();
scheduler.schedule(2f, () -> System.out.println("2 seconds passed!"));

// update each frame
scheduler.update(deltaTime);
```

---
## License

JTime is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/jtime/issues/new)

---


## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>