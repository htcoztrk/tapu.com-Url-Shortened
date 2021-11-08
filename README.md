## tapu.com-Url-Shortened


Auction-shortened-url projesi, kullanıcılar arasında paylaşılan, sistemden kullanıcılara gönderilen email/sms/push notification gibi farklı kanallarda kullanılabilmek üzere url kısaltma işlemi yapıyor. 

### Teknolojiler
- Java
- Spring Boot
- PostgreSql
- Spring Data JPA 
- JUnit
- Spring Validation
- Lombok
- Swagger
---------------------------------------------------
```bash
 http://localhost:8080/swagger-ui.html
``` 
adresine giderek swagger ile oluşturulmuş olan dokümantasyona ulaşabiliriz.


  


  


  
## API Kullanımı

####  Kullanıcı Listesini getirir.

```http
  GET /user/getall
```

####  Kullanıcı öğesini getirir.

```http
  GET /user/getbyid/{id}
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | Çağrılacak öğenin id'si |

####  Kullanıcı kaydeder.

```http
  POST /user/signup
```
| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | Kullanıcı Adı |
| `password` | `string` | Kullanıcı şifresi |


#### Url Listesini getir

```http
  GET /api/url/getall
```
#### Url Öğesini getirir.
```http
  GET /api/url/get/{id}
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | Çağrılacak öğenin id'si |

#### Girilen kısaltılmış Url'e ait orjinal Url'i döndürür.

```http
  GET /api/{shortenedurl}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `shortenedurl`      | `string` | Kısaltılmış Url |

#### Kullanıcıya ait Url listesini döndürür.

```http
  GET /api/url/getbyuserid/{id}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Kullanıcı Id'si |

#### Url Ekleme.

```http
  POST /api/user/{id}/url/create
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Kullanıcı Id'si |
| `longUrl`      | `String` | Orjinal Url |

#### Url Update.

```http
  PUT /api/url/update
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Url Id'si |
| `longUrl`      | `String` | Orjinal Url |

#### Url Delete.

```http
  DELETE /api/url/delete
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | Url Id'si |





  

  
