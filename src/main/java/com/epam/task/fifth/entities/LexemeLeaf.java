package com.epam.task.fifth.entities;

import com.epam.task.fifth.enums.LexemeType;

import java.util.Objects;

public class LexemeLeaf implements Component {

    private final String content;
    private final LexemeType lexemeType;

    public LexemeLeaf(String content, LexemeType lexemeType) {
        this.content = content;
        this.lexemeType = lexemeType;
    }

    public String getContent() {
        return content;
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public static LexemeLeaf buildWord(String content) {
        return new LexemeLeaf(content, LexemeType.WORD);
    }

    public static LexemeLeaf buildExpression(String content) {
        return new LexemeLeaf(content, LexemeType.EXPRESSION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LexemeLeaf that = (LexemeLeaf) o;
        return Objects.equals(content, that.content) && lexemeType == that.lexemeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, lexemeType);
    }

    @Override
    public String toString() {
        return "LexemeLeaf{" +
                "content='" + content + '\'' +
                ", lexemeType=" + lexemeType +
                '}';
    }
}
