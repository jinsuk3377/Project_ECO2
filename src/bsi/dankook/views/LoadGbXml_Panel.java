package bsi.dankook.views;

import bsi.dankook.util.Ui_Model;
import bsi.dankook.exception.GBXmlValidationError;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadGbXml_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField outputTextField;
	private JButton _loadFileBtn;
	Ui_Model _model;
	private String gbxmlFilePath = "";

	public LoadGbXml_Panel() {
		setToolTipText("gbXml 파일을 가져와서 아래 단계에 그 값을 뿌려줍니다.");
		setLayout(null);
		setBounds(10, 10, 770, 58);

		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BIM Model Upload", 4, 2, null,
				new Color(0, 0, 255)));

		JLabel leftLabel = new JLabel("GbXml Path");
		leftLabel.setFont(new Font("Consolas", 0, 12));

		leftLabel.setBounds(12, 21, 78, 25);
		add(leftLabel);

		this.outputTextField = new JTextField();
		this.outputTextField.setBackground(Color.WHITE);
		this.outputTextField.setEditable(false);
		this.outputTextField.setBounds(102, 21, 545, 25);
		add(this.outputTextField);

		this._loadFileBtn = new JButton("...");
		this._loadFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadGbXml_Panel.this.loadFile();
			}
		});
		this._loadFileBtn.setBounds(600, 53, 45, 25);
		add(this._loadFileBtn);
	}

	public void setModel(Ui_Model model) {
		this._model = model;
	}

	protected void loadFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(this._model.getGbxmlFileDesc(),
				new String[] { this._model.getGbxmlFileExtention() }));
		fileChooser.setMultiSelectionEnabled(false);
		if (fileChooser.showOpenDialog(this) == 0) {
			String gbxmlFilePath = fileChooser.getSelectedFile().toString();
			try {
				this._model.openGbxmlFile(gbxmlFilePath);
				_model.setGbxmlFilePath(outputTextField.getText());
			} catch (GBXmlValidationError e) {
				JOptionPane.showMessageDialog(null, "This file is not a valid File!! Check your File",
						"ValidationError", 0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An Error has occured during load file!!", "FileLoadError", 0);

				e.printStackTrace();
			}
		}
	}

	public String getGbxmlFilePath() {
		return gbxmlFilePath;
	}

	public void update(Object eventDispatcher) {
		this.outputTextField.setText(this._model.getGbxmlFilePath());
	}
}