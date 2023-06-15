package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionReadService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.positions.PositionReadView;

public class PositionReadController {

    PositionReadService service;
    PositionReadView view;

    public PositionReadController(PositionReadService service, PositionReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readPositions() {
        // Передаем запрос и получаем ответ.
        String str = service.readPositions();
        // Проверяем возврат чтения данных.
        // Если что-то не так, выводим сообщение об этом, и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.SMTH_WRONG_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление или данные.
            view.getOutput("\n_ Positions ___________\n" + str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}
