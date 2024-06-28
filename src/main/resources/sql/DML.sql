INSERT INTO users (name,surname,email,role) VALUES 
    ('Admin','Administrador','csirt@gna.gob,ar','ADMINISTRADOR'),
    ('Ivan', 'Carneiro', 'icarneiro@gmail.com', 'OPERADOR'),
    ('Juan', 'Perez', 'juanperez@gmail.com', 'OPERADOR'),
    ('Tamara', 'Acosta', 'tacosta@gmail.com', 'VEEDOR');

INSERT INTO categories_ticket (id, clasification, category, detail) VALUES
    (1, 'Contenido Abusivo', 'SPAM', 'Correo electrónico masivo no solicitado.'),
    (2, 'Contenido Abusivo', 'Manifestación de odio', 'Contenido discriminatorio, acoso, amenazas, incitación a la violencia o similar.'),
    (3, 'Contenido Abusivo', 'Abuso sexual infantil, contenido sexual', 'Material que represente contenido relacionado con el abuso sexual infantil, etc.'),
    (4, 'Contenido Dañino', 'Malware', 'Código malicioso que puede ser distribuido con fines ilegítimos y se instala sin autorización o conocimiento del usuario en equipos que resultan infectados. En este ítem, se encontrarán todos los códigos maliciosos que no estén descritos en otros tipos de la taxonomía.'),
    (5, 'Contenido Dañino', 'Ransomware', 'Tipo de software malicioso que bloquea el acceso a los datos de la víctima. Quien lo usa puede inclusive publicar y/o difundir la información bloqueada si no se paga el rescate pedido para liberar la información.'),
    (6, 'Contenido Dañino', 'Botnet', 'Conjunto de hosts conectados a Internet que interactúan con el fin de cumplir una tarea distribuida, que generalmente es maliciosa.'),
    (7, 'Contenido Dañino', 'Command & Control', 'También llamados C&C o C2, son servidores operados por el/los atacante/s para controlar una botnet.'),
    (8, 'Obtencion de informacion', 'Escaneo de redes / análisis de tráfico', 'Envío de peticiones a un sistema para descubrir vulnerabilidades, obtención del tráfico de red o similar.'),
    (9, 'Obtencion de informacion', 'Ingeniería social', 'Recopilación de información, con el uso o no de la tecnología, en la que el atacante utiliza técnicas de manipulación psicológica o engaños para lograr que la víctima le entregue voluntariamente su información.'),
    (10, 'Intrusion', 'Explotación de vulnerabilidades', 'Intento o compromiso de un sistema a través de fallas o ausencia de controles o medidas de seguridad apropiadas.'),
    (11, 'Intrusion', 'Ataque de fuerza bruta', 'Múltiples intentos de vulnerar credenciales.'),
    (12, 'Intrusion', 'Ataque desconocido', 'Son aquellos ataques cuya naturaleza no se conoce.'),
    (13, 'Intrusion', 'Compromiso de equipo/sistema', 'Afectación de la confidencialidad, integridad o disponibilidad de un sistema/aplicación mediante técnicas tales como SQLi, keyloggers, web shell, etc.'),
    (14, 'Intrusion', 'Robo', 'Intrusion física que concluye con el robo de activos, como pueden ser equipos o información.'),
    (15, 'Intrusion', 'Compromiso de cuenta', 'Compromiso de un sistema empleando una cuenta con o sin privilegios.'),
    (16, 'Disponibilidad', 'Denegación de servicio (DoS/DDoS)', 'Ciberataque que tiene como objetivo que uno o varios ordenadores, servicios u otros dispositivos no estén disponibles para los usuarios a los que va dirigido, interrumpiendo su funcionamiento normal.'),
    (17, 'Disponibilidad', 'Configuración errónea', 'Configuración débil o errónea de un sistema que permita afectar su disponibilidad.'),
    (18, 'Disponibilidad', 'Sabotaje', 'Sabotaje físico que puede afectar la disponibilidad de los servicios o de la información. Ej: cortes de cableados de equipos o incendios provocados.'),
    (19, 'Disponibilidad', 'Interrupciones', 'Afectaciones a la disponibilidad por causas ajenas como corte suministro eléctrico, interrupción ISP, desastre natural, condiciones climáticas desfavorables, etc.'),
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
    (35, 'Activo vulnerable', 'Revelación de información', 'Servicios que permiten la obtencion de informacion sensible.'),
    (36, 'Otros', 'Amenaza persistente avanzada o APT', 'Ataques dirigidos a organizaciones.'),
    (37, 'Otros', 'Sectores no críticos', 'Aquellos incidentes que no puedan ser clasificados dentro de los actuales parámetros.');


