package model;

public class Administrator extends User{
    private String password;

    public Administrator(String name, CPF cpf, String password) {
        super(name, cpf);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String returnCSVLine() {
        StringBuilder sb;
        sb = new StringBuilder();

        sb.append(this.getName()).append(",");
        sb.append(this.getCpf()).append(",");
        sb.append(password);

        return sb.toString();
    }
}
