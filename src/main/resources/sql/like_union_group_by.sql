SELECT *
FROM tag
WHERE text LIKE CONCAT(LOWER('пог'), '%');



SELECT *
FROM tag
         JOIN phrase_tag pt ON tag.id = pt.tag_id
WHERE text LIKE CONCAT(LOWER('пог'), '%');



SELECT tag.id, text
FROM tag
         JOIN phrase_tag pt ON tag.id = pt.tag_id
WHERE text LIKE CONCAT(LOWER('пог'), '%');



SELECT tag.id, text, count(tag.id)
FROM tag
         JOIN phrase_tag pt ON tag.id = pt.tag_id
WHERE text LIKE CONCAT(LOWER('пог'), '%')
GROUP BY tag.id;



SELECT tag.id, text, count(tag.id)
FROM tag
         JOIN phrase_tag pt ON tag.id = pt.tag_id
WHERE text LIKE CONCAT(LOWER('пог'), '%')
GROUP BY tag.id
ORDER BY count(tag.id) DESC;



SELECT tag.id, text, count(tag.id)
FROM tag
         JOIN phrase_tag pt ON tag.id = pt.tag_id
WHERE text LIKE CONCAT('%', LOWER('пог'), '%')
GROUP BY tag.id
ORDER BY count(tag.id) DESC;


SELECT id, text, c
FROM (
         SELECT tag.id, text, count(tag.id) AS c
         FROM tag
                  JOIN phrase_tag pt ON tag.id = pt.tag_id
         WHERE text LIKE CONCAT(LOWER('пог'), '%')
         GROUP BY tag.id
         ORDER BY count(tag.id) DESC) t1
UNION
SELECT id, text, c
FROM (
         SELECT tag.id, text, count(tag.id) AS c
         FROM tag
                  JOIN phrase_tag pt ON tag.id = pt.tag_id
         WHERE text LIKE CONCAT('%', LOWER('пог'), '%')
         GROUP BY tag.id
         ORDER BY count(tag.id) DESC) t2;
