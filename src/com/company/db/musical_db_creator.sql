USE `musical_pursuit_db`;

CREATE TABLE `artists` (
	`name` VARCHAR(300) NOT NULL,
    `id` VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE `albums` (
	`id` int NOT NULL PRIMARY KEY,
    `name` VARCHAR(300) NOT NULL,
    `artist_id` VARCHAR(100) REFERENCES `artists`(`id`)
);

CREATE TABLE `songs` (
	`song_id` VARCHAR(100) NOT NULL PRIMARY KEY,
    `album_id` int NOT NULL REFERENCES `albums`(`id`),
    `year` INT NOT NULL,
    `title` VARCHAR(300) NOT NULL
);