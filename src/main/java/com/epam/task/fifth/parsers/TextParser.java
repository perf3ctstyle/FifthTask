package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {

    private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private final static String PARAGRAPH_DELIMITER = "[^\\t]+";
    private final static Pattern PATTERN  = Pattern.compile(PARAGRAPH_DELIMITER);

    public TextParser(Parser successor) {
        setSuccessor(successor);
    }

    @Override
    public Component parse(String text) {
        Matcher matcher = PATTERN.matcher(text);

        List<String> paragraphs = new ArrayList<>();

        while (matcher.find()) {
            String paragraph = matcher.group();
            paragraphs.add(paragraph);
        }

        Composite compositeText = new Composite(text);

        paragraphs.stream().forEach( paragraph -> {
            Component compositeParagraph = getSuccessor().parse(paragraph);
            compositeText.addComponent(compositeParagraph);
        });

        return compositeText;
    }

}
