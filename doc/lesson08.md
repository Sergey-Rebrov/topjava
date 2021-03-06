# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava09">Topjava</a>

### <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfkpMd2UyWjBsc2JsSE4tRDFkU3BvMktFQkhUN1J6VExxSUUzOHlSR0RhNm8">Материалы занятия</a>

- **Браузер кэширует javascript и css. Если изменения не работают, обновите приложение в браузере по Ctrl+F5**
- **При удалении файлов не забывайте делать clean: `mvn clean package`**

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правка и миграция
#### Apply 0-1-refactoring-fix.patch
- Зарефакторил `JdbcUserRepositoryImpl.getAll()`
- Мелкие исправления и переименования переменных
- Поправил проверку id в `AbstractMealController` (аналогично `AbstractUserController`)
- Убрал нотификацию email в `travis-ci`

#### Apply 0-2-fix-i18n.patch
- Поменял tag локализации. См. <a href="http://forum.spring.io/forum/spring-projects/web/1077-differences-between-spring-message-and-fmt-message?p=451622#post451622">spring:message vs fmt:message</a>
- Выбор языка зависит от языка операционной системы и хедера `Accept-Language`. Поменял параметр `fallbackToSystemLocale`, который управляет выбором, 
куда переключаться при выборе en и отсутствии `app_en.properties`: локаль операционной системы или `app.properties` (`fallbackToSystemLocale=false`). Переключение локалей будем реализовывать в конце проекта.  
  - <a href="http://stackoverflow.com/questions/4281504/spring-local-sensitive-data">Use app.properties as a fallback</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW7

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFblNtbEdHbldtNE0">HW7</a>

#### Apply 1-HW07-controller-test.patch
#### Apply 2-HW07-rest-controller.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFLXZ3OHdac18yZlk">HW7_Optional</a>
#### Apply 3-HW07-formatter.patch
#### Apply 4-HW07-soapui-curl.patch

> Добавил примеры запросов curl в `config/curl.md`

  - <a href="http://rus-linux.net/lib.php?name=/MyLDP/internet/curlrus.html">Написание HTTP-запросов с помощью Curl</a> (для Windows можно использовать Git Bash)

## Занятие 8:

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUmVsM3V6djMzYmc">WebJars. jQuery and JavaScript frameworks</a>
#### Apply 5-webjars.patch

> - Обновил jQuery до 3.x
>   -  <a href="https://tproger.ru/translations/new-features-of-jquery-3/">Новое в jQuery 3</a>
> - УБРАЛ из проекта <a href="http://dandelion.github.io">Dandelion обертку к datatables</a>:
>   -  не встречал нигде, кроме Spring Pet Clinic;
>   -  поддержка работы с datatables через Dandelion оказалось гораздо более трудоемкое, чем работа с плагином напрямую.
> - Исключил из зависимостей webjars ненужные jQuery

-  Подключение веб ресурсов. <a href="http://www.webjars.org/">WebJars</a>.
-  <a href="http://www.jamesward.com/2012/04/25/introducing-webjars-web-libraries-as-managed-dependencies">Introducing WebJars</a>
-  <a href="https://ru.wikipedia.org/wiki/Document_Object_Model">Document Object Model (DOM)</a>
-  <a href="https://css-tricks.com/dom/">What is the DOM?</a>
-  <a href="https://ru.wikipedia.org/wiki/JQuery">jQuery</a>
-  <a href="http://stackoverflow.com/questions/7062775/is-jquery-a-javascript-library-or-framework">Is jquery a javascript library or framework</a>
-  <a href="https://www.datatables.net/">DataTables</a>
-  <a href="http://www.sitepoint.com/working-jquery-datatables/">Working with jQuery DataTables</a>

##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNXJmeTZBbmduaU0">Bootstrap</a>

> Добавил <a href="http://getbootstrap.com/components/#glyphicons">Glyphicons</a>

#### Apply 6-bootstrap.patch
-  <a href="http://getbootstrap.com/getting-started/">Подключаем Bootstrap</a>. Форматируем JSP.
-  <a href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/">Twitter Bootstrap Tutorial</a>
-  <a href="http://www.w3schools.com/bootstrap/">Bootstrap 3 Tutorial</a>
-  <a href="https://www.youtube.com/playlist?list=PLypd1VrGv7FPokhw3f5pwBQTHsU9T2mBq">Видео: уроки по Bootstrap 3</a>

##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcGs4b1IyWWF2S2c">AJAX. Datatables. jQuery (обновлено в конце)</a>
 JSP полезны, если надо с сервера отдать статический html с серверной логикой (условия, циклы), сформированный на основе модели. Для динамической отрисовки таблицы мы будем использовать REST и JSON на 9м уроке (работа с datatables через Ajax).
