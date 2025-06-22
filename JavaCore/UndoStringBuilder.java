package org.Makushev;

import java.util.Stack;

public class UndoStringBuilder {

    private final StringBuilder sb = new StringBuilder();
    private final Stack<String> history = new Stack<>();

    public void save() {
        history.push(sb.toString());
    }

    public UndoStringBuilder append(String str) {
        save();
        sb.append(str);
        return this;
    }

    public UndoStringBuilder delete(int start, int end) {
        save();
        sb.delete(start, end);
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            sb.setLength(0);
            sb.append(history.pop());
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
