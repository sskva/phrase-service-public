INSERT INTO tag(text) SELECT DISTINCT LOWER(?) FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = LOWER(?));

SELECT text FROM tag WHERE text = 'море';
SELECT text FROM tag WHERE text = 'пляж';

SELECT EXISTS (SELECT text FROM tag WHERE text = 'море');
SELECT EXISTS (SELECT text FROM tag WHERE text = 'пляж');

SELECT NOT EXISTS (SELECT text FROM tag WHERE text = 'море');
SELECT NOT EXISTS (SELECT text FROM tag WHERE text = 'пляж');

SELECT 'море' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'море');
SELECT 'пляж' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'пляж');

SELECT DISTINCT 'море' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'море');
SELECT DISTINCT 'пляж' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'пляж');

INSERT INTO tag(text) SELECT 'облако';

INSERT INTO tag(text) SELECT DISTINCT 'море' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'море');
INSERT INTO tag(text) SELECT DISTINCT 'пляж' FROM tag WHERE NOT EXISTS (SELECT text FROM tag WHERE text = 'пляж');

