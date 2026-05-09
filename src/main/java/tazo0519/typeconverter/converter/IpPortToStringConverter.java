package tazo0519.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import tazo0519.typeconverter.type.IpPort;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        log.info("Converting IpPort to string : {}", source);
        return source.getIp() + ":" + source.getPort();
    }
}
