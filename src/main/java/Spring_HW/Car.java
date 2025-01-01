package Spring_HW;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private String model;
    private String producer;
    private int power;
}
