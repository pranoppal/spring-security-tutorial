package com.pranoppal.springsecuritycourse.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationByUsername(String username);
}
