package enums;

public enum Availability {
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível"),
    EM_MANUTENCAO("Em Manutenção"),
    RESERVADO("Reservado");

    private final String describe;

    Availability(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return this.describe;
    }
}