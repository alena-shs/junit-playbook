package com.alenashomanova;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeetcodeThirdTestCSVFile {
    @BeforeEach
    void setup() {
        Selenide.open("https://leetcode.com/");
    }

    @CsvFileSource(resources = "/testdata/sectionHeadersExpectedText.csv")
    @ParameterizedTest(name = "The indicated {0} block should have a heading {1}")
    @Tags({
            @Tag("PROBLEM_PAGE"),
            @Tag("WEB")
    })
    void indicatedBlockHasCorrectHeadingFromFileCheck(String testData, String expectedText) {
        $(".feature-chapter-base").$(byText("View Questions")).click();
        $("a[aria-label$='" + testData + "']").shouldHave(text(expectedText));
    }
}
