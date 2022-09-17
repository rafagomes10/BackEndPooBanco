package src.model;

import java.util.Date;

import javax.swing.plaf.synth.SynthSeparatorUI;

import src.utils.DataUtil;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String agencia, String conta, int digito, Double saldoInicial) {
        
        super(agencia, conta, digito, saldoInicial);
        
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("*********************************************************");
        System.out.println("********************** EXTRATO BANCARIO *****************");
        System.out.println("*********************************************************");
        System.out.println();

        System.out.println("Gerado em:" + DataUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes){

            System.out.println(movimentacao);


        }
        
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
    }
    
}
