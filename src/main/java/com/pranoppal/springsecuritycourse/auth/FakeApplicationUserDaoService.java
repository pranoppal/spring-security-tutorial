package com.pranoppal.springsecuritycourse.auth;

import com.google.common.collect.Lists;
import com.pranoppal.springsecuritycourse.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pranoppal.springsecuritycourse.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "pranoppal",
                        true,true, true, true),
                new ApplicationUser(ADMIN_TRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "james",
                        true,true, true, true),
                new ApplicationUser(ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "adam",
                        true,true, true, true)
        );
        return applicationUsers;
    }
}