-- REGISTRAMOS UNOS TICKETS
INSERT INTO tickets (title,severity,impact,resume,category,createdBy,assignedTo) VALUES ('Escaneo de red','BAJA','BAJO','Escaneo de puertos sobre infraestructura de PSA y DNIC con múltiples vectores de ataque.',8,1,3);
INSERT INTO tickets (title,severity,impact,status,resume,category,createdBy) VALUES ('Compromiso de Aplicaciones','ALTA','IMPORTANTE','TRAMITADO','Intento de "Inyección SQL" sobre el portal web de denuncias de MINSEG',13,2);
INSERT INTO tickets (title,severity,impact,category,createdBy) VALUES('Contenido Dañino','CRITICA','IMPORTANTE',4,3);
INSERT INTO tickets (title,code,severity,impact,category,createdBy,assignedTo) VALUES('Vulnerabilidad FORTINET','VUL','CRITICA','CRITICO',33,2,1);
INSERT INTO tickets (title,code,category,severity,impact,createdBy,assignedTo,resume) VALUES('Corte suministro eléctrico Zonal','EVE',19,'CRITICA','CRITICO',2,1,'Corte suministro eléctrico de la Zona, afectando al nodo de distribucion del ISP principal');


-- REGISTRAMOS UN CVE
INSERT INTO cves (cveId,severity,cvss,description,urlRef) VALUES 
('CVE-2023-45590','CRITICA',9.4,'Un control inadecuado de la generación de código ("inyección de código") en Fortinet FortiClientLinux versión 7.2.0, 7.0.6 a 7.0.10 y 7.0.3 a 7.0.4 permite al atacante ejecutar código o comandos no autorizados engañando a un usuario de FortiClientLinux para que visite un sitio web malicioso','https://nvd.nist.gov/vuln/detail/CVE-2023-45590');
-- REGISTRAMOS UNA VULNERABILIDAD Y ASOSIACIAMO EL CVE REGISTRADO ANTERIORMENTE
INSERT INTO vulnerabilities (ticketId,advisories,resume,vendor,cves,urlRef) VALUES 
(4,'FG-IR-23-087','Una vulnerabilidad de Control Inadecuado de Generación de Código ("Inyección de Código") [CWE-94] en FortiClientLinux puede permitir## que un atacante no autenticado ejecute código arbitrario engañando a un usuario de FortiClientLinux para que visite un sitio web malicioso.','FORTINET',1,'https://www.fortiguard.com/psirt/FG-IR-23-087');


-- AGREGAMOS 2 REPORTES PARA PRUEBAS
INSERT INTO reports (id,title,created_by,description) VALUES 
(1,'Escaneo de red',2,'El sensor de PSA y DNIC ha detectado un escaneo de redes, con puerto de destino:\n5900 - (vnc)\n5800 - (vnc-http)\n5432 - (postgres)\n3306 - (mysql)\n1521 - (ncube-lm)\n1521 - (oracle)\n1433 - (ms-sql-s)\n22 - (ssh)\n\nAcción\nSe da aviso a la Comunidad Objetivo.'),
(2,'SQLinjection',1,'Se observa desde FortiSIEM-MINSEG un intento de "Inyección SQL" sobre el portal web de denuncias de MINSEG, intentando inyectar y ejecutar código según anáilis del payload.\nSe informa al Dpartamento de Infraestructura MINSEG fines confirmen estado del indicente, POSITIVO/FLASO POSITIVO.\nSe espera respuesta.'),
(3,'Botnet C&C red 139.45.197.0',2,'Se observó en Analizer-MinSeg una alarma de un endpoint posiblemente infectado relacionado con una IP sospechosa que se reitera en otras Fuerzas.\n
Se informó Seguridad Informátoca MINSEG para bloqueara la IP 139.45.197.251 por el Puerto 443.\nSe trataría de una Botnet C&C que infecta a los endpoints mediante Adware en distintas webs.\n\nAcción\nSe recomendó a Seguridad Informática realizar un bloqueo preventivo sobre la red 139.45.197.0, fines evitar que otros host se sigan infectando y realizar un escaneo con herramientas antimalware en las IP reportadas como comprometidas');


INSERT INTO incidents (ticketId,srcip,dstip,srcport,dstport,report) VALUES
(1,'98.25.125.175','10.103.10.26','55022,55023,55024','22,1433,3306',1),
(2,'45.98.145.125','192.168.1.10',NULL,'80,443',2),
(3,'139.45.197.251','10.103.17.4',NULL,'22,1433,3306',3);


-- -- Calculate and SET tickets.resolution
-- UPDATE tickets SET
--     status = 'CERRADO',
--     lastUpdate = DATETIME(CURRENT_TIMESTAMP, 'localtime')
-- WHERE id = 1;