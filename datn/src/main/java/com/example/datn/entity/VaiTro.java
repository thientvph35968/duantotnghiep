package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VaiTro")
@Data
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VaiTro")
    private Integer idVaiTro;

    @Column(name = "MaVaiTro")
    private String maVaiTro;

    @Column(name = "TenVaiTro")
    private String tenVaiTro;
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
}
