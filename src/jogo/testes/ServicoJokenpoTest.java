package jogo.testes;

import jogo.servico.ServicoJokenpo;
import org.junit.Assert;
import org.junit.Test;

public class ServicoJokenpoTest  {

    ServicoJokenpo servicoJokenpo = new ServicoJokenpo();

    @Test
    public void sortComputadorEscolha() {
        Integer esperado = servicoJokenpo.sortComputadorEscolha();
        Assert.assertNotNull(esperado);
    }

    @Test
    public void defineGanhadorRodada() {
        boolean esperado = servicoJokenpo.defineGanhadorRodada(2,2);
        Assert.assertFalse(esperado);
    }

    @Test
    public void defineCampeaoMaquinaGanhaTeste() {
        boolean esperado = servicoJokenpo.defineCampeao(1,2);
        Assert.assertFalse(esperado);
    }

    @Test
    public void defineCampeaoUsuarioGanhaTeste() {
        boolean esperado = servicoJokenpo.defineCampeao(2,1);
        Assert.assertTrue(esperado);
    }

    @Test
    public void validaCampo() {
        String esperado = servicoJokenpo.validaCampo("1");
        Assert.assertEquals("1",esperado);
    }

    @Test
    public void defineCampeaoEmpateTeste() {
        boolean esperado = servicoJokenpo.defineCampeao(2,2);
        Assert.assertTrue(esperado);
    }
}