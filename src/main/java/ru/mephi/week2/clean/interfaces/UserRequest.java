package ru.mephi.week2.clean.interfaces;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
}