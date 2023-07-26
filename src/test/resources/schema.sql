create table inspection_trial_item_report
(
    id         bigint auto_increment primary key,
    name       varchar(255),
    email      varchar(255),
    created_by bigint,
    created_at datetime default CURRENT_TIMESTAMP,
    updated_by bigint,
    updated_at datetime default CURRENT_TIMESTAMP
);