CREATE TABLE falasehhrio.image
(
	id_occurrence BIGINT NOT NULL,
	hash_image TEXT NOT NULL,
	KEY (id_occurrence)
);


CREATE TABLE falasehhrio.occurrence
(
	id BIGINT NOT NULL AUTO_INCREMENT,
	desc_open TEXT NOT NULL,
	id_user_open BIGINT NOT NULL,
	localization TEXT NOT NULL,
	desc_conclusion TEXT,
	id_user_conclusion BIGINT,
	PRIMARY KEY (id),
	KEY (desc_conclusion)
);


CREATE TABLE falasehhrio.user
(
	id BIGINT NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(32) NOT NULL,
	openid VARCHAR(255),
	admin SMALLINT NOT NULL,
	authority SMALLINT NOT NULL,
	PRIMARY KEY (id),
	UNIQUE UQ_user_email(email)
);

ALTER TABLE falasehhrio.image ADD CONSTRAINT FK_image_occurrence 
	FOREIGN KEY (id_occurrence) REFERENCES falasehhrio.occurrence (id)
;

ALTER TABLE falasehhrio.occurrence ADD CONSTRAINT FK_occurrence_user_conclusion 
	FOREIGN KEY (desc_conclusion) REFERENCES falasehhrio.user (id)
;