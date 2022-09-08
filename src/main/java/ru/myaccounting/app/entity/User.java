package ru.myaccounting.app.entity;

import ru.myaccounting.app.entity.enums.ERole;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String status;
    private String password;

    private Set<ERole> role = new HashSet<>();
    private List<Transfer> transfer = new ArrayList<>();
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
