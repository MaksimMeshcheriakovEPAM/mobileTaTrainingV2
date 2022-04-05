package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import setup.BaseTest;
import pages.web.SearchGooglePage;
import pages.web.WebIndexPage;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class webMobileTests extends BaseTest {

    @SneakyThrows
    @Test(groups = {"web"}, description = "Open Google search page and make a search using keyword ‘EPAM’. Assert that there are some relevant results")
    public void simpleWebTest() {

        WebIndexPage googlePage = (WebIndexPage) setDriverPage().getPage();

        SearchGooglePage searchPage = googlePage.openUrl(properties.getProperty("url"))
                                                .sendRequest(properties.getProperty("search.epam"));

        searchPage.searchTitlesList()
                  .forEach(title -> assertThat(title)
                      .as("Does not contain EPAM")
                      .contains(properties.getProperty("key.word")));
    }
}
