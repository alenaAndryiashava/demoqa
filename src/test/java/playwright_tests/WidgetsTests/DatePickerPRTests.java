package playwright_tests.WidgetsTests;

import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DatePickerPRTests extends TestBasePR {
    @Test
    public void datePickerSelectTomorrow() {
        page.navigate("https://demoqa.com/date-picker");

        page.locator("#datePickerMonthYearInput").click();

        LocalDateTime todayDate = LocalDateTime.now();
        System.out.println(todayDate);
        LocalDateTime tomorrowDate = todayDate.plusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String tomorrowDateFormatted = tomorrowDate.format(formatter);
        System.out.println(tomorrowDateFormatted);

        page.locator("//div[contains(@class, 'today')]/following-sibling::div[1]")
                .click();

        assertThat(page.locator("#datePickerMonthYearInput"))
                .hasValue(tomorrowDateFormatted);
    }

    @Test
    public void datePickerSelectTomorrowIfSaturday() {
        page.navigate("https://demoqa.com/date-picker");

        page.locator("#datePickerMonthYearInput").click();
        LocalDateTime todayDate = LocalDateTime.now();
        System.out.println(todayDate);

        LocalDateTime dateToSelect = todayDate.plusDays(1);
        System.out.println(dateToSelect);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String selectedDateFormatted = dateToSelect.format(formatter);
        System.out.println(selectedDateFormatted);

        String weekDay = todayDate.getDayOfWeek().toString();

        if (weekDay.equals("SATURDAY")) {
            page.locator("//div[contains(@class, 'today')]/following::div[1]/div[1]").click();
        } else {
            page.locator("//div[contains(@class, 'today')]/following-sibling::div[1]").click();
        }
        assertThat(page.locator("#datePickerMonthYearInput"))
                .hasValue(selectedDateFormatted);

    }
}
