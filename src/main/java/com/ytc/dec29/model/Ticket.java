package com.ytc.dec29.model;

import java.util.Objects;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Integer id;
    private String startCity;
    private String endCity;
    private Integer berth;
    private String startDate;
    private Company company;


    public Ticket() {
    }

    public Ticket(Integer id, String startCity, String endCity, Integer berth, String startDate, Company company) {
        this.id = id;
        this.startCity = startCity;
        this.endCity = endCity;
        this.berth = berth;
        this.startDate = startDate;
        this.company = company;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartCity() {
        return this.startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return this.endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Integer getBerth() {
        return this.berth;
    }

    public void setBerth(Integer berth) {
        this.berth = berth;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Ticket id(Integer id) {
        setId(id);
        return this;
    }

    public Ticket startCity(String startCity) {
        setStartCity(startCity);
        return this;
    }

    public Ticket endCity(String endCity) {
        setEndCity(endCity);
        return this;
    }

    public Ticket berth(Integer berth) {
        setBerth(berth);
        return this;
    }

    public Ticket startDate(String startDate) {
        setStartDate(startDate);
        return this;
    }

    public Ticket company(Company company) {
        setCompany(company);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ticket)) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(startCity, ticket.startCity) && Objects.equals(endCity, ticket.endCity) && Objects.equals(berth, ticket.berth) && Objects.equals(startDate, ticket.startDate) && Objects.equals(company, ticket.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startCity, endCity, berth, startDate, company);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", startCity='" + getStartCity() + "'" +
            ", endCity='" + getEndCity() + "'" +
            ", berth='" + getBerth() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", company='" + getCompany() + "'" +
            "}";
    }

}
