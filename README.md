# Football Manager - Sistema de Gestão de Seleções ⚽

Aplicação desktop em **Java (Swing)** para cadastro, edição, exclusão e listagem de
**Jogadores**, **Seleções** e **Técnicos**, com persistência dos dados em arquivos de texto.

O projeto foi desenvolvido como estudo de **Programação Orientada a Objetos (POO)** aplicada
a um sistema CRUD completo, com interface gráfica feita no NetBeans GUI Builder.

---

## 📖 Sobre o projeto

O sistema simula o gerenciamento de dados de uma competição de futebol, permitindo:

- Cadastrar, editar, excluir e listar **Jogadores** (nome, posição, número da camisa, altura,
  peso, seleção a que pertence, etc.);
- Cadastrar, editar, excluir e listar **Seleções** (nome, continente, ranking FIFA, quantidade
  de títulos, técnico responsável);
- Cadastrar, editar, excluir e listar **Técnicos** (nome, nacionalidade, estilo tático);
- Persistir todas essas informações em arquivos `.txt`, simulando um banco de dados simples.

---

## 🗂️ Estrutura do projeto

```
meu-projeto/
└── src/
    └── projeto/
        ├── Main.java                     # Ponto de entrada da aplicação
        │
        ├── Pessoa.java                   # Classe abstrata (base de Jogador e Tecnico)
        ├── Jogador.java                  # Modelo - Jogador (herda de Pessoa)
        ├── Tecnico.java                  # Modelo - Técnico (herda de Pessoa)
        ├── Selecao.java                  # Modelo - Seleção
        │
        ├── Crud.java                     # Interface genérica (contrato CRUD)
        ├── JogadorService.java           # Regras de negócio + persistência de Jogadores
        ├── SelecaoService.java           # Regras de negócio + persistência de Seleções
        ├── TecnicoService.java           # Regras de negócio + persistência de Técnicos
        ├── ValidacaoException.java       # Exceção customizada de validação
        │
        ├── Tela_Jogadores.java/.form         # Tela principal - listagem de Jogadores
        ├── Tela_Jogador_Cadastro.java/.form  # Tela de cadastro de Jogador
        ├── Editar_Jogadores.java/.form       # Tela de edição de Jogador
        ├── Editar_Jogadores_Final.java/.form # Confirmação de edição de Jogador
        ├── Excluir_Jogadores.java/.form      # Tela de exclusão de Jogador
        ├── Excluir_Jogadores_Final.java/.form# Confirmação de exclusão de Jogador
        │
        ├── Tela_Selecao.java/.form           # Tela principal - listagem de Seleções
        ├── Tela_Selecao_Cadastro.java/.form  # Tela de cadastro de Seleção
        ├── Editar_Selecao.java/.form         # Tela de edição de Seleção
        ├── Editar_Selecao_Final.java/.form   # Confirmação de edição de Seleção
        ├── Excluir_Selecao.java/.form        # Tela de exclusão de Seleção
        ├── Excluir_Selecao_Final.java/.form  # Confirmação de exclusão de Seleção
        │
        ├── Tela_Tecnicos.java/.form          # Tela principal - listagem de Técnicos
        ├── Tela_Tecnico_Cadastro.java/.form  # Tela de cadastro de Técnico
        ├── Editar_Tecnico.java/.form         # Tela de edição de Técnico
        ├── Editar_Tecnico_Final.java/.form   # Confirmação de edição de Técnico
        ├── Excluir_Tecnico.java/.form        # Tela de exclusão de Técnico
        └── Excluir_Tecnico_Final.java/.form  # Confirmação de exclusão de Técnico
```

> Os arquivos `.form` são os layouts das telas gerados pelo **NetBeans GUI Builder** (Swing);
> cada `.form` acompanha um `.java` de mesmo nome, que contém o código da respectiva tela.

---

## 💡 Conceitos de Java aplicados

- **Abstração**
  `Pessoa` é uma classe abstrata que define atributos e comportamentos comuns (nome,
  nacionalidade, idade, `exibirInfo()`), que são especializados pelas subclasses.

- **Herança**
  `Jogador` e `Tecnico` **estendem** `Pessoa`, reaproveitando seus atributos/métodos e
  adicionando características próprias (posição e camisa para o Jogador; estilo tático para
  o Técnico).

- **Polimorfismo**
  Sobrescrita (`@Override`) do método `exibirInfo()` em `Jogador` e `Tecnico`, cada um
  exibindo suas informações de forma diferente. Sobrescrita também do método `toString()`
  em todos os modelos.

- **Interfaces e Generics**
  A interface `Crud<T>` define um contrato genérico (`cadastrar`, `listar`, `buscar`,
  `excluir`) que é implementado por `JogadorService`, `SelecaoService` e `TecnicoService`,
  cada um trabalhando com seu respectivo tipo (`Crud<Jogador>`, `Crud<Selecao>`,
  `Crud<Tecnico>`).

- **Encapsulamento**
  Atributos das classes de modelo controlados através de construtores e métodos, evitando
  acesso direto e inconsistente aos dados.

- **Tratamento de exceções**
  Uso de `try/catch` espalhado pelas camadas de serviço e interface, além de uma exceção
  **customizada** (`ValidacaoException`) para validações específicas de regras de negócio.

- **Coleções (Collections Framework)**
  Uso extensivo de `ArrayList<T>` para armazenar e manipular listas de jogadores, seleções e
  técnicos em memória.

- **Manipulação de arquivos (I/O)**
  Leitura e escrita de dados usando `BufferedReader`, `BufferedWriter`, `FileReader` e
  `FileWriter`, com persistência em arquivos `.txt` (simulando um banco de dados simples).

- **Composição entre objetos**
  Um `Jogador` possui uma `Selecao`, e uma `Selecao` possui um `Tecnico` — relações "tem um"
  (has-a) entre as classes de modelo.

- **Interface gráfica (Swing / Event-Driven Programming)**
  Telas construídas com `javax.swing`, utilizando o modelo de programação orientada a
  eventos (`ActionListener`, botões, tabelas e formulários) através do NetBeans GUI Builder.

- **Arquitetura em camadas**
  Separação entre **Modelo** (`Pessoa`, `Jogador`, `Tecnico`, `Selecao`), **Serviço/regra de
  negócio** (`JogadorService`, `SelecaoService`, `TecnicoService`) e **Interface gráfica**
  (classes `Tela_*`), aproximando-se do padrão em camadas usado em aplicações reais.

---

## 🛠️ Tecnologias

- **Java** (Swing para interface gráfica)
- **NetBeans GUI Builder** (geração dos arquivos `.form`)
- Persistência em arquivos de texto (`.txt`)
