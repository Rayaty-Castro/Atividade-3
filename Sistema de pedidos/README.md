#  Sistema de Pedidos e Entregas - Vende Mais

Este projeto em Java calcula automaticamente o frete, prazo e valor total dos pedidos da rede **Vende Mais**, sem o uso de vários `if/else` espalhados pelo código (eu patircularmente acho meio feio).

---

##  Regras das Modalidades de Entrega

* **Entrega Normal:** R$ 5,00 por kg | **Prazo:** 7 dias.
* **Entrega Expressa:** R$ 10,00 por kg + R$ 7,50 | **Prazo:** 2 dias.
* **Retirada na Loja:** Grátis (R$ 0,00) | **Prazo:** Impartida/Pronta entrega (0 dias).
* **Entrega Agendada:** R$ 8,00 por kg + R$ 15,00 | **Prazo:** Dias até a data escolhida.

---

##  Cálculo do Valor Total

$$\text{Total} = \text{Valor dos Produtos} + \text{Frete}$$

O cálculo é automático: o pedido pega o preço dos produtos e soma com o frete específico da modalidade escolhida.

---

##  Comparação das Entregas

Para um pedido de **R$ 1.000,00** com **5 kg**:

| Modalidade | Custo do Frete | Prazo | Total do Pedido |
| :--- | :--- | :--- | :--- |
| **Entrega Normal** | R\$ 25,00 | 7 dias | R\$ 1.025,00 |
| **Entrega Expressa** | R\$ 57,50 | 2 dias | R\$ 1.057,50 |
| **Retirada na Loja** | R\$ 0,00 | 0 dias | R\$ 1.000,00 |
| **Entrega Agendada** *(5 dias)* | R\$ 55,00 | 5 dias | R\$ 1.055,00 |

---

##  Composição (Pedido + Entrega)

A classe `Pedido` **tem uma** `Entrega` vinculada a ela. 

O `Pedido` não precisa saber como o frete de cada modalidade é calculado. Ele apenas chama a entrega associada para fazer o cálculo. Um pedido **nunca** pode ser criado sem definir uma modalidade de entrega.

---

##  Conceitos de POO Aplicados

* **Abstração:** Criada a classe abstrata `Entrega`, que define o modelo padrão que toda modalidade deve ter (`calcularFrete` e `calcularPrazo`).
* **Herança:** As modalidades (`EntregaNormal`, `EntregaExpressa`, etc.) herdam os dados básicos da classe `Entrega`.
* **Encapsulamento:** Atributos são protegidos (`private`) e validados ao cadastrar (ex: o nome do cliente só aceita letras e o peso deve ser maior que zero).

---

## Como Executar

1. Abra o terminal na pasta do projeto.
2. Compile os arquivos Java:
   ```bash
   javac -d bin src/*.java
