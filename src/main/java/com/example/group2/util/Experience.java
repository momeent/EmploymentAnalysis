package com.example.group2.util;

/**
 * 工作/实习经历
 */
public class Experience {
    private String work_time;
    private String company_name;
    private String position_name;
    private String industry;
    private String job_description;
    private String isInternship;

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getIsInternship() {
        return isInternship;
    }

    public void setIsInternship(String isInternship) {
        this.isInternship = isInternship;
    }

    public Experience(String work_time, String company_name, String position_name, String industry, String job_description, String isInternship) {
        this.work_time = work_time;
        this.company_name = company_name;
        this.position_name = position_name;
        this.industry = industry;
        this.job_description = job_description;
        this.isInternship = isInternship;
    }

    public Experience() {
    }

    @Override
    public String toString() {
        return "Experience{" +
                "work_time='" + work_time + '\'' +
                ", company_name='" + company_name + '\'' +
                ", position_name='" + position_name + '\'' +
                ", industry='" + industry + '\'' +
                ", job_description='" + job_description + '\'' +
                ", isInternship='" + isInternship + '\'' +
                '}';
    }
}
