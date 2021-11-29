CREATE TABLE IF NOT EXISTS `recipe`
(
    `recipe_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `title`        TEXT                              NOT NULL,
    `description`  TEXT                              NOT NULL,
    `created`      INTEGER                           NOT NULL,
    `steps`        TEXT                              NOT NULL,
    `cuisine_type` INTEGER                           NOT NULL
);

CREATE INDEX IF NOT EXISTS `index_recipe_title` ON `recipe` (`title`);

CREATE INDEX IF NOT EXISTS `index_recipe_created` ON `recipe` (`created`);

CREATE INDEX IF NOT EXISTS `index_recipe_cuisine_type` ON `recipe` (`cuisine_type`);

CREATE TABLE IF NOT EXISTS `ingredient`
(
    `ingredient_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `recipe_id`     INTEGER                           NOT NULL,
    `name`          TEXT                              NOT NULL,
    `created`       INTEGER                           NOT NULL,
    FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_ingredient_recipe_id` ON `ingredient` (`recipe_id`);

CREATE INDEX IF NOT EXISTS `index_ingredient_created` ON `ingredient` (`created`);

