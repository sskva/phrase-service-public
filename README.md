# Бизнес требования
1. Юзер должен иметь возможность зарегистрироваться.
2. Публиковать фразы.
3. Прикреплять к фразе теги.
4. Подписываться на других пользователей.
5. Читать фразы других пользователей.
6. Оценивать фразы других пользователей.
7. Совершать поиск по тегам.
8. Совершать поиск по словам.
9. Совершать поиск по нику.

# Модель данных
## user
id, nickname, password, access_token, time_insert

# Функциональные требования
## 1.1 Метод registration
**входящие данные**
```json
{
  "nickname": "barabashka",
  "password": "barabashka1980"
}
```
**валидация**<br/>
nickname >= 4 символа, <= 15 символов, разрешенные символы a-zA-Z0-9а-яА-Я. _-<br/>
password >= 8 символов, <= 100 символов, разрешенные символы a-zA-Z0-9а-яА-Я.,:; _?!+=/'\"*(){}[]-

**логика метода**<br/>
сервис совершает поиск в таблице user по столбцу nickname входящий nickname,<br/> 
если находит - возвращает ошибку NICKNAME_BUSY,<br/>
иначе генерирует accessToken, шифрует входящий password, записывает в таблицу user nickname, password, accessToken<br/>
возвращает клиенту accessToken

**исходящие данные в случае успеха** <br/>статус 200
```json
{
  "data": {
    "accessToken": "d4a76068f5104f26975499d22bcd11cc1665995491673"
  }
}
```
**исходящие данные в случае ошибки**<br/>статус 400
```json
{
  "error": {
    "code": "REQUEST_VALIDATION_ERROR",
    "message": "Некорректный nickname. Некорректный password"
  }
}
```
```json
{
  "error": {
    "code": "NICKNAME_BUSY",
    "message": "Этот ник уже занят, придумайте другой"
  }
}
```
