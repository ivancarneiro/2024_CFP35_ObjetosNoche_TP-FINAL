package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sun.source.doctree.IdentifierTree;

import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_impacts;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_severities;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_status;
import cfp35.objetosnoche.tpfinal.tickersec.enums.Ticket_types;


public class Incident extends Ticket{
    private String incidentId;
    private ArrayList<InetAddress> srcip;
    private ArrayList<InetAddress> srcport;
    private ArrayList<Integer> dstip;
    private ArrayList<Integer> dstport;
    private Integer reportId;

    public Incident(Integer id, String title, Ticket_types type, LocalDateTime createdAt, LocalDateTime lastUpdate, String resolution, Ticket_severities severity, Ticket_impacts impact, Integer category, Integer createdBy, Integer assignedTo, Ticket_status status, String resume) {
        super(id, title, type, createdAt, lastUpdate, resolution, severity, impact, category, createdBy, assignedTo, status, resume);
        this.incidentId = super.getType().name()+super.getId();
        this.srcip = new ArrayList<>();
        this.srcport = new ArrayList<>();
        this.dstip = new ArrayList<>();
        this.dstport = new ArrayList<>();
        this.reportId = null;
    }
}