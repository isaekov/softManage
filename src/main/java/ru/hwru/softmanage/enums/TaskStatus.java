package ru.hwru.softmanage.enums;

public enum TaskStatus {

    NEW("Новая"),
    IN_PROGRESS("В работе"),
    DONE("Завершена"),
    STALLED("Приостановлена");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
