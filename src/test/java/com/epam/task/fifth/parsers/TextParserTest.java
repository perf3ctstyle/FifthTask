package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import com.epam.task.fifth.enums.LexemeType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;

public class TextParserTest {

    private final String FIRST_PARAGRAPH = "The first paragraph.";
    private final String SECOND_PARAGRAPH = "The second paragraph.";
    private final String TEXT = "\tThe first paragraph." +
            "\tThe second paragraph.";

    private final ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
    private final TextParser textParser = new TextParser(paragraphParser);

    @Test
    public void testShouldParseTextWhenTextIsCorrect() {
        Component firstSentence = new Composite(Arrays.asList(
                new LexemeLeaf("The", LexemeType.WORD),
                new LexemeLeaf("first", LexemeType.WORD),
                new LexemeLeaf("sentence", LexemeType.WORD)));
        Component firstParagraph = new Composite(Collections.singletonList(firstSentence));

        Component secondSentence = new Composite(Arrays.asList(
                new LexemeLeaf("The", LexemeType.WORD),
                new LexemeLeaf("second", LexemeType.WORD),
                new LexemeLeaf("sentence", LexemeType.WORD)));
        Component secondParagraph = new Composite(Collections.singletonList(secondSentence));

        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(firstParagraph);
        when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(secondParagraph);
        Component expected = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        Component actual = textParser.parse(TEXT);

        Assert.assertEquals(expected, actual);
    }
}
