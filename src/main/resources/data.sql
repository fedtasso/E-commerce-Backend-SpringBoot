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
  'https://plus.unsplash.com/premium_photo-1729006559482-d289e4385b1e?q=80&w=1112&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  12,
  CURRENT_TIMESTAMP
),
(
  'Tostadora 2 Ranuras',
  45990.00,
  'Tostadora 2 ranuras, 7 niveles de tostado, funcion descongelar',
  'Electrodomesticos',
  'https://plus.unsplash.com/premium_photo-1667238579781-cb4bd6126ffd?q=80&w=711&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  25,
  CURRENT_TIMESTAMP
),
(
  'Cafetera Automatica Express',
  89990.00,
  'Cafetera automatica para cafe espresso y capuccino, sistema de espuma de leche',
  'Electrodomesticos',
  'https://images.unsplash.com/photo-1637029436347-e33bf98a5412?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  18,
  CURRENT_TIMESTAMP
),
(
  'Plancha a Vapor Profesional',
  34990.00,
  'Plancha a vapor 2400W, suela de ceramica, sistema anti-calc, chorro de vapor vertical',
  'Electrodomesticos',
  'https://images.unsplash.com/photo-1662221156544-3355c817ed74?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
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
  'https://images.unsplash.com/photo-1660926655800-3d11219f390d?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  40,
  CURRENT_TIMESTAMP
),
(
  'Pelota de Baloncesto Profesional',
  24990.00,
  'Pelota de baloncesto tamano 7, material de cuero composite, buen grip en todas las condiciones',
  'Deportes',
  'https://images.unsplash.com/photo-1650566924908-db62de4863af?q=80&w=1071&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  35,
  CURRENT_TIMESTAMP
),
(
  'Pesa de 20kg',
  89990.00,
  'Set de 2 pesas de 20 kg cada una, agarre ergonomico',
  'Deportes',
  'https://images.unsplash.com/photo-1725289767222-3444016c70ce?q=80&w=1228&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  20,
  CURRENT_TIMESTAMP
),
(
  'Raqueta de Padel Profesional',
  129990.00,
  'Raqueta de padel carbono 3K, forma redonda, balance medio, incluye funda y overgrip',
  'Deportes',
  'https://images.unsplash.com/photo-1728034262202-0c3badbc3fcb?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
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
  'https://images.unsplash.com/photo-1660997598847-bdad1ad226c7?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  50,
  CURRENT_TIMESTAMP
),
(
  'Jarra de Agua con Filtro',
  12990.00,
  'Jarra de agua 2.5L con filtro purificador, elimina cloro e impurezas, material BPA free',
  'Hogar',
  'https://images.unsplash.com/photo-1743187360373-513ac4a7266f?q=80&w=792&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  28,
  CURRENT_TIMESTAMP
),
(
  'Juego de Sabanas Algodon 200 Hilos',
  34990.00,
  'Juego de sabanas 1.5 plazas, algodon 200 hilos, incluye sabana bajera y 2 fundas',
  'Hogar',
  'https://images.unsplash.com/photo-1663247135608-594dd5e69b32?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  42,
  CURRENT_TIMESTAMP
),
(
  'Florero de Porcelana Moderno',
  8990.00,
  'Florero de porcelana, diseño moderno minimalista, ideal para rosas o decoracion',
  'Hogar',
  'https://plus.unsplash.com/premium_photo-1677178629911-fe334bfd4ade?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
  60,
  CURRENT_TIMESTAMP
);