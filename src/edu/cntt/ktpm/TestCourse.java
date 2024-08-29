/*
 * @ (#) TestCrouse.java       1.0     29/08/2024
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


import java.util.*;

public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList();
        //boolean running = true;

        int n;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Lấy danh sách khóa học");
            System.out.println("3. Xóa khóa học");
            System.out.println("4. Tìm khóa học theo mã");
            System.out.println("5. Tìm khóa học theo tên");
            System.out.println("6. Tìm khóa học theo khoa");
            System.out.println("7. Sắp xếp khóa học theo tên");
            System.out.println("8. Tìm khóa học có số tín chỉ lớn nhất");
            System.out.println("9. Tìm khoa có nhiều khóa học nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn tùy chọn: ");
            n = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (n) {
                case 1:
                    System.out.print("Nhập mã khóa học: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    System.out.print("Nhập tên khoa phụ trách: ");
                    String department = scanner.nextLine();
                    Course course = new Course(id, title, credit, department);
                    courseList.addCourse(course);
                    break;
                case 2:
                    List<Course> courses = courseList.getCourses();
                    System.out.println("\nDanh sách khóa học:");
                    for (Course c : courses) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã khóa học để xóa: ");
                    String removeId = scanner.nextLine();
                    courseList.removeCourse(removeId);
                    break;
                case 4:
                    System.out.print("Nhập mã khóa học để tìm: ");
                    String findId = scanner.nextLine();
                    Course foundCourse = courseList.findCourseById(findId);
                    if (foundCourse != null) {
                        System.out.println(foundCourse);
                    } else {
                        System.out.println("Khóa học không tìm thấy.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên khóa học để tìm: ");
                    String searchTitle = scanner.nextLine();
                    List<Course> foundByTitle = courseList.findCoursesByTitle(searchTitle);
                    if (foundByTitle != null) {
                        System.out.println("\nKhóa học tìm được:");
                        for (Course c : foundByTitle) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Không tìm thấy khóa học nào.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên khoa để tìm: ");
                    String searchDepartment = scanner.nextLine();
                    List<Course> foundByDepartment = courseList.findCoursesByDepartment(searchDepartment);
                    if (foundByDepartment != null) {
                        System.out.println("\nKha học theo khoa:");
                        for (Course c : foundByDepartment) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Không tìm thấy khóa học nào.");
                    }
                    break;
                case 7:
                    List<Course> sortedCourses = courseList.sortCoursesByTitle();
                    System.out.println("\nDanh sách khóa học sau khi sắp xếp theo tên:");
                    for (Course c : sortedCourses) {
                        System.out.println(c);
                    }
                    break;
                case 8:
                    List<Course> maxCreditCourses = courseList.findCoursesWithMaxCredits();
                    if (maxCreditCourses != null) {
                        System.out.println("\nKhóa học có số tín chỉ lớn nhất:");
                        for (Course c : maxCreditCourses) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Danh sách khóa học trống.");
                    }
                    break;
                case 9:
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    if (departmentWithMostCourses != null) {
                        System.out.println("\nKhoa phụ trách có nhiều khóa học nhất: " + departmentWithMostCourses);
                    } else {
                        System.out.println("Danh sách khóa học trống.");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;

            }
        } while (n != 0);
    }
}