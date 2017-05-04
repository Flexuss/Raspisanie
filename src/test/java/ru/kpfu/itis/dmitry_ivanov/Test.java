package ru.kpfu.itis.dmitry_ivanov;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.kpfu.itis.dmitry_ivanov.model.User;
import ru.kpfu.itis.dmitry_ivanov.services.UserService;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by Dmitry on 04.05.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class Test {

    @Mock
    private UserService userService;

    @org.junit.Test
    public void testUSerService() {
        User user = new User();
        user.setPassword("userforjunit");
        user.setLogin("userforjunit");
        userService.save(user);
        User user2 = userService.findByUsername("userforjunit");
        assertNotNull(user);
    }
}
