# social_network
Test project with microservices architecture (Spring Boot, Spring Cloud, Docker)

###User service setup:

1. create db users
social_user
social_user_password (change me)

social_user_test
social_user_test_password (change me)

2. create databases that owned by above users:
social_user_service (social_user)
social_user_service_test (social_user_test)

3. setup next system variables (change values to appropriate):
DB_HOST = localhost
DB_PORT = 5432
US_DB_DATABASE = social_user_service
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
social_post_service (social_post)
social_post_service_test (social_post_test)

3. setup next system variables (change values to appropriate):
DB_HOST = localhost
DB_PORT = 5432
US_DB_DATABASE = social_post_service
US_DB_USER = social_post
US_DB_PASSWORD = social_post_password
---


Like service setup:
-