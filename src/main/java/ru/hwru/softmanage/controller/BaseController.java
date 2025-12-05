package ru.hwru.softmanage.controller;

public abstract class BaseController {

    protected String view(String name) {
        return "pages/" + name;
    }
}
