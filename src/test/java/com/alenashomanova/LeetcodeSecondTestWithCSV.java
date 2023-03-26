package com.alenashomanova;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeetcodeSecondTestWithCSV {
    @BeforeEach
    void setup() {
        Selenide.open("https://leetcode.com/");
    }

    @CsvSource(value = {
            "LeetCode 75,LeetCode 75 Study Plan to Ace Interviews",
            "Algorithm,14 Days Study Plan to Crack Algo",
            "Data Structure,2 Weeks Study Plan to Tackle DS",
            "SQL,SQL Study Plan",
            "Dynamic Programming,Ultimate DP Study Plan"
    })
    @ParameterizedTest(name = "The indicated {0} block should have a heading {1}")
    @Tags({
            @Tag("PROBLEM_PAGE"),
            @Tag("WEB")
    })
    void indicatedBlockHasCorrectHeadingCheck(String testData, String expectedText) {
        $(".feature-chapter-base").$(byText("View Questions")).click();
        $("a[aria-label$='" + testData + "']").shouldHave(text(expectedText));
    }
}
