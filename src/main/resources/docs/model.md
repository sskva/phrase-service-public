# Модель данных
**user**<br/>
id, nickname, password, access_token, time_insert

**phrase**<br/>
id, user_id, text, time_insert

**tag**<br/>
id, text, time_insert

**phrase_tag**<br/>
id, phrase_id, tag_id, time_insert
