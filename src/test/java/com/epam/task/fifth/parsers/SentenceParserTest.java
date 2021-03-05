package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import com.epam.task.fifth.enums.LexemeType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    private final String SENTENCE = "Hello, this is.";

    private final SentenceParser sentenceParser = new SentenceParser();

    @Test
    public void testShouldParseSentenceWhenSentenceIsCorrect() {
        Component expected = new Composite(Arrays.asList(
                new LexemeLeaf("Hello", LexemeType.WORD),
                new LexemeLeaf("this", LexemeType.WORD),
                new LexemeLeaf("is", LexemeType.WORD)));

        Component actual = sentenceParser.parse(SENTENCE);

        Assert.assertEquals(expected, actual);
    }
}
