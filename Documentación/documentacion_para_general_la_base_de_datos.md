
# 📚 Documentación de Base de Datos: Biblioteca

## 📘 Paso 1: Conectarse a MySQL

```bash
mysql -u root -p
```
Introduce tu contraseña cuando se te solicite.

---

## 🏗️ Paso 2: Crear la base de datos

```sql
CREATE DATABASE biblioteca;
USE biblioteca;
```

---

## 📄 Paso 3: Crear las tablas

### 🔐 Tabla `admin`

```sql
CREATE TABLE admin (
  id_admin INT NOT NULL AUTO_INCREMENT,
  user VARCHAR(45) NOT NULL,
  pass VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_admin)
);
```

### 👤 Tabla `lector`

```sql
CREATE TABLE lector (
  id_lector INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45),
  pass VARCHAR(45),
  email VARCHAR(45),
  PRIMARY KEY (id_lector)
);
```

### 📚 Tabla `libro`

```sql
CREATE TABLE libro (
  id_libro INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(150) NOT NULL,
  autor VARCHAR(100) NOT NULL,
  editorial VARCHAR(100) NOT NULL,
  isbn VARCHAR(45) NOT NULL,
  genero VARCHAR(45) NOT NULL,
  anio_publicacion INT NOT NULL,
  cantidad_disponible INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id_libro)
);
```

### 📆 Tabla `prestamo`

```sql
CREATE TABLE prestamo (
  id_prestamo INT NOT NULL AUTO_INCREMENT,
  fecha_prestamo VARCHAR(45) NOT NULL,
  fecha_devolucion VARCHAR(45) NOT NULL,
  id_libro INT NOT NULL,
  id_lector INT NOT NULL,
  PRIMARY KEY (id_prestamo),
  FOREIGN KEY (id_libro) REFERENCES libro(id_libro),
  FOREIGN KEY (id_lector) REFERENCES lector(id_lector)
);
```

---

## ✍️ Paso 4: Insertar datos de ejemplo

### 👨‍💼 Insertar administrador

```sql
INSERT INTO admin (user, pass, email)
VALUES ('juan', '123', 'jeidenmayo@gmail.com');
```

### 👥 Insertar lectores

```sql
INSERT INTO lector (name, pass, email)
VALUES 
('Ana Torres', 'ana123', 'ana@mail.com'),
('Carlos Pérez', 'carlos456', 'carlos@mail.com'),
('Lucía Gómez', 'lucia789', 'lucia@mail.com');
```

### 📘 Insertar libros

```sql
INSERT INTO libro (titulo, autor, editorial, isbn, genero, anio_publicacion, cantidad_disponible)
VALUES
('Cien años de soledad', 'Gabriel García Márquez', 'Editorial Sudamericana', '9780307474728', 'Realismo mágico', 1967, 3),
('1984', 'George Orwell', 'Secker & Warburg', '9780451524935', 'Distopía', 1949, 4),
('El nombre del viento', 'Patrick Rothfuss', 'DAW Books', '9788401352836', 'Fantasía', 2007, 5),
('La sombra del viento', 'Carlos Ruiz Zafón', 'Planeta', '9788408172178', 'Misterio', 2001, 6);
```

### 📆 Insertar préstamos

```sql
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, id_libro, id_lector)
VALUES
('2025-06-15', '2025-06-30', 2, 1),
('2025-06-16', '2025-07-01', 3, 2),
('2025-06-17', '2025-07-02', 4, 3);
```

---

## ✅ Paso 5: Verificar datos

```sql
SELECT * FROM admin;
SELECT * FROM lector;
SELECT * FROM libro;
SELECT * FROM prestamo;
```
