Aqui está seu README formatado, organizado e pronto para copiar e colar no GitHub:

---

# 🍄 Super Mario POO

Um jogo de plataforma 2D inspirado no clássico Super Mario, desenvolvido inteiramente em **Java**.
O projeto foi construído do zero, **sem o uso de motores gráficos prontos** (como Unity ou Godot), com o objetivo de aplicar na prática conceitos fundamentais de **Programação Orientada a Objetos (POO)**.

Este projeto é uma excelente peça de portfólio para a área de **Análise e Desenvolvimento de Sistemas**, demonstrando domínio em:

* Estruturação de código
* Herança
* Interfaces
* Polimorfismo
* Renderização gráfica nativa

---

## 🎮 Funcionalidades

### ⚙️ Física Customizada

Sistema próprio de gravidade, pulos fluidos e detecção de colisão (**AABB**) em dois eixos:

* Horizontal
* Vertical

### 🧩 Entidades e Polimorfismo

Uso de classes abstratas e interfaces (`Coletavel`) para gerenciamento dinâmico de objetos no loop principal.

### 👾 Sistema de Inimigos

* Inteligência artificial básica
* Patrulha automática (Goombas)
* Reação a limites do cenário e obstáculos

### 🍄 Power-ups e Coletáveis

* **Moedas:** aumentam o score
* **Cogumelos:** alteram estado/tamanho do jogador

### 💾 Persistência de Dados

* Salvamento automático do **High Score**
* Uso de arquivos `.txt` para armazenamento local

### 🖼️ Fallback Gráfico

Sistema que renderiza formas geométricas caso os *sprites* não sejam encontrados.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 11 ou superior recomendado)
* **Interface Gráfica (GUI):** Java AWT e Swing

  * `JFrame`
  * `JPanel`
  * `Graphics2D`
* **Áudio:** `javax.sound.sampled`
* **Arquitetura:** Organização em pacotes (MVC-like)

  * `modelo`
  * `controle`
  * `telas`
  * `persistencia`

---

## 🚀 Como executar o projeto no IntelliJ IDEA

### 1. Pré-requisitos

* Ter o **Java Development Kit (JDK)** instalado (versão 11 ou superior)

### 2. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 3. Abrir no IntelliJ

* Abra o IntelliJ IDEA
* Clique em **"Open"**
* Selecione a pasta do projeto

### 4. Configurar o JDK

* Vá em **File > Project Structure > Project**
* Selecione o JDK instalado

### 5. Executar o projeto

* Localize a classe principal (`Main`)
* Clique com o botão direito → **Run**

---

## 📌 Observações

* Certifique-se de que os arquivos de imagem (*sprites*) estejam corretamente posicionados no projeto.
* Caso não estejam, o sistema utilizará o **fallback gráfico automaticamente**.

---

Se quiser, posso deixar esse README ainda mais profissional (com GIF do jogo, badges, estrutura de pastas ou seção de screenshots).
