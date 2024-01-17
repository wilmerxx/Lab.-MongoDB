package org.wilmer.mongodb.wmscDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class WmscStudentDto {
    private String wmscid;
    private String wmscfirstName;
    private String wmsclastName;
    private String wmscemail;
    private String wmsccontactNumber;
    private String wmsccourseName;
    private LocalDateTime wmsccreated;
    private LocalDateTime wmscmodified;
}
