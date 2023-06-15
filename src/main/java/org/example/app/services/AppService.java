package org.example.app.services;

import org.example.app.controllers.employees.EmployeeController;
import org.example.app.controllers.positions.PositionController;
import org.example.app.exceptions.OptionException;
import org.example.app.services.employees.EmployeeService;
import org.example.app.services.positions.PositionService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeView;
import org.example.app.views.positions.PositionView;


public class AppService {

    public void getPositions() {
        PositionView view = new PositionView();
        PositionService service = new PositionService();
        PositionController controller = new PositionController(view, service);
        controller.runPositions();
    }

    public void getEmployees() {
        EmployeeView view = new EmployeeView();
        EmployeeService service = new EmployeeService();
        EmployeeController controller = new EmployeeController(view, service);
        controller.runEmployees();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Проверка наличия ввода в массиве выбора
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
