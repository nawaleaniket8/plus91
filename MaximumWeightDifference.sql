CREATE TABLE items (
  id INT AUTO_INCREMENT PRIMARY KEY,
  weight INT
);



SELECT MAX(chef_sum - son_sum) AS max_difference
FROM (
  SELECT SUM(CASE WHEN row_number <= K THEN weight ELSE 0 END) AS son_sum,
         SUM(CASE WHEN row_number > N - K THEN weight ELSE 0 END) AS chef_sum
  FROM (
    SELECT weight,
           ROW_NUMBER() OVER (ORDER BY weight) AS row_number,
           (SELECT COUNT(*) FROM items) AS N,
           (SELECT K FROM items LIMIT 1) AS K
    FROM items
  ) t
) t;


//code by Aniket Chandrakant Nawale//
