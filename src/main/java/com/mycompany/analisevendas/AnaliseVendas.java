/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.analisevendas;

/**
 *
 * @author CaioBraz
 */
import java.util.Scanner;

public class AnaliseVendas {

    static final int MAX_PRODUTOS = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] id = new int[MAX_PRODUTOS];
        double[] precoCompra = new double[MAX_PRODUTOS];
        int[] quantidadeCompra = new int[MAX_PRODUTOS];
        double[] precoVenda = new double[MAX_PRODUTOS];
        int[] quantidadeVenda = new int[MAX_PRODUTOS];
        double[] balanco = new double[MAX_PRODUTOS];

        int contador = 0;

        // Cadastro dos produtos
        while (contador < MAX_PRODUTOS) {
            System.out.print("Informe o ID do produto (ou -1 para encerrar): ");
            int inputId = scanner.nextInt();
            if (inputId == -1) break;

            id[contador] = inputId;

            System.out.print("Preço de compra: ");
            precoCompra[contador] = scanner.nextDouble();

            System.out.print("Quantidade comprada: ");
            quantidadeCompra[contador] = scanner.nextInt();

            System.out.print("Preço de venda: ");
            precoVenda[contador] = scanner.nextDouble();

            System.out.print("Quantidade vendida: ");
            quantidadeVenda[contador] = scanner.nextInt();

            // Calcula balanço do produto
            balanco[contador] = (precoVenda[contador] * quantidadeVenda[contador]) - (precoCompra[contador] * quantidadeCompra[contador]);

            contador++;
        }

        // Relatório final
        double maiorLucro = Double.NEGATIVE_INFINITY;
        double maiorPrejuizo = Double.POSITIVE_INFINITY;
        int indiceMaisLucrativo = -1;
        int indiceMenosLucrativo = -1;

        System.out.println("\n--- RELATÓRIO FINAL ---");
        for (int i = 0; i < contador; i++) {
            System.out.println("\nID do produto: " + id[i]);
            System.out.println("Balanço financeiro: R$ " + balanco[i]);

            if (balanco[i] > 0) {
                System.out.println("Classificação: Lucrativo");
            } else if (balanco[i] < 0) {
                System.out.println("Classificação: Não lucrativo");
            } else {
                System.out.println("Classificação: Neutro");
            }

            if (balanco[i] > maiorLucro) {
                maiorLucro = balanco[i];
                indiceMaisLucrativo = i;
            }

            if (balanco[i] < maiorPrejuizo) {
                maiorPrejuizo = balanco[i];
                indiceMenosLucrativo = i;
            }
        }

        // Exibe o produto mais lucrativo e o mais deficitário
        if (contador > 0) {
            System.out.println("\nProduto mais lucrativo: ID " + id[indiceMaisLucrativo] + " com lucro de R$ " + maiorLucro);
            System.out.println("Produto mais deficitário: ID " + id[indiceMenosLucrativo] + " com prejuízo de R$ " + maiorPrejuizo);
        }

        scanner.close();
    }
}

