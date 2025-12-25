package com.example.group2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Exam {
    private String category;
    private String examDate;
    private String pdfName;
    private String type;
}
