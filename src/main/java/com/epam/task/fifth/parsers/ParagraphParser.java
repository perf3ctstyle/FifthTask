package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private final static String SENTENCE_DELIMITER = "[A-Z].[^\\.!?]+";
    private final static Pattern PATTERN  = Pattern.compile(SENTENCE_DELIMITER);

    public ParagraphParser(Parser successor) {
        setSuccessor(successor);
    }

    @Override
    public Component parse(String text) {
        Matcher matcher = PATTERN.matcher(text);
        List<String> sentences = new ArrayList<>();

        while (matcher.find()) {
            String sentence = matcher.group();
            sentences.add(sentence);
        }

        Composite compositeParagraph = new Composite(text);

        sentences.stream().forEach( sentence -> {
            Component compositeSentence = getSuccessor().parse(sentence);
            compositeParagraph.addComponent(compositeSentence);
        });

        return compositeParagraph;
    }
}
