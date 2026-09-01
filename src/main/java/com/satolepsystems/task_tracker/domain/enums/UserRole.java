package com.satolepsystems.task_tracker.domain.enums;

public enum UserRole {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
