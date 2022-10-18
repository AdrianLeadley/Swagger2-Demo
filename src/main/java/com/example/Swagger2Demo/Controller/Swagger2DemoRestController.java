package com.example.Swagger2Demo.Controller;

import com.example.Swagger2Demo.Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Swagger2DemoRestController", description = "Rest Apis related to Student Entity!!")
@RestController
public class Swagger2DemoRestController {

    List<Student> students = new ArrayList<>();
    {
        students.add(new Student("Emina", "5", "Kurdistan"));
        students.add(new Student("Anoop", "10", "UK"));
        students.add(new Student("Will", "11", "Spain"));
        students.add(new Student("Osmama", "1", "Egypt"));
        students.add(new Student("Boss", "3", "Czech"));
        students.add(new Student("Dorothe", "1", "Africa"));
        students.add(new Student("Mo", "12", "Africa"));

    }

    @ApiOperation(value = "Get list of Students in the System", response = Iterable.class, tags = "getStudents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message =  "Success || oka!"),
            @ApiResponse(code = 401, message =  "not author"),
            @ApiResponse(code = 402, message =  "forbidden"),
            @ApiResponse(code = 403, message =  "not found")
    })

    @RequestMapping(value = "/getStudents")
    public List<Student> getStudents(){
        return students;
    }

    @ApiOperation(value = "Get Specific Student in the system", response = Student.class, tags = "getStudent")
    @RequestMapping(value = "/getStudentByName{name}")
    public Student getStudent(@PathVariable(value = "name") String name){
        return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get Specific Student in the System By Country", response =
            Student.class, tags = "getStudentByCountry")
    @RequestMapping(value = "/getStudentByCountry{country}")
    public List<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
        System.out.println("Searching Student in Country:" + country);
        List<Student> studentByCountry = students.stream().filter(x -> x.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
        System.out.println(studentByCountry);
        return studentByCountry;
    }
    @ApiOperation(value = "Get Specific Student in the System By Class", response =
            Student.class, tags = "getStudentByClass")
    @RequestMapping(value = "/getStudentByClass{cls}")
    public List<Student> getStudentByClass(@PathVariable(value = "cls")String cls){
        return students.stream().filter(x -> x.getCls().equalsIgnoreCase(cls)).collect(Collectors.toList());

    }



    }



