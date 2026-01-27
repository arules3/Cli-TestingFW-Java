# Cli-TestingFW-Java
This project is created to understand the basics to setup the automation FW with best practices using easy and flexible code to add and execute TestCases through CLI


# CLI Test Case Manager (Java)

A lightweight, command-line based test case management and execution tool built in Java.  
This project demonstrates **core SDET concepts** such as test modeling, execution flow, state management, and result aggregation using clean object-oriented design.

---

##  Project Purpose

The goal of this project is to simulate the **core building blocks of an automation framework** without using Selenium or external test libraries.

It focuses on:
- Clean Java design
- Separation of concerns
- Collections-driven state management
- Post-execution result aggregation

This project was built as part of structured SDET preparation.

---

## High-Level Design

The application is structured into clear layers:

CLI (User Interaction)
└── Repository (Test Storage)
└── Executor (Execution Logic)
└── Aggregator (Result Grouping)

