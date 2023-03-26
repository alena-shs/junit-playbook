package com.alenashomanova;

import com.alenashomanova.data.Blocks;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LeetcodeFourthTestWithEnum {
    static Stream<Arguments> indicatedBlockHasCorrectSectionNamesCheck() {
        return Stream.of(
                Arguments.of(Blocks.SQL, List.of("SQL I", "SQL II", "SQL III")),
                Arguments.of(Blocks.Algorithm, List.of("Algorithm I", "Algorithm II", "Algorithm III"))
        );
    }
    @MethodSource

    @ParameterizedTest(name = "The {0} page should have sections {1}")
    @Tags({
            @Tag("PROBLEM_PAGE"),
            @Tag("WEB")
    })
    void indicatedBlockHasCorrectSectionNamesCheck(Blocks blocks, List<String> sectionList) {
        Selenide.open("https://leetcode.com/problemset/all/");
        $("a[aria-label$='"+blocks.name()+"']").click();
        $$("section").shouldHave(texts(sectionList));
    }
}
