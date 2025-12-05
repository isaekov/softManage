package ru.hwru.softmanage.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (handler instanceof HandlerMethod handlerMethod) {
            // имя контроллера в нижнем регистре без "Controller" → директория
            String controllerName = handlerMethod.getBeanType().getSimpleName()
                    .replace("Controller", "")
                    .toLowerCase();

            // имя метода = имя файла
            String methodName = handlerMethod.getMethod().getName();

            // подставляем путь к шаблону: pages/имя_контроллера/имя_метода
            request.setAttribute("page", "pages/" + controllerName + "/" + methodName);

            // для меню или активной вкладки
            request.setAttribute("currentController", controllerName);
            request.setAttribute("currentPage", methodName);
        }

        return true;
    }
}


