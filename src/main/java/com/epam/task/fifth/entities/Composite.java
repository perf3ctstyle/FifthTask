package com.epam.task.fifth.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Composite implements Component {

    private String content;

    private List<Component> components = new ArrayList<>();

    public Composite() {
    }

    public Composite(String content) {
        this.content = content;
    }

    public Composite(List<Component> components) {
        this.components = components;
    }

    public String getContent() {
        return content;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public Optional<Component> getChild(int index) {
        if (index < components.size()) {
            Component requiredComponent = components.get(index);
            return Optional.of(requiredComponent);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
