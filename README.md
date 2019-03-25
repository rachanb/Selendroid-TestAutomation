# Selendroid-TestAutomation
Test Automation for the Selendroid

## Pre-requisites
* Appium 1.11
* Java 8
* Maven
* Eclipse IDE with Cucumber Plugin installed
* Android SDK

## Project Structure
* driver - Cucumber TestNG runner
* screens - Page Classes with Page Actions defined
* stepdefinations - Screen and its Steps Defs.
* Features - cucumber features
* resources - contains automation framework config file, testsuite.xml, app (.apk file)

## Dependencies
* Appium Java Client
* Cucumber JVM
* Cucumber Java
* Cucumber testNG
* Log4j

## Test Execution
$ `git clone https://github.com/rachanb/Selendroid-TestAutomation`
$ `mvn clean install`
Results generated under target > cucumber-report folder


