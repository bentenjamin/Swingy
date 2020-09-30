package com.bwebb.swingy.view.gui;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.model.chars.player.Character;
import com.bwebb.swingy.model.map.Coordinates;
import com.bwebb.swingy.view.DisplayStringHandler;
import com.bwebb.swingy.view.ViewInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ViewInterface {
	private GameController controller;
	private DisplayStringHandler stringHandler;

	private JPanel contentPane;
	
	//stuff
	JPanel panel = new JPanel();
	JTextPane txtpnTextoutput = new JTextPane();
	private final JTextPane txtpnDisplay = new JTextPane();

	/**
	 * Create the frame.
	 */
	public Gui(GameController controller, DisplayStringHandler strHandler) {
		this.controller = controller;
		stringHandler = strHandler;

		setTitle("Swingy");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

	private void initComponents() {

	}

	public void mainMenu() {
		panel.removeAll();
		
		JButton btnCreateCharacter = new JButton("Create Character");
		btnCreateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("1");
			}
		});
		btnCreateCharacter.setBounds(36, 240, 166, 33);
		panel.add(btnCreateCharacter);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(" ________  ___       __   ___  ________   ________      ___    ___ \n|\\   ____\\|\\  \\     |\\  \\|\\  \\|\\   ___  \\|\\   ____\\    |\\  \\  /  /|\n\\ \\  \\___|\\ \\  \\    \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\___|    \\ \\  \\/  / /\n \\ \\_____  \\ \\  \\  __\\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\  ___   \\ \\    / / \n  \\|____|\\  \\ \\  \\|\\__\\_\\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\   \\/  /  /  \n    ____\\_\\  \\ \\____________\\ \\__\\ \\__\\\\ \\__\\ \\_______\\__/  / /    \n   |\\_________\\|____________|\\|__|\\|__| \\|__|\\|_______|\\___/ /     \n   \\|_________|                                       \\|___|/      \n\nwell its supposed to say Swingy :(");
		textArea.setBounds(36, 12, 436, 185);
		panel.add(textArea);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("2");
			}
		});
		btnLoad.setBounds(36, 285, 166, 33);
		panel.add(btnLoad);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("3");
			}
		});
		btnDelete.setBounds(36, 330, 166, 33);
		panel.add(btnDelete);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 375, 166, 33);
		panel.add(btnQuit);
		
		panel.repaint();
	}

	@Override
	public void invalidInput() {}

	@Override
	public void endScreen() {}

	@Override
	public void createCharacter() {
		panel.removeAll();

		String[] classList = ClassesHandler.getClassList();
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(53, 45, 149, 24);
		
		for (String aClass: classList)
			comboBox.addItem(aClass);
		
		comboBox.setSelectedIndex(0);
		
		panel.add(comboBox);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("b");
			}
		});
		btnBack.setBounds(36, 323, 166, 33);
		panel.add(btnBack);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(comboBox.getSelectedIndex());
				controller.runGuiCommand(Integer.toString((comboBox.getSelectedIndex() + 1)));
			}
		});
		btnCreate.setBounds(36, 271, 166, 33);
		panel.add(btnCreate);
		
		JTextPane txtpnCreateChar = new JTextPane();
		txtpnCreateChar.setText("Create Character");
		txtpnCreateChar.setBounds(49, 12, 153, 21);
		panel.add(txtpnCreateChar);
		
		panel.repaint();
	}

	@Override
	public void exploring(int[][] mapArr, Coordinates playerPos) {
		panel.removeAll();
		
		JTextPane mapDisplay = new JTextPane();
		mapDisplay.setText(stringHandler.arrMapToCenteredStrMap(mapArr, playerPos));
		mapDisplay.setBounds(45, 28, 361, 195);
		mapDisplay.setEditable(false);
		Font monoFont = new Font(Font.MONOSPACED, 3, 10);
		mapDisplay.setFont(monoFont);
		panel.add(mapDisplay);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		txtpnTextoutput.setEditable(false);
		

		txtpnTextoutput.setBounds(444, 28, 166, 195);
		panel.add(txtpnTextoutput);
		
		JButton btnStats = new JButton("Stats");
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("i");
			}
		});
		btnStats.setBounds(467, 252, 117, 25);
		panel.add(btnStats);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("w");
}
		});
		btnUp.setBounds(172, 235, 117, 25);
		panel.add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("s");
}
		});
		btnDown.setBounds(172, 289, 117, 25);
		panel.add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("a");
}
		});
		btnLeft.setBounds(42, 262, 117, 25);
		panel.add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("d");
}
		});
		btnRight.setBounds(304, 262, 117, 25);
		panel.add(btnRight);
		
		panel.repaint();
	}

	@Override
	public void exploring(int[][] curMap) {}

	@Override
	public void loadingPlayer() {}

	@Override
	public void blockage() {
		txtpnTextoutput.setText(stringHandler.genBlockage());
	}

	@Override
	public void artifactFound(String artifactType, int newArtifactStat, int currentArtifactStat) {
		panel.removeAll();
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		txtpnDisplay.setBounds(36, 31, 316, 193);
		
		panel.add(txtpnDisplay);
		
		JButton btnEquip = new JButton("Equip");
		btnEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("1");
			}
		});
		btnEquip.setBounds(36, 248, 166, 33);
		panel.add(btnEquip);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("2");
			}
		});
		btnDiscard.setBounds(36, 302, 166, 33);
		
		panel.add(btnDiscard);

		Font monoFont = new Font(Font.MONOSPACED, 3, 10);
		txtpnDisplay.setFont(monoFont);
		txtpnDisplay.setText(stringHandler.artifactString(artifactType, newArtifactStat, currentArtifactStat));
		
		panel.repaint();
	}

	@Override
	public void enemyFound() {
		panel.removeAll();
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		txtpnDisplay.setBounds(36, 31, 316, 193);
		
		panel.add(txtpnDisplay);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("1");
			}
		});
		btnFight.setBounds(36, 248, 166, 33);
		
		panel.add(btnFight);
		
		JButton btnFlee = new JButton("Flee");
		btnFlee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("2");
			}
		});
		btnFlee.setBounds(36, 302, 166, 33);
		
		panel.add(btnFlee);
		
		txtpnDisplay.setText("You have encountered an enemy!\nDo you Fight or attempt to Flee?");
		
		panel.repaint();
	}

	@Override
	public void fight() {
		txtpnTextoutput.setText("You engage in an 'epic battle that will be spoke of for decades'");
	}

	@Override
	public void fightWon() {
		txtpnTextoutput.setText("You have slain the heretic");
	}

	@Override
	public void fled() {
		txtpnTextoutput.setText("You have evaded the Monster");
	}

	@Override
	public void equippedArtifact() {
		txtpnTextoutput.setText("You have equipped your new loot");
	}

	@Override
	public void death() {
		panel.removeAll();
		
		JButton btnReturn = new JButton("Return to Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnReturn.setBounds(36, 368, 166, 33);
		panel.add(btnReturn);
		txtpnDisplay.setBounds(36, 31, 316, 193);
		
		panel.add(txtpnDisplay);
		
		txtpnDisplay.setText("YOU DIED");
		
		panel.repaint();
	}

	@Override
	public void levelUp(int playerLevel) {
		txtpnTextoutput.setText("You have leveled up to level " + playerLevel);
	}

	@Override
	public void win() {
		panel.removeAll();
		
		JButton btnReturn = new JButton("Return to Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("");
			}
		});
		btnReturn.setBounds(36, 368, 166, 33);
		panel.add(btnReturn);
		txtpnDisplay.setBounds(36, 31, 316, 193);
		
		panel.add(txtpnDisplay);
		
		txtpnDisplay.setText("MISSION SUCCESS");

		panel.repaint();
	}

	@Override
	public void stats(Character player) {
		txtpnTextoutput.setText(stringHandler.formatStats(player));
	}

	@Override
	public void loadPlayer(String[] savedNamesList) {
		panel.removeAll();
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(49, 66, 149, 24);
		
		for (String save: savedNamesList)
			comboBox.addItem(save);
		
		if (savedNamesList.length > 0) {
			comboBox.setSelectedIndex(0);
			panel.add(comboBox);
		}

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("b");
			}
		});
		btnBack.setBounds(36, 323, 166, 33);
		panel.add(btnBack);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(comboBox.getSelectedIndex());
				controller.runGuiCommand(Integer.toString((comboBox.getSelectedIndex() + 1)));
			}
		});
		btnLoad.setBounds(36, 271, 166, 33);
		if (savedNamesList.length > 0)
			panel.add(btnLoad);
		
		JTextPane txtpnLoadSave = new JTextPane();
		txtpnLoadSave.setText("Load Save");
		txtpnLoadSave.setBounds(49, 12, 153, 21);
		panel.add(txtpnLoadSave);
		
		panel.repaint();
	}

	@Override
	public void askSave() {
		panel.removeAll();
		
		txtpnDisplay.setBounds(36, 31, 316, 193);
		
		panel.add(txtpnDisplay);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("1");
			}
		});
		btnSave.setBounds(36, 248, 166, 33);
		
		panel.add(btnSave);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("2");
			}
		});
		btnDiscard.setBounds(36, 302, 166, 33);
		
		panel.add(btnDiscard);
		
		txtpnDisplay.setText("Do you want to save?");
		
		panel.repaint();
	}

	@Override
	public void deleteSaves(String[] savesList) {
		panel.removeAll();
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(49, 66, 149, 24);
		
		for (String save: savesList)
			comboBox.addItem(save);
		
		if (savesList.length > 0) {
			comboBox.setSelectedIndex(0);
			panel.add(comboBox);
		}

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("q");
			}
		});
		btnQuit.setBounds(36, 368, 166, 33);
		panel.add(btnQuit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("b");
			}
		});
		btnBack.setBounds(36, 323, 166, 33);
		panel.add(btnBack);
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand(Integer.toString((comboBox.getSelectedIndex() + 1)));
			}
		});
		btnDel.setBounds(36, 233, 166, 33);
		if (savesList.length > 0)
			panel.add(btnDel);
		
		JTextPane txtpnDelSave = new JTextPane();
		txtpnDelSave.setText("Delete Save");
		txtpnDelSave.setBounds(49, 12, 153, 21);
		panel.add(txtpnDelSave);
		
		JButton btnDelAll = new JButton("Delete All");
		btnDelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("d");
			}
		});
		btnDelAll.setBounds(36, 278, 166, 33);
		panel.add(btnDelAll);
		
		panel.repaint();
	}
}
