package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionService;
import org.example.app.utils.Constants;
import org.example.app.views.positions.PositionView;

public class PositionController {

    PositionView view;
    PositionService service;

    public PositionController(PositionView view, PositionService service) {
        this.view = view;
        this.service = service;
    }

    public void runPositions() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.createPosition();
            case 2 -> service.readPositions();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }
}
