create table url(
                    id serial PRIMARY KEY,
                    cut_url varchar not null,
                    full_url varchar not null,
                    live_time timestamp
);

create index url_cut_url_index
    on url (cut_url);

INSERT INTO url (cut_url, full_url) VALUES ('g','google.com');
INSERT INTO url (cut_url, full_url) VALUES ('y','yandex.ru');
INSERT INTO url (cut_url, full_url) VALUES ('gm','gmail.com');