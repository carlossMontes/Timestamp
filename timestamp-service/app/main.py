import sqlite3
import time
from datetime import datetime, timezone

# Ruta al archivo de base de datos SQLite
DB_PATH = "/data/timestamps.db"

# Esquema de la tabla para almacenar los timestamps
# Crea la tabla si no existe con un id autoincremental y la fecha de creación
TABLE_SCHEMA = """
CREATE TABLE IF NOT EXISTS timestamps (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    created_at TEXT NOT NULL
);
"""

def init_db(conn):
    """
    Inicializa la base de datos creando la tabla si no existe
    Args:
        conn: Conexión a la base de datos SQLite
    """
    conn.execute(TABLE_SCHEMA)
    conn.commit()

def insert_timestamp(conn):
    """
    Inserta un nuevo timestamp en la base de datos con la hora UTC actual
    Args:
        conn: Conexión a la base de datos SQLite
    """
    now = datetime.now(timezone.utc)
    conn.execute("INSERT INTO timestamps (created_at) VALUES (?)", (now,))
    conn.commit()
    print(f"[{now}] Timestamp inserted")

def run_loop():
    """
    Función principal que ejecuta el bucle infinito del servicio
    Crea una conexión a la base de datos y registra timestamps cada minuto
    Se puede interrumpir con Ctrl+C
    """
    conn = sqlite3.connect(DB_PATH, check_same_thread=False)
    init_db(conn)
    try:
        while True:
            insert_timestamp(conn)
            time.sleep(60)   # Espera un minuto
    except KeyboardInterrupt:
        print("Stopping service...")
    finally:
        conn.close()

if __name__ == "__main__":
    run_loop()
