
# Code Coverage
- Is a metric indicating which percentage of lines of code are executed when running automated tests.

- **Unit** and **integration tests** for instance.
> **Integration testing** is a type of testing to check if different pieces of the modules are working together  
> **Unit testing** checks a single component of an application

- Do you know if you need more unit tests? Or if your tests cover all possible branches of an if or switch statements?

- Or if your code coverage is decreasing over time? Especially after you join a team to work on an on-going project.

> Code coverage helps to answer these questions. 

:point_right: ***Keep in mind though, 100% code coverage does not necessary reflects effective testing, as it only reflects the amount of code exercised during tests.***


# SonarQube
SonarSource analyzers do not run your tests or generate reports. They only import pre-generated reports.


# [Jacoco](https://www.eclemma.org/jacoco/index.html), ([GitHub](https://github.com/jacoco/jacoco))
JaCoCo is a free Java code coverage library for analysis in Java VM based environments, uses the standard [JVM Tool Interface](https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html).

During a build a JaCoCo agent attaches itself to a JVM, creates a file "jacoco.exec" which contains the coverage statistics in binary form.

When the JVM starts, and whenever a class is loaded, JaCoCo can use the agent to see when the class is called and what lines are executed. This is how code coverage statistics are collected.

When the JVM terminates it creates the coverage report file. The reports are published in the directory /target/site/jacoco.

The main features of Jacoco are:

- Coverage analysis of instructions (C0), branches (C1), lines, methods, types and cyclomatic complexity.
- Based on Java byte code and therefore works also without source files.
- Simple integration through Java agent based on-the-fly instrumentation. Other integration scenarios like custom class loaders are possible through the API.
- Framework agnostic: Smoothly integrates with Java VM based applications like plain Java programs, OSGi frameworks, web containers or EJB servers.
- Compatible with all released Java class file versions.
- Support for different JVM languages.
- Several report formats (HTML, XML, CSV).
- Remote protocol and JMX control to request execution data dumps from the coverage agent at any point in time.
- Ant tasks to collect and manage execution data and create structured coverage reports.
- Maven plug-in to collect coverage information and create reports in Maven builds.

## Jacoco Rules
Rules on Java elements:

- ***BUNDLE***  
The set of counter limits would have to be met at the application as a whole.

- ***PACKAGE***  
The set of counter limits would have to be met for all packages.

- ***CLASS***  
The set of counter limits would have to be met for every Java class.

- ***SOURCEFILE***  
The set of counter limits would have to be met for the source file.

- ***METHOD***  
The set of counter limits would have to be met for every class method.

Observe: BUNDLE less constraining -> METHOD more constraining

## [Jacoco Coverage Counters](https://www.eclemma.org/jacoco/trunk/doc/counters.html)
JaCoCo uses a set of different counters to calculate coverage metrics:

- ***INSTRUCTION (C0 Coverage)***  
Counts the number of code instructions.  
The smallest unit JaCoCo counts are single Java byte code instructions.  
Instruction coverage provides information about the amount of code that has been executed or missed.

- ***BRANCH (C1 Coverage)***  
Counts the number of execution branches.  
The total number of branches (***if*** and ***switch*** statements) in a method that can be executed or missed. This metric counts the total number of such branches in a method and determines the number of *executed* or *missed* branches.
>> **No coverage**: No branches in the line has been executed (red diamond)  
>> **Partial coverage**: Only a part of the branches in the line have been executed (yellow diamond)  
>> **Full coverage**: All branches in the line have been executed (green diamond)

