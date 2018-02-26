package com.example.android.myloctionapp;

/**
 * Created by eKasiLab Alex CDTB on 2018/02/09.
 */

public class ReportIssuesClass {

    private String name;
    private String address;
    private String problems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReport() {
        return problems;
    }

    public void setReport(String report) {
        this.problems = problems;
    }

    public ReportIssuesClass(String name, String address, String report) {
        this.name = name;
        this.address = address;
        this.problems = report;
    }
}
