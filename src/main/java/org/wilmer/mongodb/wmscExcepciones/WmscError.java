package org.wilmer.mongodb.wmscExcepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmscError {
    private String message;
    private int status;
    private Long timestamp;
}
