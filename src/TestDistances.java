// This class contains code to test the methods in the CityDistances class
public class TestDistances {
    // cityPairs is a 2 dimensional array of strings. 
    // Each element is a pair of city names.
    // We will feed these city pairs to the findDistance method of
    // the CityDistances class and see if the results match what we are expecting
    static String[][] cityPairs = {
            { "Boston", "New York" }, // expect 214
            { "Boston", "Miami" }, // expect 1763
            { "Miami", "Boston" }, // try the opposite direction
            { "Miami", "Miami" }, // should be zero
            { "Boston", "Las Vegas" }, // second city not in my list
            { "Las Vegas", "Boston" }, // first city not in my list
            { "Las Vegas", "Phoenix" }, // both cities not in list
    };
    // expectedValues is an array of doubles that contain the results
    // we are expecting when we invoke the findDistance method of CityDistances
    // with the corresponding city pair from cityPairs.
    static double expectedDistanceValues[] = {
            214,
            1763,
            1763,
            0,
            -1,
            -1,
            -1,
            -1
    };

    static String[] closestTestCities = {
        "Boston",
        "Atlanta",
        "Houston"
    };
    static double[] closestExpectedValues = {
        214,
        661,
        239
    };

    // This code feeds each city pair to the findDistance method
    // and compares the expected result with the actual result.
    public static boolean runDistanceTests() {
        boolean passAllTests = true;
        for (int i = 0; i < cityPairs.length; i++) {
            System.out.println("Testing with " + cityPairs[i][0] + " and " + cityPairs[i][1] + "...");
            double dist = CityDistances.findDistance(cityPairs[i][0], cityPairs[i][1]);
            System.out.print("Expected " + expectedDistanceValues[i] + "; got " + dist + "...");
            if (dist == expectedDistanceValues[i]) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
                passAllTests = false;
            }
        }
        return passAllTests;

    }

    public static boolean runClosestTests() {
        boolean passAllTests = true; 
        for (int i=0; i<closestTestCities.length; i++) {
            System.out.print ("Testing with " + closestTestCities[i] + "...");
            double closestDist = CityDistances.closest(closestTestCities[i]);
            System.out.print ("Expected " + closestExpectedValues[i] + "... ");
            System.out.print (" got " + closestDist + "... ");
            if (closestDist == closestExpectedValues[i]) {
                System.out.println("Pass");
            } else {
                passAllTests = false;
                System.out.println("Fail");
            }
        }
        return passAllTests;
    }


    // main just runs the test methods
    public static void main(String[] args) {
        boolean ok = runDistanceTests();
        if (ok) {
            System.out.println ("All getDistance tests pass");

        } else {
            System.out.println("Not all getDistance tests pass");
        }
         ok = runClosestTests();
        if (ok) {
            System.out.println ("All closest tests pass");

        } else {
            System.out.println("Not all closest tests pass");
        }
    }


}
