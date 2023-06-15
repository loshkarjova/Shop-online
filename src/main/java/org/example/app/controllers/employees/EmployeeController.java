package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeService;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeView;

public class EmployeeController {
    private final EmployeeView view;
    private final EmployeeService service;

    public EmployeeController(EmployeeView view, EmployeeService service) {
        this.view = view;
        this.service = service;
    }

    public void runEmployees() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.createEmployees();
            case 2 -> service.readEmployees();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }
}
