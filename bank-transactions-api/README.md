# Introduction 

PostgreSQL Master Slave Cluster & backend for bank transactions

# Getting Started

1.	Make sure you have volumes for postgres and pgadmin are created with rigth permissions:

        a. mkdir -p ~/volumes/data/pgmaster/data & chmod 755 ~/volumes/data/pgmaster/data

        b. mkdir -p ~/volumes/data/pgslave/data & chmod 755 ~/volumes/data/pgslave/data

        c. mkdir -p ~/volumes/data/pgbackup/_data/pgadmin & chown -R 5050:5050 ~/volumes/data/pgbackup/_data/pgadmin

        
2.      docker compose up -d --build
      
3.	pgadmin http://localhost:5050 admin@gmail.com/admin

4.      Connect to master and create bank-transactions database


5.    ./run.sh

6. Check Transaction API http://localhost:2024/swagger-ui/index.html


