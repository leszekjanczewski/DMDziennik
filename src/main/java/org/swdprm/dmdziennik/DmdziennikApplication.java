package org.swdprm.dmdziennik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.swdprm.dmdziennik.model.Role;
import org.swdprm.dmdziennik.model.User;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ContextConfiguration
public class DmdziennikApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmdziennikApplication.class, args);
    }

}
