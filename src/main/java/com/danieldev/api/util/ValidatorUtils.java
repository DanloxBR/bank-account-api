package com.danieldev.api.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class ValidatorUtils {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private ValidatorUtils() {
    }

    public static boolean emailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    public static boolean senhaValida(String senha) {
        return senha != null && senha.length() >= 6;
    }
    public static boolean valorValido(BigDecimal valor) {
        return valor != null && valor.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
}