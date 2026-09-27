````markdown
# 🐾 Café Patinhas

Sistema em Java para gerenciamento de uma cafeteria temática e pet-friendly, desenvolvido como projeto acadêmico em grupo para a disciplina de Programação Orientada a Objetos (POO).

O Café Patinhas tem como proposta unir o funcionamento de uma cafeteria com um espaço voltado para a interação e adoção de animais. Dessa forma, o sistema permite realizar o gerenciamento de clientes, funcionários, mesas, pedidos, produtos, pagamentos e animais disponíveis para adoção.

---

## 📌 Sobre o Projeto

O projeto foi desenvolvido em grupo com o objetivo de aplicar na prática os principais conceitos de Programação Orientada a Objetos utilizando Java.

O sistema simula o funcionamento do Café Patinhas, permitindo que os funcionários realizem diferentes operações relacionadas ao atendimento da cafeteria e ao gerenciamento dos animais disponíveis para adoção.

Entre as principais funcionalidades estão:

- Cadastro e gerenciamento de clientes;
- Cadastro e gerenciamento de funcionários;
- Cadastro de mesas;
- Cadastro de comidas e bebidas;
- Criação e consulta de pedidos;
- Cálculo do valor dos pedidos;
- Realização de pagamentos;
- Cadastro e consulta de animais;
- Controle do status dos animais;
- Registro de adoções;
- Consulta de animais disponíveis e já adotados.

---

## 🎯 Objetivos

### Objetivo Geral

Desenvolver um sistema em Java para simular o gerenciamento de uma cafeteria pet-friendly, aplicando conceitos de Programação Orientada a Objetos.

### Objetivos Específicos

- Aplicar conceitos de classes e objetos;
- Utilizar herança e polimorfismo;
- Trabalhar com interfaces;
- Organizar o sistema utilizando o padrão MVC;
- Desenvolver operações de cadastro, consulta, atualização e exclusão;
- Simular o gerenciamento de pedidos e pagamentos;
- Implementar o controle de animais disponíveis para adoção.

---

## ☕ Funcionalidades

### 👤 Clientes

O sistema permite cadastrar, listar, atualizar e excluir clientes.

Cada cliente possui informações como:

- ID;
- Nome;
- Telefone;
- Pontos de fidelidade.

---

### 🧑‍💼 Funcionários

É possível cadastrar e listar os funcionários do Café Patinhas.

Cada funcionário possui:

- ID;
- Nome;
- Telefone;
- Cargo.

Os funcionários também são utilizados durante o processo de pagamento de um pedido.

---

### 🪑 Mesas

O sistema permite cadastrar mesas para utilização durante os pedidos.

Cada mesa possui um número e pode ter seu estado controlado para indicar se está ocupada.

Ao cadastrar um pedido, o sistema verifica se a mesa existe e se ela já está ocupada.

---

### 🧁 Comidas

O sistema permite cadastrar os alimentos disponíveis na cafeteria.

Cada comida possui:

- Nome;
- Preço;
- Ingredientes;
- Informação sobre presença de glúten.

---

### ☕ Bebidas

O sistema também permite cadastrar as bebidas disponíveis na cafeteria.

Cada bebida possui:

- Nome;
- Preço;
- Tipo;
- Tamanho;
- Informação se é gelada.

---

### 🧾 Pedidos

O sistema permite criar e listar pedidos.

Cada pedido pode estar associado a:

- Um ID;
- Uma mesa;
- Uma comida;
- Uma bebida.

Durante o cadastro do pedido, o sistema verifica se a mesa existe e se ela está disponível.

Após a criação do pedido, a mesa passa a ser considerada ocupada.

O sistema também calcula e exibe o valor total do pedido com base nos produtos selecionados.

---

### 💳 Pagamentos

O sistema permite realizar o pagamento de pedidos em aberto.

Durante o processo de pagamento, o sistema:

1. Localiza o pedido pelo ID;
2. Calcula o valor total;
3. Identifica o funcionário responsável;
4. Permite selecionar a forma de pagamento;
5. Exibe as informações do pagamento.

---

### 🐾 Pets e Adoção

Uma das principais características do Café Patinhas é o gerenciamento dos animais disponíveis para adoção.

