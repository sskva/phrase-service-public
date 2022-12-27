CREATE TABLE phrase_public.block
(
    id              BIGINT AUTO_INCREMENT,
    user_id         BIGINT    NOT NULL,
    block_user_id BIGINT    NOT NULL,
    time_insert     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (block_user_id) REFERENCES user (id),
    UNIQUE user_id_block_user_id (user_id, block_user_id)
) COLLATE utf8_bin;



CREATE TABLE phrase_public.comment
(
    id          BIGINT AUTO_INCREMENT,
    user_id     BIGINT       NOT NULL,
    phrase_id   BIGINT       NOT NULL,
    text        VARCHAR(140) NOT NULL,
    time_insert TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (phrase_id) REFERENCES phrase (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
) COLLATE utf8_bin;



CREATE TABLE phrase_public.like_phrase
(
    id          BIGINT AUTO_INCREMENT,
    phrase_id   BIGINT    NOT NULL,
    user_id     BIGINT    NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (phrase_id) REFERENCES phrase (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    UNIQUE `phrase_id_user_id` (`phrase_id`, `user_id`)
) COLLATE utf8_bin;


CREATE TABLE test_scheduler_lock
(
    instance_name VARCHAR(64) NOT NULL,
    time_insert   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE shedlock
(
    name       VARCHAR(64)  NOT NULL,
    lock_until TIMESTAMP(3) NOT NULL,
    locked_at  TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    locked_by  VARCHAR(255) NOT NULL,
    PRIMARY KEY (name)
);



CREATE TABLE phrase_public.subscription
(
    id          BIGINT AUTO_INCREMENT,
    sub_user_id BIGINT    NOT NULL,
    pub_user_id BIGINT    NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (sub_user_id) REFERENCES user (id),
    FOREIGN KEY (pub_user_id) REFERENCES user (id),
    UNIQUE KEY sub_user_id_pub_user_id (sub_user_id, pub_user_id)
) COLLATE utf8_bin;



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



CREATE TABLE phrase_public.tag
(
    id          BIGINT AUTO_INCREMENT,
    text        VARCHAR(25) NOT NULL,
    time_insert TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE (text)
) COLLATE utf8_bin;
INSERT INTO tag(text) VALUE ('море');



CREATE TABLE phrase_public.phrase
(
    id          BIGINT AUTO_INCREMENT,
    user_id     BIGINT NOT NULL,
    text        VARCHAR(140) NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
) COLLATE utf8_bin;



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