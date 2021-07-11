package com.example.offline_1;

import androidx.viewpager.widget.PagerAdapter;

public class info {

    private String userId;
    private String name;
    private String studentId;

    info(String userId,String name,String studentId)
    {
        this.name = name;
        this.userId = userId;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUserId() {
        return userId;
    }
}
