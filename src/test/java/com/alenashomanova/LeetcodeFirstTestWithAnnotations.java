package com.alenashomanova;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LeetcodeFirstTestWithAnnotations {
    @BeforeEach
    void setup() {
        Selenide.open("https://leetcode.com/");
    }

    @ValueSource(strings = {
            "LeetCode 75", "Algorithm"
    })
    @ParameterizedTest(name = "The {0} study plan is divided into 3 problem sections")
    @Tags({
            @Tag("PROBLEM_PAGE"),
            @Tag("WEB")
    })
    void eachLearningPathHasThreeSections(String testData) {
        $(".feature-chapter-base").$(byText("View Questions")).click();
        $("a[aria-label$='"+testData+"']").click();
        $$("section").shouldHave(size(3));
    }
}
