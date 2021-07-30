package com.pranoppal.springsecuritycourse.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {
    String username;
    String password;
}
