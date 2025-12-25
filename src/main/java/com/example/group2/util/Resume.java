package com.example.group2.util;

import java.util.Arrays;

/**
 * 用户个人简历
 */
public class Resume {
    private String name;
    private String birthday_date;
    private String gender;
    private String graduation_year;
    private String city;
    private String identity;
    private String tel;
    private String email;
    private Expectation expectation;//期望的工作
    private String personal_advantages;
    private Experience[] experiences;
    private Project[] projects;
    private Education[] educations;
    private String[] honor;
    private String[] certificate;
    private String organization;
    private String major_skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(String birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(String graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Expectation getExpectation() {
        return expectation;
    }

    public void setExpectation(Expectation expectation) {
        this.expectation = expectation;
    }

    public String getPersonal_advantages() {
        return personal_advantages;
    }

    public void setPersonal_advantages(String personal_advantages) {
        this.personal_advantages = personal_advantages;
    }

    public Experience[] getExperiences() {
        return experiences;
    }

    public void setExperiences(Experience[] experiences) {
        this.experiences = experiences;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public Education[] getEducations() {
        return educations;
    }

    public void setEducations(Education[] educations) {
        this.educations = educations;
    }

    public String[] getHonor() {
        return honor;
    }

    public void setHonor(String[] honor) {
        this.honor = honor;
    }

    public String[] getCertificate() {
        return certificate;
    }

    public void setCertificate(String[] certificate) {
        this.certificate = certificate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMajor_skills() {
        return major_skills;
    }

    public void setMajor_skills(String major_skills) {
        this.major_skills = major_skills;
    }

    public Resume() {
    }

    public Resume(String name, String birthday_date, String gender, String graduation_year, String city, String identity, String tel, String email, Expectation expectation, String personal_advantages, Experience[] experiences, Project[] projects, Education[] educations, String[] honor, String[] certificate, String organization, String major_skills) {
        this.name = name;
        this.birthday_date = birthday_date;
        this.gender = gender;
        this.graduation_year = graduation_year;
        this.city = city;
        this.identity = identity;
        this.tel = tel;
        this.email = email;
        this.expectation = expectation;
        this.personal_advantages = personal_advantages;
        this.experiences = experiences;
        this.projects = projects;
        this.educations = educations;
        this.honor = honor;
        this.certificate = certificate;
        this.organization = organization;
        this.major_skills = major_skills;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", birthday_date='" + birthday_date + '\'' +
                ", gender='" + gender + '\'' +
                ", graduation_year='" + graduation_year + '\'' +
                ", city='" + city + '\'' +
                ", identity='" + identity + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", expectation=" + expectation +
                ", personal_advantages='" + personal_advantages + '\'' +
                ", experiences=" + Arrays.toString(experiences) +
                ", projects=" + Arrays.toString(projects) +
                ", educations=" + Arrays.toString(educations) +
                ", honor=" + Arrays.toString(honor) +
                ", certificate=" + Arrays.toString(certificate) +
                ", organization='" + organization + '\'' +
                ", major_skills='" + major_skills + '\'' +
                '}';
    }
}
