-- Centros de Formacion
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede A",1);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede B",2);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede D",3);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede E",4);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede F",5);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede G",6);
insert into db_e_productiva_003.centros_de_formacion (enabled,nombre,uuid) values (b'1',"sede H",7);
-- -- Instructores
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (1569253218,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,1);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (37524,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,2);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (8734521,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,3);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (254367,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,4);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (378635438,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,5);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (4123534,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,6);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (12345678,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,7);
insert into db_e_productiva_003.instructores(cc,apellido,email,enabled,nombre,telefono,centro_id) values (4856543123,"zapateiro guzman","zapateiro@gmail.com",b'1',"David andres",32654545,7);
-- -- Programas de Formacion
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"adsi",1);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"tps",2);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"cria de pollitas",3);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"diseño",4);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"fotografia",5);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"animacion",6);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"modulacion",7);
insert into db_e_productiva_003.programas_de_formacion(enabled,nombre,id) values (b'1',"varios",8);
-- -- Fichas
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2010-09-10','2019-09-10',"precencial",1,1569253218,7,1);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2022-09-10','2019-09-10',"virtual",2,37524,6,2);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2002-09-10','2019-09-10',"alternancia",3,8734521,5,3);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2000-09-10','2019-09-10',"virtual",4,254367,4,4);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2012-09-10','2019-09-10',"virtual",5,378635438,3,5);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2021-09-10','2019-09-10',"alternancia",6,4856543123,2,6);
insert into db_e_productiva_003.fichas(enabled,fin,inicio,modalidad,programa_id,instructor_cc,centro_id,id) values (b'1','2023-09-10','2019-09-10',"precencial",7,12345678,1,7);
-- -- Aprendices
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (1016944421,"morales bohorquez","morales@hotmail.com",b'1',"lectiva","jaider", "45342452",1);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (123123,"rodriuez bohorquez","rodriuez@hotmail.com",b'1',"productiva","andres", "33214545",2);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (456457,"sosa torres","sosa@hotmail.com",b'1',"lectiva","victor", "4546234523",2);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (6866546345,"agredo bonivento","matias@hotmail.com",b'1',"productiva","davic", "32123457",3);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (123563463,"guzman herrera","guzman@hotmail.com",b'1',"productiva","johann", "1234542",4);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (564532132,"garcia zapata","garcia@hotmail.com",b'1',"lectiva","andrea", "123456454",5);
insert into db_e_productiva_003.aprendices(cedula,apellido,email,enabled,etapa,nombre,telefono,ficha_id) values (765748675,"vaquero zapata","garcia@hotmail.com",b'1',"productiva","andrea", "123456454",1);
-- Formatos
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2023-10-30',1569253218);
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2020-10-30',378635438);
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2021-10-30',4123534);
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2019-10-30',4856543123);
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2018-10-30',37524);
insert into db_e_productiva_003.formato(fecha,instructor_cc) values ('2015-10-30',4123534);