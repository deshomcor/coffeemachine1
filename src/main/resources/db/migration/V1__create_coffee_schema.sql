-- V1__create_coffee_schema.sql

-- Создание таблицы кофемашин
CREATE TABLE coffeemachine (
                               id BIGSERIAL PRIMARY KEY
);

-- Создание таблицы рецептов
CREATE TABLE recipe (
                        id BIGSERIAL PRIMARY KEY,
                        recipename VARCHAR UNIQUE
);

-- Создание таблицы связей между кофемашинами и рецептами
CREATE TABLE coffeemachine_recipe (
                                      id BIGSERIAL PRIMARY KEY,
                                      coffeemachine_id BIGINT NOT NULL REFERENCES coffeemachine(id),
                                      recipe_id BIGINT NOT NULL REFERENCES recipe(id)
);

-- Создание таблицы заказов
CREATE TABLE "order" (
                         id BIGSERIAL PRIMARY KEY,
                         recipe_id BIGINT NOT NULL REFERENCES recipe(id),
                         date TIMESTAMP NOT NULL
);