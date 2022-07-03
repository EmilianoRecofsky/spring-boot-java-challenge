package ar.com.ere.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class IndexController implements WebMvcConfigurer {
	
	private static Logger logger = Logger.getLogger(IndexController.class.getName());

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		logger.info("IndexController addViewControllers");
		registry.addViewController("/notFound").setViewName("forward:/autobusesbackend/autobusesfrontend/index.html");
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
		logger.info("IndexController WebServerFactoryCustomizer");
		return container -> {
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notFound"));
		};
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/**/*")
				.addResourceLocations("classpath:/static/").resourceChain(true)
				.addResolver(new PathResourceResolver() {
					
					@Override
					protected Resource getResource(String resourcePath, Resource location) throws IOException {
						
						Resource requestedResource = location.createRelative(resourcePath);
						
						if(requestedResource.exists() && requestedResource.isReadable()){
							return requestedResource;
						}else{
							return new ClassPathResource("/static/autobusesfrontend/index.html");
						}
						
					}
					
				});
		
	}

}
