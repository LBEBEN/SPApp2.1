package pl.sportplusopole.bucklet;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "bucklets")
@Data
public class Bucklet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bucklet_id")
    private int buckletId;

    @Size(max = 50, message = "Maksymalnie 50 znaków")
    private String name;

    @NotNull(message = "Podaj cenę")
    private double price;

    @Max(30)
    @Min(value = 1, message = "Wartość musi zawierać się w przedziale od 1-30")
    private int validity; // określa jak długo jest ważny karnet, w dniach

    // określa max ilość wejść klienta do klubu, w przedziale określonym zmienną validity
    @Column(name = "visits_number")
    @Size(max = 10)
    @NotBlank(message = "Pole nie może być puste")
    private String numberOfVisits;

}
