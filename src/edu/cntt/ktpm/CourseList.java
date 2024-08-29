/*
 * @ (#) CourseList.java       1.0     29/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package edu.cntt.ktpm;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * author: Nguyen Van Duc
 * @date: 29/08/2024
 * @version     1.0
 */


import java.util.*;


public class CourseList {
    private int count;
    // private ArrayList<Course> courses;
    private List<Course> courses;
    public CourseList() {
        this.courses = new ArrayList<>();
        this.count = 0;
    }
    public boolean addCourse(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                System.out.println("Mã khóa học đã tồn tại. Không thể thêm khóa học mới.");
                return false; // Không thêm khóa học vì mã đã tồn tại
            }
        }
        courses.add(course); // Thêm khóa học vào danh sách nếu mã chưa tồn tại
        return true;
    }
    public boolean removeCourse(String courseId) {
        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                courses.remove(c); // Xóa khóa học khỏi danh sách
                count--; // Giảm biến đếm khi xóa khóa học
                return true; // Trả về true khi xóa thành công
            }
        }
        // Thông báo lỗi nếu mã khóa học không tồn tại
        System.out.println("Mã khóa học không tồn tại. Không thể xóa.");
        return false; // Trả về false nếu không tìm thấy khóa học
    }
    public Course findCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                return c; // Trả về khóa học nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy khóa học
    }
    // Phương thức tìm kiếm các khóa học theo tên khóa học (tìm tương đối)
    public List<Course> findCoursesByTitle(String title) {
        List<Course> result = new ArrayList<>();
        if (title == null || title.isEmpty()) {
            System.out.println("Tên khóa học không hợp lệ.");
            return null;
        }

        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }

        return result.isEmpty() ? null : result;
    }

    // Phương thức tìm kiếm các khóa học theo khoa phụ trách
    public List<Course> findCoursesByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        if (department == null || department.isEmpty()) {
            System.out.println("Tên khoa không hợp lệ.");
            return null;
        }

        for (Course c : courses) {
            if (c.getDepartment().equalsIgnoreCase(department)) {
                result.add(c);
            }
        }

        return result.isEmpty() ? null : result;
    }
    // Phương thức sắp xếp các khóa học theo tên khóa học
    public List<Course> sortCoursesByTitle() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort(Comparator.comparing(Course::getTitle, String.CASE_INSENSITIVE_ORDER));
        return sortedCourses;
    }

    // Phương thức tìm các khóa học có số tín chỉ lớn nhất
    public List<Course> findCoursesWithMaxCredits() {
        List<Course> maxCreditCourses = new ArrayList<>();
        if (courses.isEmpty()) {
            return null; // Trả về null nếu danh sách khóa học trống
        }

        int maxCredit = Integer.MIN_VALUE;
        for (Course c : courses) {
            if (c.getCredit() > maxCredit) {
                maxCredit = c.getCredit();
            }
        }

        for (Course c : courses) {
            if (c.getCredit() == maxCredit) {
                maxCreditCourses.add(c);
            }
        }

        return maxCreditCourses;
    }

    // Phương thức tìm khoa phụ trách có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        Map<String, Integer> departmentCount = new HashMap<>();
        for (Course c : courses) {
            departmentCount.put(c.getDepartment(), departmentCount.getOrDefault(c.getDepartment(), 0) + 1);
        }

        String maxDepartment = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }

        return maxDepartment;
    }

    public List<Course> getCourses() {
        return courses;
    }
//    public class Validator {
//        public static boolean isValidId(String id) {
//            return id != null && id.matches("[a-zA-Z0-9]{3,}");
//        }
//    }
}
