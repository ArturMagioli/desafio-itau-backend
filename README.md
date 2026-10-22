
# Desafio backend ITAU

O projeto é uma API REST responsável em gerenciar transações e calcular as suas estatístias nos últimos 60 segundos. API desenvolvida com Java e Spring Boot

![Badge](https://img.shields.io/badge/status-finalizado-green?style=for-the-badge)

## Variáveis de ambiente

Para rodar esse projeto, você precisa de:
* Java: JDK 25 ou superior;
* MAVEN: 4.0.0 ou superior;
* GIT para clonar o repositório.




## Instalação
```
git clone https://github.com/ArturMagioli/desafio-itau-backend

mvn clean install

mvn spring-boot:run
```

## API Reference

#### Obter todas as transações

```http
  GET /transacao
```

| Descrição                |
:------------------------- |
| Retorna todas as transações registradas |

#### Cadastrar transação

```http
  POST /transacao
```

| Parâmetro | Tipo     | Descrição                       |
| :-------- | :------- | :-------------------------------- |
| `valor`      | `BigDecimal` | valor da transação |
| 'dataHora' | `OffsetDateTime` | instante da transação |


#### Calcular estatísticas

```http
  GET /estatistica
```

#### Limpar transações

```http
  DELETE /estatistica
```

