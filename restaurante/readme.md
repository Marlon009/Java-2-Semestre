# Sistema de Pedidos em Restaurante

O sistema foi desenvolvido pelo seguinte grupo:

- [Gabriel Dutra](https://github.com/DutraGames)
- [Luccas Lohan](https://github.com/gohan-exe)
- [Denis Gales](https://github.com/DenisGalesNeves)

O **Bom Prato** é um sistema de pedidos de restaurante desenvolvido para otimizar e simplificar o processo de pedidos e entregas para clientes e funcionários. Com uma interface intuitiva e amigável, os clientes podem fazer pedidos. Por outro lado, os funcionários do restaurante têm acesso a uma interface de gerenciamento robusta, onde podem monitorar os pedidos.

## Tecnologias Utilizadas

### **BackEnd**

- **mysql-connector-java**

  - **GroupID:** mysql
  - **ArtifactID:** mysql-connector-java

- **spring-boot-starter-web**

  - **GroupID:** org.springframework.boot
  - **ArtifactID:** spring-boot-starter-web

- **spring-boot-devtools**

  - **GroupID:** org.springframework.boot
  - **ArtifactID:** spring-boot-devtools
  - **Scope:** runtime
  - **Optional:** true

- **lombok**

  - **GroupID:** org.projectlombok
  - **ArtifactID:** lombok
  - **spring-boot-starter-test**
    - **GroupID:** org.springframework.boot
    - **ArtifactID:** spring-boot-starter-test
    - **Scope:** test
  - **spring-boot-starter-data-jpa**
    - **GroupID:** org.springframework.boot
    - **ArtifactID:** spring-boot-starter-data-jpa
  - **springdoc-openapi-starter-webmvc-ui**
    - **GroupID:** org.springdoc
    - **ArtifactID:** springdoc-openapi-starter-webmvc-ui

### **FrontEnd**

- **@hookform/resolvers**
- **@tanstack/react-query**
- **axios**
- **class-variance-authority**
- **clsx**
- **react**
- **react-dom**
- **react-hook-form**
- **sonner**
- **tailwind-merge**
- **tailwindcss-animate**
- **use-mask-input**
- **zod**
- **ShadUI**

## Regras de Negócio

- O pedido só pode ser calculado se houver pelo menos um item no pedido.
- A remoção de itens só é permitida se houver mais de um item no pedido.
- A reserva de mesa só pode ser feita para pedidos com itens.

## Requisitos Funcionais

- Cadastro de Pratos:
  - O sistema deve permitir o cadastro de pratos com nome, preço e detalhes.
- Realizar Pedido:
  - Os clientes devem ser capazes de criar pedidos, adicionando itens ao pedido.
- Calcular Total do Pedido:
  - O sistema deve calcular o valor total do pedido, incluindo o preço de todos os itens e a taxa de entrega.
- Adicionar e Remover Itens:
  - Os clientes podem adicionar e remover itens do pedido.
- Reservar Mesa:
  - Os clientes podem reservar uma mesa ao fazer um pedido.

## Casos de Uso

- Cadastrar Prato:
  - Ator: Administrador
  - Fluxo:
    - O administrador insere os detalhes do prato.
    - O sistema valida e armazena as informações.
- Fazer Pedido:
  - Ator: Cliente
  - Fluxo:
    - O cliente seleciona os pratos desejados.
    - O sistema cria um pedido associado ao cliente.
- Calcular Total do Pedido:
  - Ator: Cliente
  - Fluxo:
    - O cliente solicita o cálculo do valor total do pedido.
    - O sistema realiza o cálculo considerando itens e taxa de entrega.
- Adicionar Item ao Pedido:
  - Ator: Cliente
  - Fluxo:
    - O cliente adiciona um item ao pedido.
    - O sistema atualiza o pedido.
- Remover Item do Pedido:
  - Ator: Cliente
  - Fluxo:
    - O cliente remove um item do pedido.
    - O sistema atualiza o pedido se houver mais de um item.
- Reservar Mesa:
  - Ator: Cliente
  - Fluxo:
    - O cliente reserva uma mesa ao fazer o pedido.
    - O sistema associa a reserva ao pedido realizado.
