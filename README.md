

ーーーデータベース設計ーーー

CREATE DATABASE recipe_album_db
CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

USE recipe_album_db;

SELECT * FROM admins;
SELECT * FROM recipe;

CREATE TABLE admins (
   id INT PRIMARY KEY AUTO_INCREMENT,
   login_id VARCHAR(30) UNIQUE NOT NULL,
   login_pass CHAR(60) NOT NULL,
   name VARCHAR(30) NOT NULL
);

CREATE TABLE recipe (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(50) UNIQUE NOT NULL,
   detail VARCHAR(500),
   url VARCHAR(255),
   images VARCHAR(50)
   );
   
   -- パスワードは「kama,chi,koba」
INSERT INTO admins VALUES
(1, "kamada", "$2a$10$Y5Yc7lHQV/r/k7AyIM6i9e5HQ3mJ6aZAV3vyszySQLbgmuNHGl/XW", "鎌田"),
(2, "chisato", "$2a$10$Uu4ZZpBgCIGBsH.6dOlDzOllrXejMmmmkjdr4b/MAuZY9zLfneuy6", "千紗都"),
(3, "kobayashi", "$2a$10$wt.DxxNBkGW68bVsIU2xaO4m8bcfapgZvAjmtJtMRnuRHbiAf78na", "小林");

INSERT INTO recipe VALUES
(1, "ゴーヤチャンプル", "卵、ゴーヤ、豆腐", null, "cook_photo03.jpg");

SELECT * FROM admins
WHERE login_id=2;

-- RecipeDaoImplのfindAllに記述
SELECT
recipe.id, recipe.name, recipe.detail, 
recipe.url, recipe.images 
FROM recipe;

-- RecipeDaoImplのaddに記述
INSERT INTO recipe(name,detail,url,images)
VALUES("ハンバーグ", "ひき肉、玉ねぎ、パン粉", "https://cookpad.com/jp/recipes/19788495-%E7%B0%A1%E5%8D%98%E3%81%8A%E3%81%84%E3%81%97%E3%81%84%E5%9F%BA%E6%9C%AC%E3%81%AE%E3%83%8F%E3%83%B3%E3%83%90%E3%83%BC%E3%82%B0", "cook_photo07.png");

-- RecipeDaoImplのupdateに記述
UPDATE recipe
SET name = "オムライス", detail = "卵、玉ねぎ、ピーマン、ケチャップ", url = "https://www.sirogohan.com/recipe/omuraisukihon/", images = "cook_photo08.png"
WHERE id = 3;

-- RecipeDaoImplのdeleteに記述
DELETE FROM recipe WHERE id = 5;

-- RecipeDaoImplのfindByIdに記述
SELECT
recipe.id, recipe.name, recipe.detail, 
recipe.url, recipe.images 
FROM recipe
WHERE recipe.id=1;
