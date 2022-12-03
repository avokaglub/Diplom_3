# Diplom_3

[Задание 3: веб-приложение](task_3.md)

Для запуска тестов выполнить команду
```
mvn clean test
```
Для генерации и открытия отчета Allure выполнить команды
```
Copy-Item ".\allure-results-props\categories.json" -Destination ".\target\allure-results"
Copy-Item ".\allure-results-props\executor.json" -Destination ".\target\allure-results"
Copy-Item ".\allure-results-props\environment.properties" -Destination ".\target\allure-results"
Copy-Item ".\allure-results-props\yatest.feature" -Destination ".\target\allure-results"
allure generate .\target\allure-results -o .\target\allure-reports
allure open .\target\allure-reports
```

Для запуска тестов [chromedriver.exe](https://chromedriver.chromium.org/downloads) должен быть расположен в директории, указанной в переменной окружения PATH.
Версия драйвера должна соответствовать версии браузера Google Chrome.
