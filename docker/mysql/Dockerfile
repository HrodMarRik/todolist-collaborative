FROM mysql:8.0

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=todolist_db
ENV MYSQL_USER=todolist_user
ENV MYSQL_PASSWORD=todolist_password

# Copy initialization scripts
COPY init.sql /docker-entrypoint-initdb.d/

# Expose port
EXPOSE 3307
