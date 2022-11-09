# Diplom_3

[Задание 3: веб-приложение](task_3.md)

Для запуска тестов выполнить команду
```
mvn clean test
```
Для генерации и открытия отчета Allure выполнить команды
```
allure generate --clean .\target\allure-results -o .\target\allure-reports
allure open .\target\allure-reports
```