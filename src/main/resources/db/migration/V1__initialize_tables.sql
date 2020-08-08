CREATE TABLE "user" (
	id numeric NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	notification_enabled bool NOT NULL DEFAULT false,
	created timestamp NOT NULL DEFAULT now(),
	"name" varchar NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE poll (
	id numeric NOT NULL,
	title varchar NULL,
	description varchar NULL,
	"type" varchar NULL,
	state varchar NULL,
	locale varchar NULL,
	created timestamp NOT NULL DEFAULT now(),
	modified timestamp NOT NULL DEFAULT now(),
	created_user_id numeric NOT NULL,
	preferences_type varchar NULL,
	device varchar NULL,
	"level" varchar NULL,
	meta_data jsonb  NULL,
	CONSTRAINT poll_pk PRIMARY KEY (id),
	CONSTRAINT poll_user_fk FOREIGN KEY (created_user_id) REFERENCES "user"(id)
);
CREATE INDEX poll_created_user_id_idx ON poll USING btree (created_user_id);
CREATE INDEX poll_title_idx ON poll USING btree (title);


CREATE TABLE invitee (
	id numeric NOT NULL,
	invited_user_id numeric NOT NULL,
	poll_id numeric NOT NULL,
	created timestamp NOT NULL DEFAULT now(),
	invited_by numeric NULL,
	CONSTRAINT invitee_pk PRIMARY KEY (id),
	CONSTRAINT invitee_poll_fk FOREIGN KEY (poll_id) REFERENCES poll(id),
	CONSTRAINT invitee_user_fk FOREIGN KEY (invited_user_id) REFERENCES "user"(id)
);
CREATE INDEX invitee_poll_id_idx ON invitee USING btree (poll_id);

CREATE TABLE "option" (
	id numeric NOT NULL,
	"text" varchar NOT NULL,
	active bool NOT NULL DEFAULT true,
	start_date timestamp NULL,
	end_date timestamp NULL,
	meta_data jsonb NULL,
	poll_id numeric NOT NULL,
	CONSTRAINT option_pk PRIMARY KEY (id),
	CONSTRAINT option_poll_fk FOREIGN KEY (poll_id) REFERENCES poll(id)
);
CREATE INDEX option_poll_id_idx ON option USING btree (poll_id);

CREATE TABLE user_vote (
	id numeric NOT NULL,
	poll_id numeric NOT NULL,
	user_id numeric NOT NULL,
	created timestamp NOT NULL DEFAULT now(),
	option_id numeric NOT NULL,
	CONSTRAINT participant_pk PRIMARY KEY (id),
	CONSTRAINT participant_poll_fk FOREIGN KEY (poll_id) REFERENCES poll(id),
	CONSTRAINT participant_user_fk FOREIGN KEY (user_id) REFERENCES "user"(id),
	CONSTRAINT user_vote_option_fk FOREIGN KEY (option_id) REFERENCES option(id)
);
CREATE INDEX user_vote_poll_id_idx ON user_vote USING btree (poll_id);


CREATE SEQUENCE invitee_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE user_vote_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE poll_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE user_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE option_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;