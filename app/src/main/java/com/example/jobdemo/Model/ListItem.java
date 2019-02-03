package com.example.jobdemo.Model;

public class ListItem  {

    private String Name,Salary,Exp,Skills,Type,Job;

    public ListItem() {
    }

    public ListItem(String name, String salary, String exp, String skills, String type, String job) {
        Name = name;
        Salary = salary;
        Exp = exp;
        Skills = skills;
        Type = type;
        Job = job;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}
