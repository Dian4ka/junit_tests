package com.example.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessManagerTest {

    private AccessManager manager;
    private User admin;
    private User user;
    private User guest;

    @BeforeEach
    void setUp() {
        manager = new AccessManager();
        admin = new User("admin", Role.ADMIN);
        user = new User("user", Role.USER);
        guest = new User("guest", Role.GUEST);
    }

    @Test
    void testAdminCanCreate() {
        assertTrue(manager.canCreate(admin));
    }

    @Test
    void testAdminCanDelete() {
        assertTrue(manager.canDelete(admin));
    }

    @Test
    void testAdminCanUpdate() {
        assertTrue(manager.canUpdate(admin));
    }

    @Test
    void testAdminCanRead() {
        assertTrue(manager.canRead(admin));
    }

    @Test
    void testUserCanRead() {
        assertTrue(manager.canRead(user));
    }

    @Test
    void testUserCannotDelete() {
        assertFalse(manager.canDelete(user));
    }

    @Test
    void testGuestCannotUpdate() {
        assertFalse(manager.canUpdate(guest));
    }

    @Test
    void testGuestCannotCreate() {
        assertFalse(manager.canCreate(guest));
    }

    @Test
    void testInvalidUserThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> manager.validateUser(null));
    }

    @Test
    void testMultipleUserAccess() {
        assertTrue(manager.canRead(admin));
        assertTrue(manager.canRead(user));
        assertTrue(manager.canRead(guest));
    }
}
