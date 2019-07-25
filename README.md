# social_network
Test project with microservices architecture (Spring Boot, Spring Cloud, Docker)

###User service setup:

1. create db users
social_user
social_user_password (change me)

social_user_test
social_user_test_password (change me)

2. create databases that owned by above users:
social_user_service (social_user user)
social_user_service_test (social_user_test user)

3. setup next system variables (change values to appropriate):
DB_HOST = localhost
DB_PORT = 5432
US_DATABASE = social_user_service
US_DB_USER = social_user
US_DB_PASSWORD = social_user_password
---


###Post service setup:

1. create db users
social_post
social_post_password (change me)

social_post_test
social_post_test_password (change me)

2. create databases that owned by above users:
social_post_service (social_post user)
social_post_service_test (social_post_test user)

3. setup next system variables (change values to appropriate):
DB_HOST = localhost
DB_PORT = 5432
PS_DATABASE = social_post_service
PS_DB_USER = social_post
PS_DB_PASSWORD = social_post_password
---


###Like service setup:

1. create db users
social_like
social_like_password (change me)

social_like_test
social_like_test_password (change me)

2. create databases that owned by above users:
social_like_service (social_like user)
social_like_service_test (social_like_test user)

3. setup next system variables (change values to appropriate):
DB_HOST = localhost
DB_PORT = 5432
LS_DATABASE = social_like_service
LS_DB_USER = social_like
LS_DB_PASSWORD = social_like_password