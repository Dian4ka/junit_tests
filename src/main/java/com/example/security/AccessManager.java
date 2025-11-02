package com.example.security;

public class AccessManager {

    public boolean canRead(User user) {
        return true;
    }

    public boolean canCreate(User user) {
        return user.getRole() == Role.ADMIN;
    }

    public boolean canUpdate(User user) {
        return user.getRole() == Role.ADMIN;
    }

    public boolean canDelete(User user) {
        return user.getRole() == Role.ADMIN;
    }

    public void validateUser(User user) {
        if (user == null || user.getRole() == null) {
            throw new IllegalArgumentException("Invalid user or role");
        }
    }
}
