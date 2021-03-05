package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import com.epam.task.fifth.enums.LexemeType;

import java.util.Arrays;

public abstract class AbstractParserTest {

    private final String TEXT = "    Lorem ipsum. Sed eiusmod." +
            "    Excepteur proident. Officia laborum.";
    private final String FIRST_WORD = "Lorem";
    private final String SECOND_WORD = "ipsum";
    private final String THIRD_WORD = "Sed";
    private final String FOURTH_WORD = "eiusmod";
    private final String FIFTH_WORD = "Excepteur";
    private final String SIXTH_WORD = "proident";
    private final String SEVENTH_WORD = "Officia";
    private final String EIGHTH_WORD = "laborum";
    private final Component FIRST_PARAGRAPH = new Composite(Arrays.asList(
            new Composite(
                    Arrays.asList(
                            new LexemeLeaf(FIRST_WORD, LexemeType.WORD),
                            new LexemeLeaf(SECOND_WORD, LexemeType.WORD),
                            new LexemeLeaf(THIRD_WORD, LexemeType.WORD),
                            new LexemeLeaf(FOURTH_WORD, LexemeType.WORD)))));
    private final Component SECOND_PARAGRAPH = new Composite(Arrays.asList(
            new Composite(
                    Arrays.asList(
                            new LexemeLeaf(FIFTH_WORD, LexemeType.WORD),
                            new LexemeLeaf(SIXTH_WORD, LexemeType.WORD),
                            new LexemeLeaf(SEVENTH_WORD, LexemeType.WORD),
                            new LexemeLeaf(EIGHTH_WORD, LexemeType.WORD)))));
}
