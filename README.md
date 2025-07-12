# Timestamp
Servicio Dockerizado en Python que guarda un timestamp cada minuto en una base SQLite. Es modular y listo para escalar como microservicio conectado a un panel web.

# ⏱️ Timestamp Service

Servicio en Python que guarda automáticamente marcas de tiempo (UTC) en una base de datos SQLite cada minuto. Este contenedor es el primer módulo de un sistema que permitirá la gestión de microservicios desde una interfaz web usando Spring Boot.

---

## 🚀 Características

- Inserta timestamps automáticamente cada 60 segundos
- Base de datos persistente en SQLite
- Contenedorizado con Docker para fácil encendido/apagado
- Datos disponibles para consulta y visualización externa

---

---

## 🛠 Requisitos

- Docker
- Docker Compose
- Python (sólo si se prueba fuera del contenedor)

---

## 🧑‍💻 Cómo usar

### 1. Construir la imagen

```bash
docker compose build
```

### 2. Levantar el servicio en segundo plano
```bash
docker compose up -d
```

### 3. Ver registros en tiempo real
```bash
docker compose logs -f timestamp-service
```

### 4. Apagar el servicio
```bash
docker compose down
```