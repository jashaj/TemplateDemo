package eu.jasha.examples;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan("eu.jasha.examples")
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean
  public ViewResolver jspViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setOrder(3);
    return resolver;
  }

  @Bean
  // THYMELEAF: Template Resolver for webapp pages
  public ITemplateResolver webTemplateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("/WEB-INF/thymeleaf/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setCharacterEncoding("UTF-8");
    resolver.setCacheable(false);
    return resolver;
  }


  @Bean
  // THYMELEAF: Template Engine (Spring-specific version)
  public ISpringTemplateEngine templateEngine(SpringResourceTemplateResolver webTemplateResolver) {
    SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
    springTemplateEngine.setTemplateResolver(webTemplateResolver);
    return springTemplateEngine;
  }

  @Bean
  // THYMELEAF: View Resolver - implementation of Spring's ViewResolver interface
  public ViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setExcludedViewNames(new String[]{ "*-jsp" });
    resolver.setTemplateEngine(templateEngine);
    resolver.setCharacterEncoding("UTF-8");
    resolver.setOrder(2);
    return resolver;
  }

  @Bean
  // freemarker config
  public FreeMarkerConfig freeMarkerConfig() {
    Properties properties = new Properties();
    properties.setProperty("auto_import", "spring.ftl as spring");

    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    configurer.setTemplateLoaderPath("/WEB-INF/freemarker/");
    configurer.setDefaultEncoding("UTF-8");
    configurer.setFreemarkerSettings(properties);
    return configurer;
  }

  @Bean
  public ViewResolver freemarkerViewResolver() {
    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
    resolver.setCache(false);
    resolver.setPrefix("");
    resolver.setSuffix(".ftl");
    resolver.setOrder(0);
    return resolver;
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    messageSource.addBasenames("versions");
    return messageSource;
  }
}
