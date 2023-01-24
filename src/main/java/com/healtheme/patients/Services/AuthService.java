package com.healtheme.patients.Services;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    String getIdentifier(HttpServletRequest request);
}
