# Сервис по сборке автомобилей

Этот сервис предоставляет бэкенд-решение для сборки автомобилей с использованием существующих деталей. 
Реализован на Spring Boot (версия 3.2.0), написан на Java 17. Приложение поддерживает сборку автомобилей с использованием двух основных компонентов: Кузова автомобиля и Колес. Данные для этих компонентов хранятся в базе данных PostgreSQL.

## Используемые технологии
- Spring Boot 3.2.0
- Java 17
- PostgreSQL
- Hibirnate

## Установка
  1. **Клонируйте репозиторий на свой локальный компьютер**
  2. **По желанию собрать повторно проект**
  3. **Запустите файл `docker-compose.yaml` или через командной строке напишите команду `docker-compose up`**

## Схема базы данных 
Приложение использует реляционную базу данных со следующими таблицами:

### Таблица CarBody

- `id`: Уникальный идентификатор кузова автомобиля.
- `type`: Тип кузова автомобиля (Хэтчбек, Седан).

### Таблица CarWheel

- `id`: Уникальный идентификатор колеса автомобиля.
- `size`: Размер колеса автомобиля (R15, R16, R17).

### Таблица Car

- `id`: Уникальный идентификатор автомобиля.
- `carBody`: Внешний ключ, ссылающийся на таблицу CarBody.
- `carWheel`: Внешний ключ, ссылающийся на таблицу CarWheel.
- `numberOfWheels`: Число колес для автомобиля
- `coolName`: Крутое название автомобиля

## API-точки

### Получить все кузова автомобилей

- **Endpoint:** `/api/car-bodies/getAllCarBody`
- **HTTP Method:** `GET`
- **Описание:** Возвращает информацию о всех существующих кузовах автомобилей.
- **Формат ответа:**
  ```json
  [
      {
          "id": 1,
          "type": "Hatchback"
      },
      {
          "id": 2,
          "type": "Sedan"
      }
  ]

### Получить все типы колес автомобилей

- **Endpoint:** `/api/car-wheels/getAllCarWheels`
- **HTTP Method:** `GET`
- **Описание:** Возвращает информацию о всех существующих колес автомобилей.
- **Формат ответа:**
  ```json
  [
      {
          "id": 1,
          "size": "R15"
          "availableQuantity": 15
      },
      {
          "id": 2,
          "size": "R16",
          "availableQuantity": 15
      },
      {
          "id": 3,
          "size": "R17",
          "availableQuantity": 15
      }
  ]

### Создание нового автомобиля

- **Endpoint:** `/api/cars/createCar`
- **HTTP Method:** `POST`
- **Описание:** Создает новый автомобиль с предоставленными данными.
- **Тело запроса:**
  ```json
    {
        "carBodyId": 2,
        "carWheelId": 3,
        "numberOfWheels": 4,
        "coolName": "test1"
    }  

- **Формат ответа:**
  ```json
  {
      "id": 1,
      "carBody": {
          "id": 2,
          "type": "Sedan"
      },
      "carWheel": {
          "id": 3,
          "size": "R17",
          "availableQuantity": 11
      },
      "numberOfWheels": 4,
      "coolName": "test1"
  }


### Получить всю информацию о существующем автомобиле

- **Endpoint:** `/api/cars/getCarById/{id}`
- **HTTP Method:** `GET`
- **Описание:**  Возвращает полную информацию о существующем автомобиле.