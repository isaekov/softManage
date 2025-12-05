package ru.hwru.softmanage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.method.HandlerMethod;

@ControllerAdvice
public class GlobalModelAdvice {

//    @ModelAttribute
//    public void addGlobalAttributes(Model model, HandlerMethod handlerMethod) {
//
//        String controllerName = handlerMethod.getBeanType().getSimpleName();
//        String methodName = handlerMethod.getMethod().getName();
//
//        model.addAttribute("controller", controllerName);
//        model.addAttribute("method", methodName);
//    }

}
