package com.endava.moderator.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
