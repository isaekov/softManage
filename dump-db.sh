#!/bin/bash

# 📋 Настройки
CONTAINER_NAME="postgres"
DB_USER="${POSTGRES_USER:-user}"
DB_NAME="${POSTGRES_DB:-soft}"
DUMP_DIR="./postgres/init"
DUMP_FILE="$DUMP_DIR/dump.sql"

# 🛡 Создаём папку если нет
mkdir -p "$DUMP_DIR"

# 📦 Делаем дамп
echo "🔄 Создание дампа базы данных..."

docker exec -t "$CONTAINER_NAME" pg_dumpall -c -U "$DB_USER" > "$DUMP_FILE"

# ✅ Проверка
if [ $? -eq 0 ]; then
    SIZE=$(du -h "$DUMP_FILE" | cut -f1)
    echo "✅ Дамп успешно создан: $DUMP_FILE ($SIZE)"
    echo ""
    echo "📊 Статистика:"
    echo "   Строк в файле: $(wc -l < "$DUMP_FILE")"
    echo "   Размер: $SIZE"
else
    echo "❌ Ошибка при создании дампа!"
    exit 1
fi