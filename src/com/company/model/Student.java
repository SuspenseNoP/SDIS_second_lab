package com.company.model;

public class Student {
    private String name;
            private int  group, illnesses, reasons, noReasons, all;

    public Student(String name, int group,  int illnesses, int reasons,int noReasons, int all){
        this.noReasons =noReasons;
        this.group = group;
        this.name =name;
        this.illnesses = illnesses;
        this.reasons = reasons;
        this.all = all;
    }



    public int getNoReasons() {
        return noReasons;
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public int getIllnesses() {
        return illnesses;
    }

    public int getReasons() {
        return reasons;
    }

    public int getAll() {
        return all;
    }
}
