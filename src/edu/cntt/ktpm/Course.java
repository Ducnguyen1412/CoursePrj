/*
 * @ (#) Course.java       1.0     29/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package edu.cntt.ktpm;

/*
 * @description:
 * author: Nguyen Van Duc
 * @date: 29/08/2024
 * @version     1.0
 */
public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;
    public Course(String id, String title, int credit, String department) {
    }
    public Course() {
//       if(credit > 0){
//           this.credit = credit;
//       }
//        this.department = department;
//        this.id = id;
//        this.title = title;

    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


}
