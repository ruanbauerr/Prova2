import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banco {
    private JPanel panel1;
    private JButton btnLimpar;
    private JButton btnDeposito;
    private JButton btnSaque;
    private JTextField txtMensage;
    private JTextField txtSaque;
    private JTextField txtDeposito;
    private JTextField txtSaldo;

    private double saldo = 500.00;

    public Banco() {

        txtSaldo.setText(String.valueOf(saldo));


        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();
            }
        });


        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMensage.setText("");
            }
        });
    }

    private void realizarSaque() {
        String textoSaque = txtSaque.getText();
        if (!isValidInput(textoSaque)) {
            txtMensage.setText("Entrada inválida");
            return;
        }
        double valorSaque = Double.parseDouble(textoSaque);

        if (valorSaque <= 0) {
            txtMensage.setText("O valor do saque deve ser positivo");
            return;
        }

        if (valorSaque > saldo) {
            txtMensage.setText("Saldo insuficiente");
            return;
        }

        saldo -= valorSaque;
        txtSaldo.setText(String.valueOf(saldo));
        txtMensage.setText("Saque bem sucedido");
    }

    private void realizarDeposito() {
        String textoDeposito = txtDeposito.getText();
        if (!isValidInput(textoDeposito)) {
            txtMensage.setText("Entrada inválida");
            return;
        }
        double valorDeposito = Double.parseDouble(textoDeposito);

        if (valorDeposito <= 0) {
            txtMensage.setText("O valor do depósito deve ser positivo");
            return;
        }

        if (valorDeposito > 1000) {
            txtMensage.setText("Depósito não permitido");
            return;
        }

        saldo += valorDeposito;
        txtSaldo.setText(String.valueOf(saldo));
        txtMensage.setText("Depósito bem sucedido");
    }

    private boolean isValidInput(String input) {
        try {
            Double.parseDouble(input);
            return input != null && !input.trim().isEmpty();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("If");
        frame.setContentPane(new Banco().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}