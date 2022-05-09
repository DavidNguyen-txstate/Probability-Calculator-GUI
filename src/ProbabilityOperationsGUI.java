import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ProbabilityOperationsGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton factorialOperation;
	private JButton permutationsOperation;
	private JButton combinationsOperation;
	private JTextField firstUserProbabilityInput;
	private JTextField secondUserProbabilityInput;
	private JPanel mainProbabilityPanel;
	private JPanel subProbabilityPanel;
	private JLabel probabilitySolution;
	
	public ProbabilityOperationsGUI() {
		setTitle("Probabilty Operations Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setProbabilityComponents();
		pack();
	}
	
	public void setProbabilityComponents() {
		mainProbabilityPanel = new JPanel(new GridLayout(10, 5));
		subProbabilityPanel = new JPanel();
		firstUserProbabilityInput= new JTextField(4);
		secondUserProbabilityInput= new JTextField(4);
		subProbabilityPanel.add(new JLabel("Enter the two values on the text fields: "));
		subProbabilityPanel.add(firstUserProbabilityInput);
		subProbabilityPanel.add(secondUserProbabilityInput);
		mainProbabilityPanel.add(subProbabilityPanel);
		factorialOperation = new JButton("Factorial");
		permutationsOperation = new JButton("Permutations");
		combinationsOperation = new JButton("Combinations");
		factorialOperation.addActionListener(this);
		permutationsOperation.addActionListener(this);
		combinationsOperation.addActionListener(this);
		mainProbabilityPanel.add(factorialOperation);
		mainProbabilityPanel.add(permutationsOperation);
		mainProbabilityPanel.add(combinationsOperation);
		probabilitySolution = new JLabel("");
		mainProbabilityPanel.add(probabilitySolution);
		firstUserProbabilityInput.setText("0");
		secondUserProbabilityInput.setText("0");
		this.add(mainProbabilityPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double firstValue = Integer.parseInt(firstUserProbabilityInput.getText());
		double secondValue = Integer.parseInt(secondUserProbabilityInput.getText());
		long solution = (long) 0.0;
		if (e.getSource() == factorialOperation) {
			solution = factorialCalculation(firstValue);
			probabilitySolution.setText("Factorial: " + solution);
		}
		else if (e.getSource() == permutationsOperation) {
			solution = factorialCalculation(firstValue)/factorialCalculation(firstValue - secondValue);
			probabilitySolution.setText("Permutations: " + solution);
		}
		else if (e.getSource() == combinationsOperation) {
			solution = factorialCalculation(firstValue)/(factorialCalculation(firstValue - secondValue)*factorialCalculation(secondValue));
			probabilitySolution.setText("Combinations: " + solution);
		}
	}
	
	public long factorialCalculation(double n)
	{
		if(n == 0.0) {
			return (long) 1.0;
		}
		else {
			return (long) (n*factorialCalculation(n-1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new ProbabilityOperationsGUI().setVisible(true);
			}
		});
	}

}