> - Сделал загрузку скриптов асинхронной (и все общие скрипты в `headTag.jsp`). Для асинхронной загрузки <a href="http://stackoverflow.com/a/41947330/548473">вынес скрипт</a> из `users.jsp` в `userDatatables.js`.
>   - <a href="http://stackoverflow.com/questions/436411/where-should-i-put-script-tags-in-html-markup/24070373#24070373">JavaScript loading modern approach</a>
> - Поправил стили `jquery.dataTables` на `dataTables.bootstrap` и добавил `dataTables.bootstrap..js`
>   - <a href="https://datatables.net/examples/styling/bootstrap.html">DataTables/Bootstrap 3 integration</a>
> - Вместо id и селектора для добавления пользователя использовал обработчик `onclick` и функцию `add()`
>   - <a href="https://learn.javascript.ru/introduction-browser-events">Введение в браузерные события</a>
> - Обновил dataTables API:
>  - <a href="https://datatables.net/upgrade/1.10-convert">Converting parameter names for 1.10</a>
>  - <a href="http://stackoverflow.com/questions/25207147/datatable-vs-datatable-why-is-there-a-difference-and-how-do-i-make-them-w">dataTable() vs. DataTable()</a>

#### Apply 7-ajax-datatables.patch


-  <a href="https://ru.wikipedia.org/wiki/AJAX">AJAX</a>.
-  <a href="http://ruseller.com/jquery.php?id=124">Событие  $(document).ready</a>.
-  <a href="http://anton.shevchuk.name/jquery/">jQuery для всех</a>.
-  <a href="http://anton.shevchuk.name/javascript/jquery-for-beginners-ajax/">jQuery для начинающих. AJAX</a>.
-  <a href="http://anton.shevchuk.name/javascript/jquery-for-beginners-selectors/">jQuery для начинающих. Селекторы</a>.
-  <a href="http://api.jquery.com/">jQuery API</a>
-  Редактирование таблицы на основе <a href="http://getbootstrap.com/javascript/#modals">модального окна Bootstrap</a>.
-  <a href="http://bootstrap-ru.com/203/javascript.php">Javascript плагины для Bootstrap</a>
-  <a href="http://datatables.net/reference/api/">DataTables API</a>


##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMTVWaXdWRUZsUEE"> Notifications</a>
#### Apply 8-notification.patch
-  <a href="http://ruseller.com/jquery.php?id=2">Обработка ajaxError</a>.
-  <a href="http://ned.im/noty/">jQuery notification</a>

##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRVkzcFMwc0hrYmM">Добавление Spring Security</a>
>  - Правка к видео: путь в intercept-url должен быть полный - `pattern="/rest/admin/**"`
>  - В Spring Security 4.x по умолчанию включен csrf (защита от <a href="https://ru.wikipedia.org/wiki/Межсайтовая_подделка_запроса">межсайтовой подделки запроса</a>). Выключили и будем включать на 10-м занятии.

#### Apply 9-add-security.patch
-  <a href="http://projects.spring.io/spring-security/">Spring Security</a>
-  <a href="https://ru.wikipedia.org/wiki/Протокол_AAA">Протокол AAA</a>
-  <a href="https://ru.wikipedia.org/wiki/Аутентификация_в_Интернете">Методы аутентификации</a>.
-  <a href="https://en.wikipedia.org/wiki/Basic_access_authentication">Basic access authentication</a>
-  <a href="http://articles.javatalks.ru/articles/17">Использование ThreadLocal</a>
-  Добавляем в проект spring-security и security filter
-  Конфигурируем security context для ресурсов и REST
-  Тестируем Security REST через SoapUI/ curl/ Postman/ <a href="https://www.jetbrains.com/help/idea/2016.1/testing-restful-web-services.html">Testing RESTful Web Services + Generate Authorization Header</a>
-  <a href="http://www.baeldung.com/security-spring">Security with Spring</a>
```
curl -v -H 'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' http://localhost:8080/topjava/rest/profile/meals
```

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> Что делает код?
```
$('.delete').click(function () {
        deleteRow($(this).attr("id"));
    });
```

На все элементы DOM с классом `delete` вешается обработчик события `click` который вызывает функцию `deleteRow`. Классы в html разделяются через пробел.

> тянет ли bootstrap за собой jQuery?

Bootstrap css это стили (форматирование), Bootstrap js зависит от jQuery: http://stackoverflow.com/questions/14608681/can-i-use-twitter-bootstrap-without-jquery#answer-14608772

> А где реально этот путь "classpath:/META-INF/resources/webjars"?

Внутри подключаемых webjars ресурсы лежат по пути `/META-INF/resources/webjars/...` Не поленитесь посмотреть на них через Ctrl+Shift+N.
Все подключаемые jar попадают в classpath и ресурсы доступны по этому пути.

> У меня webjars зависимость лежит внутри ".m2\repository\org\webjars\". С чем это может быть связано?

Maven скачивает все депенденси в local repository, который по умолчанию находится в `~/.m2`.
Каталог по умолчанию можно переопределить в `APACHE-MAVEN-HOME\conf\settings.xml`, элемент `localRepository`.

