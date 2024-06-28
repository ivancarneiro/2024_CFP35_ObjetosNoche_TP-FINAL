-- Active: 1719275292816@@127.0.0.1@3306
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories_ticket;
DROP TABLE IF EXISTS reports;
DROP TABLE IF EXISTS cves;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS incidents;
DROP TABLE IF EXISTS vulnerabilities;
DROP TABLE IF EXISTS events;

CREATE TABLE users (
  id INTEGER PRIMARY KEY,
  name TEXT(50) NOT NULL,
  surname TEXT(50) NOT NULL,
  email TEXT(50) UNIQUE NOT NULL /* No puede repetirse con otro usuario.*/,
  role TEXT NOT NULL check (role in ('ADMINISTRADOR','OPERADOR','VEEDOR'))
);

CREATE TABLE categories_ticket (
  id INTEGER PRIMARY KEY,
  clasification TEXT NOT NULL,
  category TEXT NOT NULL,
  detail TEXT NOT NULL
);

CREATE TABLE reports (
  id INTEGER PRIMARY KEY,
  title TEXT(100) NOT NULL,
  createdAt DATE DEFAULT current_timestamp,
  created_by INTEGER NOT NULL REFERENCES users(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  description TEXT NOT NULL DEFAULT 'Resumen Ejecutivo:..., Desarrollo:..., Recomendaciones:..., Referencias:...'
);

CREATE TABLE cves (
  id INTEGER PRIMARY KEY,
  cveId TEXT(15) NOT NULL DEFAULT 'CVE-XXXX-XXXXX',
  severity TEXT NOT NULL check (severity in ('CRITICA','ALTA','MEDIA','BAJA')),
  cvss FLOAT check (cvss >= 0 and cvss <=10),
  description TEXT NOT NULL,
  urlRef TEXT NOT NULL
);

CREATE TABLE tickets (
  id integer PRIMARY KEY,
  title TEXT(100) NOT NULL,
  code TEXT(3) NOT NULL DEFAULT 'INC' check (code in ('INC','VUL','EVE')),
  createdAt DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'localtime')),
  lastUpdate DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'localtime')),
  resolution DATETIME,
  severity TEXT DEFAULT 'BAJA' check (severity in ('CRITICA','ALTA','MEDIA','BAJA')),
  impact TEXT DEFAULT 'NULO' check (impact in ('CRITICO','IMPORTANTE','MODERADO','BAJO','NULO')),
  status TEXT DEFAULT 'ABIERTO' check (status in ('ABIERTO','TRAMITADO','CERRADO')),
  category INTEGER NOT NULL REFERENCES categories_ticket(id)
    ON UPDATE RESTRICT
    ON DELETE RESTRICT,
  resume TEXT(300),
  createdBy INTEGER NOT NULL REFERENCES users(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  assignedTo INTEGER REFERENCES users(id)
);

CREATE TABLE incidents (
  id INTEGER PRIMARY KEY,
  ticketId INTEGER NOT NULL REFERENCES tickets(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  srcip TEXT,
  srcport TEXT,
  dstip TEXT,
  dstport TEXT,
  report INTEGER REFERENCES reports(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE vulnerabilities (
  id INTEGER PRIMARY KEY,
  ticketId INTEGER NOT NULL REFERENCES tickets(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  advisories TEXT NOT NULL,
  cves TEXT REFERENCES cves(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  resume TEXT NOT NULL,
  vendor TEXT(50) NOT NULL,
  urlRef TEXT NOT NULL
);

CREATE TABLE events (
  id INTEGER PRIMARY KEY,
  ticketId INTEGER NOT NULL REFERENCES tickets(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  resume TEXT NOT NULL,
  report INTEGER REFERENCES reports(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)