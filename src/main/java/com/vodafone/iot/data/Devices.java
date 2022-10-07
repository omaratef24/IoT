package com.vodafone.iot.data;

import javax.persistence.*;

@Entity
@Table(name="DEVICES")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SIM_ID")
    private Long ID;

    @Column(name="OPCODE")
    private String OPCODE;

    @Column(name="COUNTRY")
    private String COUNTRY;

    @Column(name="STATUS")
    private String STATUS;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getOPCODE() {
        return OPCODE;
    }

    public void setOPCODE(String OPCODE) {
        this.OPCODE = OPCODE;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "ID=" + ID +
                ", OPCODE='" + OPCODE + '\'' +
                ", COUNTRY='" + COUNTRY + '\'' +
                ", STATUS='" + STATUS + '\'' +
                '}';
    }
}
