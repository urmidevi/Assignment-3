import javax.swing.JOptionPane;

public class HeartRateCalculator {
    public static void main(String[] args) {
        String firstName = null;
        String lastName = null;
        int birthMonth = 0;
        int birthDay = 0;
        int birthYear = 0;

        // Read personal information from user
        try {
            firstName = JOptionPane.showInputDialog("Enter your first name:");
            lastName = JOptionPane.showInputDialog("Enter your last name:");
            birthMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter your birth month (1-12):"));
            birthDay = Integer.parseInt(JOptionPane.showInputDialog("Enter your birth day (1-31):"));
            birthYear = Integer.parseInt(JOptionPane.showInputDialog("Enter your birth year (yyyy):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            System.exit(0);
        }

        HeartRates heartRates = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);

        // Calculate and print maximum and target heart rates
        String output = "Maximum Heart Rate: " + heartRates.calculateMaxHeartRate() + "\n" +
                        "Target Heart Rate Range: " + heartRates.calculateTargetHeartRateRange();
        JOptionPane.showMessageDialog(null, output);
    }
}
