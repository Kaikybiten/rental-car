package model;

import inteface.CsvDatas;

public class User implements CsvDatas {
    private final String name;
    private final CPF cpf;


    public User (String name, CPF cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    @Override
    public String returnCSVLine() {
        StringBuilder csv;
        csv = new StringBuilder();

        csv.append(name).append(",");
        csv.append(cpf.getCPF());

        return csv.toString();
    }
}
