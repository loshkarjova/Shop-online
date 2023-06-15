package org.example.app.services.positions;

import org.example.app.controllers.positions.PositionCreateController;
import org.example.app.controllers.positions.PositionReadController;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.positions.PositionCreateRepository;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.positions.PositionCreateView;
import org.example.app.views.positions.PositionReadView;

public class PositionService {

    public void createPosition() {
        PositionCreateRepository repository = new PositionCreateRepository();
        PositionCreateService service = new PositionCreateService(repository);
        PositionCreateView view = new PositionCreateView();
        PositionCreateController controller = new PositionCreateController(service, view);
        controller.createPosition();
    }

    public void readPositions() {
        PositionReadRepository repository = new PositionReadRepository();
        PositionReadService service = new PositionReadService(repository);
        PositionReadView view = new PositionReadView();
        PositionReadController controller = new PositionReadController(service, view);
        controller.readPositions();
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
