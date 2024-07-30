package cfp35.objetosnoche.tpfinal.tickersec.enums;

public enum Ticket_types {
    INC("Incidente"),
    VUL("Vulnerabilidad"),
    EVE("Evento");

    private final String displayName;

    Ticket_types(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
