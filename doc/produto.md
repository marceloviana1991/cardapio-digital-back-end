# Endpoint de Produtos

```
http://localhost:8080/produto
```

| Método | Body Request     | Body Response | Path Variable | Route            |
|--------|------------------|---------------|---------------|------------------|
| GET    |                  | application/json |   integer         |                  |


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
        "descrição": "String"
        "valor": "double",
        "idGrupo": "Long"
    },
    {
        "id": "Long",
        "nome": "String",
        "descrição": "String"
        "valor": "double",
        "idGrupo": "Long"
    }
]
...


