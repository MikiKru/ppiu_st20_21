package pl.utp.ppiu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor         // generuje automatycznie konstruktor z wszystkimi polami w argumencie
@Data                       // generuje automatycznie getters/setters/toString()
public class User {
    private String email;
    private String password;
    private boolean status;
    private LocalDateTime registrationDateTime;
}
