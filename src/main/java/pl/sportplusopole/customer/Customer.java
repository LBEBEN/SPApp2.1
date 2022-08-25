package pl.sportplusopole.customer;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sportplusopole.bucklet.Bucklet;
import pl.sportplusopole.trainer.Trainer;
import pl.sportplusopole.validators.CustomerCartNumber;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Size(max = 50)
    @NotBlank(message = "Wypełnij imię")
    private String name;

    @Size (max = 50)
    @NotBlank (message = "Wypełnij nazwisko")
    private String surname;

    @Column(name = "cart_number", unique = true)
    @NotBlank (message = "Nadaj unikalny numer")
    @CustomerCartNumber
    private String cartNumber;

    @Column(name = "cart_deposit")
    private boolean cartDeposit;

    @Email(message = "Wpisz poprawny adres email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column (name = "purchase_date")
    @javax.validation.constraints.NotNull(message = "Ustaw datę zakupu")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate purchaseDate; // data zakupu karnetu

    private LocalDate expiryDate; // data ważności karnetu

    @Size(max = 255)
    private String comment;

    private String visitsLeft; // liczba wizyt jakie jeszcze klientowi zostały

    @Column(name = "last_visit")
    private LocalDate lastVisit;

    @ManyToOne
    @JoinColumn(name = "t_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "b_id")
    @NotNull(message = "Ustaw rodzaje karnetu")
    private Bucklet bucklet;

}
