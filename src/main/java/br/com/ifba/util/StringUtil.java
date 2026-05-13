/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.util;

/**
 *
 * @author joaol
 */
public class StringUtil {

    //Verifica se uma string é nula ou vazia (length == 0).
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Verifica se uma string é nula, vazia ou contém apenas espaços em branco.
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Verifica se uma string não é nula, não é vazia e contém pelo menos um caractere não espaço.
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    //Verifica se uma string não é nula e não é vazia.
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}

