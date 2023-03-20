package com.zhiyou.Game.CarRental.CarRentalPlus;

public enum Role {
    Admin("Admin"),
    User("User");
    private String role;

    Role() {
    }

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


    public String toString() {
        return "Role{Admin = " + Admin + ", User = " + User + ", role = " + role + "}";
    }
}
