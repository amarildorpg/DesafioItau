package dev.datanorte.DesafioItau.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {

}
