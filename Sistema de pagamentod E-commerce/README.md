# Sistema de Folha de Pagamento

Aplicação em Java para cadastrar funcionários, calcular bonificações por cargo e gerar o valor total da folha de pagamento da empresa[cite: 1].


##  Objetivo
Automatizar a gestão de funcionários (Gerentes, Desenvolvedores e Vendedores), aplicando validações como CPF único de 11 dígitos e impedindo salários inválidos[cite: 1].



##  Regras de Bonificação
- **Gerente**: +20% do salário base[cite: 1].
- **Desenvolvedor**: +10% do salário base[cite: 1].
- **Vendedor**: +5% de comissão sobre o total vendido[cite: 1].



##  Conceitos de POO Aplicados
- **Encapsulamento**: Atributos `private` com acessores (*getters*/*setters*) e validação de dados (salário > 0, CPF com 11 dígitos)[cite: 1].
- **Herança**: As classes `Gerente`, `Desenvolvedor` e `Vendedor` herdam de `Funcionario` usando `extends`[cite: 1].
- **Abstração**: A classe `Funcionario` é `abstract` (não pode ser instanciada diretamente) e exige a implementação do método `calcularBonificacao()` nas subclasses[cite: 1].

## Exemplo de execução
Entrada:

|Nome: Ana | CPF: 12345678901 | Salário: 8000 (Gerente)|

|Nome: Carlos | CPF: 98765432100 | Salário: 5000 (Desenvolvedor)|

|Nome: Mariana | CPF: 45678912345 | Salário: 2500 | Vendas: 40000 (Vendedor)|

Saíada:
=== HOLERITE ===
Gerente: Ana | Salário: R$ 8.000,00 | Bônus: R$ 1.600,00 | Total: R$ 9.600,00

=== HOLERITE ===
Desenvolvedor: Carlos | Salário: R$ 5.000,00 | Bônus: R$ 500,00 | Total: R$ 5.500,00

=== HOLERITE ===
Vendedor: Mariana | Salário: R$ 2.500,00 | Bônus: R$ 2.000,00 | Total: R$ 4.500,00

TOTAL DA FOLHA DE PAGAMENTO: R$ 19.600,00
##  Como Executar
1. Acesse a pasta `src/`:
   ```bash
   cd src
2. Compile os arquivos
 ```bash
 javac *.java

