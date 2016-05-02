/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import control.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;

/**
 *
 * @author Igor
 */
public class Console {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int sair =0;
        do{
            //for(short i=0; i<20; i++) System.out.println("\n");
            System.out.println("   Selecione o módulo  [Organizar depois o Menu] ");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionário- ManterCliente");        
            System.out.println("3. Gerente- ManterFuncionario");
            System.out.println("4. Gerente- ManterMesa");
            System.out.println("5. Funcionario- ManterItem");
            String menuPrincipal = scanner.nextLine();
            scanner.reset();
            switch( menuPrincipal )
            {
                case "1": 
                    clienteCardapio();
                    break;
                case "2": 
                    ManterCliente manterCliente = new ManterCliente();
                    manterCliente.console_load();
                    break;
                case "3":
                    ManterFuncionario manterFuncionario = new ManterFuncionario();
                    manterFuncionario.console_load();
                    break;
                case "4":
                    ManterMesa manterMesa = new ManterMesa();
                    manterMesa.console_load();
                    break;
                case "5":
                    ManterItem manterItem = new ManterItem();
                    manterItem.console_load();
                    break;
                default: sair = -1;
            }
        
        }while(sair == 0);
    }
    
    public static void clienteCardapio() throws IOException{
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        CardapioDao cardapioDao = new CardapioDao();
        cardapio = cardapioDao.abrirCardapio();
        
        //for(short i=0; i<20; i++) System.out.println("\n"); //limpar tela (bizarro, mas não achei coisa melhor).
        System.out.println("   Cardápio   ");
        for(Item item: cardapio.getListItem()){
            System.out.printf("%d. %s ..... R$ %.2f\n",item.getIdItem(), item.getNome(), item.getValor());
        }
        short menuCardapio = scanner.nextShort();
        scanner.nextLine();
    }

}
