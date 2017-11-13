package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 自定义加密方法实现
 */
public class MyPasswordEncoder implements PasswordEncoder {

    private static final String SECRET_KEY = "my-secret-key";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(SECRET_KEY);

    @Override
    public String encode(CharSequence charSequence) {
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encoder.matches(charSequence, s);
    }

    public static void main(String[] args) {
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        System.out.println(bc.encode("test"));
        System.out.println(bc.encode("test"));
        System.out.println(bc.matches("test", "$2a$10$iGuMRmvMgyxjzH8sdDc5H.IElUDMsH.CKYizY0.SvpB4i/.ssy5r2"));
        System.out.println(myPasswordEncoder.encode("test"));
        System.out.println(myPasswordEncoder.encode("test"));
        System.out.println(myPasswordEncoder.matches("test", myPasswordEncoder.encode("test")));
    }
}
