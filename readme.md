```bash
mvn test;
mvn -Dtest=ReservationTest test;
mvn -Dtest=ReservationTest#testGetAllReservations test

```

```bash
sudo systemctl start postgresql
sudo -i -u postgres;  
psql;  # konsola postgres
CREATE USER user WITH PASSWORD 'tajne';
CREATE DATABASE db OWNER user;
GRANT ALL PRIVILEGES ON DATABASE db TO app_user;
\q # zakończ sesje
exit # wyjdz w konta postgres
sudo systemctl restart postgresql

sudo apt install postgresql-client
psql -h localhost -U user -d db
```