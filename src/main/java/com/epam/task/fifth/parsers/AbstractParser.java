package com.epam.task.fifth.parsers;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
