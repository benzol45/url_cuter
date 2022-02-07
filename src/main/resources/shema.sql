create table url(
                    id serial PRIMARY KEY,
                    cut_url varchar not null,
                    full_url varchar not null,
                    live_time timestamp
);

create index url_cut_url_index
    on url (cut_url);