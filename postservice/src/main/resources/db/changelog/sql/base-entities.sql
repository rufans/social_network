CREATE TABLE public.post
(
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR(512) NOT NULL,
    user_id BIGINT NOT NULL,
    image_path VARCHAR(200) DEFAULT NULL,
    parent_post_id BIGINT DEFAULT NULL,
    created timestamp,
    updated timestamp
);