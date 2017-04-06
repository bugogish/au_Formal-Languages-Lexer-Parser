# Парсер

## Запуск скрипта
Для работы необходима установленная Java8.  
* Для запуска программы необходимо запустить скрипт `run.sh <FILE> [-filter] [-fulltree] [-text] [-notree]`.
* Альтернативная последовательность действий:  
  1. Запустить ./gradlew build  
  2. ./gradlew run -PappArgs="['FILENAME'[,'-filter']]"  (Здесь `-filter`  - опциональный параметр)

### Значения ключей:
* `-filter` - фильтрует комментарии в результате работы лексера
* `-text` - выводит в консоль текстовую версию АСТ с полной информацией о лексемах
* `-fulltree` - рисует полное АСТ (см. пример)
* `-notree` - выводит в консоль только результат работы лексера  

### Описание работы  
Скрипт умеет рисовать 2 вида АСТ:  
Пример программы:  
`if (true) then skip else begin write(x) ; z := 13 end`
1. Полное дерево, сгенерированное парсером:  
![alt text][full]
2. Дерево с обрезанными вершинами-обертками для лучшей читаемости:  
![alt text][trimmed]

По умолчанию генерируется второй вариант, первый можно посмотреть запустить скрипт с ключом `-fulltree`.
### Запуск тестов
* Для запуска тестов необходимо выполнить команду ./gradlew test
* Результат можно посмотреть в build/reports/tests
### Генерация лексера*
Файл, содержащий описание языка в формате g4 находится в папке utils (LLanguage.g4).  
Для генерации соответствующего ему лексера необходимо иметь установленный [antlr](http://www.antlr.org/).  
(Для работы скрипта это не обязательно).  

[full]: https://github.com/bugogish/Formal-Languages/blob/Parser/img/FULL.png "Full tree"
[trimmed]: https://github.com/bugogish/Formal-Languages/blob/Parser/img/TRiMMED.png "Trimmed tree"