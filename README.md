# 🚗 Smart Adaptive Cruise Control (SmartACC) Simulation in Java

This is a simple Java program that simulates the core decision-making logic of a **Smart Adaptive Cruise Control (ACC)** system, which acts like a basic AI to dynamically adjust a vehicle's speed based on surrounding traffic and road conditions.

---

## ✨ Features

* **Dynamic Speed Adjustment:** The system increases or decreases the car's speed (in km/h) to maintain a safe and comfortable driving experience.
* **Sensor Simulation:** Uses Java's `Random` class to simulate real-time sensor readings for:
    * Distance to the car ahead.
    * Distances to cars in adjacent lanes (left and right).
    * Road condition (Dry or Wet).
* **Risk-Based Logic:** Implements a simple **risk scoring mechanism** that dictates the control action (hard braking, slight slowdown, or acceleration).
* **Dynamic Safety Distance:** The required safe following distance is automatically increased when the road is wet.

---

## 🛠️ How It Works (The Core Logic)

The simulation runs through **10 cycles**, and in each cycle, it follows these steps:

1.  **Reads Sensors:** Generates random distances for surrounding vehicles and sets the road condition.
2.  **Adjusts Safe Distance:** Sets a higher safe distance ($\mathbf{35 \text{ m}}$) for a wet road and a lower one ($\mathbf{25 \text{ m}}$) for a dry road.
3.  **Computes Risk Level:** Assigns penalty points (risk) based on conditions:
    * **$\mathbf{+3}$** if the front distance is less than the `safeDistance`.
    * **$\mathbf{+2}$** if any adjacent vehicle is too close ($\mathbf{< 15 \text{ m}}$).
    * **$\mathbf{+1}$** if the road is wet.
4.  **Makes Decision:** Adjusts the current car speed based on the total `riskLevel`:

| Risk Level | Decision | Speed Change |
| :---: | :--- | :---: |
| **$\ge 5$** | ⚠️ **High Risk** (Brake Hard) | Speed $\mathbf{-30}$ km/h |
| **$\ge 3$** | ⚠️ **Medium Risk** (Slow Down) | Speed $\mathbf{-10}$ km/h |
| **$\mathbf{1 \text{ or } 2}$** | ✅ **Low Risk** (Slight Accelerate) | Speed $\mathbf{+5}$ km/h |
| **$\mathbf{0}$** | 🟢 **Clear Road** (Accelerate Smoothly) | Speed $\mathbf{+10}$ km/h |

5.  **Displays Status:** Prints the new speed and a Safety Score (calculated as $10 - \text{Risk Level}$).

---

## ▶️ Getting Started

### Prerequisites

* **Java Development Kit (JDK)** installed on your system.

### Running the Simulation

1.  **Save the Code:** Save the provided code into a file named `SmartAdaptiveCruiseControl.java`.
2.  **Compile:** Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the code:
    ```bash
    javac SmartAdaptiveCruiseControl.java
    ```
3.  **Run:** Execute the compiled class file:
    ```bash
    java SmartAdaptiveCruiseControl
    ```

You will see the simulation output, cycle by cycle, showing the changing traffic conditions and the system's dynamic speed adjustments.
