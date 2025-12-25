package com.example.group2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Job {
    private int id;
    private String jobName;
    private String monthlyPay;
    private String jobCity;
    private String companyLink;
    private String companyName;
    private String type;
}
