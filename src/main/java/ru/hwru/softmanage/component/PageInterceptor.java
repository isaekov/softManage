package ru.hwru.softmanage.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        if (handler instanceof HandlerMethod handlerMethod) {
            // имя контроллера в нижнем регистре без "Controller" → директория
            String controllerName = handlerMethod.getBeanType().getSimpleName()
                    .replace("Controller", "")
                    .toLowerCase();

            // имя метода = имя файла
            String methodName = handlerMethod.getMethod().getName();

            // подставляем путь к шаблону: pages/имя_контроллера/имя_метода
            request.setAttribute("page", "pages/" + controllerName + "/" + methodName);
            System.out.println("pages/" + controllerName + "/" + methodName);
            // для меню или активной вкладки
            request.setAttribute("currentController", controllerName);
            request.setAttribute("currentPage", methodName);
        }

        String uri = request.getRequestURI();
        // ===== ЛОГИКА BACK-URL =====
        HttpSession session = request.getSession(false);
        String currentUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        if (queryString != null) {
            currentUrl += "?" + queryString;
        }

        String backUrl = null;
        if (session != null) {
            backUrl = (String) session.getAttribute("lastPage");
        }
        if (backUrl == null || backUrl.isEmpty()) {
            backUrl = request.getHeader("Referer");
        }

        if (backUrl != null && !backUrl.isEmpty() && !backUrl.equals(currentUrl)) {
            if (!backUrl.contains("/login") && !backUrl.contains("/logout")) {
                request.setAttribute("back", backUrl);
            }
        }

        // Сохраняем ТОЛЬКО если это не статика и не API
        if (session != null && !isStaticResource(uri) && !isApiRequest(uri)) {
            session.setAttribute("lastPage", currentUrl);
        }


        return true;
    }


    // ===== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ =====
    private boolean isStaticResource(String uri) {
        return uri != null && (
                uri.endsWith(".css") ||
                        uri.endsWith(".js") ||
                        uri.endsWith(".png") ||
                        uri.endsWith(".jpg") ||
                        uri.endsWith(".jpeg") ||
                        uri.endsWith(".gif") ||
                        uri.endsWith(".svg") ||
                        uri.endsWith(".ico") ||
                        uri.endsWith(".woff") ||
                        uri.endsWith(".woff2") ||
                        uri.endsWith(".ttf") ||
                        uri.endsWith(".eot") ||
                        uri.contains("/static/") ||
                        uri.contains("/resources/") ||
                        uri.contains("/webjars/")
        );
    }

    private boolean isApiRequest(String uri) {
        return uri != null && (
                uri.startsWith("/api/") ||
                        uri.contains("/actuator/")
        );
    }
}


