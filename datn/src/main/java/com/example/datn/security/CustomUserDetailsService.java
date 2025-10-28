package com.example.datn.security;

import com.example.datn.entity.NhanVien;
import com.example.datn.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== ĐANG TÌM USER: " + username);

        NhanVien nhanVien = nhanVienRepository.findByTaiKhoan(username)
                .orElseThrow(() -> {
                    System.out.println("❌ KHÔNG TÌM THẤY USER: " + username);
                    return new UsernameNotFoundException("Không tìm thấy tài khoản: " + username);
                });

        System.out.println("✅ TÌM THẤY USER: " + nhanVien.getTaiKhoan());
        System.out.println("   - Mật khẩu trong DB: " + nhanVien.getMatKhau());
        System.out.println("   - Trạng thái: " + nhanVien.getTrangThai());

        if (nhanVien.getVaiTro() != null) {
            System.out.println("   - Vai trò: " + nhanVien.getVaiTro().getTenVaiTro());
        } else {
            System.out.println("   - ⚠️ VAI TRÒ NULL!");
        }

        return new CustomUserDetails(nhanVien);
    }
}