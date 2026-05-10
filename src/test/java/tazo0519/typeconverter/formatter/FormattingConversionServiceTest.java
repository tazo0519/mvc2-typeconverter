package tazo0519.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import tazo0519.typeconverter.converter.IpPortToStringConverter;
import tazo0519.typeconverter.converter.StringToIpPortConverter;
import tazo0519.typeconverter.type.IpPort;

class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        Assertions.assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        Assertions.assertThat(conversionService.convert("1,000", Integer.class)).isEqualTo(1000L);
    }
}
