package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import com.epam.task.fifth.enums.LexemeType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private final String FIRST_WORD = "Loremucus";
    private final String SECOND_WORD = "ips";
    private final String THIRD_WORD = "Sed";
    private final String FOURTH_WORD = "eiuso";
    private final String FIFTH_WORD = "Excepteur";
    private final String SIXTH_WORD = "proid";
    private final String SEVENTH_WORD = "Officia";
    private final String EIGHTH_WORD = "laborumoscus";

    private final Composite FIRST_SENTENCE = new Composite(Arrays.asList(
            new LexemeLeaf(FIRST_WORD, LexemeType.WORD),
            new LexemeLeaf(SECOND_WORD, LexemeType.WORD)));

    private final Composite SECOND_SENTENCE = new Composite(Arrays.asList(
            new LexemeLeaf(THIRD_WORD, LexemeType.WORD),
            new LexemeLeaf(FOURTH_WORD, LexemeType.WORD)));

    private final Composite THIRD_SENTENCE = new Composite(Arrays.asList(
            new LexemeLeaf(FIFTH_WORD, LexemeType.WORD),
            new LexemeLeaf(SIXTH_WORD, LexemeType.WORD)));

    private final Composite FOURTH_SENTENCE = new Composite(Arrays.asList(
            new LexemeLeaf(SEVENTH_WORD, LexemeType.WORD),
            new LexemeLeaf(EIGHTH_WORD, LexemeType.WORD)));

    private final Composite FIRST_PARAGRAPH = new Composite(Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE, THIRD_SENTENCE));
    private final Composite SECOND_PARAGRAPH = new Composite(Collections.singletonList(FOURTH_SENTENCE));

    private final TextLogic textLogic = new TextLogic();

    @Test
    public void testShouldSortParagraphsInTextByNumberOfSentences() {
        Composite text = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));
        Composite expected = new Composite(Arrays.asList(SECOND_PARAGRAPH, FIRST_PARAGRAPH));

        Composite actual = textLogic.sortParagraphsInTextByNumberOfSentences(text);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShouldSortWordsInSentenceByLength() {
        Composite expected = new Composite(Arrays.asList(
                new LexemeLeaf(SECOND_WORD, LexemeType.WORD),
                new LexemeLeaf(FIRST_WORD, LexemeType.WORD)));

        Composite actual = textLogic.sortWordsInSentenceByLength(FIRST_SENTENCE);

        Assert.assertEquals(expected, actual);
    }
}