> WEBJARS лежат вообще в другом месте WEB-INF\lib*. Биндим mapping="/webjars/*" на реальное положение jar в ware, откуда spring знает где искать наш jquery ?

В war в `WEB-INF/lib/*` лежат все jar, которые попадают к classpath. Spring при обращении по url `/webjars/` ищет по пути биндинга `<mvc:resources mapping="/webjars/ " location="classpath:/META-INF/resources/webjars/"/>`
по всему classpath (то же самое как распаковать все jar в один каталог) в `META-INF/resources/webjars/`. В этом месте во всех jar, которые мы подключили из webjars лежат наши ресурсы.

> Как можно в браузере сбросить введенный пароль базовой авторизации?

Проще всего делать новый запрос в новой анонимной вкладке (`Ctrl+Shift+N` в Chrome)

> Оптимально ли делать доступ к статическим ресурсам (css, js, html) через webjars ?

На продакшене под нагрузкой статические ресурсы лучше всего держать не в war, а снаружи. Доступ к ним делается либо через <a href="http://www.moreofless.co.uk/static-content-web-pages-images-tomcat-outside-war/">конфигурирование Tomcat</a>, но чаще всего через прокси, например <a href="https://nginx.org/ru/">Nginx</a>

> Как по REST определяется залогиненный юзер? Аутентификация происходит при каждом запросе?

<a href="http://stackoverflow.com/questions/319530/restful-authentication">Способы RESTful Authentication</a>.
Мы будем использовать 2: coockie + http session (на след. уроке) и Basic Authentication с аутентификацией при каждом запросе.

> Почему `@RequestParam` не работает в PUT и DELETE запросах?

По спецификации Servlet API параметры в теле для PUT, DELETE, TRACE методах не обрабатываются (только в url).
Те. можно: 
 - использовать POST
 - передавать параметры в url
 - использовать `HttpPutFormContentFilter` фильтр
 - настроить Tomcat в обход спецификации. 
 
См. <a href="http://stackoverflow.com/a/14568899/548473">Handle request parameters for an HTTP PUT method</a>
 
>  Что происходит, когда мы нажимаем на кнопку submit в форме добавления юзера (`users.jsp`, `<form id="detailsForm">`)?

В `datatablesUtil.js` берется DOM элемент (форма) по id="detailsForm" и на событие submit вешается обработчик:

    $('#detailsForm').submit(function () {
        save();
        return false;
    });

> Данные между браузером и ajax гоняются в виде json?  Почему в `AdminAjaxController`  у методов delete и createOrUpdate нет в аннотациях параметра `consumes = MediaType.APPLICATION_JSON_VALUE` ?

Посмотреть на данные между приложением и браузером можно (и нужно!) в браузере (вкладка Network в Инструментах разработчика, F12 в Хроме). Зависит от того, как их отправляем из браузера и из приложения. Данные формы обычно передаются просто параметрами. `APPLICATION_JSON_VALUE` в контроллере нужно, только если параметры отдаются\принимаются в формате JSON.

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW08

- 1. Перевести `meals` на `datatables` (`meals.jsp`, `MealAjaxController`).
  - Реализовать добавление записи еды через модальное окно Bootstrap и удаление еды по ajax (БЕЗ редактирования).
  - При вставке данных по AJAX пропадает все JSP форматирование, чинить перерисовку НЕ надо. Следующий урок- будем делать datatable по AJAX и форматирование на стороне клиента.
- 2. Т.к. HTML атрибут id у каждого элемента документа должен быть уникален, нужно избавиться от дублирования `id="${user.id}"` в строках таблиц users и meals (переместить атрибут id в тэг `<tr>` или передавать в качестве параметра функций через `onclick`)

#### Optional.
- 3. Перевести работу фильтра на AJAX. Попробуйте после модификации таблицы (например добавлении записи) обновлять ее также с учетом фильтра.
- 4. Сделать кнопку сброса фильтра.
- 5. Реализовать enable/disable User через checkbox в `users.jsp` с сохранением в DB. Неактивных пользователей выделить css стилем.

---------------------
## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW08
- проверьте, как у вас первоначально (или по F5) отображаются неактивные пользователи (если меняете css при enable/disable)
- если у вас запрос фильтрации не попадает в Ajax контроллер, скорее всего срабатывает submit формы фильтрации. Нужно или делать в событии `return false` как в `datatablesUtil:$('#detailsForm').submit`, либо вместо `type="submit"` сделать `type="button"`
- enable/disable делать c `@Transactional` (можно реализовать как на уровне репозитория, так и на уровне сервиса через несколько sql, которые должны быть в одной транзакции)
- в datatablesUtil.js выносите только общие скрипты (cкрипты еды размещайте в  `mealDatatables.js`, пользователей в `userDatatables.js`)