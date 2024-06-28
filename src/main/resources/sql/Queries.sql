-- CONSULTAS DE PRUEBA
SELECT * FROM users;
SELECT clasification, count(categories_ticket.clasification) AS 'CANT' FROM categories_ticket GROUP BY clasification;
SELECT count(categories_ticket.category) AS 'CATEGORIAS_DE_TICKET' FROM categories_ticket;
SELECT * FROM categories_ticket WHERE category LIKE '%phish%';
SELECT * FROM tickets;
SELECT * FROM incidents;
SELECT * FROM vulnerabilities;

-- 1 LISTADO DE TICKET INCIDENTES
SELECT tickets.id, tickets.code, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM incidents
    JOIN tickets ON incidents.ticketId = tickets.id;

-- 2 LISTADO DE TICKET VULNERABILIDADES
SELECT tickets.id, tickets.code, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM vulnerabilities
    JOIN tickets ON vulnerabilities.ticketId = tickets.id;

-- 2 INCIDENTES REGISTRADOS POR IVAN
SELECT tickets.id, tickets.code, tickets.title, tickets.createdAt, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, users.name
    FROM tickets
    JOIN users ON tickets.createdBy = users.id
    WHERE users.name LIKE '%ivan%';

-- 3 INCIDENTES REGISTRADOS DE CATEGORIA MALWARE
SELECT tickets.id, tickets.code, tickets.title, tickets.severity, tickets.impact, tickets.status, categories_ticket.clasification, categories_ticket.category
    FROM tickets
    JOIN categories_ticket ON tickets.category = categories_ticket.id
    WHERE categories_ticket.category LIKE '%malware%';


-- 4 TICKETS INCIDENTES ORDENADOS POR EL TITULO
SELECT tickets.id, tickets.code, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM incidents
    JOIN tickets ON incidents.ticketId = tickets.id
    ORDER BY tickets.title;


