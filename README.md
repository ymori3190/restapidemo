# Spring Boot REST API 学習用デモ

Spring Bootでタスク管理用のREST APIを実装する学習用プロジェクトです。タスクはPostgreSQLに保存し、Spring Data JPAでCRUD操作を行います。

## 使用技術

- Java 17
- Spring Boot 4.2.0-M1
- Maven Wrapper
- Lombok
- PostgreSQL 16
- Spring Data JPA

## 前提条件

- Java 17以降
- Docker Desktop（PostgreSQLをDockerで起動する場合）

## 開発用DBに関する注意

このプロジェクトのPostgreSQL設定と認証情報は、cloneした人がすぐに動作確認できるように用意したローカル開発・検証専用のものです。

- 本番環境や共有環境では使用しないでください
- 実際の個人情報・機密情報・重要なデータは保存しないでください
- DBのポートは`localhost`からのみ接続できるようにしています
- 公開されている認証情報のため、セキュリティ用途のパスワードとして扱わないでください

## 起動方法

1. PostgreSQLを起動します。

	```bash
	docker compose up -d
	```

	`docker-compose.yml`の設定により、`taskdb`データベースが`localhost:5432`で起動します。

2. Spring Bootアプリケーションを起動します。

	```bash
	./mvnw spring-boot:run
	```

起動後、アプリケーションは `http://localhost:8080` で利用できます。
データベースを停止する場合は、次のコマンドを実行します。

```bash
docker compose down
```

データボリュームも削除して初期化する場合は、`-v`を付けます。

```bash
docker compose down -v
```

動作確認用のルートエンドポイントは次のとおりです。

```http
GET http://localhost:8080/
```

レスポンス:

```text
Hello, World!
```

## API

タスクのJSON形式は次のとおりです。

```json
{
	"id": 1,
	"title": "タスク名",
	"description": "タスクの説明"
}
```

`id`はPostgreSQLの自動採番です。レスポンスのJSONには`id`が含まれますが、タスク作成時のリクエストでは指定しません。

### タスク一覧を取得

```http
GET http://localhost:8080/tasks
```

### タスクを1件取得

```http
GET http://localhost:8080/tasks/{id}
```

### タスクを追加

```http
POST http://localhost:8080/tasks
Content-Type: application/json

{
	"title": "新しいタスク",
	"description": "タスクの説明"
}
```

### タスクを更新

```http
PUT http://localhost:8080/tasks/{id}
Content-Type: application/json

{
	"title": "更新後のタスク名",
	"description": "更新後の説明"
}
```

### タスクを削除

```http
DELETE http://localhost:8080/tasks/{id}
```

## プロジェクト構成

- `controller`: HTTPリクエストを受け付ける層
- `service`: タスク操作のユースケースを担当する層
- `repository`: Spring Data JPAによるデータアクセス層
- `entity`: データベースの`tasks`テーブルに対応する`Task`エンティティ
- `resources/application.properties`: PostgreSQLとJPAの設定

## テスト

```bash
./mvnw test
```

## 参考
- [Spring Bootを使ったREST APIの基本構築から動作確認まで①](https://qiita.com/pomecode/items/dcd2353d1f3b49dc23ff)