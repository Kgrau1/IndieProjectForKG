delete from hours;
delete from users;

INSERT INTO users VALUES(1, 1, 'Kevin', 'Grau', 0, null),(2, 2, 'John', 'Doe', 0, null);
INSERT INTO hours VALUES(1, 121, TIMESTAMP('2023-11-16 08:00:00'), TIMESTAMP('2023-11-16 02:00:00'), 1, 1),(2, 222, TIMESTAMP('2023-11-16 11:00:00'), TIMESTAMP('2023-11-16 11:00:00'), 2, 2);

