import java.util.Scanner;

/**
 * ShapeArea class asks the user to select a shape and calculates its area.
 *
 * @author  Shem Irekpita
 * @version 1.0
 * @since   2026-10-04
 */
public final class ShapeCalculator {

    /**
     * Private constructor to satisfy Checkstyle utility class requirement.
     */
    private ShapeCalculator() {
    }

    /**
     * Helper method to format and display the calculated area.
     *
     * @param shapeName the name of the shape
     * @param area      the calculated area
     */
    private static void printArea(final String shapeName, final double area) {
        if (area == (long) area) {
            System.out.printf("%s Area: %d%n", shapeName, (long) area);
        } else {
            System.out.printf("%s Area: %.3f%n", shapeName, area);
        }
    }

    /**
     * Main method where the program starts running.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to choose a shape
        System.out.print(
            "Choose a shape to calculate its area "
            + "(Triangle, Trapezoid, Pentagon): "
        );
        String choice = scanner.nextLine().trim();

        // If user picked triangle
        if (choice.equalsIgnoreCase("Triangle")) {
            System.out.println("You selected Triangle.");
            System.out.print("Enter base length: ");
            String baseInput = scanner.nextLine().trim();

            System.out.print("Enter height: ");
            String heightInput = scanner.nextLine().trim();

            try {
                double base = Double.parseDouble(baseInput);
                double height = Double.parseDouble(heightInput);

                if (base <= 0 || height <= 0) {
                    System.out.println("Please enter a positive input.");
                } else {
                    double area = 0.5 * base * height;
                    printArea("Triangle", area);
                }
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number format. "
                    + "Please enter valid numeric values."
                );
            }

        // If user picked trapezoid
        } else if (choice.equalsIgnoreCase("Trapezoid")) {
            System.out.println("You selected Trapezoid.");
            System.out.print("Enter base 1 length: ");
            String baseInput1 = scanner.nextLine().trim();

            System.out.print("Enter base 2 length: ");
            String baseInput2 = scanner.nextLine().trim();

            System.out.print("Enter height: ");
            String heightInput = scanner.nextLine().trim();

            try {
                double base1 = Double.parseDouble(baseInput1);
                double base2 = Double.parseDouble(baseInput2);
                double height = Double.parseDouble(heightInput);

                if (base1 <= 0 || base2 <= 0 || height <= 0) {
                    System.out.println("Please enter a positive input.");
                } else {
                    double area = 0.5 * (base1 + base2) * height;
                    printArea("Trapezoid", area);
                }
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number format. "
                    + "Please enter valid numeric values."
                );
            }

        // If user picked pentagon
        } else if (choice.equalsIgnoreCase("Pentagon")) {
            System.out.println("You selected Pentagon.");
            System.out.print("Enter side length: ");
            String sideInput = scanner.nextLine().trim();

            try {
                double side = Double.parseDouble(sideInput);

                if (side <= 0) {
                    System.out.println("Please enter a positive input.");
                } else {
                    double pentagonFactor =
                        0.25 * Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0)));
                    double area = pentagonFactor * Math.pow(side, 2);
                    printArea("Pentagon", area);
                }
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number format. "
                    + "Please enter valid numeric values."
                );
            }

        // Invalid shape choice
        } else {
            System.out.println("Invalid selection.");
        }

        // Close scanner
        scanner.close();
    }
}
