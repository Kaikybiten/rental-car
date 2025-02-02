package model;

import exception.CpfException;

import java.util.Objects;

public class CPF {
    final private String CPF;

    public CPF(String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new CpfException("The CPF must consist of a non-constant sequence of 11 digits.");
        }
        if (!isValidCPF(cpf)){
            throw new CpfException("Invalid CPF");
        }
        this.CPF = cpf;
    }

    private static boolean isValidCPF(String cpf){

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")){
            throw new CpfException("The CPF must have 11 digits that cannot be a constant sequence.");
        }

        int firstDigitSum = 0;
        for (int i = 0; i < 9; i++){
            int digit = Integer.parseInt(String.valueOf(cpf.charAt(i)));

            firstDigitSum += digit * (10 - i);
        }

        int secondDigitSum = 0;
        for (int i = 0; i < 10; i++){
            int digit = Integer.parseInt(String.valueOf(cpf.charAt(i)));

            secondDigitSum += digit * (11 - i);
        }

        int firstDigit = firstDigitSum % 11 < 2 ? 0 : 11 - (firstDigitSum % 11);
        int secondDigit = secondDigitSum % 11 < 2 ? 0 : 11 - (secondDigitSum % 11);

        char firstCheckDigit = cpf.charAt(9);
        char secondCheckDigit = cpf.charAt(10);

        return firstDigit == Character.getNumericValue(firstCheckDigit) && secondDigit == Character.getNumericValue(secondCheckDigit);
    }

    public String getCPF() {
        return CPF;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(CPF, cpf.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }

    @Override
    public String toString() {
        return this.CPF;
    }
}
