#!/bin/bash
echo "🔄 Pulling code..."
git pull origin main

echo "🛠 Building app..."
./mvnw clean package -DskipTests

echo "🛑 Stopping old app..."
pkill -f 'java' || true

echo "🚀 Starting new app..."
nohup java -jar target/*.jar > app.log 2>&1 &
