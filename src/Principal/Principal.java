package Principal;

import entidades.ContaEmpresarial;
import entidades.ContaPessoaFisica;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Date data = new Date();
        Double valorSaque, valorDep, convertido;
        String tipo, titular, cpf, empresa, cnpj, opc = null, opc3;
        int opc2;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        List<ContaPessoaFisica> listaPf = new ArrayList<>();
        List<ContaEmpresarial> listaCe = new ArrayList<>();

        ContaPessoaFisica pf = new ContaPessoaFisica();
        ContaEmpresarial ce = new ContaEmpresarial();
        
        System.out.println("=============================================================");
        System.out.println("               Seja Bem Vindo ao Gringotes");
        System.out.println("=============================================================");

        System.out.println("Selecione o tipo de Conta: PF- Pessoa Física | E- Empresarial");
        tipo = sc.next();
        pf.setTipo(tipo);
        if (tipo.equals("PF") || tipo.equals("pf")) {
            pf.setTipo("Pessoa Física");
            System.out.println("Digite seu nome: ");
            titular = sc.next();
            pf.setTitular(titular);
            System.out.println("Informe seu CPF: ");
            cpf = sc.next();
            pf.setCpf(cpf);
            pf.setSaldo(150.0);
            pf.setNumConta(random.nextInt(1000));
            pf.setStatus("Ativa");
            System.out.println("Conta aberta com sucesso!");
            listaPf.add(pf);
            pf.estadoAtual();
            
            while (opc != "n" || opc != "N"){
                System.out.println("");
                System.out.println("Deseja realizar alguma operação? S/N");
                opc = sc.next();
                if (opc.equals("s") || opc.equals("S")){
                    System.out.println("Selecione: 1- Sacar | 2- Depositar | 3- Comprar Cambio | 4- Fechar Conta");
                    opc2 = sc.nextInt();
                    switch(opc2){
                        case 1:
                            System.out.println("Digite o valor a ser sacado");
                            valorSaque = sc.nextDouble();
                            pf.sacar(valorSaque);
                            break;
                        case 2:
                            System.out.println("Valor a ser depositado ");
                            valorDep = sc.nextDouble();
                            pf.depositar(valorDep);
                            break;
                        case 3:
                            System.out.println("Informe o valor a ser comprado R$");
                            convertido = sc.nextDouble();
                            pf.converterMoeda(convertido);
                            break;
                        case 4:
                            System.out.println("Tem certeza que deseja fechar sua conta? ");
                            opc3 = sc.next();
                            if (opc3.equals("S") || opc3.equals("s")){
                                pf.setStatus("Inativa");
                                pf.deletarConta(pf.getStatus());
                            }
                        default:
                            System.out.println("Opção Inválida");
                    }
                }
                System.out.println("Volte sempre!");
                break;
            }
        } else if (tipo.equals("E") || tipo.equals("e")) {
            ce.setStatus("Ativa");
            ce.setTipo("Empresarial");
            System.out.println("Digite o nome da empresa: ");
            empresa = sc.next();
            ce.setEmpresa(empresa);
            System.out.println("Informe o CNPJ: ");
            cnpj = sc.next();
            ce.setCnpj(cnpj);
            ce.setSaldo(100.0);
            ce.setNumConta(random.nextInt(1000));
            System.out.println("Conta aberta com sucesso!");
            listaCe.add(ce);
            ce.estadoAtual();
            
            while(!"N".equals(opc) || !"n".equals(opc)){
                System.out.println("");
                System.out.println("Deseja realizar alguma operação? S/N");
                opc = sc.next();
                if (opc.equals("s") || opc.equals("S")){
                    System.out.println("Selecione: 1- Sacar | 2- Depositar | 3- Comprar Cambio | 4- Fechar Conta");
                    opc2 = sc.nextInt();
                    switch(opc2){
                        case 1:
                            System.out.println("Digite o valor a ser sacado");
                            valorSaque = sc.nextDouble();
                            ce.sacar(valorSaque);
                            break;
                        case 2:
                            System.out.println("Valor a ser depositado ");
                            valorDep = sc.nextDouble();
                            ce.depositar(valorDep);
                            break;
                        case 3:
                            System.out.println("Valor a ser convertido ");
                            convertido = sc.nextDouble();
                            ce.converterMoeda(convertido);
                            break;
                        case 4:
                            System.out.println("Tem certeza que deseja fechar sua conta? ");
                            opc3 = sc.next();
                            if (opc3.equals("S") || opc3.equals("s")){
                                ce.setStatus("Inativa");
                                ce.deletarConta(ce.getStatus());
                            }
                        default:
                            System.out.println("Opção Inválida");
                        }
                }
                System.out.println("Volte Sempre!");
                break;
            }
        } else {
            System.out.println("Opção Inválida");
        }
        sc.close();
        System.out.println(data);
    }
}
   
