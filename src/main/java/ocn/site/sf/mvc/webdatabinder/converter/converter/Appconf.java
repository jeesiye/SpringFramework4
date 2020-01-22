package ocn.site.sf.mvc.webdatabinder.converter.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

////reference : org.springframework.core.convert.support.DefaultConversionService
//
////org.springframework.core.convert.support.DefaultConversionService.addDefaultConverters(ConverterRegistry)
//	public static void addDefaultConverters(ConverterRegistry converterRegistry) {
//		addScalarConverters(converterRegistry);
//		addCollectionConverters(converterRegistry);
//
//		converterRegistry.addConverter(new ByteBufferConverter((ConversionService) converterRegistry));
//		if (jsr310Available) {
//			Jsr310ConverterRegistrar.registerJsr310Converters(converterRegistry);
//		}
//
//		converterRegistry.addConverter(new ObjectToObjectConverter());
//		converterRegistry.addConverter(new IdToEntityConverter((ConversionService) converterRegistry));
//		converterRegistry.addConverter(new FallbackObjectToStringConverter());
//		if (javaUtilOptionalClassAvailable) {
//			converterRegistry.addConverter(new ObjectToOptionalConverter((ConversionService) converterRegistry));
//		}
//	}
//
////org.springframework.core.convert.support.DefaultConversionService.addCollectionConverters(ConverterRegistry)
//	public static void addCollectionConverters(ConverterRegistry converterRegistry) {
//		ConversionService conversionService = (ConversionService) converterRegistry;
//
//		converterRegistry.addConverter(new ArrayToCollectionConverter(conversionService));
//		converterRegistry.addConverter(new CollectionToArrayConverter(conversionService));
//
//		converterRegistry.addConverter(new ArrayToArrayConverter(conversionService));
//		converterRegistry.addConverter(new CollectionToCollectionConverter(conversionService));
//		converterRegistry.addConverter(new MapToMapConverter(conversionService));
//
//		converterRegistry.addConverter(new ArrayToStringConverter(conversionService));
//		converterRegistry.addConverter(new StringToArrayConverter(conversionService));
//
//		converterRegistry.addConverter(new ArrayToObjectConverter(conversionService));
//		converterRegistry.addConverter(new ObjectToArrayConverter(conversionService));
//
//		converterRegistry.addConverter(new CollectionToStringConverter(conversionService));
//		converterRegistry.addConverter(new StringToCollectionConverter(conversionService));
//
//		converterRegistry.addConverter(new CollectionToObjectConverter(conversionService));
//		converterRegistry.addConverter(new ObjectToCollectionConverter(conversionService));
//
//		if (streamAvailable) {
//			converterRegistry.addConverter(new StreamConverter(conversionService));
//		}
//	}
//
////org.springframework.core.convert.support.DefaultConversionService.addScalarConverters(ConverterRegistry)
//	private static void addScalarConverters(ConverterRegistry converterRegistry) {
//		converterRegistry.addConverterFactory(new NumberToNumberConverterFactory());
//
//		converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
//		converterRegistry.addConverter(Number.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverter(new StringToCharacterConverter());
//		converterRegistry.addConverter(Character.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverter(new NumberToCharacterConverter());
//		converterRegistry.addConverterFactory(new CharacterToNumberFactory());
//
//		converterRegistry.addConverter(new StringToBooleanConverter());
//		converterRegistry.addConverter(Boolean.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverterFactory(new StringToEnumConverterFactory());
//		converterRegistry.addConverter(new EnumToStringConverter((ConversionService) converterRegistry));
//
//		converterRegistry.addConverterFactory(new IntegerToEnumConverterFactory());
//		converterRegistry.addConverter(new EnumToIntegerConverter((ConversionService) converterRegistry));
//
//		converterRegistry.addConverter(new StringToLocaleConverter());
//		converterRegistry.addConverter(Locale.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverter(new StringToCharsetConverter());
//		converterRegistry.addConverter(Charset.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverter(new StringToCurrencyConverter());
//		converterRegistry.addConverter(Currency.class, String.class, new ObjectToStringConverter());
//
//		converterRegistry.addConverter(new StringToPropertiesConverter());
//		converterRegistry.addConverter(new PropertiesToStringConverter());
//
//		converterRegistry.addConverter(new StringToUUIDConverter());
//		converterRegistry.addConverter(UUID.class, String.class, new ObjectToStringConverter());
//	}

@EnableWebMvc
@Configuration
@ComponentScan("ocn.site.sf.mvc.webdatabinder.converter.converter")
public class Appconf extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new String2Date());
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
	}

}
