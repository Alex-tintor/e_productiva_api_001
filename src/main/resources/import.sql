-- Centros de Formacion
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede A",1);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede B",2);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede D",3);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede E",4);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede F",5);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede G",6);
INSERT INTO db_e_productiva_003.centros (enabled,nombre,uuid) VALUES (b'1',"sede H",7);
-- Usuario
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('1056ce12b3694d1baf0d256d8877716c','Zapateiro Guzman','1569253211','zapateira@gmail.com',b'1','David andres',32654541,1)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('1eb6f4e724474caf9d8e436885ae79af','Zapateiro Guzman','1569253212','zapateirb@gmail.com',b'1','David andres',32654542,1)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('b0d3fdc1fd2b43fca1114cac7f673d2e','Zapateiro Guzman','1569253213','zapateirc@gmail.com',b'1','David andres',32654543,0)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('b4b97cdbeacc430d96989d6baf99b02f','Zapateiro Guzman','1569253214','zapateird@gmail.com',b'1','David andres',32654544,0)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('7bfb95b3487643aeb1ce3f0e02fb7544','Zapateiro Guzman','1569253215','zapateire@gmail.com',b'1','David andres',32654545,0)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('bcea506d2d8242edb84d1b1f885cb6bc','Zapateiro Guzman','1569253216','zapateirf@gmail.com',b'1','David andres',32654546,1)
INSERT INTO db_e_productiva_003.usuario(uuid,apellido,documento,email,enabled,nombre,telefono,tipo_documento) VALUES ('aaa658bbc5d44b629db7e33aabfbfc05','Zapateiro Guzman','1569253217','zapateirg@gmail.com',b'1','David andres',32654547,1)
-- Instructores
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('1056ce12b3694d1baf0d256d8877716c',1);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('1eb6f4e724474caf9d8e436885ae79af',2);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('b0d3fdc1fd2b43fca1114cac7f673d2e',3);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('b4b97cdbeacc430d96989d6baf99b02f',4);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('7bfb95b3487643aeb1ce3f0e02fb7544',5);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('bcea506d2d8242edb84d1b1f885cb6bc',6);
INSERT INTO db_e_productiva_003.instructores(uuid,centro_uuid) VALUES ('aaa658bbc5d44b629db7e33aabfbfc05',7);
-- Programas de Formacion
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"adsi",1);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"tps",2);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"cria de pollitas",3);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"diseño",4);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"fotografia",5);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"animacion",6);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"modulacion",7);
-- --insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"varios",8);
-- -- Fichas
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2010-09-10','2019-09-10',"precencial",1,1569253218,7,1);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2022-09-10','2019-09-10',"virtual",2,37524,6,2);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2002-09-10','2019-09-10',"alternancia",3,8734521,5,3);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2000-09-10','2019-09-10',"virtual",4,254367,4,4);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2012-09-10','2019-09-10',"virtual",5,378635438,3,5);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2021-09-10','2019-09-10',"alternancia",6,4856543123,2,6);
-- --insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2023-09-10','2019-09-10',"precencial",7,12345678,1,7);
-- -- Aprendices
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (1016944421,"morales bohorquez","morales@hotmail.com",b'1',"lectiva","jaider", "45342452",1);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (123123,"rodriuez bohorquez","rodriuez@hotmail.com",b'1',"productiva","andres", "33214545",2);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (456457,"sosa torres","sosa@hotmail.com",b'1',"lectiva","victor", "4546234523",2);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (6866546345,"agredo bonivento","matias@hotmail.com",b'1',"productiva","davic", "32123457",3);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (123563463,"guzman herrera","guzman@hotmail.com",b'1',"productiva","johann", "1234542",4);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (564532132,"garcia zapata","garcia@hotmail.com",b'1',"lectiva","andrea", "123456454",5);
-- --insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (765748675,"vaquero zapata","garcia@hotmail.com",b'1',"productiva","andrea", "123456454",1);
-- Formatos
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2023-10-30',1569253218);
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2020-10-30',378635438);
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2021-10-30',4123534);
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2019-10-30',4856543123);
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2018-10-30',3752-- --4);
-- --insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2015-10-30',4123534);