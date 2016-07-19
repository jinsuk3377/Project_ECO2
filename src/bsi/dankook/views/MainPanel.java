package bsi.dankook.views;

import bsi.dankook.util.Ui_Observer;
import bsi.dankook.util.Ui_Model;
import bsi.dankook.views.dataprocessing.*;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel implements Ui_Observer, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private LoadGbXml_Panel loadGbXmlPanel;
	private GbXmltoBIX gbxmltoBIX = new GbXmltoBIX();
	
	private JTextField gbxmlFilePathField;
	public final JButton generateBIXButton = new JButton("Generate");
	public final JButton nextButton = new JButton("Next >>");

	private Ui_Model _model = null;
	
	private JFrame hvacDialog;

	public MainPanel(Ui_Model model) {
		this._model = model;

		this.loadGbXmlPanel = new LoadGbXml_Panel();
		this.loadGbXmlPanel.setSize(660, 95);
		this.loadGbXmlPanel.setToolTipText("");
		this.loadGbXmlPanel.setModel(model);
		this.loadGbXmlPanel.setLocation(10, 35);
		add(this.loadGbXmlPanel);

		createBIXGenerationPanel();
		createNextButton();
		setLayout(null);
		setSize(800, 800);

		refreshView();
	}

	private void createBIXGenerationPanel() {
		/* 99 */JLabel idfFilePathLabel = new JLabel("BIX File Path :");
		/* 100 */idfFilePathLabel.setBounds(12, 580, 89, 21);
		/* 101 */add(idfFilePathLabel);

		/* 103 */this.gbxmlFilePathField = new JTextField();
		/* 104 */this.gbxmlFilePathField.setEditable(false);
		/* 105 */this.gbxmlFilePathField.setBounds(105, 580, 415, 21);
		/* 106 */this.gbxmlFilePathField.setColumns(10);
		/* 107 */add(this.gbxmlFilePathField);

		/* 109 */this.generateBIXButton.setFont(new Font("Consolas", 0, 13));
		/* 110 */this.generateBIXButton.setBounds(535, 580, 132, 28);
		/* 111 */this.generateBIXButton.addActionListener(this);
		/* 112 */add(this.generateBIXButton);
	}
	
	private void createNextButton() {
		/* 76 */this.nextButton.setForeground(SystemColor.desktop);
		/* 77 */this.nextButton.setFont(new Font("Consolas", 0, 13));
		/* 78 */this.nextButton.setBounds(535, 615, 132, 28);
		/* 79 */this.nextButton.addActionListener(this);
		/* 80 */add(this.nextButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.generateBIXButton)) {
			convert();
		}
	}

	private void convert() {
		
		gbxmltoBIX.setPath(_model.getGbxmlFilePath());
		gbxmltoBIX.startConvert();
		int rightPosition = 0;
        for(int i=0; i < _model.getGbxmlFilePath().length(); i++){
            if(_model.getGbxmlFilePath().charAt(i) == '\\'){
                 rightPosition = i+1; 
                 // do what ever you want with character and its position
            }
        }
        _model.setBIXFilePath(_model.getGbxmlFilePath().substring(0, rightPosition));
		this.gbxmlFilePathField.setText(_model.getBIXFilePath());
	}

	public void update(Object eventDispatcher) {
		refreshView();
	}

	private void refreshView() {
		if (this._model != null) {
			updateGenerateButton();
			updateNextButton();
		}
	}

	private void updateGenerateButton() {
		if (this._model.loadedGbxmlFile()) {
			this.generateBIXButton.setEnabled(true);
		} else
			this.generateBIXButton.setEnabled(false);
	}

	private void updateNextButton() {
	}

}

/*
 * Location: C:\Users\LG\workspace\Django-server\EDI.jar Qualified Name:
 * bsi.dankook.edi.views.FirstStepWindow JD-Core Version: 0.6.0
 */