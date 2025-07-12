# Usamos imagen oficial de Python ligera
FROM python:3.11-slim

# Directorio de trabajo
WORKDIR /app

# Copiamos código
COPY app/requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY app/main.py .

# Creamos carpeta para la base de datos
RUN mkdir /data
VOLUME ["/data"]

# Comando por defecto
CMD ["python", "main.py"]
