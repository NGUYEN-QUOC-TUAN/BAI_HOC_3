package com.example.bai_hoc_2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Student {
    private String name;
    private Boolean gender;
    private Double marks;
    private Contact contact;
    private List<String> subjects;
}
