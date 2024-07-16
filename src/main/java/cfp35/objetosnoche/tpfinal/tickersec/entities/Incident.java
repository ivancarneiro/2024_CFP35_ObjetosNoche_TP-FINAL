package cfp35.objetosnoche.tpfinal.tickersec.entities;

import java.net.InetAddress;
import java.util.ArrayList;


public class Incident extends Ticket{
    private Integer id;
    private ArrayList<InetAddress> srcip;
    private ArrayList<InetAddress> srcport;
    private ArrayList<Integer> dstip;
    private ArrayList<Integer> dstport;
    private Integer reportId;
}
