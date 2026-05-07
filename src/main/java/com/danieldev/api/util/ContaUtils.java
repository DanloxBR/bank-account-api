package com.danieldev.api.util;

import java.util.Random;

public class ContaUtils {
    private static final Random RANDOM = new Random();
    private ContaUtils() {
    }

    public static String gerarNumeroConta() {
        int numero = 100000 + RANDOM.nextInt(900000);
        return String.valueOf(numero);
    }

    public static boolean validarNumeroConta(String numeroConta) {
        return numeroConta != null && numeroConta.matches("\\d{6}");
    }
}