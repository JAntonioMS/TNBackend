package com.softitlan.tortuganinja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_account")
@NamedQueries({
        @NamedQuery(name = "AccountVO.getListAccount", query = "SELECT c FROM AccountVO as c WHERE c.id_user = :id_user")
})
public class AccountVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer id_user;

    @Column
    private String title;

    @Column
    private String label1;

    @Column
    private String label2;


    @Column
    private String label3;


    @Column
    private String label4;


    @Column
    private String label5;

    @Column
    private String value1;

    @Column
    private String value2;

    @Column
    private String value3;

    @Column
    private String value4;

    @Column
    private String value5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    public String getLabel4() {
        return label4;
    }

    public void setLabel4(String label4) {
        this.label4 = label4;
    }

    public String getLabel5() {
        return label5;
    }

    public void setLabel5(String label5) {
        this.label5 = label5;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    @Override
    public String toString() {
        return "AccountVO{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", title='" + title + '\'' +
                ", label1='" + label1 + '\'' +
                ", label2='" + label2 + '\'' +
                ", label3='" + label3 + '\'' +
                ", label4='" + label4 + '\'' +
                ", label5='" + label5 + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", value5='" + value5 + '\'' +
                '}';
    }
}
