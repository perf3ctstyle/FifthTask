package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private final static String LEXEME_DELIMITER = "(\\w+)|(\\[[\\d [\\+\\-\\*\\/]]+\\])";
    private final static Pattern PATTERN  = Pattern.compile(LEXEME_DELIMITER);
    private final static String OPENING_BRACKET  = "[";

    @Override
    public Component parse(String text) {
        Matcher matcher = PATTERN.matcher(text);
        List<String> lexemes = new ArrayList<>();

        while (matcher.find()) {
            String lexeme = matcher.group();
            lexemes.add(lexeme);
        }

        Composite compositeSentence = new Composite(text);

        lexemes.stream().forEach( lexeme -> {
            LexemeLeaf lexemeLeaf;
            if (lexeme.startsWith(OPENING_BRACKET)) {
                lexemeLeaf = LexemeLeaf.buildExpression(lexeme);
            } else {
                lexemeLeaf = LexemeLeaf.buildWord(lexeme);
            }
            compositeSentence.addComponent(lexemeLeaf);
        });

        return compositeSentence;
    }
}
