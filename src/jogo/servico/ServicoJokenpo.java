package jogo.servico;

import jogo.constantes.ConstantesJokenpo;
import jogo.jogadores.Computador;
import jogo.jogadores.Usuario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServicoJokenpo {

    private String resposta;

    private Usuario usuario = new Usuario();

    private Computador computador = new Computador();

    private String opcaoUsuario = "";

    private int computadorEscolha;

    private int usuarioEscolha;

    private int pontosUsuario;

    private int pontosComputador;

    public void regrasJokenpo(){
        System.out.println(ConstantesJokenpo.REGRA_EXPLICAO);
    }

    public void jogarJogo(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println(ConstantesJokenpo.INICIA_JOGO);
        resposta = sc1.next().toLowerCase();
        if (resposta.equals("s")){
            iniciaJogoJokenpo();
        }
        else {
            System.out.println(ConstantesJokenpo.RECUSA_JOGO);
        }

    }

    public void iniciaJogoJokenpo(){
        while (!resposta.equals("n")){
            int nuRodadas = 1;
            pontosComputador = 0;
            pontosUsuario = 0;
            while (nuRodadas <= 3){
                Scanner sc1 = new Scanner(System.in);

                System.out.println(ConstantesJokenpo.ESCOLHA_USUARIO);

                opcaoUsuario = sc1.next();

                validaCampo(opcaoUsuario);

                Integer transforma = Integer.parseInt(opcaoUsuario);

                usuario.setUsuario(transforma - 1);

                sortComputadorEscolha();

                mostraEscolhas();

                computadorEscolha = computador.getComputador();

                usuarioEscolha = usuario.getUsuario();

                defineGanhadorRodada(usuarioEscolha, computadorEscolha);

                nuRodadas ++;
            }

            defineCampeao(pontosUsuario,pontosComputador);

            jogarJogo();


        }

    }

    public String validaCampo(String opcao){
        while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")){
            System.out.println(ConstantesJokenpo.ESCOLHA_INVALIDA );
            Scanner sc1 = new Scanner(System.in);
            opcao = sc1.next();
        }
        opcaoUsuario = opcao;
        return opcaoUsuario;
    }

    public Integer sortComputadorEscolha(){
        Random geraAleatorio = new Random();
        Integer numeroComputador = geraAleatorio.nextInt(2);
        computador.setComputador(numeroComputador);
        return numeroComputador;
    }

    public String mostraEscolhas(){
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(ConstantesJokenpo.PEDRA);
        opcoes.add(ConstantesJokenpo.TESOURA);
        opcoes.add(ConstantesJokenpo.PAPEL);

        String escolhaComputador = opcoes.get(computador.getComputador());
        String escolhaUsuario = opcoes.get(usuario.getUsuario());
        String escolhas = (ConstantesJokenpo.OPCAO_ESCOLHIDA_USUARIO + escolhaUsuario + "\n"
                + ConstantesJokenpo.OPCAO_ESCOLHIDA_COMPUTADOR + escolhaComputador );
        System.out.println(escolhas);

        return escolhas;
    }

    public boolean defineGanhadorRodada(int usuarioEscolha, int computadorEscolha){
        if (usuarioEscolha == computadorEscolha){
            System.out.println(ConstantesJokenpo.EMPATE);
            return false;
        }
        else {
            if ((usuarioEscolha + computadorEscolha) % 2 == 0 ){
                if (usuarioEscolha > computadorEscolha){
                    System.out.println(ConstantesJokenpo.VENCEDOR_RODADA);
                    pontosUsuario++;
                }
                else {
                    System.out.println(ConstantesJokenpo.PERDEDOR_RODADA);
                    pontosComputador++;
                }
            }

            if ((usuarioEscolha + computadorEscolha) % 2 == 1){
                if (usuarioEscolha < computadorEscolha){
                    System.out.println(ConstantesJokenpo.VENCEDOR_RODADA);
                    pontosUsuario++;
                    return true;
                }
                else{
                    System.out.println(ConstantesJokenpo.PERDEDOR_RODADA);
                    pontosComputador++;
                }
            }
        }
        return true;
    }

    public boolean defineCampeao(int pontosUsuario, int pontosComputador) {
        System.out.println(ConstantesJokenpo.PONTOS_COMPUTADOR + pontosComputador + "\n" +
                ConstantesJokenpo.PONTOS_USUARIO + pontosUsuario + "\n");
        if (pontosUsuario == pontosComputador){
            System.out.println(ConstantesJokenpo.EMPATE_JOGO);
            return true;
        }

        if (pontosUsuario > pontosComputador) {
            System.out.println(ConstantesJokenpo.VENCEDOR_JOGO);
            return true;
        }
        else {
            System.out.println(ConstantesJokenpo.PERDEDOR_JOGO);
            return false;
        }

    }

}
