package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by wlniu on 4/29/15.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(InputManager.class)
public class UserManagerStaticTest {

    @Test
    public void testGetUserNumberInputUntilItValid() throws Exception {
        UserManager userManager = Mockito.spy(initUserManager());
        PowerMockito.mockStatic(InputManager.class);
        when(InputManager.getInput()).thenReturn("000-0000").thenReturn("000-0001");
        userManager.login();
        verify(userManager, times(1)).getUserIndex("000-0000");
        verify(userManager, times(1)).getUserIndex("000-0001");
        verify(userManager, times(1)).getExpectedPassword(0);
    }

    private UserManager initUserManager() {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("000-0001", "123456", "Mousse", "mousse@tw.com", "1111111");
        users.add(user1);
        User user2 = new User("000-0002", "654321", "Luca", "luca@tw.com", "0000000");
        users.add(user2);
        UserManager userManager = new UserManager();
        userManager.setUsers(users);
        return userManager;
    }
}
