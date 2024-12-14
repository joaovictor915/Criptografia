# Algoritmo de Criptografia - Cifra de Transposição e RSA

## Objetivo
Este projeto tem como objetivo fornecer uma implementação prática e interativa de dois métodos de criptografia:

1. **Cifra de Transposição por Colunas:** Uma técnica clássica de reorganização de caracteres com base em uma chave numérica.
2. **RSA:** Um algoritmo assimétrico amplamente utilizado para proteção de dados sensíveis.

Através deste código, buscamos promover a educação em segurança da informação e conscientizar sobre a importância da criptografia no mundo digital.

## O que o algoritmo faz
Este programa:

- Permite cifrar e decifrar mensagens usando a técnica de Transposição por Colunas.
- Implementa a criptografia RSA para cifrar e decifrar mensagens usando um par de chaves pública e privada.
- Possibilita a interação com o usuário, solicitando inputs para o texto a ser cifrado e a chave necessária.

## Desenvolvedores
- Pedro Henrique Siman
- João Victor Martins

## Requisitos
Para executar este programa, você precisará de:

- **Java Development Kit (JDK)** versão 8 ou superior.
- Um ambiente de desenvolvimento como IntelliJ IDEA, Eclipse, ou apenas o terminal.

## Como utilizar o algoritmo

### Passo 1: Clonar o repositório
Clone este repositório para o seu ambiente local utilizando o comando:
```bash
git clone <URL-do-repositório>
```

### Passo 2: Compilar o código
1. Navegue até o diretório do projeto.
2. Compile o arquivo `tp4.java` com o seguinte comando:
```bash
javac tp4.java
```

### Passo 3: Executar o programa
Execute o programa com o comando:
```bash
java tp4
```

### Passo 4: Interação com o programa
Siga as instruções exibidas no terminal:

1. Escolha o método de criptografia (Transposição ou RSA).
2. Insira a mensagem a ser cifrada.
3. Forneça a chave ou parâmetros solicitados.
4. Visualize a mensagem cifrada e, se desejar, realize o processo de decifragem.

## Exemplo de Uso
### Cifra de Transposição:
- **Entrada:**
  - Mensagem: `HELLO WORLD`
  - Chave: `5`
- **Saída:**
  - Texto Cifrado: `HOLELWRDLO`
  - Texto Decifrado: `HELLOWORLD`

### RSA:
- **Entrada:**
  - Mensagem: `Esta é uma mensagem secreta`
- **Saída:**
  - Mensagem Cifrada: `Base64String`
  - Mensagem Decifrada: `Esta é uma mensagem secreta`

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença
Este projeto é disponibilizado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

## Contato
Para dúvidas ou sugestões, entre em contato com os desenvolvedores:

- **Pedro Henrique Siman**: pedro.siman@exemplo.com
- **João Victor Martins**: joao.martins@exemplo.com
