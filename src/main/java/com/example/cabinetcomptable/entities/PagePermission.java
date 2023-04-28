package com.example.cabinetcomptable.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "page_permission")
public class PagePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotNull
    private String NamePermission;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePermission() {
        return NamePermission;
    }

    public void setNamePermission(String namePermission) {
        NamePermission = namePermission;
    }
}
