package org.wilmer.mongodb.wmscModelos;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document(collection = "student")
public class WmscStudent {
    @Id
    private String wmscid;
    private String wmscfirstName;
    private String wmsclastName;
    private String wmscemail;
    private String wmsccontactNumber;
    private String wmsccourseName;
    @CreatedDate
    private LocalDateTime wmsccreated;
    @LastModifiedDate
    private LocalDateTime wmscmodified;
}
