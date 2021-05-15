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
    @Story("Проверка курса Python Developer. Professional")
    @Description("Тест проверяет заголовок и кнопку записи на странице курса Python Developer. Professional")
    @DisplayName("Проверка курса Python Developer. Professional")
    public void checkFirstCoursePageTest() {
        String expectedCourseName = "Python Developer. Professional";
        String expectedButtonName = "Вступительное тестирование";

        mainPage = new MainPage(driver);
        coursePage = new CoursePage(driver);

        mainPage
                .open()
                .clickMainMenuByName("Курсы")
                .openSecondLevelMenuByName("Программирование")
                .clickSecondLevelMenuByName("Python Developer. Professional");

        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));

        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }

    @Test
    @Story("Проверка курса по Machine Learning")
    @Description("Тест проверяет заголовок и кнопку записи на странице экспресс курса")
    @DisplayName("Проверка курса по NoSQL")
    public void checkSecondCoursePageTest() {
        String expectedCourseName = "Экспресс-курс \"Версионирование и командная работа с помощью Git\"";
        String expectedButtonName = "Оставить заявку";

        mainPage = new MainPage(driver);
        coursePage = new CoursePage(driver);

        mainPage
                .open()
                .clickMainMenuByName("Курсы")
                .openSecondLevelMenuByName("Инфраструктура")
                .clickSecondLevelMenuByName("Экспресс-курс \"Версионирование и командная работа с помощью Git\"");
        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));

        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }

    @Test
    @Story("Проверка курса по тестированию Game QA Engineer")
    @Description("Тест проверяет заголовок и кнопку записи на странице курса по тестированию Game QA Engineer")
    @DisplayName("Проверка курса по тестированию Game QA Engineer")
    public void checkThirdCoursePageTest() {
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
