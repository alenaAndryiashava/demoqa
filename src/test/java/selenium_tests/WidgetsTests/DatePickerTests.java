package selenium_tests.WidgetsTests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.DatePickerPage;
import selenium_tests.TestBase;

import java.text.SimpleDateFormat;
import java.util.*;


public class DatePickerTests extends TestBase {
    DatePickerPage datePickerPage;
    private String testDate;
    private String actualTestDate;
    private String expectedTestDate;
    String time;
    Date date = DateUtils.addDays(new Date(), 7);
    Date datePlusMonth = DateUtils.addMonths(new Date(), 1);
    Date timePlus = DateUtils.addHours(new Date(), 2);
    SimpleDateFormat chooseFormatter;
    SimpleDateFormat actualFormatter;
    SimpleDateFormat timeFormatter;
    SimpleDateFormat actualDateTimeFormatter;

    public String getRandomMin() {
        List<String> min = Arrays.asList("00", "15", "30", "45");
        Random random = new Random();
        int randomIndex = random.nextInt(min.size());
        return min.get(randomIndex);
    }

    @BeforeMethod
    public void preconditions() {
        chooseFormatter = new SimpleDateFormat("EEEE, MMMM d'th', yyyy", Locale.UK);
        actualFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String randomMin = getRandomMin();
        timeFormatter = new SimpleDateFormat("HH:" + randomMin);
        actualDateTimeFormatter = new SimpleDateFormat("MMMM d, yyyy h:" + randomMin + " aa");
        new HomePage(driver).openWidgetsPage();
        new SideMenu(driver).openDatePicker();
    }

    @Test
    public void chooseDateTest() {
        testDate = chooseFormatter.format(date);
        expectedTestDate = actualFormatter.format(date);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void choseDataPlusMonthTest() {
        testDate = chooseFormatter.format(datePlusMonth);
        expectedTestDate = actualFormatter.format(datePlusMonth);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.getNextMonth();
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void chooseDateTimeTest() {
        testDate = chooseFormatter.format(timePlus);
        expectedTestDate = actualDateTimeFormatter.format(timePlus);
        time = timeFormatter.format(timePlus);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getDateTimeCalendar());
        datePickerPage.chooseDate(testDate);
        datePickerPage.chooseTime(time);
        actualTestDate = datePickerPage.getDateTimeFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }
}
