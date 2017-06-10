-- Author: Jonathan Rai Samines Solares
-- Proyecto Sistemas Operativos 2
-- Script base de datos Simulacion de Procesos

CREATE SEQUENCE simulacion_seq START WITH 1;

CREATE OR REPLACE TRIGGER simulacion_generated_id 
BEFORE INSERT ON simulacion 
FOR EACH ROW
BEGIN
  SELECT simulacion_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE SEQUENCE proceso_seq START WITH 1;

CREATE OR REPLACE TRIGGER proceso_generated_id 
BEFORE INSERT ON proceso 
FOR EACH ROW
BEGIN
  SELECT proceso_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;


CREATE SEQUENCE planificacion_seq START WITH 1;

CREATE OR REPLACE TRIGGER planificacion_generated_id 
BEFORE INSERT ON planificacionproceso
FOR EACH ROW
BEGIN
  SELECT planificacion_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;