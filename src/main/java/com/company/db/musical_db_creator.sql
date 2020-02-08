CREATE DATABASE IF NOT EXISTS `musical_pursuit`;

USE `musical_pursuit`;

CREATE TABLE IF NOT EXISTS `artists` (
                           `name` VARCHAR(300) NOT NULL,
                           `id` VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `songs` (
                         `song_id` INT NOT NULL PRIMARY KEY,
                         `year` INT NOT NULL,
                         `title` VARCHAR(300) NOT NULL,
                         `artist_id` VARCHAR(100) NOT NULL REFERENCES `artists`(`id`)
);

CREATE TABLE IF NOT EXISTS `data` (
                        `song_id` INT NOT NULL PRIMARY KEY,
                        `year` INT NOT NULL,
                        `title` VARCHAR(300) NOT NULL,
                        `name` VARCHAR(300) NOT NULL,
                        `artist_id` VARCHAR(100) NOT NULL
);