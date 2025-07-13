# Timestamp
Servicio Dockerizado en Python que guarda un timestamp cada minuto en una base SQLite. Es modular y listo para escalar como microservicio conectado a un panel web.

# ⏱️ Timestamp Service

Sistema modular que registra y gestiona marcas de tiempo, compuesto por un servicio Python para la recolección de datos y una API REST en Spring Boot para su consulta.

## 🚀 Características

- **Servicio de Recolección (Python)**
  - Inserta timestamps UTC automáticamente cada 60 segundos
  - Base de datos persistente en SQLite
  - Contenedorizado con Docker
  - Funcionamiento autónomo en segundo plano

- **API REST (Spring Boot)**
  - Endpoints para consulta de timestamps
  - Arquitectura en capas (Controller-Service-Repository)
  - Acceso a la misma base de datos SQLite
  - Documentación JavaDoc completa

## 🛠 Requisitos

- Docker y Docker Compose
- Java 17+ (para desarrollo de la API)
- Python 3.x (para desarrollo del servicio)

## 🏗️ Estructura del Proyecto

```
timestamp/
├── spring-collector/      # API REST en Spring Boot
│   └── src/              # Código fuente de la API
├── timestamp-service/     # Servicio Python
│   └── app/              # Código fuente del recolector
└── data/                 # Volumen persistente para SQLite
```

## 🧑‍💻 Instrucciones de Uso

### 1. Construir los servicios
```bash
docker compose build
```

### 2. Levantar todo el sistema
```bash
docker compose up -d
```

### 3. Monitorear los servicios

Ver logs del servicio Python:
```bash
docker compose logs -f timestamp-service
```

Ver logs de la API Spring:
```bash
docker compose logs -f spring-api
```

### 4. Usar la API REST

- Listar todos los timestamps:
  ```
  GET http://localhost:8080/timestamps
  ```

### 4. Acceder a la interfaz web

Visitar en el navegador:
```
http://localhost:8080
```

La interfaz web muestra:
- Lista de todos los timestamps registrados
- Actualización automática de la página cada minuto

### 5. Detener los servicios
```bash
docker compose down
```

## 📝 Notas Técnicas

- La base de datos SQLite se almacena en `/data/timestamps.db`
- El servicio Python registra timestamps cada minuto en UTC
- La API Spring Boot expone los datos en formato JSON
- Ambos servicios comparten la misma base de datos

## 🔄 Flujo de Datos

1. El servicio Python registra timestamps automáticamente
2. Los datos se almacenan en SQLite
3. La API Spring Boot permite consultar estos registros
4. Los clientes pueden acceder a los datos vía HTTP

## 🛡️ Consideraciones

- Los servicios están configurados para reinicio automático
- Los datos persisten entre reinicios gracias al volumen Docker
- Zona horaria UTC para consistencia temporal