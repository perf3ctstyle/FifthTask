package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;

public interface Parser {

    Component parse(String text);
}