O sistema permite:

- Cadastrar pets;
- Consultar pets;
- Verificar o status de um pet;
- Listar pets disponíveis;
- Listar pets adotados;
- Remover pets;
- Registrar uma adoção.

Para realizar uma adoção, o sistema relaciona um cliente a um pet disponível. Após a adoção, o status do animal é alterado para adotado.

---

## 🏗️ Estrutura do Projeto

O projeto foi organizado utilizando uma estrutura baseada no padrão MVC (Model-View-Controller).

### 📦 Model

Contém as classes responsáveis por representar os dados e entidades do sistema.

Entre elas estão:

- `Cliente`
- `Funcionario`
- `Comida`
- `Bebida`
- `Pedido`
- `Pet`
- `Adocao`
- `Pagamento`

Também são utilizadas relações de herança entre algumas classes, como:

```text
Pessoa
├── Cliente
└── Funcionario
````

e:

```text
Produto
├── Comida
└── Bebida
```

---

### 🎮 Controller

Contém as classes responsáveis por controlar as funcionalidades do sistema e intermediar a interação entre as entidades e as telas.

Principais controllers:

* `ClienteController`
* `FuncionarioController`
* `PedidoController`
* `PagamentoController`
* `PetController`

---

### 🖥️ View

Contém as classes responsáveis pela interação com o usuário através do terminal.

As Views exibem os menus, recebem as informações digitadas pelo usuário e apresentam as mensagens do sistema.

---

### ▶️ Main

A classe `Main` é responsável por inicializar os componentes do sistema e apresentar o menu principal do Café Patinhas.

O menu principal possui as seguintes opções:

```text
====================================
     🐾 CAFÉ PATINHAS - SISTEMA 🐾
====================================
 | [1] Gerenciar Clientes
 | [2] Gerenciar Pedidos, Mesas, Comidas e Bebidas
 | [3] Menu de Adoção e Pets
 | [4] Realizar Pagamento de um Pedido
 | [5] Gerenciar Funcionários
 | [0] Sair do Sistema
```

---

## 🧩 Conceitos de POO Utilizados

Durante o desenvolvimento do projeto foram aplicados diferentes conceitos de Programação Orientada a Objetos.

### Herança

A herança foi utilizada para reaproveitar características entre classes.

Exemplos:

```text
Pessoa
├── Cliente
└── Funcionario
```

```text
Produto
├── Comida
└── Bebida
```

---

### Encapsulamento

Os atributos das classes são protegidos por meio de modificadores de acesso e métodos `get` e `set`, permitindo controlar o acesso e a alteração dos dados.

---

### Interface

O projeto possui a interface `Adotavel`, utilizada para definir comportamentos relacionados à adoção de animais.

A interface possui os métodos:

```java
void realizarAdocao();
boolean estaAdotado();
```

---

### MVC

O projeto utiliza uma organização baseada no padrão MVC:

```text
Model
  ↓
Controller
  ↓
View
```

Essa organização ajuda a separar as responsabilidades do sistema e facilita sua manutenção e compreensão.

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

Para executar o projeto, é necessário ter:

* Java JDK instalado;
* Uma IDE compatível com Java, como IntelliJ IDEA, Eclipse ou Visual Studio Code.

### Executando

1. Clone este repositório ou faça o download do projeto;
2. Abra o projeto na sua IDE;
3. Certifique-se de que o Java JDK está configurado;
4. Localize a classe `Main`;
5. Execute o método `main()`.

Após a execução, o menu principal do Café Patinhas será exibido no terminal.

---

## 📚 Referências

* Documentação oficial da linguagem Java;
* Materiais e conteúdos disponibilizados durante as aulas de Programação Orientada a Objetos;
* Materiais de apoio utilizados pelo grupo durante o desenvolvimento.

---

## 👥 Integrantes

* Ana Júlia Nicolack
* Isabela Quintilhano Benthin
* Nataly Barão de Paula
* Stephany Ramina Leite

---

## 🎓 Projeto Acadêmico

Projeto desenvolvido em grupo para a disciplina de **Programação Orientada a Objetos**, utilizando a linguagem **Java**.

🐾 **Café Patinhas — Onde um café pode se transformar em um novo lar!**


