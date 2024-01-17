package org.wilmer.mongodb.wmscDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class WmscStudentExistengDto {
    @NotNull(message = "id cannot be empty")
    private String wmscid;
    @NotNull(message = "firstName cannot be empty")
    @Size(min = 2, max = 30, message = "firstName must be atleast of 2 letters and not more then 100 letters")
    private String wmscfirstName;
    @NotNull(message = "lastName cannot be empty")
    @Size(min = 2, max = 30,
    message = "lastName must be atleast of 2 letters and not more then 100 letters")
    private String wmsclastName;
    @NotEmpty(message = "email cannot be empty")
    @Email
    private String wmscemail;
    private String wmsccontactNumber;
    private String wmsccourseName;
    private LocalDateTime wmsccreated;
    private LocalDateTime wmscmodified;
}
