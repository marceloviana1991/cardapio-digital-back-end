# Endpoint de Pedidos

```
http://localhost:8080/pedido
```

| Método | Body Request     | Body Response | Path Variable | Route            |
|--------|------------------|---------------|---------------|------------------|
| POST    |    application/json    |  |          |                  |


```
Resquest
header
{
    "bearer-token": "tokenJwt"
}

body 
{
    "quantidade": "integer",
    "idProduto": "Long"
}
```



