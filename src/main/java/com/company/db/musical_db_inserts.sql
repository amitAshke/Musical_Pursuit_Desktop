use `musical_pursuit`;
LOAD DATA INFILE  ''SongCSV.csv'' INTO TABLE `data`
FIELDS TERMINATED BY '',''
ENCLOSED BY ''"''
LINES TERMINATED BY ''\r\n''
IGNORE 1 ROWS;

INSERT INTO `songs` ( `song_id`, `year`, `title`, `artist_id`)
SELECT  `song_id`, `year`, `title`, `artist_id`
FROM  `data`
WHERE NOT (`year`= 0);

INSERT INTO `artists` (`name`, `id`)
SELECT  `name`, `artist_id`
FROM  `data`
-- GROUP BY `name`, `artist_id`
-- HAVING COUNT(*) = 1;