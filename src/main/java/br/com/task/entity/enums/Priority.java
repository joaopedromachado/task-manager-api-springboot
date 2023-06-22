package br.com.task.entity.enums;

import java.util.Arrays;

public enum Priority {

    HIGH (3),
    MEDIUM (2),
    LOW (1);

    private int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public static Priority valueOf(int level) {
        return Arrays.stream(Priority.values())
                .filter(p -> p.getLevel() == level)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
