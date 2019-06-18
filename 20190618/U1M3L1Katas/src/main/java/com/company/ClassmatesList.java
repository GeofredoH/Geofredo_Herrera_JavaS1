package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate> students = new ArrayList<>();

    public void add(Classmate classmate) {
        students.add(classmate);
    }

    public Classmate get(int num) {
        return students.get(num);
    }

    public List<Classmate> getAll() {
        return students;
    }
}
