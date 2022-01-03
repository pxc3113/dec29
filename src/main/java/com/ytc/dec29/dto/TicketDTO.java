package com.ytc.dec29.dto;

import java.util.Objects;
import com.ytc.dec29.model.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Integer id;
    private String startCity;
    private String endCity;
    private Integer berth;
    private String startDate;
    private String startDateLeft;
    private String startDateRight;
    private Integer companyId;
    private Company company;

    public TicketDTO() {
    }

    public TicketDTO(Integer id, String startCity, String endCity, Integer berth, String startDate, String startDateLeft, String startDateRight, Integer companyId, Company company) {
        this.id = id;
        this.startCity = startCity;
        this.endCity = endCity;
        this.berth = berth;
        this.startDate = startDate;
        this.startDateLeft = startDateLeft;
        this.startDateRight = startDateRight;
        this.companyId = companyId;
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

    public String getStartDateLeft() {
        return this.startDateLeft;
    }

    public void setStartDateLeft(String startDateLeft) {
        this.startDateLeft = startDateLeft;
    }

    public String getStartDateRight() {
        return this.startDateRight;
    }

    public void setStartDateRight(String startDateRight) {
        this.startDateRight = startDateRight;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public TicketDTO id(Integer id) {
        setId(id);
        return this;
    }

    public TicketDTO startCity(String startCity) {
        setStartCity(startCity);
        return this;
    }

    public TicketDTO endCity(String endCity) {
        setEndCity(endCity);
        return this;
    }

    public TicketDTO berth(Integer berth) {
        setBerth(berth);
        return this;
    }

    public TicketDTO startDate(String startDate) {
        setStartDate(startDate);
        return this;
    }

    public TicketDTO startDateLeft(String startDateLeft) {
        setStartDateLeft(startDateLeft);
        return this;
    }

    public TicketDTO startDateRight(String startDateRight) {
        setStartDateRight(startDateRight);
        return this;
    }

    public TicketDTO companyId(Integer companyId) {
        setCompanyId(companyId);
        return this;
    }

    public TicketDTO company(Company company) {
        setCompany(company);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TicketDTO)) {
            return false;
        }
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id) && Objects.equals(startCity, ticketDTO.startCity) && Objects.equals(endCity, ticketDTO.endCity) && Objects.equals(berth, ticketDTO.berth) && Objects.equals(startDate, ticketDTO.startDate) && Objects.equals(startDateLeft, ticketDTO.startDateLeft) && Objects.equals(startDateRight, ticketDTO.startDateRight) && Objects.equals(companyId, ticketDTO.companyId) && Objects.equals(company, ticketDTO.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startCity, endCity, berth, startDate, startDateLeft, startDateRight, companyId, company);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", startCity='" + getStartCity() + "'" +
            ", endCity='" + getEndCity() + "'" +
            ", berth='" + getBerth() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", startDateLeft='" + getStartDateLeft() + "'" +
            ", startDateRight='" + getStartDateRight() + "'" +
            ", companyId='" + getCompanyId() + "'" +
            ", company='" + getCompany() + "'" +
            "}";
    }

}