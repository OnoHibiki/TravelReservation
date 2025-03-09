# OpenJDK 21 の公式イメージを使用
FROM maven:3.9.6-eclipse-temurin-21 AS build

# 作業ディレクトリを設定
WORKDIR /app

# 依存関係をキャッシュするために pom.xml だけコピー
COPY pom.xml .

# 依存関係を事前ダウンロード（キャッシュを有効活用）
RUN mvn dependency:go-offline

# ソースコードをコピー
COPY . .

# Maven でアプリをビルド（JAR を作成）
RUN mvn clean package -DskipTests

# ========================
# 実行環境の設定
# ========================
FROM openjdk:21-jdk

WORKDIR /app

# ビルド済みの JAR ファイルをコピー
COPY --from=build /app/target/reservation-0.0.1-SNAPSHOT.jar app.jar

# アプリケーションを実行
CMD ["java", "-jar", "app.jar"]
