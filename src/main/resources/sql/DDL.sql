DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ticket_categories;
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
    role TEXT NOT NULL check (
        role in (
            'ADMINISTRADOR',
            'OPERADOR',
            'VEEDOR'
        )
    ),
    activo BOOLEAN DEFAULT true check (activo in (true, false))
);

CREATE TABLE ticket_categories (
    id INTEGER PRIMARY KEY,
    category TEXT NOT NULL,
    type TEXT NOT NULL,
    description TEXT NOT NULL,
    activo BOOLEAN DEFAULT true check (activo in (true, false))
);

CREATE TABLE reports (
    id INTEGER PRIMARY KEY,
    title TEXT(100) NOT NULL,
    createdAt DATE DEFAULT current_timestamp,
    created_by INTEGER NOT NULL REFERENCES users (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    description TEXT NOT NULL DEFAULT 'Resumen Ejecutivo:..., Desarrollo:..., Recomendaciones:..., Referencias:...',
    activo BOOLEAN DEFAULT true check (activo in (true, false))
);

CREATE TABLE cves (
    id INTEGER PRIMARY KEY,
    cveId TEXT(15) NOT NULL DEFAULT 'CVE-XXXX-XXXXX',
    publishedDate TEXT NOT NULL,
    lastModified TEXT,
    severity TEXT NOT NULL check (
        severity in (
            'CRITICA',
            'ALTA',
            'MEDIA',
            'BAJA',
            'NA'
        )
    ),
    cvss TEXT NOT NULL,
    description TEXT NOT NULL,
    urlRef TEXT NOT NULL
);

CREATE TABLE tickets (
    id integer PRIMARY KEY,
    title TEXT(100) NOT NULL,
    type TEXT(3) NOT NULL DEFAULT 'INC' check (type in ('INC', 'VUL', 'EVE')),
    createdAt DATETIME DEFAULT (
        DATETIME('now',
            'localtime'
        )
    ),
    lastUpdate DATETIME DEFAULT (
        DATETIME('now',
            'localtime'
        )
    ),
    resolution TEXT,
    severity TEXT DEFAULT 'BAJA' check (
        severity in (
            'CRITICA',
            'ALTA',
            'MEDIA',
            'BAJA'
        )
    ),
    impact TEXT DEFAULT 'NULO' check (
        impact in (
            'CRITICO',
            'IMPORTANTE',
            'MODERADO',
            'BAJO',
            'NULO'
        )
    ),
    category INTEGER NOT NULL REFERENCES ticket_categories (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    createdBy INTEGER NOT NULL REFERENCES users (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    assignedTo INTEGER REFERENCES users (id),
    status TEXT DEFAULT 'ABIERTO' check (
        status in (
            'ABIERTO',
            'TRAMITADO',
            'CERRADO'
        )
    ),
    resume TEXT(300)
);

CREATE TABLE incidents (
    id INTEGER PRIMARY KEY,
    ticketId INTEGER NOT NULL REFERENCES tickets (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    srcip TEXT,
    srcport TEXT,
    dstip TEXT,
    dstport TEXT,
    reportId INTEGER REFERENCES reports (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    activo BOOLEAN DEFAULT true check (activo in (true, false))
);

CREATE TABLE vulnerabilities (
    id INTEGER PRIMARY KEY,
    ticketId INTEGER NOT NULL REFERENCES tickets (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    advisories TEXT NOT NULL,
    cves TEXT REFERENCES cves (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    resume TEXT NOT NULL,
    vendor TEXT(50) NOT NULL,
    urlRef TEXT NOT NULL,
    activo BOOLEAN DEFAULT true check (activo in (true, false))
);

CREATE TABLE events (
    id INTEGER PRIMARY KEY,
    ticketId INTEGER NOT NULL REFERENCES tickets (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    resume TEXT NOT NULL,
    reportId INTEGER REFERENCES reports (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    activo BOOLEAN DEFAULT true check (activo in (true, false))
)