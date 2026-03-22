# 🥟 Baozi Store - API REST

Olá! Bem-vindo(a) ao repositório da **Baozi Store**, o sistema de back-end de uma pequena e charmosa loja especializada na venda de pãezinhos chineses. 🥢

Este projeto foi desenvolvido como requisito para a Atividade Prática da disciplina de Desenvolvimento Web Back-End do Centro Universitário Internacional UNINTER. O objetivo principal é fornecer uma API REST simples, porém robusta, para gerenciar os clientes, os produtos e os pedidos da loja.

---

## 🚀 O que o sistema faz?

A API permite que o dono da Baozi Store consiga informatizar o seu negócio de forma prática. Com ela, é possível:
- **Cadastrar e gerenciar clientes** que visitam a loja.
- **Cadastrar e gerenciar produtos** (como o nosso famoso *Baozi Mix Carne*).
- **Registrar pedidos**, amarrando qual cliente comprou qual produto e a quantidade desejada.

Tudo isso seguindo os padrões arquiteturais REST (operações de Criar, Listar, Buscar por ID e Deletar).

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as melhores e mais modernas práticas do ecossistema Java. O que tem debaixo do capô:

* **Java 17**: Linguagem de programação robusta e moderna.
* **Spring Boot (3.2.4)**: Framework que facilita e acelera o desenvolvimento da aplicação.
* **Spring Data JPA**: Para a persistência de dados de forma simplificada, sem precisarmos escrever queries SQL manualmente.
* **H2 Database**: Um banco de dados em memória, perfeito para testes rápidos (os dados reiniciam com a aplicação).
* **Maven**: Gerenciador de dependências e build do projeto.
* **Padrão MVC**: Código estruturado em camadas claras: `Model`, `Repository`, `Service` e `Controller`.

---

## ⚙️ Como rodar o projeto na sua máquina?

Se você quiser testar essa API no seu computador, é muito fácil. Siga os passos abaixo:

1. **Clone o repositório:**

git clone https://github.com/psydreamz/TrabalhoDesenvolvimentoWeb.git
