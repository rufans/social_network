-- Like
CREATE TABLE public.like
(
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created timestamp,
    updated timestamp,
    PRIMARY KEY(post_id, user_id)
);