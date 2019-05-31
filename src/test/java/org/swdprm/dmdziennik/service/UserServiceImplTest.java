package org.swdprm.dmdziennik.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.swdprm.dmdziennik.model.User;
import org.swdprm.dmdziennik.repository.RoleRepository;
import org.swdprm.dmdziennik.repository.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository, mockRoleRepository, mockPasswordEncoder);
        user = User.builder()
                .id(1L)
                .firstName("Admin")
                .lastName("Kowalski")
                .login("test")
                .build();

        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByLogin(anyString())).thenReturn(user);
    }

    @Test
    public void findByUserLogin() {
        //Setup
        final String login = "test";

        //Run test
        final User result = userServiceUnderTest.findByUserLogin(login);

        //verify result
        assertEquals(login, result.getLogin());
    }

    @Test
    public void testSaveUser() {
        //Setup
        final String login = "test";

        //Run test
        User result = userServiceUnderTest.saveUser(User.builder().build());


        //Verify result
        assertEquals(login, result.getLogin());
    }
}