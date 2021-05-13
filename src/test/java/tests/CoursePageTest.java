package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CoursePage;
import pages.MainPage;

@Epic("Тесты на страницу курсов")
@DisplayName("Тесты на страницу курсов сайта otus")
public class CoursePageTest extends BaseTest {
    MainPage mainPage;
    CoursePage coursePage;

    @Test
    @Story("Проверка курса Разработчик IoT")
    @Description("Тест проверяет заголовок и кнопку записи на странице курса Разработчик IoT")
    @DisplayName("Проверка курса Разработчик IoT")
    public void checkJsCoursePageTest() {
        String expectedCourseName = "Разработчик IoT";
        String expectedButtonName = "Успеть на курс";

        mainPage = new MainPage(driver);
        coursePage = new CoursePage(driver);

        mainPage
                .open()
                .clickMainMenuByName("Курсы")
                .openSecondLevelMenuByName("Программирование")
                .clickSecondLevelMenuByName("Разработчик IoT");

        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));

        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }

    @Test
    @Story("Проверка курса по Machine Learning")
    @Description("Тест проверяет заголовок и кнопку записи на странице курса Machine Learning. Professional")
    @DisplayName("Проверка курса по Machine Learning. Professional")
    public void checkDatabaseCoursePageTest() {
        String expectedCourseName = "Machine Learning. Professional";
        String expectedButtonName = "Вступительное тестирование";

        mainPage = new MainPage(driver);
        coursePage = new CoursePage(driver);

        mainPage
                .open()
                .clickMainMenuByName("Курсы")
                .openSecondLevelMenuByName("Data Science")
                .clickSecondLevelMenuByName("Machine Learning. Professional");

        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));

        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }

    @Test
    @Story("Проверка курса по тестированию Game QA Engineer")
    @Description("Тест проверяет заголовок и кнопку записи на странице курса по тестированию Game QA Engineer")
    @DisplayName("Проверка курса по тестированию Game QA Engineer")
    public void checkJavaQaCoursePageTest() {
        String expectedCourseName = "Game QA Engineer";
        String expectedButtonName = "Вступительное тестирование";

        mainPage = new MainPage(driver);
        coursePage = new CoursePage(driver);

        mainPage
                .open()
                .clickMainMenuByName("Курсы")
                .openSecondLevelMenuByName("Тестирование")
                .clickSecondLevelMenuByName("Game QA Engineer");

        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));

        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }
}
