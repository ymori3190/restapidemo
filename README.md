# Spring Boot REST API 学習用デモ

Spring Bootでタスク管理用のREST APIを実装する学習用プロジェクトです。タスクはメモリ上で管理されるため、アプリケーションを再起動すると初期データに戻ります。
初期データとして、Taskを3つメモリに保持しています。

## 使用技術

- Java 17
- Spring Boot 4.2.0-M1
- Maven Wrapper
- Lombok

## 前提条件

- Java 17以降

## 起動方法

```bash
./mvnw spring-boot:run
```

起動後、アプリケーションは `http://localhost:8080` で利用できます。

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
	"id": 4,
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

存在しないIDを指定した場合、取得・更新・削除はいずれも特別なエラーを返さず、取得は `null`、更新・削除は何も行いません。

## プロジェクト構成

- `controller`: HTTPリクエストを受け付ける層
- `service`: メモリ上のタスクの取得・追加を担当する層
- `model`: APIで扱う `Task` データモデル
- `resources/application.properties`: アプリケーション設定

## 参考
・[Spring Bootを使ったREST APIの基本構築から動作確認まで①](https://qiita.com/pomecode/items/dcd2353d1f3b49dc23ff)