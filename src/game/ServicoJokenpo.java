package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class ServicoJokenpo {

    private String resposta;

    private Model model = new Model();

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
                String verifica = model.getUsuario().toString();
                while ( !usuario.equals("1") && !usuario.equals("2") && !usuario.equals("3")){
                    System.out.println(ConstantesJokenpo.ESCOLHA_INVALIDA );
                    usuario = sc1.next();
                }
                Integer transform = Integer.parseInt(usuario);
                model.setUsuario(transform - 1);

                sortComputadorEscolha();

                mostraEscolhas();

                defineGanhadorRodada();

                nuRodadas ++;
            }

            defineCampeao();

            jogarJogo();
        }

    }

    public void sortComputadorEscolha(){
        Random random = new Random();
        Integer computador = random.nextInt(2);
        model.setComputador(computador);
    }

    public void mostraEscolhas(){
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(ConstantesJokenpo.PEDRA);
        opcoes.add(ConstantesJokenpo.TESOURA);
        opcoes.add(ConstantesJokenpo.PAPEL);

        String EscolhaComputador = opcoes.get(model.getComputador());
        String EscolhaUsuario = opcoes.get(model.getUsuario());


        System.out.println(ConstantesJokenpo.OPCAO_ESCOLHIDA_USUARIO + EscolhaUsuario + "\n"
        + ConstantesJokenpo.OPCAO_ESCOLHIDA_COMPUTADOR + EscolhaComputador);
    }

    public void defineGanhadorRodada(){
        if (model.getUsuario().equals(model.getComputador())){
            System.out.println(ConstantesJokenpo.EMPATE);
        }
        else {
            if ((model.getUsuario() + model.getComputador()) % 2 == 0 ){
                if (model.getUsuario() > model.getComputador()){
                    System.out.println(ConstantesJokenpo.VENCEDOR_RODADA);
                    pontosUsuario++;
                }
                else {
                    System.out.println(ConstantesJokenpo.PERDEDOR_RODADA);
                    pontosComputador++;
                }
            }

            if ((model.getUsuario() + model.getComputador()) % 2 == 1){
                if (model.getUsuario() < model.getComputador()){
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
        if (pontosUsuario > pontosComputador){
            System.out.println(ConstantesJokenpo.VENCEDOR_JOGO);
        }
        else{
            System.out.println(ConstantesJokenpo.PERDEDOR_JOGO);
        }
    }
}
