package cake.manager.initializer;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    //不用重写任何内容
    //这里实际上会自动注册一个Filter，SpringSecurity底层就是依靠N个过滤器实现的，我们之后再探讨
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        servletContext.addFilter("characterEncodingFilter",new CharacterEncodingFilter("UTF-8",true))
                .addMappingForUrlPatterns(null,false,"/*");
    }
}