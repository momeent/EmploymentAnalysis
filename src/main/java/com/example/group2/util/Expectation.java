package com.example.group2.util;

public class Expectation {
    private String expected_industry;
    private String expected_position;
    private String position_details;
    private String salary_requirements;
    private String work_city;
    private String other_city;

    public String getExpected_industry() {
        return expected_industry;
    }

    public void setExpected_industry(String expected_industry) {
        this.expected_industry = expected_industry;
    }

    public String getExpected_position() {
        return expected_position;
    }

    public void setExpected_position(String expected_position) {
        this.expected_position = expected_position;
    }

    public String getPosition_details() {
        return position_details;
    }

    public void setPosition_details(String position_details) {
        this.position_details = position_details;
    }

    public String getSalary_requirements() {
        return salary_requirements;
    }

    public void setSalary_requirements(String salary_requirements) {
        this.salary_requirements = salary_requirements;
    }

    public String getWork_city() {
        return work_city;
    }

    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }

    public String getOther_city() {
        return other_city;
    }

    public void setOther_city(String other_city) {
        this.other_city = other_city;
    }

    public Expectation() {
    }

    public Expectation(String expected_industry, String expected_position, String position_details, String salary_requirements, String work_city, String other_city) {
        this.expected_industry = expected_industry;
        this.expected_position = expected_position;
        this.position_details = position_details;
        this.salary_requirements = salary_requirements;
        this.work_city = work_city;
        this.other_city = other_city;
    }

    @Override
    public String toString() {
        return "Expectation{" +
                "expected_industry='" + expected_industry + '\'' +
                ", expected_position='" + expected_position + '\'' +
                ", position_details='" + position_details + '\'' +
                ", salary_requirements='" + salary_requirements + '\'' +
                ", work_city='" + work_city + '\'' +
                ", other_city='" + other_city + '\'' +
                '}';
    }
}
