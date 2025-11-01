import java.util.Random;

/**
 * SmartAdaptiveCruiseControl
 * --------------------------
 * A simple Java simulation that demonstrates how an AI-like
 * adaptive cruise control system adjusts vehicle speed dynamically
 * based on surrounding traffic and road conditions.
 *
 * The program uses random values to simulate changing distances
 * to nearby cars and road states, then makes "smart" decisions
 * to maintain safety and comfort.
 */

public class SmartAdaptiveCruiseControl {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        // --- Initial setup ---
        int speed = 80;             // current car speed (km/h)
        int safeDistance = 25;      // safe following distance (meters)
        int minSpeed = 30;          // lower limit of speed
        int maxSpeed = 120;         // upper limit of speed
        int roadCondition;          // 0 = dry road, 1 = wet road

        System.out.println("🚗 SMART ADAPTIVE CRUISE CONTROL SIMULATION 🚗");
        System.out.println("System adjusts car speed using AI-like logic "
                         + "based on traffic distance and road conditions.\n");

        // --- Simulate 10 decision cycles ---
        for (int cycle = 1; cycle <= 10; cycle++) {
            System.out.println("=== Cycle " + cycle + " ===");

            // Randomly generate simulated sensor readings
            int frontDistance = 5 + rand.nextInt(50);    // distance to vehicle ahead
            int leftDistance = 5 + rand.nextInt(60);     // distance to left-lane vehicle
            int rightDistance = 5 + rand.nextInt(60);    // distance to right-lane vehicle
            roadCondition = rand.nextInt(2);             // 0 = dry, 1 = wet

            // Display current environmental conditions
            System.out.println("Front car distance : " + frontDistance + " m");
            System.out.println("Left lane distance  : " + leftDistance + " m");
            System.out.println("Right lane distance : " + rightDistance + " m");
            System.out.println("Road condition      : " + (roadCondition == 0 ? "Dry" : "Wet"));

            // Adjust safe following distance based on road condition
            safeDistance = (roadCondition == 1) ? 35 : 25;

            // --- Compute AI-like risk level ---
            int riskLevel = 0;

            if (frontDistance < safeDistance) riskLevel += 3;   // too close to front car
            if (leftDistance < 15 || rightDistance < 15) riskLevel += 2; // nearby cars
            if (roadCondition == 1) riskLevel += 1;             // add risk for wet surface

            // --- Decision logic based on risk ---
            if (riskLevel >= 5) {
                System.out.println("⚠️  HIGH RISK: Heavy traffic or slippery road → Braking Hard!");
                speed = Math.max(minSpeed, speed - 30);
            } else if (riskLevel >= 3) {
                System.out.println("⚠️  MEDIUM RISK: Slowing down slightly...");
                speed = Math.max(minSpeed, speed - 10);
            } else if (riskLevel == 1 || riskLevel == 2) {
                System.out.println("✅ LOW RISK: Slight acceleration...");
                speed = Math.min(maxSpeed, speed + 5);
            } else {
                System.out.println("🟢 CLEAR ROAD: Smooth acceleration...");
                speed = Math.min(maxSpeed, speed + 10);
            }

            // --- Evaluate safety rating ---
            int safetyScore = Math.max(0, 10 - riskLevel);

            // Display cycle summary
            System.out.println("Current speed : " + speed + " km/h");
            System.out.println("Safety Score  : " + safetyScore + "/10");
            System.out.println("-------------------------------------\n");

            // Add delay for realism
            Thread.sleep(1200);
        }

        System.out.println("✅ Simulation Complete! Smart ACC safely finished all driving cycles.");
    }
}
