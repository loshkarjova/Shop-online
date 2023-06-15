package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.repositories.positions.PositionReadRepository;

public class EmployeeCreateService {

    private final EmployeeCreateRepository repository;
    private final PositionReadRepository positionRepository;

    public EmployeeCreateService(EmployeeCreateRepository repository, PositionReadRepository positionRepository) {
        this.repository = repository;
        this.positionRepository = positionRepository;
    }

    public String createEmployee(Employee employee) {
        if (employee.getPositionId() != null) {
            positionRepository.checkById(employee.getPositionId());
        }
        if (employee.getPositionName() != null) {
            positionRepository.checkByName(employee.getPositionName());
        }
        if (employee.getLastName().isEmpty() ||
            employee.getFirstName().isEmpty() ||
            employee.getBirthDate().isEmpty() ||
            employee.getPhone().isEmpty() ||
            employee.getSalary() <= 0) {
            throw new RuntimeException();
        }
        return repository.createEmployee(employee);
    }
}
