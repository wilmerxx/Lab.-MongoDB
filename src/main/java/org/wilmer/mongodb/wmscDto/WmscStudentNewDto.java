package org.wilmer.mongodb.wmscDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class WmscStudentNewDto {
    private String wmscid;
    @NotNull(message = "firstName cannot be empty")
    @Size(min = 2, max = 30, message = "no puede ser menor a 2 letras y no mayor a 30 letras")
    private String wmscfirstName;
    @NotNull(message = "lastName cannot be empty")
    @Size(min = 2, max = 30, message = "lastName must be atleast of 2 letters and not more then 100 letters")
    private String wmsclastName;
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String wmscemail;
    private String wmsccontactNumber;
    private String wmsccourseName;
    private LocalDateTime wmsccreated;
    private LocalDateTime wmscmodified;

}
