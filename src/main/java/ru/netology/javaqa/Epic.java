package ru.netology.javaqa;

import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String getSubtasks() {
        return Arrays.toString(subtasks);
    }

    @Override
    public boolean matches(String query) {
        for (String task : subtasks) {
            if (task.matches(query)) {
                return true;
            }
        }
        return false;
    }
}
