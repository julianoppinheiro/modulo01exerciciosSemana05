package com.aulaspring.aula.servicos;

public class Validador {

    public static boolean verificarCpf(String xCPF) {
        try {
            int d1, d4, xx, nCount, resto, digito1, digito2;
            String Check;
            String Separadores = "/-.";
            d1 = 0;
            d4 = 0;
            xx = 1;
            for (nCount = 0; nCount < xCPF.length() - 2; nCount++) {
                String s_aux = xCPF.substring(nCount, nCount + 1);
                if (Separadores.indexOf(s_aux) == -1) {
                    d1 = d1 + (11 - xx) * Integer.valueOf(s_aux).intValue();
                    d4 = d4 + (12 - xx) * Integer.valueOf(s_aux).intValue();
                    xx++;
                }
                ;
            }
            ;

            /*Implementado para que n�o possa colocar um CPF somente com zeros*/
            if ((d1 + d4) <= 0) {
                return false;
            }

            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }

            d4 = d4 + 2 * digito1;
            resto = (d4 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }

            Check = String.valueOf(digito1) + String.valueOf(digito2);

            String s_aux2 = xCPF.substring(xCPF.length() - 2, xCPF.length());

            System.out.println(s_aux2);

            if(s_aux2.compareTo(Check) != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verificarCnpj(String xCGC) {
        try {
            int d1, d4, xx, nCount, fator, resto, digito1, digito2;
            String Check, s_aux;
            String Separadores = "/-.";
            d1 = 0;
            d4 = 0;
            xx = 0;
            for (nCount = 0; nCount < xCGC.length() - 2; nCount++) {
                s_aux = xCGC.substring(nCount, nCount + 1);
                if (Separadores.indexOf(s_aux) == -1) {
                    if (xx < 4) {
                        fator = 5 - xx;
                    } else {
                        fator = 13 - xx;
                    }

                    d1 = d1 + Integer.valueOf(s_aux).intValue() * fator;
                    if (xx < 5) {
                        fator = 6 - xx;
                    } else {
                        fator = 14 - xx;
                    }
                    d4 += Integer.valueOf(s_aux).intValue() * fator;
                    xx++;
                }
                ;
            }

            /*Implementado para que n�o possa colocar um CNPJ somente com zeros*/
            if ((d1 + d4) <= 0) {
                return false;
            }

            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }

            d4 = d4 + 2 * digito1;
            resto = (d4 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }

            Check = String.valueOf(digito1) + String.valueOf(digito2);
            System.out.println( Check );

            if (Check.compareTo(xCGC.substring(xCGC.length() - 2, xCGC.length())) != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
