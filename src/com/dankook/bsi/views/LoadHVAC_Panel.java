package com.dankook.bsi.views;

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

import com.dankook.bsi.exception.HVACValidationError;
import com.dankook.bsi.model.Ui_Model;

public class LoadHVAC_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField outputTextField;
	private JButton _loadFileBtn;
	private Ui_Model _model;
	private String HVACFilePath = "";

	public LoadHVAC_Panel(Ui_Model model) {
		_model = model;
		
		setToolTipText("HVAC 엑셀 파일을 업로드하여 설비 관련 데이터를 읽습니다.");
		setLayout(null);
		setBounds(10, 10, 770, 58);

		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "HVAC Model Upload", 4, 2, null,
				new Color(0, 0, 255)));

		JLabel leftLabel = new JLabel("HVAC Path");
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
				try {
					if (!_model.getConvertBIXCheck()) JOptionPane.showMessageDialog(null, 
							"Press ... button in BIM Model Upload dialog and import your building information model file that gbXML format.", 
							"Message: HVAC Model Upload", JOptionPane.INFORMATION_MESSAGE);
					
					else 
						LoadHVAC_Panel.this.loadFile();
				} catch (HVACValidationError e1) {
					JOptionPane.showMessageDialog(null, "This file is not a valid File!! Check your File",
							"ValidationError", 0);
				}
			}
		});
		this._loadFileBtn.setBounds(600, 53, 45, 25);
		add(this._loadFileBtn);
		
	}

	public void setModel(Ui_Model model) {
		this._model = model;
	}

	protected void loadFile() throws HVACValidationError {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(this._model.getHVACFileDesc(),
				new String[] { this._model.getHVACFileExtention() }));
		fileChooser.setMultiSelectionEnabled(false);
		if (fileChooser.showOpenDialog(this) == 0) {
			String HVACFilePath = fileChooser.getSelectedFile().toString();
			try {
				if (HVACFilePath.isEmpty()) return;
				boolean check = false;
				_model.setHVACInfo();
				check = _model.openHVACFile(HVACFilePath);
				if(check) outputTextField.setText(HVACFilePath);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "An Error has occured during load file!!", "FileLoadError", 0);

				e.printStackTrace();
			}
		}
	}
	
	public String getHVACFilePath() {
		return HVACFilePath;
	}

	public void update(Object eventDispatcher) {
		this.outputTextField.setText(this._model.getHVACFilePath());
	}
}