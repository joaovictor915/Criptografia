import java.util.*;
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class tp4 {

    // Cifra de Transposição Simples por Colunas
    public static String cifrarTransposicao(String texto, int chave) {
        texto = texto.replaceAll(" ", ""); // Remove espaços
        int coluna = chave;
        int linha = (int) Math.ceil((double) texto.length() / coluna);
        char[][] grade = new char[linha][coluna];
        StringBuilder cifrado = new StringBuilder();

        // Preenche a grade linha por linha
        int k = 0;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (k < texto.length()) {
                    grade[i][j] = texto.charAt(k++);
                } else {
                    grade[i][j] = '-'; // Caracter de preenchimento
                }
            }
        }

        // Lê a grade coluna por coluna
        for (int j = 0; j < coluna; j++) {
            for (int i = 0; i < linha; i++) {
                cifrado.append(grade[i][j]);
            }
        }

        return cifrado.toString();
    }

    public static String decifrarTransposicao(String textoCifrado, int chave) {
        int coluna = chave;
        int linha = (int) Math.ceil((double) textoCifrado.length() / coluna);
        char[][] grade = new char[linha][coluna];
        StringBuilder decifrado = new StringBuilder();

        // Preenche a grade coluna por coluna
        int k = 0;
        for (int j = 0; j < coluna; j++) {
            for (int i = 0; i < linha; i++) {
                if (k < textoCifrado.length()) {
                    grade[i][j] = textoCifrado.charAt(k++);
                }
            }
        }

        // Lê a grade linha por linha
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (grade[i][j] != '-') {
                    decifrado.append(grade[i][j]);
                }
            }
        }

        return decifrado.toString();
    }

    // Criptografia Moderna - RSA
    public static KeyPair gerarParDeChavesRSA() throws Exception {
        KeyPairGenerator geradorChaves = KeyPairGenerator.getInstance("RSA");
        geradorChaves.initialize(2048);
        return geradorChaves.generateKeyPair();
    }

    public static String cifrarRSA(String dados, PublicKey chavePublica) throws Exception {
        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.ENCRYPT_MODE, chavePublica);
        byte[] dadosCifrados = cifra.doFinal(dados.getBytes());
        return Base64.getEncoder().encodeToString(dadosCifrados);
    }

    public static String decifrarRSA(String dadosCifrados, PrivateKey chavePrivada) throws Exception {
        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.DECRYPT_MODE, chavePrivada);
        byte[] dadosDecifrados = cifra.doFinal(Base64.getDecoder().decode(dadosCifrados));
        return new String(dadosDecifrados);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Bem-vindo ao programa de criptografia!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cifra de Transposição por Colunas");
            System.out.println("2. Criptografia RSA");
            System.out.print("Sua escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (escolha == 1) {
                // Cifra de Transposição
                System.out.print("Digite o texto para cifrar: ");
                String texto = scanner.nextLine();
                System.out.print("Digite a chave (número de colunas): ");
                int chave = scanner.nextInt();

                String textoCifrado = cifrarTransposicao(texto, chave);
                System.out.println("Texto cifrado: " + textoCifrado);

                System.out.println("Deseja decifrar o texto cifrado? (s/n): ");
                char resposta = scanner.next().charAt(0);
                if (resposta == 's' || resposta == 'S') {
                    String textoDecifrado = decifrarTransposicao(textoCifrado, chave);
                    System.out.println("Texto decifrado: " + textoDecifrado);
                }

            } else if (escolha == 2) {
                // Criptografia RSA
                System.out.print("Digite a mensagem para cifrar: ");
                String mensagem = scanner.nextLine();

                KeyPair parDeChaves = gerarParDeChavesRSA();
                String mensagemCifrada = cifrarRSA(mensagem, parDeChaves.getPublic());
                System.out.println("Mensagem cifrada (RSA): " + mensagemCifrada);

                System.out.println("Deseja decifrar a mensagem cifrada? (s/n): ");
                char resposta = scanner.next().charAt(0);
                if (resposta == 's' || resposta == 'S') {
                    String mensagemDecifrada = decifrarRSA(mensagemCifrada, parDeChaves.getPrivate());
                    System.out.println("Mensagem decifrada: " + mensagemDecifrada);
                }

            } else {
                System.out.println("Opção inválida. Por favor, reinicie o programa.");
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
