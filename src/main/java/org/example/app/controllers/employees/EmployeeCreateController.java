package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeCreateView;

public class EmployeeCreateController {
    private EmployeeCreateView view;
    private Employee employee;
    private EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateView view, EmployeeCreateService service) {
        this.view = view;
        this.service = service;
    }

    public void createEmployee() {
        employee = view.getData();
        String str = service.createEmployee(employee);
        if (str.equals(Constants.SMTH_WRONG_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}
