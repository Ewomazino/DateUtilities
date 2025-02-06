import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class DateUtilities {

    /**
     * Displays the number of days in each month for a given year.
     */
    public static void reportMonthLengths(int year) {
        System.out.println("\n📅 Month lengths for the year " + year + ":");
        for (Month month : Month.values()) {
            int days = YearMonth.of(year, month).lengthOfMonth();
            System.out.println(month + ": " + days + " days");
        }
    }

    /**
     * Lists all Mondays in a given month of the current year.
     */
    public static void listMondays(int month) {
        int currentYear = Year.now().getValue();
        YearMonth yearMonth = YearMonth.of(currentYear, month);
        LocalDate date = yearMonth.atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        System.out.println("\n📌 Mondays in " + yearMonth.getMonth() + " " + currentYear + ":");
        while (date.getMonthValue() == month) {
            System.out.println(date);
            date = date.plusWeeks(1); // Move to next Monday
        }
    }

    /**
     * Checks if a given date falls on Friday the 13th.
     */
    public static void checkFridayThe13th(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13) {
            System.out.println("\n😱 " + date + " is a Friday the 13th!");
        } else {
            System.out.println("\n✅ " + date + " is NOT a Friday the 13th.");
        }
    }

    /**
     * Main menu for user interaction.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get year for month-lengths report
        System.out.print("🔢 Enter a year to check month lengths: ");
        int year = scanner.nextInt();
        reportMonthLengths(year);

        // Get month for Monday listing
        System.out.print("\n📅 Enter a month (1-12) to list all Mondays: ");
        int month = scanner.nextInt();
        listMondays(month);

        // Check for Friday the 13th
        System.out.print("\n📆 Enter a year to check for Friday the 13th: ");
        int fYear = scanner.nextInt();
        System.out.print("📆 Enter a month (1-12): ");
        int fMonth = scanner.nextInt();
        System.out.print("📆 Enter a day: ");
        int fDay = scanner.nextInt();
        checkFridayThe13th(fYear, fMonth, fDay);

        System.out.println("\n🎉 Program completed! Have a great day!");
        scanner.close();
    }
}