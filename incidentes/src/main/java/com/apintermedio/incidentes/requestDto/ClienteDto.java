package com.apintermedio.incidentes.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {
    //private Long clienteId;
    @Size(max= 20, message = "la razon social excedio los 20 caracteres")
    @NotBlank(message = "la razon social es obligatoria")
    private String razonSocial;

    @Pattern(regexp = "^\\d{2}-\\d{8}-\\d$", message = "Formato de CUIT no válido")
    @NotBlank(message = "el cuit es obligatorio")
    private String cuit;
    @NotBlank(message = "el domicilio es obligatoria")
    @Size(max = 25, message = "el domicilio no debe superar los 25 caracteres")
     private String domicilio;
    @Pattern ( regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",  message="el correo debe ser del formato correo@gmail.com")
        @NotBlank(message = "el email es obligatorio")
    private String email;
    // @Past que este en el pasada
    //@PastOrPresent que este en el pasado o presente
    //@assertue para validar booleanos
    @NotEmpty(message = "Debe existir servicios contratados")
    private Set<ServDto> listaServicios;

}
