package Spring_HW;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cars")
@Data
public class AppConfig {
    private List<Car> initialData;
}
