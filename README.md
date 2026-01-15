# 💉 Gerenciador de Cartão de Vacina

Um sistema simples em **Java** via linha de comando (CLI) para o gerenciamento de pacientes e controle de aplicação de vacinas. O projeto simula um cartão de vacinação digital, permitindo cadastro, aplicação e visualização do histórico de imunização.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido para auxiliar no controle de vacinas aplicadas em pacientes. Ele utiliza estruturas de dados básicas (Arrays e ArrayLists) para armazenar as informações em tempo de execução e oferece um menu interativo para o usuário.

O sistema já vem pré-carregado com vacinas comuns (Covid-19, Tétano, Influenza, etc.), mas permite a inclusão de novas vacinas dinamicamente.

## ✨ Funcionalidades

* **Cadastrar Paciente:** Registro de Nome, Data de Nascimento e CPF (com validação de formato via Regex).
* **Aplicar Vacina:** Vincula uma vacina a um paciente existente, registrando a data da aplicação.
* **Listar Vacinas:** Exibe o catálogo de vacinas disponíveis e permite o cadastro de novas vacinas.
* **Atualizar Cadastro:** Permite corrigir dados (Nome, Data de Nascimento ou CPF) de um paciente.
* **Cartão de Vacina:** Gera um relatório listando todos os pacientes e seus respectivos históricos de vacinação.
* **Validação de CPF:** Garante que o CPF seja inserido no formato correto (`XXX.XXX.XXX-XX`).

## 🚀 Tecnologias Utilizadas

* **Java (JDK 8+)**
* Biblioteca `java.util.Scanner` (Entrada de dados)
* Biblioteca `java.util.ArrayList` (Listas dinâmicas)
* Biblioteca `java.time` (Manipulação de datas com `LocalDate`)
* Biblioteca `java.util.regex` (Validação de padrões)

## 📂 Estrutura do Projeto

O código está organizado no pacote `CartaoDeVacina`.

```text
/SeuProjeto
  └── /CartaoDeVacina
       └── GerenciadorDeVacina.java
