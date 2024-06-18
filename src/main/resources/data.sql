-- Inserción de jugadores en la tabla players
INSERT INTO players (id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES
    (1000000, 'APP', NULL, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (100,'Agus',NULL, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserción de juegos en la tabla games
INSERT INTO games (id, code, name, description, rules)
VALUES
    (1000000, 'RPS', 'RPS', 'A classic strategy game', 'Standard chess rules');

-- Inserción de partidas en la tabla matches con la columna match_type
INSERT INTO matches (id, game_id, player1_id, player2_id, created_at, update_at, status)
VALUES
    (1000000, 1000000, 100,1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'STARTED'),
    (1000001, 1000000, 100, 1000000,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'FINISHED'),
    (1000002, 1000000, 100,1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELED');

-- Inserción de partidas específicas de RPS en la tabla matches_rps
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES
    (1000000, 10, 5, 3, 2),
    (1000002, 10, 5, 3, 2);
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score, winner_id)
VALUES (1000001,10,0,6,4,100);

-- Inserción de jugadas de RPS en la tabla plays_rps
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES
    (1000000, 1000000, 'ROCK', 'PAPER', 1000000),
    (1000001, 1000000, 'PAPER', 'ROCK', 1000000),
    (1000002, 1000000, 'PAPER', 'ROCK', 1000000);
