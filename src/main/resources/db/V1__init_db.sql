create table if not exists employee(
employee_id BIGSERIAL,
first_name character varying(50) not null,
last_name character varying(50) not null,
middle_name character varying(50),
dob date not null,
contact_number character varying(20) not null,
email character varying(50) not null,
CONSTRAINT employee_pkey PRIMARY KEY (employee_id)
)