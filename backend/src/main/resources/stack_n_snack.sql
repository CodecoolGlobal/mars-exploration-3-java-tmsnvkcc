--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;



SET default_tablespace = '';

SET default_with_oids = false;


---
--- drop tables
---


DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS answers_questions_reference;
DROP TABLE IF EXISTS answers_users_reference;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS questions_tags_reference;
DROP TABLE IF EXISTS questions_users_reference;
DROP TABLE IF EXISTS users;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(20),
                       password TEXT,
                       email VARCHAR(255)
);

CREATE TABLE questions(
                          id SERIAL PRIMARY KEY,
                          title VARCHAR(300) NOT NULL,
                          description TEXT,
                          createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          numberOfAnswers INTEGER,
                          numberOfViews INTEGER,
                          userId INTEGER REFERENCES users(id)
);

CREATE TABLE answers (
                         id SERIAL PRIMARY KEY,
                         description TEXT,
                         questionId INTEGER REFERENCES questions(id),
                         createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         numberOfLikes INTEGER,
                         numberOfDislikes INTEGER,
                         userId INTEGER REFERENCES users(id)
);

CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(16),
                      questionId INTEGER REFERENCES questions(id)
);

CREATE TABLE questions_tags_reference (
                                          questionId INTEGER,
                                          tagId INTEGER
);

CREATE TABLE questions_users_reference (
                                           questionId INTEGER,
                                           userId INTEGER
);

CREATE TABLE answers_users_reference (
                                         answerId INTEGER,
                                         userId INTEGER
);

CREATE TABLE answers_questions_reference (
                                             answerId INTEGER,
                                             questionId INTEGER
);

INSERT INTO users(username, password, email) VALUES ('admin', '123', 'admin@admin.com');
INSERT INTO questions(title, description, numberOfAnswers, numberOfViews, userId) VALUES ('Where is my phone?', 'I lost my phone a few minutes ago and I can''t find it :(', 2, 41, 1);
INSERT INTO answers(id, description, questionid, createdAt, numberOfLikes, numberOfDislikes, userId) VALUES
(1, 'This is the answer!', 1, Now(), 3, 4, 1);
