package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NhanVien")
@Data
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NhanVien")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_VaiTro")
    private VaiTro vaiTro;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TenNhanVien")
    private String tenNhanVien;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
