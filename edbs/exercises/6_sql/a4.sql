CREATE TABLE branches (
  branchno  VARCHAR2(4) NOT NULL,
  street    VARCHAR2(30) NOT NULL,
  city      VARCHAR2(30) NOT NULL,
  postcode  VARCHAR2(10) NOT NULL,
  CONSTRAINT branches_pk PRIMARY KEY (branchno)
);

CREATE TABLE clients (
  clientno  VARCHAR2(4) NOT NULL,
  fname     VARCHAR2(15) NOT NULL,
  lname     VARCHAR2(15) NOT NULL,
  telno     VARCHAR2(15) NOT NULL,
  preftype  VARCHAR2(15) NOT NULL,
  maxrent   NUMBER(10,0) NOT NULL,
  CONSTRAINT preftype_ck check (preftype IN ('Flat', 'House', 'Loft')),
  CONSTRAINT clients_pk PRIMARY KEY (clientno)
);

CREATE TABLE staff (
  staffno   VARCHAR2(4) NOT NULL,
  fname     VARCHAR2(15) NOT NULL,
  lname     VARCHAR2(15) NOT NULL,
  position  VARCHAR2(20) NOT NULL,
  sex       CHAR(1)     NOT NULL,
  dob       DATE       NOT NULL,
  salary    NUMBER(6,0)      NOT NULL,
  branchno  VARCHAR2(4)  NOT NULL,
  CONSTRAINT  sex_ck CHECK (sex = 'M' OR sex = 'F'),
  CONSTRAINT  position_ck CHECK (position IN ('Manager', 'Assistant', 'Supervisor')),
  CONSTRAINT staff_pk PRIMARY KEY (staffno),
  CONSTRAINT staff_branches_fk FOREIGN KEY (branchno) REFERENCES branches (branchno)
);

CREATE TABLE propertiesforrent (
  propertyno  VARCHAR2(4) NOT NULL,
  street      VARCHAR2(30) NOT NULL,
  city        VARCHAR2(30) NOT NULL,
  postcode    VARCHAR2(10) NOT NULL,
  type        VARCHAR2(15) NOT NULL,
  rooms       NUMBER(3,0) NOT NULL,
  rent        NUMBER(5,1) NOT NULL,
  ownerno     VARCHAR2(4) NOT NULL,
  staffno     VARCHAR2(4) NOT NULL,
  branchno    VARCHAR2(4) NOT NULL,
  CONSTRAINT type_ck check (type IN ('Flat', 'House', 'Loft')),
  CONSTRAINT pf_pk PRIMARY KEY (propertyno),
  CONSTRAINT pf_owners_fk FOREIGN KEY (branchno) REFERENCES branches (branchno),
  CONSTRAINT pf_staff_fk FOREIGN KEY (staffno) REFERENCES staff (staffno),
  CONSTRAINT pf_branches_fk FOREIGN KEY (branchno) REFERENCES branches (branchno)
);

CREATE TABLE privateowners (
  ownerno   VARCHAR2(4) NOT NULL,
  fname     VARCHAR2(15) NOT NULL,
  lname     VARCHAR2(15) NOT NULL,
  address   VARCHAR2(90) NOT NULL,
  telno     VARCHAR2(15) NOT NULL,
  CONSTRAINT privateowners_pk PRIMARY KEY (ownerno)
);

CREATE TABLE viewings (
  clientno    VARCHAR2(4) NOT NULL,
  propertyno  VARCHAR2(4) NOT NULL,
  viewdate    DATE NOT NULL,
  v_comment   VARCHAR2(90),
  CONSTRAINT viewings_pk PRIMARY KEY (clientno, propertno, viewdate),
  CONSTRAINT v_clients_fk FOREIGN KEY (clientno) REFERENCES clients (clientno),
  CONSTRAINT v_prop_fk FOREIGN KEY (propertyno) REFERENCES propertiesforrent (propertyno)
);

CREATE TABLE registrations (
  clientno    VARCHAR2(4) NOT NULL,
  branchno    VARCHAR2(4) NOT NULL,
  staffno     VARCHAR2(4) NOT NULL,
  datejoined  DATE NOT NULL,
  CONSTRAINT registrations_pk PRIMARY KEY (clientno, branchno),
  CONSTRAINT r_clients_fk FOREIGN KEY (clientno) REFERENCES clients (clientno),
  CONSTRAINT r_branches_fk FOREIGN KEY (branchno) REFERENCES branches (branchno),
  CONSTRAINT r_staff_fk FOREIGN KEY (staffno) REFERENCES staff (staffno)
);
