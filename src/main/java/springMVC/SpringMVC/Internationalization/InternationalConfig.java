package springMVC.SpringMVC.Internationalization;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalConfig implements WebMvcConfigurer{

	/*
	 * LocaleResolver is an interface that determines the user’s locale, which represents the user’s language and country 
	 * or region. Determines the locale to use from requests.
	 */
	@Bean
	public LocaleResolver localeResolver()
	{
		/*
		 * we are using here sessionlocaleresolver so that after changing locale it stay on that till the session is active
		 */
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
	
	/*
	 * LocaleChangeInterceptor is an interceptor that allows for changing the locale based on a request parameter or attribute.
	 */
	@Bean
	public LocaleChangeInterceptor changeInterceptor()
	{
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		return changeInterceptor;
	}
	
	/*
	 * MessageSource is an interface that provides a way to resolve messages from resource bundles based on the current locale.
	 */
	@Bean
	public MessageSource messageSource()
	{
		/*
		 * Resource bundles are files that contains locale-specific key-value pairs, 
		 * where keys represent message codes and values represent the translated messages.
		 */
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("resources");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(changeInterceptor());
	}
	
}
