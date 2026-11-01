# custom-Z80Processor
This is a fork of Z80Processor (https://github.com/codesqueak/Z80Processor), that exposes the CPU interrupt line.

Specifically version 2.0.2 of Z80Processor is used here. There are newer versions of this library, but v2.0.2 offers superior backwards compatibility all the way back to Java 8.

This project was created for the Sega Master System emulator found here: https://github.com/netb258/defn-system

The original Z80Processor only exposed Non Maskable Interrupts through the Z80Core method "setNMI".

This fork also exposes Maskable interrupts by adding a new Z80Core method "setInterrupt".

Also, a "setSP" method was added (previously only a "getSP" method was available).

# Note on Building and Testing
The original Z80Processor v2.0.2 used Gradle 3 (with out of date deps) to compile the code and run unit tests.

I found it difficult to run this Gradle 3 setup, so I wrote a simple project.clj that allows Leiningen to compile the code and run the tests.

The old gradle setup is also included.

# Building the code
lein clean

lein uberjar

# Running the tests
lein clean

lein with-profile dev junit

# Release version
There is a standalone JAR file in the release section.

## How to make a machine

To make a machine you need three components, the CPU, Memory and I/O.  To see a simple example, look at the test in Z80CoreTest.java. 
