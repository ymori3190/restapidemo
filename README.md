# Spring Boot REST API 学習用デモ

Spring Bootを使ってREST APIを実装する方法を学習するためのデモプロジェクトです。

## 使用技術

- Java 17
- Spring Boot 4.2.0-M1
- Maven

## 起動方法

```bash
cd demo
./mvnw spring-boot:run
```

アプリケーション起動後、`http://localhost:8080`でアクセスできます。

## API

### タスク一覧を取得

```http
GET http://localhost:8080/tasks
```

## プロジェクト構成

- `controller`: HTTPリクエストを受け付ける層
- `service`: ビジネスロジックを担当する層
- `model`: APIで扱うデータモデル
