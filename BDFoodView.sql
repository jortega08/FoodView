-- Schema foodview
CREATE SCHEMA IF NOT EXISTS foodview;

-- Table foodview.department
CREATE TABLE IF NOT EXISTS foodview.department (
  id_department SERIAL PRIMARY KEY,
  name VARCHAR(40) NOT NULL
);

-- Table foodview.town
CREATE TABLE IF NOT EXISTS foodview.town (
  id_town SERIAL PRIMARY KEY,
  name VARCHAR(40) NOT NULL,
  FK_id_department_t INT NOT NULL,
  CONSTRAINT FK_id_department_t
    FOREIGN KEY (FK_id_department_t)
    REFERENCES foodview.department (id_department)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.usertable
CREATE TABLE IF NOT EXISTS foodview.usertable (
  id_user SERIAL PRIMARY KEY,
  given_name VARCHAR(50) NOT NULL,
  familary_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  gender VARCHAR(9) CHECK (gender IN ('Masculino', 'Femenino', 'Otro')) NOT NULL,
  birthday DATE NOT NULL,
  status VARCHAR(7) CHECK (status IN ('Activo', 'Inactivo')) NOT NULL,
  FK_id_town_u INT,
  CONSTRAINT FK_id_town_u
    FOREIGN KEY (FK_id_town_u)
    REFERENCES foodview.town (id_town)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.neighborhood
CREATE TABLE IF NOT EXISTS foodview.neighborhood (
  id_neighborhood SERIAL PRIMARY KEY,
  name VARCHAR(40) NOT NULL,
  FK_id_town_n INT NOT NULL,
  CONSTRAINT FK_id_town_n
    FOREIGN KEY (FK_id_town_n)
    REFERENCES foodview.town (id_town)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.address
CREATE TABLE IF NOT EXISTS foodview.address (
  id_address SERIAL PRIMARY KEY,
  street VARCHAR(45) NOT NULL,
  street_number VARCHAR(45) NOT NULL,
  street_complement VARCHAR(45),
  FK_neighborhood_a INT NOT NULL,
  CONSTRAINT FK_neighborhood_a
    FOREIGN KEY (FK_neighborhood_a)
    REFERENCES foodview.neighborhood (id_neighborhood)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.place
CREATE TABLE IF NOT EXISTS foodview.place (
  id_place SERIAL PRIMARY KEY,
  name_place VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  email VARCHAR(50) NOT NULL,
  phonenumber VARCHAR(16) NOT NULL,
  FK_id_address_p INT NOT NULL,
  status VARCHAR(7) CHECK (status IN ('Activo', 'Inactivo')) NOT NULL,
  CONSTRAINT FK_id_address_p
    FOREIGN KEY (FK_id_address_p)
    REFERENCES foodview.address (id_address)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.favoriteplaces
CREATE TABLE IF NOT EXISTS foodview.favoriteplaces (
  id_favoriteplaces SERIAL PRIMARY KEY,
  FK_id_user_fp INT NOT NULL,
  FK_id_place_fp INT NOT NULL,
  CONSTRAINT FK_id_user_fp
    FOREIGN KEY (FK_id_user_fp)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_place_fp
    FOREIGN KEY (FK_id_place_fp)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.review
CREATE TABLE IF NOT EXISTS foodview.review (
  id_review SERIAL PRIMARY KEY,
  description TEXT NOT NULL,
  stars FLOAT NOT NULL,
  date DATE NOT NULL,
  FK_id_user_r INT NOT NULL,
  FK_id_place_r INT NOT NULL,
  CONSTRAINT FK_id_user_r
    FOREIGN KEY (FK_id_user_r)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_place_r
    FOREIGN KEY (FK_id_place_r)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.content
CREATE TABLE IF NOT EXISTS foodview.content (
  id_content SERIAL PRIMARY KEY,
  FK_id_place_c INT NOT NULL,
  CONSTRAINT FK_id_place_c
    FOREIGN KEY (FK_id_place_c)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.placeList
CREATE TABLE IF NOT EXISTS foodview.placeList (
  id_placeList SERIAL PRIMARY KEY,
  name VARCHAR(24) NOT NULL,
  description TEXT NOT NULL,
  image BYTEA,
  FK_id_user_pl INT NOT NULL,
  FK_id_content_pl INT NOT NULL,
  CONSTRAINT FK_id_user_pl
    FOREIGN KEY (FK_id_user_pl)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_content_pl
    FOREIGN KEY (FK_id_content_pl)
    REFERENCES foodview.content (id_content)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.place_metrics
CREATE TABLE IF NOT EXISTS foodview.place_metrics (
  id_metrics INT PRIMARY KEY,
  contReview INT NOT NULL,
  contLikes INT NOT NULL,
  contPlaceList INT NOT NULL,
  FK_id_place_m INT NOT NULL,
  CONSTRAINT FK_id_place_m
    FOREIGN KEY (FK_id_place_m)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.place_image
CREATE TABLE IF NOT EXISTS foodview.place_image (
  id_place_image INT PRIMARY KEY,
  image BYTEA,
  FK_id_place_i INT NOT NULL,
  CONSTRAINT FK_id_place_i
    FOREIGN KEY (FK_id_place_i)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.friendship
CREATE TABLE IF NOT EXISTS foodview.friendship (
  id_friendship INT PRIMARY KEY,
  FK_id_user_f1 INT NOT NULL,
  FK_id_user_f2 INT NOT NULL,
  status VARCHAR(10) CHECK (status IN ('Pendiente', 'Aceptada', 'Rechazada')) NOT NULL,
  CONSTRAINT FK_id_user_f1
    FOREIGN KEY (FK_id_user_f1)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_user_f2
    FOREIGN KEY (FK_id_user_f2)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.preferences
CREATE TABLE IF NOT EXISTS foodview.preferences (
  id_preferences SERIAL PRIMARY KEY,
  name VARCHAR(48) NOT NULL
);

-- Table foodview.user_preferences
CREATE TABLE IF NOT EXISTS foodview.user_preferences (
  id_user_preferences SERIAL PRIMARY KEY,
  FK_id_user_up INT NOT NULL,
  FK_id_preferences_up INT NOT NULL,
  CONSTRAINT FK_id_user_up
    FOREIGN KEY (FK_id_user_up)
    REFERENCES foodview.usertable (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_preferences_up
    FOREIGN KEY (FK_id_preferences_up)
    REFERENCES foodview.preferences (id_preferences)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Table foodview.place_preferences
CREATE TABLE IF NOT EXISTS foodview.place_preferences (
  id_place_preferences SERIAL PRIMARY KEY,
  FK_id_place_pp INT NOT NULL,
  FK_id_preferences_pp INT NOT NULL,
  CONSTRAINT FK_id_place_pp
    FOREIGN KEY (FK_id_place_pp)
    REFERENCES foodview.place (id_place)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_id_preferences_pp
    FOREIGN KEY (FK_id_preferences_pp)
    REFERENCES foodview.preferences (id_preferences)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
