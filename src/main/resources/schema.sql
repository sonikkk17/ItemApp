create table if not exists fighter (
  id identity,
  name varchar(50) not null,
  brand_from varchar(50) not null,
  year_of_creation int not null,
  price numeric not null,
  created_at timestamp not null
);