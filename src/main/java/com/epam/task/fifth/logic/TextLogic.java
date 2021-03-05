package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.LexemeLeaf;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite sortParagraphsInTextByNumberOfSentences(Composite text) {
        List<Component> receivedParagraphs = text.getComponents();
        List<Component> paragraphs = new ArrayList<>(receivedParagraphs);
        paragraphs.sort((first, second) -> {
            List<Component> firstParagraph = ((Composite) first).getComponents();
            List<Component> secondParagraph = ((Composite) second).getComponents();
            return firstParagraph.size() - secondParagraph.size();
        });

        return new Composite(paragraphs);
    }

    public Composite sortWordsInSentenceByLength(Composite sentence) {
        List<Component> receivedWords = sentence.getComponents();
        List<Component> words = new ArrayList<>(receivedWords);
        words.sort((first, second) -> {
            String firstWord = ((LexemeLeaf) first).getContent();
            String secondWord = ((LexemeLeaf) second).getContent();
            return firstWord.length() - secondWord.length();
        });

        return new Composite(words);
    }
}
