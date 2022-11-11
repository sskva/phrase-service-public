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
