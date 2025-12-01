-- ============================================
-- USUARIOS (2 usuarios con password: $prueba123)
-- ============================================
-- Password: "$prueba123" encriptado con BCrypt
-- Generado con: https://www.bcryptcalculator.com/
INSERT INTO users (name, email, password, role, phone, avatar, active, created_at) VALUES
(
  'Cliente Demo',
  'cliente@demo.com',
  '$2a$10$7VzLqB.5NpQN2qY6w8kZLuGfKJ9hM1rX2sT3uV4w5x6y7z8A9b0C1d2E3f4G5h6I',
  'CUSTOMER',
  '+541100000001',
  'customer.jpg',
  true,
  CURRENT_TIMESTAMP
),
(
  'Administrador Sistema',
  'admin@demo.com',
  '$2a$10$7VzLqB.5NpQN2qY6w8kZLuGfKJ9hM1rX2sT3uV4w5x6y7z8A9b0C1d2E3f4G5h6I',
  'ADMIN',
  '+541100000002',
  'admin.jpg',
  true,
  CURRENT_TIMESTAMP
);

-- ============================================
-- PRODUCTOS - CATEGORIA: ELECTRODOMESTICOS (4 productos)
-- ============================================
INSERT INTO products (title, price, description, category, image, stock, created_at) VALUES
(
  'Aspiradora Robot Inteligente',
  149990.00,
  'Aspiradora robot con navegacion inteligente, mapeo de habitaciones, control por app',
  'Electrodomesticos',
  'aspiradora-robot.jpg',
  12,
  CURRENT_TIMESTAMP
),
(
  'Tostadora 4 Ranuras Digital',
  45990.00,
  'Tostadora 4 ranuras con control digital, 7 niveles de tostado, funcion descongelar',
  'Electrodomesticos',
  'tostadora-digital.jpg',
  25,
  CURRENT_TIMESTAMP
),
(
  'Cafetera Automatica Express',
  89990.00,
  'Cafetera automatica para cafe espresso y capuccino, sistema de espuma de leche',
  'Electrodomesticos',
  'cafetera-express.jpg',
  18,
  CURRENT_TIMESTAMP
),
(
  'Plancha a Vapor Profesional',
  34990.00,
  'Plancha a vapor 2400W, suela de ceramica, sistema anti-calc, chorro de vapor vertical',
  'Electrodomesticos',
  'plancha-vapor.jpg',
  30,
  CURRENT_TIMESTAMP
);

-- ============================================
-- PRODUCTOS - CATEGORIA: DEPORTES (4 productos)
-- ============================================
INSERT INTO products (title, price, description, category, image, stock, created_at) VALUES
(
  'Pelota de Futbol Oficial',
  29990.00,
  'Pelota de futbol tamano 5, material PU resistente, valvula de latex, peso oficial',
  'Deportes',
  'pelota-futbol.jpg',
  40,
  CURRENT_TIMESTAMP
),
(
  'Pelota de Baloncesto Profesional',
  24990.00,
  'Pelota de baloncesto tamano 7, material de cuero composite, buen grip en todas las condiciones',
  'Deportes',
  'pelota-basket.jpg',
  35,
  CURRENT_TIMESTAMP
),
(
  'Set de Pesas Ajustables 20kg',
  89990.00,
  'Set de 2 pesas ajustables de 1 a 10kg cada una, sistema de cambio rapido, agarre ergonomico',
  'Deportes',
  'pesas-ajustables.jpg',
  20,
  CURRENT_TIMESTAMP
),
(
  'Raqueta de Padel Profesional',
  129990.00,
  'Raqueta de padel carbono 3K, forma redonda, balance medio, incluye funda y overgrip',
  'Deportes',
  'raqueta-padel.jpg',
  15,
  CURRENT_TIMESTAMP
);

-- ============================================
-- PRODUCTOS - CATEGORIA: HOGAR (4 productos)
-- ============================================
INSERT INTO products (title, price, description, category, image, stock, created_at) VALUES
(
  'Alfombra de Entrada Home',
  15990.00,
  'Alfombra para entrada 60x90cm, material poliester, diseño moderno, antideslizante',
  'Hogar',
  'alfombra-entrada.jpg',
  50,
  CURRENT_TIMESTAMP
),
(
  'Jarra de Agua con Filtro',
  12990.00,
  'Jarra de agua 2.5L con filtro purificador, elimina cloro e impurezas, material BPA free',
  'Hogar',
  'jarra-agua.jpg',
  28,
  CURRENT_TIMESTAMP
),
(
  'Juego de Sabanas Algodon 200 Hilos',
  34990.00,
  'Juego de sabanas 1.5 plazas, algodon 200 hilos, incluye sabana bajera y 2 fundas',
  'Hogar',
  'juego-sabanas.jpg',
  42,
  CURRENT_TIMESTAMP
),
(
  'Florero de Vidrio Moderno',
  8990.00,
  'Florero de vidrio transparente 25cm, diseño moderno minimalista, ideal para rosas o decoracion',
  'Hogar',
  'florero-vidrio.jpg',
  60,
  CURRENT_TIMESTAMP
);