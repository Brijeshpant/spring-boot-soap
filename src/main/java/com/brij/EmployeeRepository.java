package com.brij;

import com.brijeshpant.soap.gen.Employee;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmployeeRepository {

    private static final Map<Integer, Employee> countries = new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger();


    public Employee getEmployee(int empId) {
        Assert.notNull(empId, "The employee's id must not be null");
        return countries.get(empId);
    }
    public Employee createEmployee(Employee employee) {
        int id = counter.incrementAndGet();
        employee.setEmpId(id);
        Assert.notNull(id, "The employee's id must not be null");
        countries.put(id,employee);
        return employee;
    }
}