package jogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServicoJokenpo {

    private String resposta;

    private Jogador jogador = new Jogador();

    private int pontosUsuario = 0;

    private int pontosComputador = 0;

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
            while (nuRodadas <= 3){
                Scanner sc1 = new Scanner(System.in);
                System.out.println(ConstantesJokenpo.ESCOLHA_USUARIO);
                String usuario = sc1.next();
                while ( !usuario.equals("1") && !usuario.equals("2") && !usuario.equals("3")){
                    System.out.println(ConstantesJokenpo.ESCOLHA_INVALIDA );
                    usuario = sc1.next();
                }
                Integer transforma = Integer.parseInt(usuario);
                jogador.setUsuario(transforma - 1);

                sortComputadorEscolha();

                mostraEscolhas();

                defineGanhadorRodada();

                nuRodadas ++;
            }

            defineCampeao();

            pontosUsuario = 0;
            pontosComputador = 0;

            jogarJogo();


        }

    }

    public void sortComputadorEscolha(){
        Random geraAleatorio = new Random();
        Integer computador = geraAleatorio.nextInt(2);
        jogador.setComputador(computador);
    }

    public void mostraEscolhas(){
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(ConstantesJokenpo.PEDRA);
        opcoes.add(ConstantesJokenpo.TESOURA);
        opcoes.add(ConstantesJokenpo.PAPEL);

        String EscolhaComputador = opcoes.get(jogador.getComputador());
        String EscolhaUsuario = opcoes.get(jogador.getUsuario());

        System.out.println(ConstantesJokenpo.OPCAO_ESCOLHIDA_USUARIO + EscolhaUsuario + "\n"
        + ConstantesJokenpo.OPCAO_ESCOLHIDA_COMPUTADOR + EscolhaComputador);
    }

    public void defineGanhadorRodada(){
        if (jogador.getUsuario().equals(jogador.getComputador())){
            System.out.println(ConstantesJokenpo.EMPATE);
        }
        else {
            if ((jogador.getUsuario() + jogador.getComputador()) % 2 == 0 ){
                if (jogador.getUsuario() > jogador.getComputador()){
                    System.out.println(ConstantesJokenpo.VENCEDOR_RODADA);
                    pontosUsuario++;
                }
                else {
                    System.out.println(ConstantesJokenpo.PERDEDOR_RODADA);
                    pontosComputador++;
                }
            }

            if ((jogador.getUsuario() + jogador.getComputador()) % 2 == 1){
                if (jogador.getUsuario() < jogador.getComputador()){
                    System.out.println(ConstantesJokenpo.VENCEDOR_RODADA);
                    pontosUsuario++;
                }
                else{
                    System.out.println(ConstantesJokenpo.PERDEDOR_RODADA);
                    pontosComputador++;
                }
            }
        }
    }

    public void defineCampeao(){
        System.out.println(ConstantesJokenpo.PONTOS_COMPUTADOR + pontosComputador + "\n" +
                ConstantesJokenpo.PONTOS_USUARIO + pontosUsuario + "\n");

        if (pontosUsuario > pontosComputador){
            System.out.println(ConstantesJokenpo.VENCEDOR_JOGO);
        }
        else{
            System.out.println(ConstantesJokenpo.PERDEDOR_JOGO);
        }
    }
}
