-- ============================================
-- USUARIOS (2 usuarios con password: $prueba123)
-- ============================================
-- Password: "$prueba123" encriptado con BCrypt
-- Generado con: https://www.bcryptcalculator.com/
INSERT INTO users (name, email, password, role, phone, avatar, active, created_at) VALUES
(
  'Cliente Demo',
  'cliente@demo.com',
  '$2a$10$2Z5FQ4NvLb8e7wR9xYzABCDEfGhIjKlMnOpQrStUvWXyZaBcDeFgH',
  'CUSTOMER',
  '+541100000001',
  'https://images.unsplash.com/photo-1494790108755-2616b612b786?auto=format&fit=crop&w=200&q=80', -- Avatar cliente
  true,
  CURRENT_TIMESTAMP
),
(
  'Administrador Sistema',
  'admin@demo.com',
  '$2a$10$2Z5FQ4NvLb8e7wR9xYzABCDEfGhIjKlMnOpQrStUvWXyZaBcDeFgH',
  'ADMIN',
  '+541100000002',
  'https://images.unsplash.com/photo-1560250097-0b93528c311a?auto=format&fit=crop&w=200&q=80', -- Avatar admin
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
  'https://images.unsplash.com/photo-1558618666-fcd25c85cd64?auto=format&fit=crop&w=600&q=80', -- Aspiradora robot
  12,
  CURRENT_TIMESTAMP
),
(
  'Tostadora 4 Ranuras Digital',
  45990.00,
  'Tostadora 4 ranuras con control digital, 7 niveles de tostado, funcion descongelar',
  'Electrodomesticos',
  'https://images.unsplash.com/photo-1572442388796-11668a67e53d?auto=format&fit=crop&w=600&q=80', -- Tostadora
  25,
  CURRENT_TIMESTAMP
),
(
  'Cafetera Automatica Express',
  89990.00,
  'Cafetera automatica para cafe espresso y capuccino, sistema de espuma de leche',
  'Electrodomesticos',
  'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?auto=format&fit=crop&w=600&q=80', -- Cafetera
  18,
  CURRENT_TIMESTAMP
),
(
  'Plancha a Vapor Profesional',
  34990.00,
  'Plancha a vapor 2400W, suela de ceramica, sistema anti-calc, chorro de vapor vertical',
  'Electrodomesticos',
  'https://images.unsplash.com/photo-1581235720864-1d5e12c9c0a4?auto=format&fit=crop&w=600&q=80', -- Plancha
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
  'https://images.unsplash.com/photo-1575361204480-aadea25e6e68?auto=format&fit=crop&w=600&q=80', -- Pelota futbol
  40,
  CURRENT_TIMESTAMP
),
(
  'Pelota de Baloncesto Profesional',
  24990.00,
  'Pelota de baloncesto tamano 7, material de cuero composite, buen grip en todas las condiciones',
  'Deportes',
  'https://images.unsplash.com/photo-1546519638-68e109498ffc?auto=format&fit=crop&w=600&q=80', -- Pelota basket
  35,
  CURRENT_TIMESTAMP
),
(
  'Set de Pesas Ajustables 20kg',
  89990.00,
  'Set de 2 pesas ajustables de 1 a 10kg cada una, sistema de cambio rapido, agarre ergonomico',
  'Deportes',
  'https://images.unsplash.com/photo-1534367507877-0edd93bd013b?auto=format&fit=crop&w=600&q=80', -- Pesas
  20,
  CURRENT_TIMESTAMP
),
(
  'Raqueta de Padel Profesional',
  129990.00,
  'Raqueta de padel carbono 3K, forma redonda, balance medio, incluye funda y overgrip',
  'Deportes',
  'https://images.unsplash.com/photo-1595435934247-5d33b7f92c70?auto=format&fit=crop&w=600&q=80', -- Raqueta padel
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
  'https://images.unsplash.com/photo-1556228578-9c360e1d8d34?auto=format&fit=crop&w=600&q=80', -- Alfombra
  50,
  CURRENT_TIMESTAMP
),
(
  'Jarra de Agua con Filtro',
  12990.00,
  'Jarra de agua 2.5L con filtro purificador, elimina cloro e impurezas, material BPA free',
  'Hogar',
  'https://images.unsplash.com/photo-1558617999-3c4034e1af17?auto=format&fit=crop&w=600&q=80', -- Jarra agua
  28,
  CURRENT_TIMESTAMP
),
(
  'Juego de Sabanas Algodon 200 Hilos',
  34990.00,
  'Juego de sabanas 1.5 plazas, algodon 200 hilos, incluye sabana bajera y 2 fundas',
  'Hogar',
  'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?auto=format&fit=crop&w=600&q=80', -- Sabanas
  42,
  CURRENT_TIMESTAMP
),
(
  'Florero de Vidrio Moderno',
  8990.00,
  'Florero de vidrio transparente 25cm, diseño moderno minimalista, ideal para rosas o decoracion',
  'Hogar',
  'https://images.unsplash.com/photo-1585320806297-9794b3e4eeae?auto=format&fit=crop&w=600&q=80', -- Florero
  60,
  CURRENT_TIMESTAMP
);