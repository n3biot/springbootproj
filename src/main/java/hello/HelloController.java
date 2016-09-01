package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.reader.MetricReader;
import org.springframework.boot.actuate.metrics.reader.MetricRegistryMetricReader;
import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    @Value("${spring.application.name:application}.${random.value:0000}")
    private String prefix = "metrics";
    @Bean
    @ExportMetricReader
    public MetricReader metricReader() {
        return new MetricRegistryMetricReader(metricRegistry);
    }
    @Bean
    @ExportMetricWriter
    MetricWriter metricWriter() {
        return new StatsdMetricWriter(prefix, "localhost", 8125);
    }
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
