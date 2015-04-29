package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;


public class UserManagerTest extends TestCase {

    @Test
    public void testGetUserIndex() throws Exception {
        UserManager userManager = initUserManager();
        int index = userManager.getUserIndex("000-0001");
        assertEquals(0, index);
        int index2 = userManager.getUserIndex("000-0003");
        assertEquals(-1, index2);
    }

    @Test
    public void testGetExpectedPassword() throws Exception {
        UserManager userManager = initUserManager();
        String expectedPassword = userManager.getExpectedPassword(0);
        assertEquals(expectedPassword, "123456");
    }

    @Test
    public void testValidatePassword() throws Exception {
        UserManager userManager = new UserManager();
        assertTrue(userManager.validatePassword("111", "111"));
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