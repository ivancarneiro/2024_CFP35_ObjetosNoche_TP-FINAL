package cfp35.objetosnoche.tpfinal.tickersec.enums;

public enum Ticket_severities {
    CRITICA("(9.0 - 10.0)"),
    ALTA("(7.0 - 8.9)"),
    MEDIA("(4.0 - 6.9)"),
    BAJA("(0.1 - 3.9)"),
    NA("Falta análisis");

    private final String displayName;

    Ticket_severities(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
