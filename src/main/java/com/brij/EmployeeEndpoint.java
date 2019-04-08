package com.brij;

import com.brijeshpant.soap.gen.CreateEmployeeRequest;
import com.brijeshpant.soap.gen.CreateEmployeeResponse;
import com.brijeshpant.soap.gen.GetEmployeeRequest;
import com.brijeshpant.soap.gen.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://brijeshpant.com/soap/gen";

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(employeeRepository.getEmployee(request.getId()));

        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployee(employeeRepository.createEmployee(request.getEmployee()));

        return response;
    }
}