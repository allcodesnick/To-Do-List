package com.allcodesnick.todolist.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String taskName;

    private String description;

    private java.sql.Date dueDate;

    @Type(type = "yes_no")
    private boolean completed;

}
