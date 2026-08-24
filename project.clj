(defproject Custom-Z80 "0.1.0-SNAPSHOT"
  :description "A slightly modified version Z80Core, that exposes the interrupt line."
  :url "https://github.com"
  :license {:name "The Apache Software License, Version 2.0"
            :url "http://apache.org"}

  ;; Here we add all the Java files that will be compiled with 'lein uberjar'.
  :java-source-paths ["src/main/java"]

  ;; The Java files need only 1 dependency to compile.
  :dependencies [[com.github.spotbugs/spotbugs-annotations "4.8.6"]]

  ;; This is a big code base. We want to be able to run the JUnit tests when modifying it.
  ;; This Leiningen plugin helps. Now we can run tests with: 'lein with-profile dev junit'.
  :plugins [[lein-junit "1.1.9"]]

  ;; Point junit to the directory where all compiled classes are located.
  :junit ["target/classes"]

  ;; This flexible pattern targets compiled class names containing "Test".
  :junit-test-file-pattern #".*Test.*"

  ;; Development and testing dependencies. These should not be added to the UberJar.
  :profiles {:dev {:dependencies [[junit/junit "4.12"]
                                  [org.mockito/mockito-all "2.0.2-beta"]
                                  [org.hamcrest/hamcrest-all "1.3"]]
                   ;; Inject test paths ONLY when running in development mode
                   :java-source-paths ["src/main/java" "src/test/java"]}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
