INSERT INTO users (nombre,apellido,email,role) VALUES 
('Admin','Administrador','csirt@gna.gob,ar','ADMINISTRADOR'),
('Ivan', 'Carneiro', 'icarneiro@gmail.com', 'OPERADOR'),
('Tamara', 'Acosta', 'tacosta@gmail.com', 'VEEDOR');

-- INSERT INTO categories_tickets (clasification,type) VALUES
--     ("Contenido Abusivo",'{
--       "SPAM": "Correo electrónico masivo no solicitado.",
--       "Manifestación de odio": "Contenido discriminatorio, acoso, amenazas, incitación a la violencia o similar.",
--       "Abuso sexual infantil, contenido sexual": "Material que represente contenido relacionado con el abuso sexual infantil, etc."
--       }'
--     );

-- SELECT clasification, json_extract (type, '$.SPAM') AS SPAM FROM categories_tickets;

INSERT INTO categories_ticket (id, clasification, category, detail) VALUES
    (1, 'Contenido Abusivo', 'SPAM', 'Correo electrónico masivo no solicitado.'),
    (2, 'Contenido Abusivo', 'Manifestación de odio', 'Contenido discriminatorio, acoso, amenazas, incitación a la violencia o similar.'),
    (3, 'Contenido Abusivo', 'Abuso sexual infantil, contenido sexual', 'Material que represente contenido relacionado con el abuso sexual infantil, etc.'),
    (4, 'Contenido Dañino', 'Malware', 'Código malicioso que puede ser distribuido con fines ilegítimos y se instala sin autorización o conocimiento del usuario en equipos que resultan infectados. En este ítem, se encontrarán todos los códigos maliciosos que no estén descritos en otros tipos de la taxonomía.'),
    (5, 'Contenido Dañino', 'Ransomware', 'Tipo de software malicioso que bloquea el acceso a los datos de la víctima. Quien lo usa puede inclusive publicar y/o difundir la información bloqueada si no se paga el rescate pedido para liberar la información.'),
    (6, 'Contenido Dañino', 'Botnet', 'Conjunto de hosts conectados a Internet que interactúan con el fin de cumplir una tarea distribuida, que generalmente es maliciosa.'),
    (7, 'Contenido Dañino', 'Command & Control', 'También llamados C&C o C2, son servidores operados por el/los atacante/s para controlar una botnet.'),
    (8, 'Obtención de información', 'Escaneo de redes / análisis de tráfico', 'Envío de peticiones a un sistema para descubrir vulnerabilidades, obtención del tráfico de red o similar.'),
    (9, 'Obtención de información', 'Ingeniería social', 'Recopilación de información, con el uso o no de la tecnología, en la que el atacante utiliza técnicas de manipulación psicológica o engaños para lograr que la víctima le entregue voluntariamente su información.'),
    (10, 'Intrusión', 'Explotación de vulnerabilidades', 'Intento o compromiso de un sistema a través de fallas o ausencia de controles o medidas de seguridad apropiadas.'),
    (11, 'Intrusión', 'Ataque de fuerza bruta', 'Múltiples intentos de vulnerar credenciales.'),
    (12, 'Intrusión', 'Ataque desconocido', 'Son aquellos ataques cuya naturaleza no se conoce.'),
    (13, 'Intrusión', 'Compromiso de equipo/sistema', 'Afectación de la confidencialidad, integridad o disponibilidad de un sistema/aplicación mediante técnicas tales como SQLi, keyloggers, web shell, etc.'),
    (14, 'Intrusión', 'Robo', 'Intrusión física que concluye con el robo de activos, como pueden ser equipos o información.'),
    (15, 'Intrusión', 'Compromiso de cuenta', 'Compromiso de un sistema empleando una cuenta con o sin privilegios.'),
    (16, 'Disponibilidad', 'Denegación de servicio (DoS/DDoS)', 'Ciberataque que tiene como objetivo que uno o varios ordenadores, servicios u otros dispositivos no estén disponibles para los usuarios a los que va dirigido, interrumpiendo su funcionamiento normal.'),
    (17, 'Disponibilidad', 'Configuración errónea', 'Configuración débil o errónea de un sistema que permita afectar su disponibilidad.'),
    (18, 'Disponibilidad', 'Sabotaje', 'Sabotaje físico que puede afectar la disponibilidad de los servicios o de la información. Ej: cortes de cableados de equipos o incendios provocados.'),
    (19, 'Disponibilidad', 'Interrupciones', 'Afectaciones a la disponibilidad por causas ajenas como desastre natural, condiciones climáticas desfavorables, etc.'),
    (20, 'Compromiso de la información', 'Acceso no autorizado a la información', 'Acceso sin permiso a los activos, como documentos, sistemas, servicios, etc.'),
    (21, 'Compromiso de la información', 'Modificación no autorizada de la información', 'Alteración no autorizada de la información (creación, modificación o borrado). Esto puede ser causado por ataques de ransomware, queries SQL, etc.'),
    (22, 'Compromiso de la información', 'Pérdida de datos', 'Pérdida de información sucedida por fallo de hardware.'),
    (23, 'Indicio de fraude', 'Uso no autorizado de los recursos', 'Utilización de los recursos para propósitos inadecuados.'),
    (24, 'Indicio de fraude', 'Derechos de autor', 'Ofrecimiento o instalación de software, y utilización o difusión de manera ilegítima de material protegido por derechos de autor.'),
    (25, 'Indicio de fraude', 'Suplantación', 'Ataque mediante el cual una entidad se hace pasar por otra para obtener beneficios ilegítimos.'),
    (26, 'Indicio de fraude', 'Phishing - General', 'Suplantación de identidad para la sustracción de datos.'),
    (27, 'Indicio de fraude', 'Phishing - Correo electrónico', 'El phishing por email es el tipo más utilizado y más conocido.'),
    (28, 'Indicio de fraude', 'Phishing - Vishing', 'Este ataque se lleva a cabo a través de una llamada de voz.'),
    (29, 'Indicio de fraude', 'Phishing - Whaling', 'Es un ciberataque dirigido al personal jerárquico de las organizaciones.'),
    (30, 'Indicio de fraude', 'Phishing - Smishing', 'Consiste en mandar un mensaje de texto (SMS) suplantando la identidad del remitente.'),
    (31, 'Indicio de fraude', 'Phishing - Basado en malware', 'El ciberdelincuente envía un correo electrónico que en sí es el malware.'),
    (32, 'Indicio de fraude', 'Phishing - QRishing', 'Se trata de códigos QR modificados de forma maliciosa.'),
    (33, 'Activo vulnerable', 'Sistema vulnerable', 'Sistema con servicios vulnerables, ya sea por errores de diseño o por no poseer medidas de seguridad o controles apropiados.'),
    (34, 'Activo vulnerable', 'Publicación de servicios vulnerables', 'Servicios activos expuestos en Internet que pueden ser utilizados para el acceso no autorizado en los sistemas. Ej: RDP, Telnet, etc.'),
    (35, 'Activo vulnerable', 'Revelación de información', 'Servicios que permiten la obtención de información sensible.'),
    (36, 'Otros', 'Amenaza persistente avanzada o APT', 'Ataques dirigidos a organizaciones.'),
    (37, 'Otros', 'Sectores no críticos', 'Aquellos incidentes que no puedan ser clasificados dentro de los actuales parámetros.');

SELECT * FROM categories_ticket WHERE category LIKE '%phish%';

-- CREAMOS UNOS TICKETS
INSERT INTO tickets (title,severity,impact,category,createdBy) VALUES
    ('Escaneo de red','BAJA','BAJO',8,1),
    ('Compromiso de Aplicaciones','ALTA','IMPORTANTE',13,2),
    ('Contenido Dañino','CRITICA','IMPORTANTE',4,2);

SELECT * FROM tickets;
UPDATE tickets SET status='CERRADO' WHERE id=1;
SELECT * FROM tickets;

-- Calculate and SET tickets.resolution timestamp
UPDATE tickets
SET status = 'CERRADO', 
    lastUpdate = current_timestamp,
    resolution = (
        SELECT CAST(julianday(lastUpdate) - julianday(cratedAt) AS INTEGER) || ' Días ' ||
            strftime('%H:%M', 'now', '-' || CAST(julianday(lastUpdate) - julianday(cratedAt) AS TEXT) || ' days')
    )
WHERE status = 'CERRADO';

SELECT * FROM tickets;
