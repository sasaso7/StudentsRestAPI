INSERT INTO supervisor (id, name, email) values (1, 'Charles Xavier', 'xmenwillwin@gmail.us');
INSERT INTO supervisor (id, name, email) values (2, 'Magneto', 'hatexmen@gmail.ru');
INSERT INTO student (id, name, email, fk_supervisor_id) values (1, 'Benny Hansen', 'sejebenny@gmail.ru', 1);
INSERT INTO student (id, name, email, fk_supervisor_id) values (2, 'Wolverine', 'aaarh@xmen.com', 1);
INSERT INTO student (id, name, email, fk_supervisor_id) values (3, 'Phoenix', 'amidead@xmen.com', 1);
INSERT INTO student (id, name, email, fk_supervisor_id) values (4, 'Sabretooth', 'ihatewolves@notxmen.com', 2);
INSERT INTO student (id, name, email, fk_supervisor_id) values (5, 'Abomination', 'destroyallponies@notxmen.com', 2);
INSERT INTO student (id, name, email, fk_supervisor_id) values (6, 'Mystique', 'backstabbing@notxmen.com', 2);
INSERT INTO student (id, name, email, fk_supervisor_id) values (7, 'Juggernaut', 'cnttype@notxmen.com', 1);