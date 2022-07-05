DROP SCHEMA IF EXISTS  customer_db;

CREATE SCHEMA customer_db;
USE customer_db;

create table Customer (
                             customer_Id INT(4) AUTO_INCREMENT,
                             date_Of_Birth VARCHAR(10) not null,
                             email VARCHAR(20) not null,
                             first_Name VARCHAR(20) not null,
                             last_Name VARCHAR(20) not null,
                             offer_id INT REFERENCES Offer,
                             CONSTRAINT ps_sim_id_pk PRIMARY KEY (customer_Id)
);

create table Offer (
                          offer_Id INT AUTO_INCREMENT,
                          call_Qty INT not null,
                          cost INT not null,
                          data_Qty INT not null,
                          duration INT not null,
                          offer_Name VARCHAR(20) not null,
                          CONSTRAINT ps_sim_id_pk PRIMARY KEY (offer_Id)
);

INSERT INTO Customer VALUES('1001','1990-12-20','smith@abc.com','Smith','John',1);
INSERT INTO Customer VALUES('1002','1998-12-12','bob@abc.com','Bob','Sam',2);

INSERT INTO Offer VALUES(1,100,100,120,10,'Free calls and data');
INSERT INTO Offer VALUES(2,150,50,100,15,'Free Calls');

COMMIT;
SELECT * FROM Customer;
SELECT * FROM Offer;