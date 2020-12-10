CREATE TABLE employees (
  id              INT NOT NULL,
  last_name       VARCHAR(50) ,
  first_name      VARCHAR(50) ,
  email           VARCHAR(50) ,
  avatar          VARCHAR(250) ,
  job_title       VARCHAR(50) ,
  department      VARCHAR(50) ,
  manager_id      INT ,
  phone           VARCHAR(25) ,
  address1        VARCHAR(150),
  address2        VARCHAR(150),
  city            VARCHAR(50) ,
  state           VARCHAR(50) ,
  postal_code     VARCHAR(15) ,
  country         VARCHAR(50) ,
  PRIMARY KEY (id)
);

