# 🥟 Baozi Store - API REST

Olá! Bem-vindo(a) ao repositório da **Baozi Store**, o sistema de back-end de uma pequena e charmosa loja especializada na venda de pãezinhos chineses. 🥢

[cite_start]Este projeto foi desenvolvido como requisito para a Atividade Prática da disciplina de Desenvolvimento Web Back-End do Centro Universitário Internacional UNINTER[cite: 1, 4, 5, 11]. [cite_start]O objetivo principal é fornecer uma API REST simples, porém robusta, para gerenciar os clientes, os produtos e os pedidos da loja[cite: 14, 21, 22].

---

## 🚀 O que o sistema faz?

[cite_start]A API permite que o dono da Baozi Store consiga informatizar o seu negócio de forma prática[cite: 22]. Com ela, é possível:
- [cite_start]**Cadastrar e gerenciar clientes** que visitam a loja[cite: 25].
- [cite_start]**Cadastrar e gerenciar produtos** (como o nosso famoso *Baozi Mix Carne*)[cite: 26].
- [cite_start]**Registrar pedidos**, amarrando qual cliente comprou qual produto e a quantidade desejada [cite: 27, 34-37].

[cite_start]Tudo isso seguindo os padrões arquiteturais REST (operações de Criar, Listar, Buscar por ID e Deletar) [cite: 10, 84-89].

---

## 🛠️ Tecnologias Utilizadas

[cite_start]Este projeto foi construído com as melhores e mais modernas práticas do ecossistema Java[cite: 145]. O que tem debaixo do capô:

* [cite_start]**Java 17**: Linguagem de programação robusta e moderna[cite: 12, 145].
* [cite_start]**Spring Boot (3.2.4)**: Framework que facilita e acelera o desenvolvimento da aplicação[cite: 12, 146].
* [cite_start]**Spring Data JPA**: Para a persistência de dados de forma simplificada, sem precisarmos escrever queries SQL manualmente[cite: 12, 147].
* [cite_start]**H2 Database**: Um banco de dados em memória, perfeito para testes rápidos (os dados reiniciam com a aplicação)[cite: 148].
* **Maven**: Gerenciador de dependências e build do projeto.
* [cite_start]**Padrão MVC**: Código estruturado em camadas claras: `Model`, `Repository`, `Service` e `Controller` [cite: 14, 150-154].

---

## ⚙️ Como rodar o projeto na sua máquina?

Se você quiser testar essa API no seu computador, é muito fácil. Siga os passos abaixo:

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU_USUARIO/baozistore.git](https://github.com/SEU_USUARIO/baozistore.git)
