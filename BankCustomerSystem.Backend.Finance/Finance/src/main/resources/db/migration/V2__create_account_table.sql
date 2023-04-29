create table if not exists finance.account (
        id uuid not null,
        balance numeric not null,
        account_status text not null,
        account_type text not null,
        currency text not null,
        customer_id uuid not null,
        primary key (id)
);


