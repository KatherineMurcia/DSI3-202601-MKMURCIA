CREATE TABLE IF NOT EXISTS Mesa (
    id_mesa    INTEGER PRIMARY KEY AUTOINCREMENT,
    numero     INTEGER,
    capacidad  INTEGER,
    estado     TEXT
);

CREATE TABLE IF NOT EXISTS Cliente (
    id_cliente     INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre         TEXT,
    telefono       TEXT,
    email          TEXT,
    fecha_registro DATETIME
);

CREATE TABLE IF NOT EXISTS Usuario (
    id_usuario    INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre        TEXT,
    email         TEXT,
    password_hash TEXT,
    activo        INTEGER
);

CREATE TABLE IF NOT EXISTS Producto (
    id_producto  INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre       TEXT,
    descripcion  TEXT,
    precio       REAL,
    categoria    TEXT,
    imagen_url   TEXT,
    disponible   INTEGER,
    stock        INTEGER
);

CREATE TABLE IF NOT EXISTS Pedido (
    id_pedido      INTEGER PRIMARY KEY AUTOINCREMENT,
    id_mesa        INTEGER,
    id_cliente     INTEGER,
    id_usuario     INTEGER,
    fecha_creacion DATETIME,
    estado         TEXT,
    observaciones  TEXT,
    total          REAL DEFAULT 0,

    FOREIGN KEY (id_mesa)    REFERENCES Mesa(id_mesa),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE IF NOT EXISTS detalle_pedido (
    id_detalle      INTEGER PRIMARY KEY AUTOINCREMENT,
    id_pedido       INTEGER,
    id_producto     INTEGER,
    cantidad        INTEGER,
    precio_unitario REAL,
    subtotal        REAL,

    FOREIGN KEY (id_pedido)   REFERENCES Pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
