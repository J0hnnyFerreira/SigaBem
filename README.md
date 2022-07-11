# API (Backend) CÁLCULO DE FRETE
Criada para calcular o preço do frete, levando em consieração o cepOrigem, cepDestino e peso da mercadoria. E para consumir uma API externa sendo a [API publica  Códigos de Endereçamento Postal (CEP)](https://viacep.com.br/) para obter o CEP, DDD e UF. Para o desenvolvimento foi utilizado Java 8, Spring Boot, Mongodb.

## Links para requisições na API
- POST: http://localhost:8080/api/frete (Adiciona os dados e retorna o preço do frete)

#### Exemplo de Input

```
{
"nomeDestinatario": "johnny",
"cepOrigem": "06542089",
"cepDestino": "68440000",
"peso": 13.5
}
```

#### Exemplo de Response

```
{
"id": "62cb99dadcefe914958412b7",
"nomeDestinatario": "johnny",
"cepOrigem": "06542089",
"cepDestino": "68440000",
"peso": 13.5,
"vlTotalFrete": 13.5,
"dataPrevistaEntrega": "2022-07-21",
"dataConsulta": "2022-07-11"
}
```
