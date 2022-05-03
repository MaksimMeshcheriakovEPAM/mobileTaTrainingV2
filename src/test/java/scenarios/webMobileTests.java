package scenarios;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.testng.annotations.Test;
import pages.web.SearchGooglePage;
import pages.web.WebIndexPage;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @SneakyThrows
    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
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
