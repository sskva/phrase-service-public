CREATE TABLE phrase_public.user
(
    id           BIGINT AUTO_INCREMENT,
    nickname     VARCHAR(15)  NOT NULL,
    password     VARCHAR(100) NOT NULL,
    access_token VARCHAR(100) NOT NULL,
    time_insert  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `nickname_password` (`nickname`, `password`)
) COLLATE utf8_bin;

ALTER TABLE user DROP INDEX `nickname_password`;
ALTER TABLE user ADD UNIQUE (nickname);
ALTER TABLE user ADD UNIQUE (access_token);


CREATE TABLE phrase_public.phrase
(
    id          BIGINT AUTO_INCREMENT,
    user_id     BIGINT NOT NULL,
    text        VARCHAR(140) NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
) COLLATE utf8_bin;


CREATE TABLE phrase_public.tag
(
    id          BIGINT AUTO_INCREMENT,
    text        VARCHAR(25) NOT NULL,
    time_insert TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE (text)
) COLLATE utf8_bin;
INSERT INTO tag(text) VALUE ('море');


CREATE TABLE phrase_public.phrase_tag
(
    id          BIGINT AUTO_INCREMENT,
    phrase_id   BIGINT NOT NULL,
    tag_id      BIGINT NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (phrase_id) REFERENCES phrase (id),
    FOREIGN KEY (tag_id) REFERENCES tag (id),
    UNIQUE `phrase_id_tag_id` (`phrase_id`, `tag_id`)
) COLLATE utf8_bin;