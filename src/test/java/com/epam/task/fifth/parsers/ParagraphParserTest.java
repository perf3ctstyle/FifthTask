package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import com.epam.task.fifth.enums.LexemeType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    private final String FIRST_SENTENCE = "Well, very long";
    private final String SECOND_SENTENCE = "Sorry, not patient";
    private final String PARAGRAPH = "Well, very long. Sorry, not patient.";

    private final SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
    private final ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

    @Test
    public void testShouldParseParagraphWhenParagraphIsCorrect() {
        Component firstSentence = new Composite(Arrays.asList(
                new LexemeLeaf("Well", LexemeType.WORD),
                new LexemeLeaf("very", LexemeType.WORD),
                new LexemeLeaf("long", LexemeType.WORD)));
        Component secondSentence = new Composite(Arrays.asList(
                new LexemeLeaf("Sorry", LexemeType.WORD),
                new LexemeLeaf("not", LexemeType.WORD),
                new LexemeLeaf("patient", LexemeType.WORD)));
        Component expected = new Composite(Arrays.asList(firstSentence, secondSentence));
        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(firstSentence);
        when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(secondSentence);

        Component actual = paragraphParser.parse(PARAGRAPH);

        Assert.assertEquals(expected, actual);
    }
}
