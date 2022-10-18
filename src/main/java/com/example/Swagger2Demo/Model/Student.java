package com.example.Swagger2Demo.Model;


import io.swagger.annotations.ApiModelProperty;

public class Student {

    @ApiModelProperty(notes = "Name of the Student", name = "name", required = true, value = "test name")
    private String name;
    @ApiModelProperty(notes = "Class of the Student", name = "cls", required = true, value = "test class")

    private String cls;
    @ApiModelProperty(notes = "Country of the Student", name = "country", required = true, value = "test country")

    private String country;

    ///////////////// variable /////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //////////// cosntructor //////

    public Student(String name, String cls, String country) {
        super();
        this.name = name;
        this.cls = cls;
        this.country = country;
    }





}
