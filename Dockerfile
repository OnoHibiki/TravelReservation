# OpenJDK 21をベースイメージとして使用
FROM openjdk:21-jdk

# 作業ディレクトリを作成
WORKDIR /app

# JARファイルをコピー
COPY target/reservation-0.0.1-SNAPSHOT.jar app.jar

# ポート設定 (Render の Web サービス用)
EXPOSE 5000

# Spring Boot アプリを実行
CMD ["java", "-jar", "app.jar"]


