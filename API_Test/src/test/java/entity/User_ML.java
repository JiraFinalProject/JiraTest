package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User_ML {
    private String name;
    private String password;
    private String emailAddress;
    private String displayName;
    private String[] applicationKeys;
}