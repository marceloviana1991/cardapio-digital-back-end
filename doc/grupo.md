# Endpoint de Grupos

```
http://localhost:8080/grupo
```

| Método | Body Request     | Body Response | Path Variable | Route            |
|--------|------------------|---------------|---------------|------------------|
| GET    |                  | application/json |            |                  |


```
Resquest
header
{
    "bearer-token": "tokenJwt"
}

body 
{
    
}
```

```
Response
[
    {
        "id": "Long",
        "nome": "String",
        "imagem": "String"
    },
    {
        "id": "Long",
        "nome": "String",
        "imagem": "String"
    }
]
...


