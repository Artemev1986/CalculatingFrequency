## REST API для вычисления частоты встречи символов

Это REST API предоставляет возможность вычислить частоту встречи символов в заданной строке и вернуть результат в отсортированном порядке по убыванию количества вхождений символа в строку.

### Запрос:
URL: /calculateFrequency
Метод: GET
- Параметры запроса:
**inputString** (строка, обязательный): Строка, для которой необходимо вычислить частоту символов. Максимальная длина строки ограничена, но зависит от ограничений вашего сервера.
### Пример запроса:

GET /calculateFrequency?inputString=aaaaabcccc!@#$

- Ответ:

API вернет результат в формате JSON, содержащий символы и их частоты в убывающем порядке:

{
"a": 5,
"c": 4,
"!": 1,
"@": 1,
"#": 1,
"$": 1
}

Символы отсортированы по убыванию количества вхождений.

#### Для запуска сперва необходимо собрать проект с помощью Maven.
```sh
##build the project
mvn clean install
```

После этого можно запустить проект командой:
```sh
##run the project
mvn spring-boot:run
```