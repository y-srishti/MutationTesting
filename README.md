# Mutation Testing for Ticket Price Calculator

## Problem Statement
Mutation testing is applied by introducing mutations (small changes) into the source code of a program. The goal is to verify whether the test cases can detect these mutations and "kill" them, meaning the tests should fail or produce incorrect results when mutations are applied. At least three different mutation operators should be used to evaluate the effectiveness of the test suite.

## What is Mutation Testing?
Mutation testing is a structural testing technique that uses the code’s structure to guide the testing process. It involves making small, deliberate changes (mutations) to the source code to uncover any flaws or weaknesses in the tests. Essentially, it helps identify redundant or ineffective test cases by checking if the tests can detect these changes.

## Types of Mutation Testing:
- *Value Mutations*: These mutations modify values (often constants) in the code, usually by changing them to larger or smaller values, to check if the program handles such changes properly.
- *Decision Mutations*: These mutations modify decision-making structures in the code, such as changing relational or logical operators (e.g., == to !=, or && to ||), to verify that the program’s logic is sound.
- *Statement Mutations*: These mutations alter statements in the code, such as by deleting or duplicating lines, which might arise from errors like copy-pasting. This helps ensure the code does not have redundant or incorrect logic.

## Project Overview and Testing Strategy:
This project focuses on testing a *Ticketing Application* that handles different types of tickets for travel (e.g., train, bus, taxi, ship) and also extends to other services like movies and hotels. The testing strategy involves covering all possible ticket combinations for each transportation mode.

### Example Ticket Types:
- *Bus Ticket*: 
  - Ticket for Child
  - Ticket for Adult
  - Ticket for Senior Citizen

### The following test cases are considered for each ticket type:
1. *calculatePriceForChild*: Tests the price calculation for a single child passenger.
2. *calculatePriceForFamily*: Tests the price calculation for a family consisting of two adults and two children.
3. *calculatePriceForChildNarrowCase*: Tests the edge case where a child’s age is exactly 18 years.
4. *calculatePriceForFreeTicketNarrowCase*: Tests the edge case where a child's age is exactly 3 years (eligible for a free ticket).
5. *shouldNotCalculatePriceForFamilyEdgeCaseWithAdults*: Tests the case where there are two adult passengers and one child.
6. *shouldNotCalculatePriceForFamilyEdgeCaseWithChildren*: Tests the case where there are two child passengers and one adult.
7. *calculatePriceForOneAdult*: Tests the case for a single adult passenger.

This strategy is similarly applied to other ticket types, including airplane, taxi, ship, train, and extends to movies, hotels, and parks.

## Tools and Plugins Used

### 1. *PIT (Pitest)*
PIT is a mutation testing tool that runs your unit tests against automatically modified versions of the application code. When mutations are introduced into the code, the tests should fail, indicating that the test suite can detect these changes. If a unit test does not fail when expected, it may signal an issue with the test coverage or quality.

### 2. *JUnit*
JUnit is a widely used regression testing framework in Java that supports unit testing, helping developers to speed up development while improving code quality. It can be integrated with various tools and frameworks for comprehensive testing and is used in this project for verifying the functionality of the TicketPriceCalculator system.

ticket-price-calculator/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/thedeciders/pitest/
│   │   │       ├── TicketPriceCalculator.java
│   │   │       └── Passenger.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/thedeciders/pitest/
│       │       └── TicketPriceCalculatorTest.java
│       └── resources/
├── pom.xml
└── README.md
