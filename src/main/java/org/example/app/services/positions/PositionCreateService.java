package org.example.app.services.positions;

import org.example.app.entities.Position;
import org.example.app.exceptions.PositionCreateException;
import org.example.app.repositories.positions.PositionCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class PositionCreateService {

    PositionCreateRepository repository;

    public PositionCreateService(PositionCreateRepository repository) {
        this.repository = repository;
    }

    public String createPosition(Position position) {

        // Map для сбора ошибок
        Map<String, String> errors = new HashMap<>();

        if (position.getName().isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);

        if (errors.size() > 0) {
            try {
                throw new PositionCreateException("Check inputs", errors);
            } catch (PositionCreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.createPosition(position);
    }
}
