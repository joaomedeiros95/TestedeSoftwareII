import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import parameter.CalculoImpostoRenda;
import parameter.CalculoImpostoRendaTeste;
import fila.FilaCircularTeste;
import fila.FilaTest;
import banco.ContaTest;

/**
 * João Eduardo Ribeiro de Medeiros - 2013020793
 * Universidade Federal do Rio Grande do Norte
 * Bacharelado em Tecnologia da Informação
 * Criado em 11/02/2015
 */

/**
 * @author joao
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ContaTest.class, FilaCircularTeste.class, FilaTest.class, CalculoImpostoRendaTeste.class})
public class TodosTestes {

}
