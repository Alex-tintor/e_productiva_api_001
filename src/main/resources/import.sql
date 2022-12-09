-- -- Centros de Formacion
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede A","1");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede B","2");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede D","3");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede E","4");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede F","5");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede G","6");
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede H","7");
-- Usuario/aprendices
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('1056ce12b3694d1baf0d256d8877716c','Zapateiro Guzman','1016944420','zapateira@gmail.com',b'1','David andres',32654541,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('1eb6f4e724474caf9d8e436885ae79af','Zapateiro Guzman','1016944421','zapateirb@gmail.com',b'1','David andres',32654542,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('b0d3fdc1fd2b43fca1114cac7f673d2e','Zapateiro Guzman','1016944422','zapateirc@gmail.com',b'1','David andres',32654543,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('b4b97cdbeacc430d96989d6baf99b02f','Zapateiro Guzman','1016944423','zapateird@gmail.com',b'1','David andres',32654544,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('7bfb95b3487643aeb1ce3f0e02fb7544','Zapateiro Guzman','1016944424','zapateire@gmail.com',b'1','David andres',32654545,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('bcea506d2d8242edb84d1b1f885cb6bc','Zapateiro Guzman','1016944425','zapateirf@gmail.com',b'1','David andres',32654546,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('aaa658bbc5d44b629db7e33aabfbfc05','Zapateiro Guzman','1016944426','zapateirg@gmail.com',b'1','David andres',32654547,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('c829b2d35f114688816e7588c2a831d4','Zapateiro Guzman','1016944427','zapateirh@gmail.com',b'1','David andres',32654548,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1eb24e53b011edbdc30242ac120002','Zapateiro Guzman','1016944428','zapateiri@gmail.com',b'1','David andres',32654549,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1eb5f053b011edbdc30242ac120002','Zapateiro Guzman','1016944429','zapateirj@gmail.com',b'1','David andres',32654510,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1ebb0e53b011edbdc30242ac120002','Zapateiro Guzman','1016944410','zapateirk@gmail.com',b'1','David andres',32654511,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1ebcee53b011edbdc30242ac120002','Zapateiro Guzman','1016944411','zapateirl@gmail.com',b'1','David andres',32654512,0);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1ec09a53b011edbdc30242ac120002','Zapateiro Guzman','1016944412','zapateirm@gmail.com',b'1','David andres',32654513,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1ec25c53b011edbdc30242ac120002','Zapateiro Guzman','1016944413','zapateirn@gmail.com',b'1','David andres',32654514,1);
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('2f1ec43253b011edbdc30242ac120002','Zapateiro Guzman','1016944414','zapateiro@gmail.com',b'1','David andres',32654515,1);
-- Programas de Formacion
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"adsi","TECNICO",1);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"tps","TECNICO",2);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"cria de pollitas","TECNICO",3);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"diseño","TECNICO",4);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"fotografia","TECNICO",5);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"animacion","TECNICO",6);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"modulacion","TECNICO",7);
insert into db_e_productiva_003.programas(enabled,nombre,nivel,id) values (b'1',"varios","TECNICO",8);
-- Instructores
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1eb24e53b011edbdc30242ac120002',1);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1eb5f053b011edbdc30242ac120002',2);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1ebb0e53b011edbdc30242ac120002',3);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1ebcee53b011edbdc30242ac120002',4);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1ec09a53b011edbdc30242ac120002',5);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1ec25c53b011edbdc30242ac120002',6);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('2f1ec43253b011edbdc30242ac120002',7);
-- -- Fichas
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (1,b'1','2023-01-01','2022-01-01',"precencial",1,"2f1eb24e53b011edbdc30242ac120002",1);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (2,b'1','2023-01-01','2022-01-01',"virtual",1,"2f1eb5f053b011edbdc30242ac120002",2);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (3,b'1','2023-01-01','2022-01-01',"alternancia",1,"2f1ebb0e53b011edbdc30242ac120002",3);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (4,b'1','2023-01-01','2022-01-01',"virtual",1,"2f1ebcee53b011edbdc30242ac120002",4);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (5,b'1','2023-01-01','2022-01-01',"precencial",1,"2f1ec09a53b011edbdc30242ac120002",5);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (6,b'1','2023-01-01','2022-01-01',"precencial",1,"2f1ec25c53b011edbdc30242ac120002",6);
insert into db_e_productiva_003.fichas(id,enabled,fin,inicio,modalidad,centro_id,instructor,programa_id) values (7,b'1','2023-01-01','2022-01-01',"precencial",1,"2f1ec43253b011edbdc30242ac120002",7);
-- Aprendices
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("LECTIVA","1056ce12b3694d1baf0d256d8877716c",2);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("PRODUCTIVA","1eb6f4e724474caf9d8e436885ae79af",1);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("DESERTADO","b0d3fdc1fd2b43fca1114cac7f673d2e",1);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("LECTIVA","b4b97cdbeacc430d96989d6baf99b02f",3);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("PRODUCTIVA","7bfb95b3487643aeb1ce3f0e02fb7544",1);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("DESERTADO","bcea506d2d8242edb84d1b1f885cb6bc",2);
insert into db_e_productiva_003.aprendices(etapa,uuid,ficha_id) values ("LECTIVA","aaa658bbc5d44b629db7e33aabfbfc05",2);
-- Formatos
insert into db_e_productiva_003.formato(id,fecha,instructor) values (1,'2022-01-01',"2f1eb24e53b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (2,'2022-01-01',"2f1eb5f053b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (3,'2022-01-01',"2f1ebb0e53b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (4,'2022-01-01',"2f1ebcee53b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (5,'2022-01-01',"2f1ec09a53b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (6,'2022-01-01',"2f1ec25c53b011edbdc30242ac120002");
insert into db_e_productiva_003.formato(id,fecha,instructor) values (7,'2022-01-01',"2f1eb24e53b011edbdc30242ac120002");