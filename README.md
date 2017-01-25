# SBT-Test
Текст задания находится по [Ссылке](https://github.com/KonstantinPavlov/SBT-Test/blob/master/task.md "Задание к проекту")

## Установка проекта

После скачивания файлов проекта необходимо настроить следующие параметры проекта :

1. Настроить JDK (1.8.0_101 и выше)
2. Настроить "Project language level" - `8 lambdas, type annotations etc` или выше
3. Подключить к проекту библиотеки JUnit (путь к библиотеке `\lib\`)

## Входные и выходные данные

Входные данные находяться по пути : `\src\main\ru\konstpavlov\resourses\`, в эту же папку записывается файл `result.txt`

Данные для тестов находяться по пути : `\src\test\ru\konstpavlov\resourses\` и имеют подпись `Test` в конце имени файла.

### Тесты

Для удобства тестирования сделан основной тест `TestMain`, запускающий все остальные.

### UML Диаграмма

![UML](http://s8.hostingkartinok.com/uploads/images/2017/01/58944a63799708aa324b9708bb81ffd5.jpg)

