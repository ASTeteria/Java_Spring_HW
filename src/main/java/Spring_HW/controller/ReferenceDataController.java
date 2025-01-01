package Spring_HW.controller;

import Spring_HW.config.FuelConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReferenceDataController {

    @Value("${engine-types}")
    private List<String> engineTypes;

    private final FuelConfig fuelConfig;

    // engine-types
    @GetMapping("/engine-types")
    public List<String> getEngineTypes() {
        return engineTypes;
    }

    // fuel-types
    @GetMapping("/fuel-types")
    public Map<String, List<String>> getFuelTypes() {
        return fuelConfig.getFuelTypes();
    }

    // fuel-types/{fuelName}
    @GetMapping("/fuel-types/{fuelName}")
    public Map<String, Object> getFuelTypeDetails(@PathVariable String fuelName) {
        Map<String, List<String>> fuelTypes = fuelConfig.getFuelTypes();

        if (!fuelTypes.containsKey(fuelName)) {
            throw new IllegalArgumentException("Тип палива " + fuelName + " не знайдено.");
        }

        return Map.of(
                "name", fuelName,
                "options", fuelTypes.get(fuelName)
        );
    }
}