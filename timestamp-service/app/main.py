import sqlite3
import time
from datetime import datetime, timezone

DB_PATH = "/data/timestamps.db"
TABLE_SCHEMA = """
CREATE TABLE IF NOT EXISTS timestamps (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    created_at TEXT NOT NULL
);
"""

def init_db(conn):
    conn.execute(TABLE_SCHEMA)
    conn.commit()

def insert_timestamp(conn):
    now = datetime.now(timezone.utc)
    conn.execute("INSERT INTO timestamps (created_at) VALUES (?)", (now,))
    conn.commit()
    print(f"[{now}] Timestamp inserted")

def run_loop():
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
