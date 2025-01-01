package Spring_HW.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "fuel-types")
public class FuelConfig {
    private Map<String, List<String>> fuelTypes;
}
