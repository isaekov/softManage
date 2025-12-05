package ru.hwru.softmanage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.hwru.softmanage.component.PageInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final PageInterceptor pageInterceptor;

    public WebConfig(PageInterceptor pageInterceptor) {
        this.pageInterceptor = pageInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageInterceptor);
    }
}

