    create table if NOT EXISTS Run (
      id INT NOT NULL,
      title varchar(250) NOT NULL,
        started_on TIMESTAMP NOT NULL,
        completed_on TIMESTAMP NOT NULL,
        miles INT NOT NULL,
        location varchar(10) NOT NULL,
        primary key (id)
    );