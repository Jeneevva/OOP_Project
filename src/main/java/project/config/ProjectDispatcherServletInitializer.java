package project.config;

//16 урок
//конфигурируем Dispatcher Servlet и заменяем web.xml, чтобы укоротить код и не вводить это все от руки

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import project.config.SpringConfig;

public class ProjectDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //указываем где находится спринг конфигурация
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //все запросы будут напралены на Dispatcher Servlet
    }
}