- [***CYCLOMATIC COMPLEXITY***](https://en.wikipedia.org/wiki/Cyclomatic_complexity)  
It is a quantitative measure of the number of linearly independent paths through a program's source code, the minimum number of paths that can, in (linear) combination, generate all possible paths through a method.  
Thus the complexity value can serve as an indication for the number of unit test cases to fully cover a certain piece of software.  
The formal definition of the cyclomatic complexity v(G) is based on the representation of a method's control flow graph as a directed graph:  
>> **v(G) = E - N + 2**  
Where E is the number of edges and N the number of nodes.  
JaCoCo calculates cyclomatic complexity of a method with the following equivalent equation based on the number of branches (B) and the number of decision points (D):  
>>
>> **v(G) = B - D + 1**  
Based on the coverage status of each branch JaCoCo also calculates covered and missed complexity for each method.  
Missed complexity again is an indication for the number of test cases missing to fully cover a module.  
Note that as JaCoCo does not consider exception handling as branches try/catch blocks will also not increase complexity. 

- ***LINE***  
Counts the number of lines.  
Reflects the amount of code that has been exercised based on the number of ***Java byte code instructions*** called by the tests.
>> **No coverage**: No instruction in the line has been executed (red background)  
>> **Partial coverage**: Only a part of the instruction in the line have been executed (yellow background)  
>> **Full coverage**: All instructions in the line have been executed (green background)

- ***METHOD***  
Counts the number of methods.  
Executed when at least one instruction has been executed.

- ***CLASS***  
Executed when at least one of its methods has been executed

Notice that as you move down in the JaCoCo counters table, the check goal becomes less constraining.

a counter value is one of:

- ***TOTALCOUNT***  
Total number of items

- ***COVEREDCOUNT***  
Absolute number of covered items

- ***MISSEDCOUNT***  
Absolute number of items not covered

- ***COVEREDRATIO***  
Ratio of covered items to uncovered items (i.e. percentage of total items that are covered)

- ***MISSEDRATIO***  
Ratio of items not covered

> If a limit refers to a ratio it must be in the range from 0.0 to 1.0 where the number of decimal places will also determine the precision in error messages.  
> A limit ratio may optionally be declared as a percentage where 0.80 and 80% represent the same value.

# The Maven Plugin

Observation: *Do not set **[forkCount](http://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#forkCount)** to 0 or set **[forkMode](http://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#forkMode)** to never as it would prevent executing the tests with the JaCoCo javaagent and no coverage would be recorded.*

Display help information on jacoco-maven-plugin:
```
$ mvn help:describe -Dplugin=org.jacoco:jacoco-maven-plugin -Ddetail
```

Sample configuration:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>${jacoco.maven.plugin.version}</version>
    <executions>

        <!-- prepare-agent -->
        <execution>
            <id>coverage-initialize</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>

        <!-- report -->
        <execution>
            <id>coverage-report</id>
            <phase>post-integration-test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>

        <!-- check -->
        <execution>
          <id>coverage-check</id>
          <goals>
            <goal>check</goal>
          </goals>
          <configuration>
            <rules>
              <rule>
                <element>CLASS</element>
                <limits>
                  <limit>
                    <counter>LINE</counter>
                    <value>COVEREDRATIO</value>
                    <minimum>80%</minimum>
                  </limit>
                </limits>
              </rule>
            </rules>
          </configuration>
        </execution>

    </executions>
</plugin>
```


Running the test using JUnit will automatically set in motion the JaCoCo agent, thus, it will create a coverage report in binary format in the target directory – target/jacoco.exec.

Obviously we cannot interpret the output single-handedly, but other tools and plugins can – e.g. [Sonar Qube](https://www.sonarqube.org/).

The good news is that we can use the jacoco:report goal in order to generate readable code coverage reports in several formats – e.g. HTML, CSV, and XML.


## [maven goal: prepare-agent](https://www.eclemma.org/jacoco/trunk/doc/prepare-agent-mojo.html)
The **prepare-agent** goal sets up the property **argLine** (for most packaging types) pointing to the JaCoCo runtime agent.

(You can also pass **argLine** as a VM argument. **maven-surefire-plugin** uses **argLine** to set the JVM options to run the tests.)

- Right after the *clean phase* completes, jacoco-maven-plugin’s **prepare-agent** goal *(bound to the Maven’s Build Default Lifecycle’s initialize phase)* sets the **argLine** property pointing to the **JaCoCo Java agent**.

## [maven goal: report](https://www.eclemma.org/jacoco/trunk/doc/report-mojo.html)
The **report** goal creates code coverage reports for tests in **HTML, XML, CSV formats**. 

This goal reads the *dataFile* property value if set, or *target/jacoco.exec*. 
And writes the resulting reports to *outputDirectory* property value or *target/site/jacoco*.

-  jacoco-maven-plugin’s **report** goal *(bound to the Maven’s Build Default Lifecycle’s post-integration-test phase)* generates HTML, XML and CSV reports.

## [maven goal: check](https://www.eclemma.org/jacoco/trunk/doc/check-mojo.html)
The **check** goal validates the coverage rules are met.

In case they are not, it interrupts and fails the build unless **haltOnFailure** property is set to false. 

- jacoco-maven-plugin’s **check** goal *(bound to the Maven’s Build Default Lifecycle’s verify phase)* checks the code coverage metrics are met.



# Refs
- [Jacoco](https://www.eclemma.org/jacoco/trunk/index.html)
- [Jacoco - GitHub](https://github.com/jacoco/jacoco)
- [Reporting Code Coverage using Maven and JaCoCo plugin](https://tech.asimio.net/2019/04/23/Reporting-Code-Coverage-using-Maven-and-JaCoCo-plugin.html)
- [DZone - Reporting Code Coverage Using Maven and JaCoCo Plugin](https://dzone.com/articles/reporting-code-coverage-using-maven-and-jacoco-plu)
- [Baeldung - Intro to JaCoCo](https://www.baeldung.com/jacoco)
- [Scala - SBT plugin](https://www.scala-sbt.org/sbt-jacoco/)
- [Scala - Using JaCoCo as a code coverage tool for Scala](https://blog.developer.atlassian.com/using-jacoco-a-code-coverage-tool-for-scala/)
- [Gradle -Definitive Guide to the JaCoCo Gradle Plugin](https://reflectoring.io/jacoco/)

---
*Creado el 12 de Mayo del 2021 a las 16:21*

