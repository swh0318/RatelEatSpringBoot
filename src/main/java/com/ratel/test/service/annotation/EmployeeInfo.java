package com.ratel.test.service.annotation;

public class EmployeeInfo {
    @EmployeeName("zfq")
    private String employeeName;
    @EmployeeSex(employeeSex = EmployeeSex.Sex.Woman)
    private String employeeSex;
    @Company(id = 1,name = "文华集团",address = "河北衡水")
    private String company;
}
