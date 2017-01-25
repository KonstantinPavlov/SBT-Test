# SBT-Test
Текст задания находится по [ссылке](https://github.com/KonstantinPavlov/SBT-Test/blob/master/task.md "Задание к проекту").

## Установка проекта

После скачивания файлов проекта необходимо выполнить следующие шаги:

1. Настроить JDK (1.8.0_101 и выше)
2. Настроить "Project language level" - `8 lambdas, type annotations etc` или выше
3. Подключить к проекту библиотеки JUnit (путь к библиотекам `\lib\`)

## Входные и выходные данные

Входные данные находятся по пути : `\src\main\ru\konstpavlov\resourses\`, в эту же папку записывается файл `result.txt`

Данные для тестов находятся по пути : `\src\test\ru\konstpavlov\resourses\` и имеют подпись `Test` в конце имени файла.

### Тесты

Для удобства тестирования сделан основной тест `TestMain`, запускающий все остальные.

### UML Диаграмма

![UML](http://s8.hostingkartinok.com/uploads/images/2017/01/58944a63799708aa324b9708bb81ffd5.jpg)

Диаграмма также лежит в корне проекта.

#### Настройки папок проекта

Если используется IDE `Intellij IDEA` то в файл `*ProjectName*.iml`  можно добавить следующие настройки папок: 
```
   <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/resourses" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/src/main/ru/konstpavlov/resourses" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/src/test" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/src/test/ru/konstpavlov/resourses" type="java-test-resource" />
    </content>
```
