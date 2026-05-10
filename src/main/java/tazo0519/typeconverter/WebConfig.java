package tazo0519.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tazo0519.typeconverter.converter.IpPortToStringConverter;
import tazo0519.typeconverter.converter.StringToIpPortConverter;
import tazo0519.typeconverter.formatter.MyNumberFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Converter가 Formatter보다 우선순위가 높아서 주석 처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        
        registry.addFormatter(new MyNumberFormatter());
    }
}
