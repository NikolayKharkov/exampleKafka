create table contracts(
    contract_id int primary key,
    number int
);


create table transactions(
   transaction_id int primary key,
   contract_id int,
   transaction_date_time timestamp with time zone,
   sum numeric,
   foreign key (contract_id) references contracts(contract_id)
);
