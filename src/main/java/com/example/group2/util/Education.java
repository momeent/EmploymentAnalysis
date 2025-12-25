package com.example.group2.util;

public class Education {
    private String study_time;
    private String  university;
    private String major;
    private String qualification;
    private String major_cources;
    private String profession_rank;
    private String study_experience;

    public String getStudy_time() {
        return study_time;
    }

    public void setStudy_time(String study_time) {
        this.study_time = study_time;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String education) {
        this.qualification = education;
    }

    public String getMajor_cources() {
        return major_cources;
    }

    public void setMajor_cources(String major_cources) {
        this.major_cources = major_cources;
    }

    public String getProfession_rank() {
        return profession_rank;
    }

    public void setProfession_rank(String profession_rank) {
        this.profession_rank = profession_rank;
    }

    public String getStudy_experience() {
        return study_experience;
    }

    public void setStudy_experience(String study_experience) {
        this.study_experience = study_experience;
    }

    public Education(String study_time, String university, String major, String education, String major_cources, String profession_rank, String study_experience) {
        this.study_time = study_time;
        this.university = university;
        this.major = major;
        this.qualification = education;
        this.major_cources = major_cources;
        this.profession_rank = profession_rank;
        this.study_experience = study_experience;
    }

    public Education() {
    }

    @Override
    public String toString() {
        return "Education{" +
                "study_time='" + study_time + '\'' +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", education='" + qualification + '\'' +
                ", major_cources='" + major_cources + '\'' +
                ", profession_rank='" + profession_rank + '\'' +
                ", study_experience='" + study_experience + '\'' +
                '}';
    }
}
