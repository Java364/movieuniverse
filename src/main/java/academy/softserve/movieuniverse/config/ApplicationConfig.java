package academy.softserve.movieuniverse.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
public class ApplicationConfig {
    @Bean(name = "modelMapper")
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new LocalDateTimeConverter());
        return modelMapper;
    }

    public static class LocalDateTimeConverter implements Converter<LocalDateTime, Long> {
        @Override
        public Long convert(MappingContext<LocalDateTime, Long> context) {
            ZoneId zoneId = ZoneId.systemDefault();
            return context.getSource() == null ? null : context.getSource().atZone(zoneId).toEpochSecond();
        }
    }
}
