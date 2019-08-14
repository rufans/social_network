CREATE TABLE public.user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(40)  NOT NULL,
    username VARCHAR(15)  NOT NULL,
    email    VARCHAR(40)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    created  TIMESTAMP,
    updated  TIMESTAMP
);

CREATE TABLE public.friendship
(
    requester_id BIGINT      NOT NULL,
    friend_id    BIGINT      NOT NULL,
    status       VARCHAR(10) NOT NULL,
    date         TIMESTAMP   NOT NULL,
    PRIMARY KEY (requester_id, friend_id),
    FOREIGN KEY (requester_id) REFERENCES public.user (id) ON DELETE CASCADE,
    FOREIGN KEY (friend_id) REFERENCES public.user (id) ON DELETE CASCADE
);

CREATE TABLE public.user_role
(
    user_id   BIGINT      NOT NULL,
    role_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (user_id, role_name),
    FOREIGN KEY (user_id) REFERENCES public.user (id) ON DELETE CASCADE
);
