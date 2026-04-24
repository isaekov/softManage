package ru.hwru.softmanage.enums;

public enum Role {

    ADMIN("Администратор"),
    MANAGER("Менеджер"),
    DEVELOPER("Разработчик"),
    DESIGNER("Дизайнер"),
    HR("HR");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
