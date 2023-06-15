-- СОЗДАНИЕ БАЗЫ ДАННЫХ
-- Возможность создания БД, с целью избежания неквалифицированных
-- действий, лучше оставить за разработчиком.
-- Поэтому, такой функционал в приложении не прописываем.
-- Здесь, БД создаем через визуальный инструмент, например,
-- MySQL Workbench.
CREATE DATABASE shop_online;

-- СОЗДАНИЕ ТАБЛИЦ ---
-- Возможность создания таблиц БД, с целью избежания неквалифицированных
-- действий, лучше оставить за разработчиком.
-- Поэтому, такой функционал в приложении не прописываем.
-- Предварительно, необходимо спроектировать таблицы и их связи,
-- на основе сущностей реального мира.
-- Здесь, таблицы БД создаем через визуальный инструмент, например,
-- MySQL Workbench.

-- Таблица должностей персонала.
-- Делаем перечень необходимых должностей в отдельной таблице.
-- У разных работников может быть одна должность.
-- Можно легко редактировать значения (при необходимости).
CREATE TABLE IF NOT EXISTS positions
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- Внесение данных в таблицу должностей
INSERT INTO positions (name) VALUES (?);

-- Выборка должностей
SELECT * FROM positions;

-- Таблица работников
CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  lastName VARCHAR(128) NOT NULL,
  firstName VARCHAR(128) NOT NULL,
  birthDate DATE NOT NULL,
  positionId INTEGER NOT NULL,
  phone VARCHAR(32) NOT NULL,
  salary DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (positionId) REFERENCES positions(id)
);

-- Внесение данных в таблицу работников
INSERT INTO employees (lastName, firstName, birthDate, positionId, phone, salary) 
VALUES (?, ?, ?, ?, ?, ?);

-- Выборка работников
SELECT * FROM employees e 
INNER JOIN positions p ON e.positionId = p.id;

