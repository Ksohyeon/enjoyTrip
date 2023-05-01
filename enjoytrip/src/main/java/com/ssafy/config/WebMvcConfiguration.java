package com.ssafy.config;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import com.ssafy.interceptor.ConfirmInterceptor;

@Configuration  // Spring에게 아래 클래스는 설정 클래스라고 알려줌
@MapperScan(basePackages = {"com.ssafy.**.mapper"})  // MyBatis Mapper 스캔
@EnableAspectJAutoProxy  // AOP ProxyBeanFactory 생성 (AOP 사용하도록 설정)
public class WebMvcConfiguration implements WebMvcConfigurer {

	private ConfirmInterceptor confirmInterceptor;

	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
		this.confirmInterceptor = confirmInterceptor;
	}

	// CORS 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
		.allowedMethods(
				HttpMethod.GET.name(), 
				HttpMethod.POST.name(), 
				HttpMethod.PUT.name(),
				HttpMethod.DELETE.name(), 
				HttpMethod.HEAD.name(), 
				HttpMethod.OPTIONS.name(),
				HttpMethod.PATCH.name())
		.maxAge(1800);
	}

	// Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor)
		.addPathPatterns(Arrays.asList("/article/*", "/admin", "/user/list"));
	}

	@Bean(name = "viewResolver")
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}

}
