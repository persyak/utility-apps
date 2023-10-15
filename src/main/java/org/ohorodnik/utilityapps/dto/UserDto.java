package org.ohorodnik.utilityapps.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UserDto {
    private int id;
    private String userName;
    private String email;
    private String login;
    private String role;
    private boolean enabled = false;
    private String driverLicense;
}
