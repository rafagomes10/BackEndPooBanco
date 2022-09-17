package src.model;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.event.MouseInputAdapter;

public abstract class ContaBancaria {
    // #region Atributos
    protected String agencia;
    protected String conta;
    protected int digito;
    protected Double saldo;
    protected Date dataAbertura;
    protected ArrayList <Movimentacao> movimentacoes;
    protected Double VALOR_MINIMO_DEPOSITO = 10.00;

    // #endregion

    // #region Construtores
    public ContaBancaria(String agencia, String conta, int digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        // Se nao instaciar, vai dar uma excpetion de nullPointerException
        this.movimentacoes = new ArrayList<Movimentacao>();

        //Criando a primeira Movimentacao.
        Movimentacao movimentacao = new Movimentacao("Abertura DE cONTA", saldoInicial);

        //Aqui estou salvando a movimentacao dentro do meu array de movimentacoes.
        //AQUI ESTOU INICIANDO O MEU EXTRATO BANCARIO.

        this.movimentacoes.add(movimentacao);



        };
    
    // #endregion

    // #region GET E SETT
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    
    // #endregion

    // #endregion Metodos

    public void depositar(Double valor) {

        if (valor < VALOR_MINIMO_DEPOSITO) {
            throw new InputMismatchException("O valor minimo para deposito é" + VALOR_MINIMO_DEPOSITO);
        }

        // this.saldo = this.saldo + valor;
        this.saldo += valor;

        //Aqui faco uma movimentacao no extrato.
        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public Double sacar(Double valor){
            if (valor > this.saldo){
                throw new InputMismatchException("O saldo é insuficiente!");
            }

            //this.saldo = this.saldo - valor;
            this.saldo -= valor;

            //Aqui faco uma movimentacao no extrato.
        Movimentacao movimentacao = new Movimentacao("Valor de Saque", valor);
        this.movimentacoes.add(movimentacao);

            return valor;
            
    }


    public void transferir(Double valor, ContaBancaria contaDestino){
        this.sacar(valor);

        contaDestino.depositar(valor);
    }

    //#endregion

    //METODO ABSTRATO OBRIGA AS CLASSES QUE ESTAO HERDANDO DE IMPLEMENTAREM ESTE METODO.
    public abstract void imprimirExtrato();


}
