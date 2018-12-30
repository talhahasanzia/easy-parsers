package com.talhahasanzia.sampleapp.models;

public class SampleObject {
    private String name;
    private String comment;
    private String title;
    private int age;

    public SampleObject() {
    }

    public SampleObject(String name, String comment, String title, int age) {
        this.name = name;
        this.comment = comment;
        this.title = title;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " :: " + comment + " :: " + title + " :: " + age;
    }
}
