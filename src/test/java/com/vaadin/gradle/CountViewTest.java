package com.vaadin.gradle;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@UsePlaywright
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "vaadin.production-mode=true")
class CountViewTest {

    @BeforeEach
    void navigate(Page page, @LocalServerPort int port) {
        page.navigate("http://localhost:" + port);
    }

    @Test
    void buttonIncrementsCounter(Page page) {
        var count = page.getByRole(AriaRole.HEADING);
        var button = page.getByRole(AriaRole.BUTTON);
        button.click();
        assertThat(count).hasText("1.0");
    }
}
