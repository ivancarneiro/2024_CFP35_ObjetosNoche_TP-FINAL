-- CONSULTAS DE PRUEBA
SELECT * FROM users;
SELECT clasification, count(ticket_categories.clasification) AS 'CANT' FROM ticket_categories GROUP BY clasification;
SELECT count(ticket_categories.category) AS 'CATEGORIAS_DE_TICKET' FROM ticket_categories;
SELECT * FROM ticket_categories WHERE category LIKE '%phish%';
SELECT * FROM tickets;
SELECT * FROM incidents;
SELECT * FROM vulnerabilities;

-- 1 LISTADO DE TICKET INCIDENTES
SELECT tickets.id, tickets.type, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM incidents
    JOIN tickets ON incidents.ticketId = tickets.id;

-- 2 LISTADO DE TICKET VULNERABILIDADES
SELECT tickets.id, tickets.type, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM vulnerabilities
    JOIN tickets ON vulnerabilities.ticketId = tickets.id;

-- 2 INCIDENTES REGISTRADOS POR IVAN
SELECT tickets.id, tickets.type, tickets.title, tickets.createdAt, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, users.name
    FROM tickets
    JOIN users ON tickets.createdBy = users.id
    WHERE users.name LIKE '%ivan%';

-- 3 INCIDENTES REGISTRADOS DE CATEGORIA MALWARE
SELECT tickets.id, tickets.type, tickets.title, tickets.severity, tickets.impact, tickets.status, ticket_categories.clasification, ticket_categories.category
    FROM tickets
    JOIN ticket_categories ON tickets.category = ticket_categories.id
    WHERE ticket_categories.category LIKE '%malware%';


-- 4 TICKETS INCIDENTES ORDENADOS POR EL TITULO
SELECT tickets.id, tickets.type, tickets.title, tickets.createdAt, tickets.lastUpdate, tickets.resolution, tickets.severity, tickets.impact, tickets.status, tickets.category, tickets.createdBy
    FROM incidents
    JOIN tickets ON incidents.ticketId = tickets.id
    ORDER BY tickets.title;


