import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentDateDisplay {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define a date format
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the current date using the defined format
        String formattedDate = currentDate.format(dateFormat);

        // Display the formatted current date
        System.out.println("Current Date: " + formattedDate);
    }
}
