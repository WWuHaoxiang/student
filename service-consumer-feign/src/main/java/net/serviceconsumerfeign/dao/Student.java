package net.serviceconsumerfeign.dao;


import lombok.Getter;

@Getter
public class Student {

    private long id;

    private long studentId;

    private String email;

    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
